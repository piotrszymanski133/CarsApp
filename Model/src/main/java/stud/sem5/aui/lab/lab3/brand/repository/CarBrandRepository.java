package stud.sem5.aui.lab.lab3.brand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand, String> {
}
