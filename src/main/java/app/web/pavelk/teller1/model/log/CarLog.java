package app.web.pavelk.teller1.model.log;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
@Table(name = "car_log")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "log")
    private String log;
    @Lob
    @Column(name = "car")
    private String car;

}
