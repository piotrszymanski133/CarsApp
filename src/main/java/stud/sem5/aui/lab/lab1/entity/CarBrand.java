package stud.sem5.aui.lab.lab1.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
public class CarBrand {
    private String name;
    private int creationDate;

}
