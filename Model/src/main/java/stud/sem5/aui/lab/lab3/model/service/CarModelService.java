package stud.sem5.aui.lab.lab3.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;
import stud.sem5.aui.lab.lab3.brand.repository.CarBrandRepository;
import stud.sem5.aui.lab.lab3.brand.service.CarBrandService;
import stud.sem5.aui.lab.lab3.model.entity.CarModel;
import stud.sem5.aui.lab.lab3.model.repository.CarModelRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CarModelService {

    CarModelRepository repository;
    CarBrandService brandService;

    @Autowired
    public CarModelService(CarModelRepository carModelRepository, CarBrandService carBrandService){
        this.repository = carModelRepository;
        this.brandService = carBrandService;
    }

    public List<CarModel> findAll() {return repository.findAll();}

    public List<CarModel> findAll(CarBrand brand) {return repository.findAllByBrand(brand);}

    public Optional<CarModel> find (Integer key) {return repository.findById(key);}

    public Optional<CarModel> find (String brand, Integer id) {
        Optional<CarBrand> br = brandService.find(brand);
        if(br.isPresent())
            return repository.findByBrandAndId(br.get(), id);
        else
            return Optional.empty();
    }

    @Transactional
    public CarModel create(CarModel entity) {return repository.save(entity);}

    @Transactional
    public void update (CarModel entity) {repository.save(entity);}

    @Transactional
    public void delete(Integer key) {repository.deleteById(key);}

}
