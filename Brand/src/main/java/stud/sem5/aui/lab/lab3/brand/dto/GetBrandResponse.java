package stud.sem5.aui.lab.lab3.brand.dto;

import lombok.*;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetBrandResponse {

    private String name;
    private int creationDate;

    public static Function<CarBrand, GetBrandResponse> entityToDtoMapper(){
        return carBrand -> GetBrandResponse.builder()
                .name(carBrand.getName())
                .creationDate(carBrand.getCreationDate())
                .build();
    }

}
