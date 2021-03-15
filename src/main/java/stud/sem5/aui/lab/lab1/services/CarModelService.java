package stud.sem5.aui.lab.lab1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stud.sem5.aui.lab.lab1.entity.CarBrand;
import stud.sem5.aui.lab.lab1.entity.CarModel;
import stud.sem5.aui.lab.lab1.repositories.CarModelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarModelService {
    private CarModelRepository repository;
    private CarBrandService brandService;

    @Autowired
    public CarModelService(CarModelRepository carModelRepository, CarBrandService carBrandService){
        this.repository = carModelRepository;
        this.brandService = carBrandService;
    }

    public List<CarModel> findAll() {return repository.findAll();}

    public Optional<CarModel> find (Integer key) {return repository.find(key);}

    public void create(CarModel entity) {repository.create(entity);}

    public void delete(Integer key) {repository.delete(key);}

    public void createNewModel(CarBrand brand, String model, int price, int generation, Integer id){
        create(CarModel.builder()
                        .id(id)
                        .brand(brand)
                        .name(model)
                        .price(price)
                        .generation(generation)
                        .build());
    }
}
