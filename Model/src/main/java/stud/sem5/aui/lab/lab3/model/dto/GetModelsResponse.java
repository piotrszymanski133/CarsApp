package stud.sem5.aui.lab.lab3.model.dto;

import lombok.*;

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
public class GetModelsResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class CarModel {
        private Integer id;
        private String name;
    }

    @Singular
    private List<CarModel> models;

    public static Function<Collection<stud.sem5.aui.lab.lab3.model.entity.CarModel>, GetModelsResponse> entityToDtoMapper(){
        return models -> {
            GetModelsResponseBuilder responseBuilder = GetModelsResponse.builder();
            models.stream()
                    .map(carModel -> CarModel.builder()
                            .id(carModel.getId())
                            .name(carModel.getName())
                            .build())
                    .forEach(responseBuilder::model);
            return responseBuilder.build();
        };
    }
}