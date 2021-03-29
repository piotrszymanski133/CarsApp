package stud.sem5.aui.lab.lab3.brand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;
import stud.sem5.aui.lab.lab3.brand.event.repository.BrandEventRepository;
import stud.sem5.aui.lab.lab3.brand.repository.CarBrandRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CarBrandService {

    private CarBrandRepository repository;
    private BrandEventRepository eventRepository;

    @Autowired
    public CarBrandService(CarBrandRepository carBrandRepository, BrandEventRepository eventRepository) {
        this.repository = carBrandRepository;
        this.eventRepository = eventRepository;
    }

    public List<CarBrand> findAll() {
        return repository.findAll();
    }

    public Optional<CarBrand> find(String key) {
        return repository.findById(key);
    }

    @Transactional
    public void create(CarBrand entity) {
        repository.save(entity);
        eventRepository.create(entity);
    }

    @Transactional
    public void update(CarBrand entity) {
        repository.save(entity);
    }

    @Transactional
    public void delete(String key) {
        repository.deleteById(key);
        eventRepository.delete(key);
    }
}