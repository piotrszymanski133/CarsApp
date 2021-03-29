package stud.sem5.aui.lab.lab3.model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;

import javax.persistence.*;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "models")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "brand")
    private CarBrand brand;
    private String name;
    private int price;
    private int generation;
}

