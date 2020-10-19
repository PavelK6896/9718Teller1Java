package app.web.pavelk.teller1.model.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CarDto {
    private String number;
    private Long count;
    private Long count2;
    private List<Long> list;


    @Data
    @Builder
    @AllArgsConstructor
    public static class Car2 {
        private Long count3;
        private Long count4;
    }

}
