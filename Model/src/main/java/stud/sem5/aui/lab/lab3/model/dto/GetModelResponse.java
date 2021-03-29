package stud.sem5.aui.lab.lab3.model.dto;

import lombok.*;
import stud.sem5.aui.lab.lab3.model.entity.CarModel;

import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetModelResponse {

    private String brand;
    private String name;
    private int price;
    private int generation;

    public static Function<CarModel, GetModelResponse> entityToDtoMapper(){
        return carModel -> GetModelResponse.builder()
                .brand(carModel.getBrand().getName())
                .name(carModel.getName())
                .price(carModel.getPrice())
                .generation(carModel.getGeneration())
                .build();
    }
}