package app.web.pavelk.teller1.model.car;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "code")
    private String code;


    @Column(name = "active")
    private Boolean active;

    @Column(name = "date")
    private LocalDateTime date;

}
