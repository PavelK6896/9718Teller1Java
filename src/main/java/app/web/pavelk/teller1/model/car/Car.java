package app.web.pavelk.teller1.model.car;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data

//12------------------------
//@SqlResultSetMapping(
//        name="EmployeeResult",
//        columns={@ColumnResult(name="number", type=String.class),
//                @ColumnResult(name="active", type=Boolean.class)}
//)
//------------------------------------


//13------------------------------
@SqlResultSetMapping(
        name = "EmployeeResult",
        classes = {
                @ConstructorResult(
                        targetClass = app.web.pavelk.teller1.model.car.EmployeeResult.class,
                        columns = {@ColumnResult(name = "number", type = String.class),
                                @ColumnResult(name = "active", type = Boolean.class)})
        }
)
//----------------------------------------------------------------------


//12 13 -------------------------
//@NamedNativeQuery(
//        name = "Employees",
//        query = "SELECT number, active FROM cars ",
//        resultSetMapping = "EmployeeResult"
//)

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

