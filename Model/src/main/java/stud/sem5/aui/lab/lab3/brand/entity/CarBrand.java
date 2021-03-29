package stud.sem5.aui.lab.lab3.brand.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;
import stud.sem5.aui.lab.lab3.model.entity.CarModel;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "brands")
public class CarBrand {

    @Id
    private String name;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "brand")
    private List<CarModel> models;
}
