package CardGame;

/**
* Class: Card
* @author Mikey Arias
* @version 4.24.0
* Course : Cse271
* Written: April 23, 2022
*
* Purpose: – This class represents a single Card. The card is a traditional playing card -
* Face values are represented by the numbers 2 through 14 where 11 is a jack,
* 12 is a queen, 13 is a king, and 14 is an ace. Suits are represented by 1 for
* spades, 2 for hearts, 3 for clubs, and 4 for diamonds.
*/
public class Card implements CardInterface, Comparable {

	// instance variables
	private int suit;
	private int rank;

	/**
	 * Constructs a Card object with a random rank and suit
	 * The rank is randomly chosen 2 and 14 inclusive
	 * suits are randomly chosen from 1 to 4
	 * 
    */
	public Card() {
		rank = (int) (Math.random() * 13) + 2;
		suit = (int) (Math.random() * 4) + 1; 
	}

	/**
	 * This constructor creates a new Card object as a copy of the given Card
	 *@param other The Card object to copy.
    */
	public Card(Object other) {
		if (other != null && other instanceof Card) {
			this.setRank(((Card) other).getRank());
			this.setSuit(((Card) other).getSuit());
		}
	}

	/**
	 * This constructor creates a Card object with the given suit and rank.
	 * @param suit and @param rank will define the Card instantiation. 
    */
	public Card(int suit, int rank) {
		this.setSuit(suit);
		this.setRank(rank);

	}

	/**
	 * returns the card's rank as a number 
    */
	public int getRank() {
		return rank;
	}

	/**
	 * returns the suit's rank as a number
    */
	public int getSuit() {
		return suit;
	}

	/**
	 *  sets the Card object to the given rank
    */
	public void setRank(int rank) {
		if (rank >= TWO && rank <= ACE)
			this.rank = rank;
		else
			throw new InvalidCardException("Attempt to set a card to an invalid rank");
	}

	/**
	 *  sets the Card object to the given suit 
    */
	public void setSuit(int suit) {
		if (suit >= SPADES && suit <= DIAMONDS)
			this.suit = suit;
		else
			throw new InvalidCardException("Attempt to set card to an invalid suit");
	}

	/**
	 * Compares the card's suit with the @param other. 
	 * If both are the same it returns true, and false otherwise.
    */
	public boolean sameSuit(Card other) {
		if (other != null) {
			if (other.getSuit() == this.getSuit())
				return true;
			else
				return false;
		} else
			return false;
	}

	/**
	 * It compares the first Card with the @param other object.
	 * Returns the Max value of an interger if null or another object
	 * or a difference of ranks between the first and the second Card object.
    */
	public int compareTo(Object other) {
		if (other == null || !(other instanceof Card)) {
			return Integer.MAX_VALUE;
		} else {
			return this.rank - ((Card) other).rank;
		}
	}

	/**
	 * Returns the rank of the current object as a string.	 
    */
	public String getRankAsString() {
		switch (rank) {
		case TWO:
			return "Two";
		case THREE:
			return "Three";
		case FOUR:
			return "Four";
		case FIVE:
			return "Five";
		case SIX:
			return "Six";
		case SEVEN:
			return "Seven";
		case EIGHT:
			return "Eight";
		case NINE:
			return "Nine";
		case TEN:
			return "Ten";
		case ACE:
			return "Ace";
		case KING:
			return "King";
		case QUEEN:
			return "Queen";
		case JACK:
			return "Jack";
		default:
			return Integer.toString(rank);
		}
	}
	
   /**
	* returns the suit of the current object as a string.	 
    */
	public String getSuitAsString() {
		switch (suit) {
		case CLUBS:
			return "Clubs";
		case DIAMONDS:
			return "Diamonds";
		case HEARTS:
			return "Hearts";
		default:
			return "Spades";
		}
	}

	/**
	 * Returns the rank and suit of the selected Card object as a string.
    */
	public String toString() {
		String retString = "rank: " + this.getRank() + " suit: " + this.getSuit();
		return retString;
	}
	
	/**
	 * Compares two Card objects 
    */
	@Override
	public int compareTo(Card other) {

		return 0;
	}
}
