package CardGame;


import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/**
*
* @author Mikey Arias
*
* This class represents a hand for a card game
* @param <T>
*/
@SuppressWarnings("rawtypes")
public class Hand extends Card implements Comparable {
private LinkedList<Card> hand;
private int handSize; // size of the hand for a specific game
private final int defaultNumCards = 7;

/**
* Initializes hand to numCards as a maximum size for the hand and
* 
* initializes totalCards in the Hand to zero. No cards are in the hand yet
*/

public Hand() {
	this.handSize = defaultNumCards;
	hand = new LinkedList<Card>();
}

public Hand(int numCards) {
this.handSize = numCards;
hand = new LinkedList<Card>();
}

/**
* Returns a card from the hand as specified by the user and removes it.
*
* @param whichOne
* number indicating what card to return.
* @return 0th, 1st, 2nd, ... totalCards card in hand. null if the whichOne
* is invalid.
* @throws InvalidCardReference
*/
public Card removeCard(int whichOne) throws InvalidCardReference {
Card temp = null;
//&& whichOne < this.hand.size()
if (this.hand.size() > 0) {
temp = this.hand.get(whichOne);
hand.remove(whichOne);
} else 
throw new InvalidCardReference();
return new Card(temp.getSuit(), temp.getRank());
}

public Card removeCardByRank(int rank) throws InvalidCardReference {
	for (int i = 0; i < hand.size(); i++) {
		if(hand.get(i).getRank() == rank) {
			return hand.remove(i);
		}
}
	return null;
}


/**
* @param wonCard
* - card to add to the hand
* @return true if add was successful
*/
public boolean addCard(Card wonCard) {
if (wonCard != null) {
//if (!this.isFull()) {
Card temp = new Card(wonCard.getSuit(), wonCard.getRank());
this.hand.add(temp);
// this.totalCards++;
return true;
}
//}
return false;
}

/**
* Displays all the cards in the Hand at a given time
*/
public void showHand() {
for (int i = 0; i < this.hand.size(); i++) {
Card s = hand.get(i);
System.out.println(s.getRankAsString() + " of " +
s.getSuitAsString());
}
}

/**
 * Check if the hand contains four cards of the same rank (four-of-a-kind).
 *
 * @return True if the hand has four cards of the same rank, false otherwise.
 * @throws InvalidCardReference if there is an issue with card references.
 */
public boolean hasFourOfAKind() {
    Map<Integer, Integer> rankCounts = new HashMap<>();

    // Count the occurrences of each rank in the hand
    for (Card card : hand) {
        int rank = card.getRank();
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
    }

    // Check if there is any rank that occurs four times
    for (int count : rankCounts.values()) {
        if (count >= 4) {
            return true;
        }
    }
    return false;
}

/**
 * Check if the hand contains a card with a specific rank.
 *
 * @param wantedRank The rank of the card being checked.
 * @return True if the hand has a card with the specified rank, false otherwise.
 */
public boolean hasCardWithRank(int wantedRank) {
    for (Card card : hand) {
        if (card.getRank() == wantedRank) {
            return true;
        }
    }
    return false;
}


/**
* @param i
* @return the card at position i in the Hand
*/
public Card getCard(int i) {
Card s;
try {
s = hand.get(i);
return new Card(s.getSuit(), s.getRank());
} catch (IndexOutOfBoundsException e) {
// TODO Auto-generated catch block
// e.printStackTrace();
e.getMessage();
return null;
}
}

/**
* @return true if the Hand has no cards
*/
public boolean isEmpty() {
if (hand.size() == 0)
return true;
else
return false;
}

/**
* @return true if the totalCards in the Hand is equal to numCards
*/
public boolean isFull() {
if (hand.size() == this.handSize)
return true;
else
return false;
}

/**
* @return number of cards in the hand
*/
public int getTotalCards() {
return this.hand.size();
}

/**
* @return the handSize
*/
public int getHandSize() {
return handSize;
}

/**
* @param handSize
* the handSize to set
*/
public void setHandSize(int handSize) {
this.handSize = handSize;
}

/**
* @return the hand
*/
public LinkedList<Card> getHand() {
return hand;
}

/**
 * Counts the number of sets of four cards of the same rank in the hand.
 *
 * @return A Map.Entry where the key is the count of sets and the value is the rank of the set.
 */
public Map.Entry<Integer, Integer> countBooks() {
    Map<Integer, Integer> rankCounts = new HashMap<>();

    // Count the occurrences of each rank in the hand
    for (Card card : hand) {
        int rank = card.getRank();
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
    }

    // Check if there is any rank that occurs four times
    for (Map.Entry<Integer, Integer> entry : rankCounts.entrySet()) {
        if (entry.getValue() >= 4) {
            return new AbstractMap.SimpleEntry<>(entry.getValue() / 4, entry.getKey());
        }
    }

    return new AbstractMap.SimpleEntry<>(0, -1); // No books found
}

/**
* Sort the Hand by suit. This is a two-level sort and doesn't use the
* Comparable interface.
*
*/
public void sortHandBySuit() {
boolean sorted = false;
// first sort by suit, not paying attention the the rank of the card
while (sorted == false) {
sorted = true;// flag to check if any cards were swapped
for (int i = 0; i < this.hand.size() - 1; i++) {
if (hand.get(i).getSuit() > hand.get(i + 1).getSuit()) {
// swap cards
sorted = false;// we aren't done sorting
Card hold1 = hand.remove(i);
Card hold2 = hand.remove(i);
hand.add(i, hold2);
hand.add((i + 1), hold1);
}
}
} 
// end while
// now sort within the suit
sorted = false;
// System.out.println("sort by suit phase 1, suit only, no rank within suit");
// this.showHand();
System.out.println();
while (sorted == false) {
sorted = true;
int pos = 0;
for (int suit = SPADES; suit <= DIAMONDS; suit++) {
int count = countSuit(suit); //counts number in the hand of suit 
Card[] temp = new Card[count]; //make a small array of one suit
for (int i = pos, c = 0; c < count; i++, c++) {
temp[c] = hand.get(i);
}
if (count >= 2)
bubbleSort(temp);// no need to sort unless there are two or more of the same suit
//put the sorted elements back into the hand in order
for (int i = pos, c = 0; c < count; i++, c++) {
hand.set(i, temp[c]);
}
pos += count;//update position in the linked list where another suit starts
} // end for
} // end while
}
// Sorts the specified array of Comparable objects using a bubble sort
// algorithm.
// -----------------------------------------------------------------
@SuppressWarnings("unchecked")
public static void bubbleSort(Comparable[] data) {
int position, scan;
for (position = 0; position < data.length - 1; position++) {
for (scan = 0; scan < data.length - 1; scan++) {
// System.out.println(" in sort " + data[scan] + " " + data[scan// + 1]);
if (data[scan].compareTo(data[scan + 1]) > 0)
swap(data, scan, scan + 1);
}
}
}
private static void swap(Comparable[] data, int index1, int index2) {
Comparable temp = data[index1];
data[index1] = data[index2];
data[index2] = temp;
}

// -----------------------------------------------------------------
/**
* Counts the number of cards of a specific suit in the hand
* @param suit - the suit in the hand
* @return the count of cards of the suit in the hanbd
*/
private int countSuit(int suit) {
int count = 0;
for (int i = 0; i < this.hand.size(); i++) {
if (hand.get(i).getSuit() == suit)
count++;
}
return count;
}

/**
* sort the hand by Rank
* several methods for sorting are presented in the comments
*/
@SuppressWarnings("unchecked")
public void sortHandByRank() {
// brute force way to convert the list to an array of card objects
/*
Card[] temp = new Card[hand.size()];
int count = hand.size();
for (int c = 0; c < count; c++)
temp[c] = hand.get(c);
*/
//Arrays.sort works well but you have to put the
//sorted array back into the list
/*
Arrays.sort(temp);
for (int i = 0; i < this.hand.size(); i++) {
hand.set(i, temp[i]);
}
*/
// use the toArray method in the LinkedList class
// not yet working correctly here but the Arrays.sort method is very efficient
//Card[] newArray = (Card[]) hand.toArray();
//String array[] = list.toArray(new String[6]);
// Collections sorting works here too.
Collections.sort(hand);
}
/**
* Converts a hand to a printable string representation.
*
* @return String representation of hand: one card per line
*/
public String toString() {
String result = "";
int i = 0;
while (i < hand.size()) {
if (hand.get(i) != null) {
result += hand.get(i).toString() + "\n";
i++;
}
}
return result;
}
}
