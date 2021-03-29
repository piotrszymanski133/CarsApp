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
public class CreateBrandRequest {

    private String name;

    public static Function<CreateBrandRequest, CarBrand> dtoToEntityMapper(){
        return createBrandRequest -> CarBrand.builder()
                .name(createBrandRequest.getName())
                .build();
    }
}
