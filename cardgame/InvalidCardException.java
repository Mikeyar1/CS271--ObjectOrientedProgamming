package CardGame;

/**
 * 
 */

/**
 * @author mikeyarias
 *
 */
public class InvalidCardException extends RuntimeException {

	public InvalidCardException() {
		super("The suit or rank of the card was not within the designated bounds.");
	}
	public InvalidCardException(String reason) {
		// TODO Auto-generated constructor stub
		super(reason);

	}

}
