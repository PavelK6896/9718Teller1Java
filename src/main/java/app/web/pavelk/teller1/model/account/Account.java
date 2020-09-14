package app.web.pavelk.teller1.model.account;


import app.web.pavelk.teller1.model.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bill")
    private Long bill;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIdentityReference(alwaysAsId = true) // только ид связанно с JsonIdentityInfo
    private User user;

}
