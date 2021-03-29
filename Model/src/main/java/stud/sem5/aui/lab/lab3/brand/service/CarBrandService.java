package stud.sem5.aui.lab.lab3.brand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;
import stud.sem5.aui.lab.lab3.brand.repository.CarBrandRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CarBrandService {

    private CarBrandRepository repository;

    @Autowired
    public CarBrandService(CarBrandRepository repository){
        this.repository = repository;
    }

    public Optional<CarBrand> find(String name){
        return repository.findById(name);
    }

    @Transactional
    public void create(CarBrand brand){
        repository.save(brand);
    }

    @Transactional
    public void delete(CarBrand brand){
        repository.delete(brand);
    }
}
