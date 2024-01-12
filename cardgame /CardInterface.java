package CardGame;

/**
* Class: CardInterface
* @author Mikey Arias
* @version 4.24.0
* Course : Cse271
* Written: April 23, 2022
*
* Purpose: An interface for a playing card
*
*/
public interface CardInterface {
// Define the suit
public static final int SPADES = 1;
public static final int HEARTS = 2;
public static final int CLUBS = 3;
public static final int DIAMONDS = 4;
// define the card rank
public static final int TWO = 2;
public static final int THREE = 3;
public static final int FOUR = 4;
public static final int FIVE = 5;
public static final int SIX = 6;
public static final int SEVEN = 7;
public static final int EIGHT = 8;
public static final int NINE = 9;
public static final int TEN = 10;
public static final int JACK = 11;
public static final int QUEEN = 12;
public static final int KING = 13;
public static final int ACE = 14;

/**
* Get the rank of the card.
*/
public int getRank();

/**
* Get the suit of the card.
*/
public int getSuit();

/**
* Set the rank of the card.
* 
* @param rank The rank to set.
*/
public void setRank(int rank);

/**
* Set the suit of the card.
* 
* @param suit The suit to set.
*/
public void setSuit(int suit);

/**
*  Check if the card has the same suit as another card.
*  
*  @param other The other card to compare with.
*/
public boolean sameSuit(Card other);

/**
* Compare this card to another card based on rank.
* 
* @param other The other card to compare with.
*/
public int compareTo(Card other);

/**
* Compare this card to another object based on rank.
* 
* @param other The other object to compare with.
*/
public int compareTo(Object other);

/**
* Get the rank of the card as a string.
*/
public String getRankAsString();

/**
* Get the suit of the card as a string.
*/
public String getSuitAsString();


/**
* Get a string representation of the card.
*/
@Override 
public String toString();
}
