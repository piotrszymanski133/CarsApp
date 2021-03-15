package stud.sem5.aui.lab.lab1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stud.sem5.aui.lab.lab1.entity.CarBrand;
import stud.sem5.aui.lab.lab1.repositories.CarBrandRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarBrandService {
    private CarBrandRepository repository;

    @Autowired
    public CarBrandService(CarBrandRepository carBrandRepository){
        this.repository = carBrandRepository;
    }

    public List<CarBrand> findAll() {return repository.findAll();}

    public Optional<CarBrand> find (String key) {return repository.find(key);}

    public void create(CarBrand entity) {repository.create(entity);}

    public void delete(String key) {repository.delete(key);}
}
