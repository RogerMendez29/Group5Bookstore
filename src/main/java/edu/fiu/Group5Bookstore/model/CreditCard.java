package edu.fiu.Group5Bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    private String expDate;

    private String cvc;

    public CreditCard() {
    }

    public CreditCard(int id, String number, String expDate, String cvc) {
        this.id = id;
        this.number = number;
        this.expDate = expDate;
        this.cvc = cvc;
    }
}
