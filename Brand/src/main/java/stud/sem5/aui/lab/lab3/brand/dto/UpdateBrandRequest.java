package stud.sem5.aui.lab.lab3.brand.dto;

import lombok.*;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;

import java.util.function.BiFunction;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateBrandRequest {

    private int creationDate;

    public static BiFunction<CarBrand, UpdateBrandRequest, CarBrand> dtoToEntityUpdater(){
        return (carBrand, updateBrandRequest) -> {
            carBrand.setCreationDate(updateBrandRequest.getCreationDate());
            return carBrand;
        };
    }
}
