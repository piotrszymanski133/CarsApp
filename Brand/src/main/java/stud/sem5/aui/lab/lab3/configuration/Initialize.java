package stud.sem5.aui.lab.lab3.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;
import stud.sem5.aui.lab.lab3.brand.service.CarBrandService;

import javax.annotation.PostConstruct;

@Component
public class Initialize {

    private CarBrandService brandService;

    @Autowired
    public Initialize(CarBrandService carBrandService) {
        this.brandService = carBrandService;
    }

    @PostConstruct
    public void initializeData() {
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
    }
}