package CardGame;
import java.util.*;

/**
* Class: Deck
* @author Mikey Arias
* @version 4.24.0
* Course : Cse271
* Written: April 23, 2022
*
* Purpose: – This class represents a set of 52 traditional playing cards.
* It purposes is to simulate the basic functions of a pack of cards.
*/
public class Deck{
public static final int DECKSIZE = 52;
private Card[] deck;
private int cardsDealt = 0;

/**
* Default constructor
* 
* initializes the deck with suits from 1 to 4
* and rank from 2 to 14.
*/
public Deck() {
this.initializeDeck();
cardsDealt=0;
}

/**
* reset the cards dealt 
*/
private void reset() {
cardsDealt = 0;
}

/**
* @return the cards left in the deck
*/
public int getCardsLeft() {
return deck.length - cardsDealt;
}

/**
* @return the cards that have been dealt
*/
public int getCardsDealt() {
return cardsDealt;
}

/**
* @return the current card and increases the cardsDealt by 1
* if there is not card left returns 0
*/
public Card dealCard() {
if ( getCardsLeft() <= 0 ) {
return null;
} 
return deck[cardsDealt++];
}

/**
* Create a full deck of 52 playing cards
* initializes an array of the cards, unshuffled, with unique cards
* Called only in Constructor
*/
private void initializeDeck() {
deck = new Card[DECKSIZE];
int pos = 0;
for( int suit = Card.SPADES; suit <= Card.DIAMONDS; suit++ ) {
for( int rank = 2; rank <= Card.ACE; rank++ ) {
deck[pos++] = new Card(suit, rank);
}
}
}

/**
* Creates a new reference to the deck[] array Card objects and then
* randomly select an index from the new referenced array to store in a 
* sequential order in the old deck[] array.
*/
public void randomShuffle() {
Card[] other = deck;
deck = new Card[deck.length];
Random random = new Random(System.nanoTime());
for(int i = 0; i < deck.length; i++) {
int pos = random.nextInt(DECKSIZE);
while(other[pos] == null) {
pos = random.nextInt(DECKSIZE);
}
deck[i] = other[pos];
other[pos] = null;
}
reset();
}

/**
* Randomly swap Card objects by storing the objects in a temp
* holder Card and then swapping it with the random generated position.
*/
public void randomShuffleSwap() {
Random random = new Random(System.nanoTime());
for(int i = 0; i < deck.length; i++) {
int pos = random.nextInt(DECKSIZE);
Card holder = new Card(deck[i]);
deck[i] = deck[pos];
deck[pos] = holder;
}
reset();
}

/**
* output the deck list of objects as a string.
*/
public String toString(){
String retString="";
for (int i = 0; i<deck.length;i++){
retString = retString + deck[i]+"\n";
}
return retString;
}
}
