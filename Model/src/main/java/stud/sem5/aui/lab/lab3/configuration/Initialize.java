package stud.sem5.aui.lab.lab3.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;
import stud.sem5.aui.lab.lab3.brand.service.CarBrandService;
import stud.sem5.aui.lab.lab3.model.entity.CarModel;
import stud.sem5.aui.lab.lab3.model.service.CarModelService;

import javax.annotation.PostConstruct;

@Component
public class Initialize {
    private CarBrandService brandService;
    private CarModelService modelService;

    @Autowired
    public Initialize(CarBrandService carBrandService, CarModelService carModelService) {
        this.brandService = carBrandService;
        this.modelService = carModelService;
    }

    @PostConstruct
    public void initializeData(){
        CarBrand toyota = CarBrand.builder()
                .name("Toyota")
                .build();

        CarBrand mercedes = CarBrand.builder()
                .name("Mercedes-Benz")
                .build();

        CarBrand volkswagen = CarBrand.builder()
                .name("Volkswagen")
                .build();

        CarBrand ford = CarBrand.builder()
                .name("Ford")
                .build();

        brandService.create(toyota);
        brandService.create(mercedes);
        brandService.create(volkswagen);
        brandService.create(ford);


        CarModel corolla_2 = CarModel.builder()
                .brand(toyota)
                .generation(2)
                .name("Corolla")
                .price(80000)
                .build();

        CarModel yaris_4 = CarModel.builder()
                .brand(toyota)
                .generation(4)
                .name("Yaris")
                .price(40000)
                .build();

        CarModel gla_4 = CarModel.builder()
                .brand(mercedes)
                .generation(4)
                .name("GLA")
                .price(350000)
                .build();

        CarModel golf_5 = CarModel.builder()
                .brand(volkswagen)
                .generation(5)
                .name("Golf")
                .price(40000)
                .build();

        CarModel mondeo_5 = CarModel.builder()
                .brand(ford)
                .generation(5)
                .name("Mondeo")
                .price(120000)
                .build();

        CarModel focus_3 = CarModel.builder()
                .brand(ford)
                .generation(3)
                .name("Focus")
                .price(30000)
                .build();

        modelService.create(corolla_2);
        modelService.create(yaris_4);
        modelService.create(gla_4);
        modelService.create(golf_5);
        modelService.create(mondeo_5);
        modelService.create(focus_3);
    }
}
