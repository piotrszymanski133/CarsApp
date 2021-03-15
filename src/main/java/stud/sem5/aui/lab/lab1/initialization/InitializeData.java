package stud.sem5.aui.lab.lab1.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stud.sem5.aui.lab.lab1.entity.CarBrand;
import stud.sem5.aui.lab.lab1.entity.CarModel;
import stud.sem5.aui.lab.lab1.services.CarBrandService;
import stud.sem5.aui.lab.lab1.services.CarModelService;
import javax.annotation.PostConstruct;

@Component
public class InitializeData {

    private CarBrandService brandService;
    private CarModelService modelService;

    @Autowired
    public InitializeData(CarBrandService carBrandService, CarModelService carModelService) {
        this.brandService = carBrandService;
        this.modelService = carModelService;
    }

    @PostConstruct
    public void initializeData(){
        CarBrand toyota = CarBrand.builder()
                .creationDate(1937)
                .name("Toyota")
                .build();

        CarBrand mercedes = CarBrand.builder()
                .creationDate(1926)
                .name("Mercedes-Benz")
                .build();

        CarBrand volkswagen = CarBrand.builder()
                .creationDate(1937)
                .name("Volkswagen")
                .build();

        CarBrand ford = CarBrand.builder()
                .creationDate(1903)
                .name("Ford")
                .build();

        brandService.create(toyota);
        brandService.create(mercedes);
        brandService.create(volkswagen);
        brandService.create(ford);


        CarModel corolla_2 = CarModel.builder()
                .id(0)
                .brand(toyota)
                .generation(2)
                .name("Corolla")
                .price(80000)
                .build();

        CarModel yaris_4 = CarModel.builder()
                .id(1)
                .brand(toyota)
                .generation(4)
                .name("Yaris")
                .price(40000)
                .build();

        CarModel gla_4 = CarModel.builder()
                .id(2)
                .brand(mercedes)
                .generation(4)
                .name("GLA")
                .price(350000)
                .build();

        CarModel golf_5 = CarModel.builder()
                .id(3)
                .brand(volkswagen)
                .generation(5)
                .name("Golf")
                .price(40000)
                .build();

        CarModel mondeo_5 = CarModel.builder()
                .id(4)
                .brand(ford)
                .generation(5)
                .name("Mondeo")
                .price(120000)
                .build();

        CarModel focus_3 = CarModel.builder()
                .id(5)
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
