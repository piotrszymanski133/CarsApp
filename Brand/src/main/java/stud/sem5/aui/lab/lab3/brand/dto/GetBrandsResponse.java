package stud.sem5.aui.lab.lab3.brand.dto;

import lombok.*;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetBrandsResponse {

    @Singular
    private List<String> brands;

    public static Function<Collection<CarBrand>, GetBrandsResponse> entityToDtoMapper(){
        return brands -> {
            GetBrandsResponse.GetBrandsResponseBuilder responseBuilder = GetBrandsResponse.builder();
            brands.stream()
                    .map(CarBrand::getName)
                    .forEach(responseBuilder::brand);
            return responseBuilder.build();
        };
    }
}