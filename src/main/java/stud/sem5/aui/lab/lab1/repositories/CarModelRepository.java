package stud.sem5.aui.lab.lab1.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import stud.sem5.aui.lab.lab1.datastore.DataStore;
import stud.sem5.aui.lab.lab1.entity.CarModel;
import stud.sem5.aui.lab.lab1.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class CarModelRepository implements Repository<CarModel, Integer> {

    private DataStore dataStore;

    @Autowired
    public CarModelRepository(DataStore store){
        this.dataStore = store;
    }


    @Override
    public List<CarModel> findAll() {
        return dataStore.findAllCarModels();
    }


    @Override
    public Optional<CarModel> find(Integer key) {
        return dataStore.findCarModel(key);
    }


    @Override
    public void create(CarModel entity) {
        dataStore.createCarModel(entity);
    }


    @Override
    public void delete(Integer key){
        dataStore.deleteCarModel(key);
    }
}
