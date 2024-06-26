package edu.fiu.Group5Bookstore.DTOs;
import lombok.Data;


/**
 * This class acts as a Data Transfer Object, it helps to encapsulate data
 * so only the required information is sent from client to server
 */
@Data
public class BookDiscountPatchDTO {
    private String publisher;
    private double discount;

    @Override
    public String toString() {
        return "BookDiscountPatchDTO{" +
                "publisher=" + publisher +
                ", discount=" + discount +
                '}';
    }
}
