package stud.sem5.aui.lab.lab3.brand.dto;

import lombok.*;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;

import java.util.function.Function;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateBrandRequest {

    private String name;
    private int creationDate;

    public static Function<CreateBrandRequest, CarBrand> dtoToEntityMapper(){
        return createBrandRequest -> CarBrand.builder()
                .name(createBrandRequest.getName())
                .creationDate(createBrandRequest.getCreationDate())
                .build();
    }

}
