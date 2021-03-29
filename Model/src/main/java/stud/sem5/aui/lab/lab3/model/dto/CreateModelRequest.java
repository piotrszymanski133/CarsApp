package stud.sem5.aui.lab.lab3.model.dto;

import lombok.*;
import stud.sem5.aui.lab.lab3.brand.entity.CarBrand;
import stud.sem5.aui.lab.lab3.model.entity.CarModel;

import java.util.function.Function;
import java.util.function.Supplier;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CreateModelRequest {


    private String brand;
    private String name;
    private int price;
    private int generation;

    public static Function<CreateModelRequest, CarModel> dtoToEntityMapper(
            Supplier<CarBrand> brandSupplier){
        return createModelRequest -> CarModel.builder()
                .brand(brandSupplier.get())
                .name(createModelRequest.getName())
                .price(createModelRequest.getPrice())
                .generation(createModelRequest.getGeneration())
                .build();
    }
}