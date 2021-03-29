package stud.sem5.aui.lab.lab3.brand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import stud.sem5.aui.lab.lab3.brand.dto.CreateBrandRequest;
import stud.sem5.aui.lab.lab3.brand.dto.GetBrandResponse;
import stud.sem5.aui.lab.lab3.brand.dto.GetBrandsResponse;
import stud.sem5.aui.lab.lab3.brand.dto.UpdateBrandRequest;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;
import stud.sem5.aui.lab.lab3.brand.service.CarBrandService;

import java.util.Optional;

@RestController
@RequestMapping("api/brands")
public class BrandController {

    private CarBrandService brandService;


    @Autowired
    public BrandController (CarBrandService carBrandService){
        brandService = carBrandService;
    }

    @GetMapping
    public ResponseEntity<GetBrandsResponse> getBrands() {
        return ResponseEntity.ok(GetBrandsResponse.entityToDtoMapper().apply(brandService.findAll()));
    }

    @GetMapping("{name}")
    public ResponseEntity<GetBrandResponse> getBrand(@PathVariable("name") String name){
        return brandService.find(name)
                .map(value -> ResponseEntity.ok(GetBrandResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createBrand(@RequestBody CreateBrandRequest createBrandRequest, UriComponentsBuilder builder){
        Optional<CarBrand> brand = brandService.find(createBrandRequest.getName());
        if(brand.isEmpty()) {
            CarBrand newBrand = CreateBrandRequest.dtoToEntityMapper().apply(createBrandRequest);
            brandService.create(newBrand);
            return ResponseEntity.created(builder.pathSegment("api", "brands", "{name}")
                    .buildAndExpand(newBrand.getName()).toUri()).build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{name}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("name") String name){
        Optional<CarBrand> brand = brandService.find(name);
        if(brand.isPresent()){
            brandService.delete(brand.get().getName());
            return ResponseEntity.accepted().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{name}")
    public ResponseEntity <Void> updateBrand(@PathVariable ("name") String name,
                                             @RequestBody UpdateBrandRequest brandRequest){
        Optional<CarBrand> brand = brandService.find(name);
        if (brand.isPresent()){
            UpdateBrandRequest.dtoToEntityUpdater().apply(brand.get(), brandRequest);
            brandService.update(brand.get());
            return ResponseEntity.accepted().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
