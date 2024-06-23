package edu.fiu.Group5Bookstore.DTOs;

import lombok.Data;

/**
 * This class acts as a Data Transfer Object, it helps to encapsulate data
 * so only the required information is sent from client to server
 */
@Data
public class CartItemPostDTO {

    private int bookId;
    private int userId;
    private int quantity;

    @Override
    public String toString() {
        return "CartItemPostDTO{" +
                "bookId=" + bookId +
                ", userId=" + userId +
                ", quantity=" + quantity +
                '}';
    }
}
