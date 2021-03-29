package stud.sem5.aui.lab.lab3.brand.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@EqualsAndHashCode
@Table(name = "brands")
public class CarBrand {
    @Id
    private String name;
    private int creationDate;
}