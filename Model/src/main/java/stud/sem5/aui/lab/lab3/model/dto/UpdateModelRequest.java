package stud.sem5.aui.lab.lab3.model.dto;

import lombok.*;
import stud.sem5.aui.lab.lab3.model.entity.CarModel;

import java.util.function.BiFunction;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UpdateModelRequest {

    private String name;
    private int price;
    private int generation;

    public static BiFunction<CarModel, UpdateModelRequest, CarModel> dtoToEntityUpdater() {
        return (carModel, updateModelRequest) -> {
            carModel.setName(updateModelRequest.getName());
            carModel.setPrice(updateModelRequest.getPrice());
            carModel.setGeneration(updateModelRequest.getGeneration());
            return carModel;
        };
    }
}