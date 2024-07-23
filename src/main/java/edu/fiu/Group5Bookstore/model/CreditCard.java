package edu.fiu.Group5Bookstore.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "exp_date")
    private String expDate;

    @Column(name = "cvc")
    private String cvc;

    @ManyToOne
    private User user;

    public CreditCard() {
    }

    public CreditCard(int id, String number, String expDate, String cvc) {
        this.id = id;
        this.number = number;
        this.expDate = expDate;
        this.cvc = cvc;
    }
}
