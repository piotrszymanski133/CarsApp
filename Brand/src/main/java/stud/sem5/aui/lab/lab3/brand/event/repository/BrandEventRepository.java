package stud.sem5.aui.lab.lab3.brand.event.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;
import stud.sem5.aui.lab.lab3.brand.event.dto.CreateBrandRequest;


@Repository
public class BrandEventRepository {

    private RestTemplate restTemplate;

    @Autowired
    public BrandEventRepository(@Value("http://localhost:8083/api") String baseUrl){
        restTemplate = new RestTemplateBuilder().rootUri(baseUrl).build();
    }

    public void delete(String key){
        restTemplate.delete("/brands/{name}", key);
    }

    public void create(CarBrand brand){
        restTemplate.postForLocation("/brands", CreateBrandRequest.entityToDtoMapper().apply(brand));
    }
}
