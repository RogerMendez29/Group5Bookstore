package edu.fiu.Group5Bookstore.DTOs;

import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;

@Data
public class RatingPostDTO {

    @Getter
    private int userId;
    private int bookId;
    private int rating;
    private LocalDate datestamp;

    @Override
    public String toString() {
        return "RatingPostDTO{" +
                "bookId=" + bookId +
                ", userId=" + userId +
                ", rating=" + rating +
                ", datestamp=" + datestamp +
                '}';
    }
}
