package edu.fiu.Group5Bookstore.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentPostDTO {

    private int bookId;
    private int userId;
    private String comment;
    private LocalDate datestamp;

    @Override
    public String toString() {
        return "CommentPostDTO [bookId=" + bookId + ", userId=" + userId + ", comment=" + comment + ", datestamp=" + datestamp + "]";
    }
}
