package stud.sem5.aui.lab.lab1.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
public class CarModel {
    private Integer id;
    private CarBrand brand;
    private String name;
    private int price;
    private int generation;
}
