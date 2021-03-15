package stud.sem5.aui.lab.lab1.datastore;

import org.springframework.stereotype.Component;
import stud.sem5.aui.lab.lab1.entity.CarBrand;
import stud.sem5.aui.lab.lab1.entity.CarModel;

import java.util.*;

@Component
public class DataStore {

    private Set<CarBrand> brands = new HashSet<>();
    private Set<CarModel> models = new HashSet<>();

    public synchronized List<CarBrand> findAllCarBrands(){ return new ArrayList<CarBrand>(brands); }

    public  synchronized void createCarBrand(CarBrand entity) {brands.add(entity);}

    public synchronized  Optional <CarBrand> findCarBrand(String name){
        return brands.stream()
                .filter(carBrand -> carBrand.getName().equals(name))
                .findFirst();
    }

    public synchronized void deleteCarBrand(String key) throws IllegalArgumentException{
        findCarBrand(key).ifPresentOrElse( brand -> brands.remove(brand),
                () -> {throw new IllegalArgumentException(key + " brand does not exist!");});
    }


    public synchronized List<CarModel> findAllCarModels(){ return new ArrayList<>(models); }

    public  synchronized void createCarModel(CarModel entity) {
        models.add(entity);
        System.out.println("Successfully added new model");
    }

    public synchronized  Optional <CarModel> findCarModel(Integer id){
        return models.stream()
                .filter(carModel -> carModel.getId().equals(id))
                .findFirst();
    }

    public synchronized void deleteCarModel(Integer key) throws IllegalArgumentException{
        findCarModel(key).ifPresentOrElse( model -> {models.remove(model);
                System.out.println("Deleted model with id " + key );},
                () -> {System.err.println("Model with id " + key.toString() + " does not exist!");});
    }



}
