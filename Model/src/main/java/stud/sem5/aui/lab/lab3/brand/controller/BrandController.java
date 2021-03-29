package stud.sem5.aui.lab.lab3.brand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import stud.sem5.aui.lab.lab3.brand.dto.CreateBrandRequest;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;
import stud.sem5.aui.lab.lab3.brand.service.CarBrandService;

import java.util.Optional;

@RestController
@RequestMapping("api/brands")
public class BrandController {

    private CarBrandService brandService;

    @Autowired
    public BrandController(CarBrandService carBrandService){
        this.brandService = carBrandService;
    }

    @PostMapping
    public ResponseEntity<Void> createBrand(@RequestBody CreateBrandRequest request, UriComponentsBuilder builder){
        CarBrand carBrand = CreateBrandRequest.dtoToEntityMapper().apply(request);
        brandService.create(carBrand);
        return ResponseEntity.created(builder.pathSegment("api", "brands", "{name}")
                .buildAndExpand(carBrand.getName()).toUri()).build();

    }

    @DeleteMapping("{name}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("name") String name){
        Optional<CarBrand> carBrand = brandService.find(name);
        if (carBrand.isPresent()){
            brandService.delete(carBrand.get());
            return ResponseEntity.accepted().build();
        }
        else
            return  ResponseEntity.notFound().build();
    }
}
