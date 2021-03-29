package stud.sem5.aui.lab.lab3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;
import stud.sem5.aui.lab.lab3.model.entity.CarModel;

import java.util.List;
import java.util.Optional;

public interface CarModelRepository extends JpaRepository<CarModel, Integer>{
    List<CarModel> findAllByBrand(CarBrand brand);
    Optional<CarModel> findByBrandAndId(CarBrand brand, Integer id);
}
