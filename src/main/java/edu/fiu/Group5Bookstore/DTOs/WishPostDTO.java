package edu.fiu.Group5Bookstore.DTOs;

import lombok.Data;

@Data
public class WishPostDTO {
    private String name;
    private int userId;
    private int bookId;
    private int wishlistId;

    @Override
    public String toString() {
        return "WishPostDTO{" +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", wishlistId=" + wishlistId +
                ", name=" + name +
                '}';
    }
}
