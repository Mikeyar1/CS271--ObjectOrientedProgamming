/**
 * Class: BookResult
 * The BookResult class represents the result of counting books in a player's hand.
 
 * @author mikeyarias
 * 
 * - Create an instance of BookResult by providing the number of books and the rank.
 * - Retrieve the number of books and rank using the provided getter methods.
 */
public 
package CardGame;

public class BookResult {
    private int books;
    private int rank;

    public BookResult(int books, int rank) {
        this.books = books;
        this.rank = rank;
    }

    public int getBooks() {
        return books;
    }

    public int getRank() {
        return rank;
    }
}

