package stud.sem5.aui.lab.lab3.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;
import stud.sem5.aui.lab.lab3.brand.service.CarBrandService;
import stud.sem5.aui.lab.lab3.model.dto.CreateModelRequest;
import stud.sem5.aui.lab.lab3.model.dto.GetModelResponse;
import stud.sem5.aui.lab.lab3.model.dto.GetModelsResponse;
import stud.sem5.aui.lab.lab3.model.dto.UpdateModelRequest;
import stud.sem5.aui.lab.lab3.model.entity.CarModel;
import stud.sem5.aui.lab.lab3.model.service.CarModelService;

import java.util.Optional;

@RestController
@RequestMapping("api/brands/{brandname}/models")
public class BrandModelController {

    private CarBrandService brandService;
    private CarModelService modelService;

    @Autowired
    public BrandModelController (CarBrandService carBrandService, CarModelService carModelService){
        brandService = carBrandService;
        modelService = carModelService;
    }

    @GetMapping
    public ResponseEntity<GetModelsResponse> getModels(@PathVariable("brandname") String brandName){
        Optional<CarBrand> brand = brandService.find(brandName);
        return brand.map(value -> ResponseEntity.ok(GetModelsResponse.entityToDtoMapper().apply(modelService.findAll(value))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<GetModelResponse> getModel(@PathVariable ("brandname") String brandName,
                                                     @PathVariable ("id") Integer id){
        return modelService.find(brandName, id)
                .map(value -> ResponseEntity.ok(GetModelResponse.entityToDtoMapper().apply(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createModel(@PathVariable ("brandname") String brandName,
                                            @RequestBody CreateModelRequest modelRequest, UriComponentsBuilder builder){
        Optional<CarBrand> brand = brandService.find(brandName);
        if (brand.isPresent()) {
            CarModel carModel = CreateModelRequest
                    .dtoToEntityMapper(brand::get)
                    .apply(modelRequest);
            carModel = modelService.create(carModel);
            return ResponseEntity.created(builder.pathSegment("api", "brands", "{brandname}", "models", "{id}")
                    .buildAndExpand(brand.get().getName(), carModel.getId()).toUri()).build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable ("id") Integer id){
        Optional<CarModel> carModel = modelService.find(id);
        if (carModel.isPresent()){
            modelService.delete(id);
            return ResponseEntity.accepted().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateModel(@PathVariable ("id") Integer id,
                                            @RequestBody UpdateModelRequest modelRequest) {
        Optional<CarModel> carModel = modelService.find(id);
        if (carModel.isPresent()){
            UpdateModelRequest.dtoToEntityUpdater().apply(carModel.get(), modelRequest);
            modelService.update(carModel.get());
            return ResponseEntity.accepted().build();

        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}