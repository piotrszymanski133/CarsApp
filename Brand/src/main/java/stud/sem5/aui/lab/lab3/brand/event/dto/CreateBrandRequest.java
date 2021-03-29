package stud.sem5.aui.lab.lab3.brand.event.dto;

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

    public static Function<CarBrand, CreateBrandRequest> entityToDtoMapper() {
        return entity -> CreateBrandRequest.builder()
                .name(entity.getName())
                .build();

    }
}
