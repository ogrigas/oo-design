package oo.naming;

import java.util.List;

public interface IBookManager {

    List<BookData> selectBook(String id);

    /**
     * @return all books written by the specified author
     */
    List<BookData> selectBooksBy(long authorId);

    /**
     * @param id Author ID
     */
    void insertNewBook(long id, BookData bookData);

    void addRating(String id, RatingInfo rating);

}
