package stud.sem5.aui.lab.lab1.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import stud.sem5.aui.lab.lab1.datastore.DataStore;
import stud.sem5.aui.lab.lab1.entity.CarBrand;
import stud.sem5.aui.lab.lab1.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class CarBrandRepository implements Repository<CarBrand, String> {

    private DataStore dataStore;

    @Autowired
    public CarBrandRepository(DataStore store){
        this.dataStore = store;
    }


    @Override
    public List<CarBrand> findAll() {
        return dataStore.findAllCarBrands();
    }


    @Override
    public Optional<CarBrand> find(String key) {
        return dataStore.findCarBrand(key);
    }


    @Override
    public void create(CarBrand entity) {
        dataStore.createCarBrand(entity);
    }


    @Override
    public void delete(String key){
        dataStore.deleteCarBrand(key);
    }
}

