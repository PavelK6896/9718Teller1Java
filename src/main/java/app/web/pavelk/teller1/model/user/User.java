package app.web.pavelk.teller1.model.user;

import app.web.pavelk.teller1.model.account.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@idType")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)//Поле, которое имеет отношение // вобщем хозяин листа
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonBackReference
//    @Fetch(FetchMode.SELECT)
    @Fetch(FetchMode.JOIN)
    //Когда аннотация @Fetch не добавлена, HQL и Hibernate Criteria запросы ведут себя по-разному.
    // В случае использования HQL запроса, по умолчанию используется FetchMode.SELECT
    // для связанных коллекций с любым типом загрузки (EAGER и LAZY).
    private List<Account> account;

}
