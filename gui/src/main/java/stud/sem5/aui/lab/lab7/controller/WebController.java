package stud.sem5.aui.lab.lab7.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import stud.sem5.aui.lab.lab7.model.File;
import java.util.ArrayList;
import java.util.List;


@Controller
public class WebController {

    @GetMapping(value = "/addFile")
    public String get(){
        return "add";
    }

    @PostMapping(value = "/addFile")
    public String submitFile(@RequestParam("file") MultipartFile file, @RequestParam("author") String author
            , @RequestParam("description") String description) {

        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
        map.add("author", author);
        map.add("description", description);
        map.add("file", file.getResource());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "multipart/form-data");
        headers.set("Accept", "text/plain");
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
        String server = "http://second_load_balancer:8080/api/files";
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.exchange(server, HttpMethod.POST, requestEntity, String.class);
        return "add";
    }

    @GetMapping("/view")
    public String showFiles(Model model){
        RestTemplate restTemplate = new RestTemplate();
        String server = "http://second_load_balancer:8080/api/files";
        ResponseEntity<String> response = restTemplate.getForEntity(server, String.class);
        String body = response.getBody();
        List<File> files = new ArrayList<File>();
        try {
            JSONObject o = new JSONObject(body);
            JSONArray array = o.getJSONArray("files");
            for (int i = 0; i < array.length(); i++) {
                files.add(new File(array.getJSONObject(i).getInt("id"),
                        array.getJSONObject(i).getString("author"),
                        array.getJSONObject(i).getString("description"),
                        array.getJSONObject(i).getString("name")));
            }

        }catch (Exception e){
            System.err.println("JSON ERROR!");
        }
        model.addAttribute("files", files);

        return "view";
    }
}