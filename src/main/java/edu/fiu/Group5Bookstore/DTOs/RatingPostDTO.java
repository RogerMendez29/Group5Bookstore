package edu.fiu.Group5Bookstore.DTOs;

public class RatingPostDTO {

    private int userId;
    private int bookId;
    private int rating;

    public RatingPostDTO() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "RatingPostDTO{" +
                "bookId=" + bookId +
                ", userId=" + userId +
                ", rating=" + rating +
                '}';
    }
}
