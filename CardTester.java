package CardGame;

/**
* Class: CardTester
* @author Mikey Arias
* @version 4.24.0
* Course : Cse271
* Written: April 23, 2022
*
* Purpose: A tester class to test the Card class
*
*/
public class CardTester {
/**
* @param args
*/
public static void main(String[] args) {
// make card objects
Card card0 = new Card();// random card
Card card1 = new Card(1, 4);// 4 of spades
Card card2 = new Card(3, 14);// Ace of clubs
System.out.println("One card instantiated using the no argument" + " constructor, card0------>" + card0);
System.out.println("Two cards instantiated using the 2 "
+ "argumentconstructor, card1 and card 2------>"+ card1 + " " + card2);
// test getters
System.out.println("Testing Getter Methods------>");
System.out.println("card0 rank is " + card0.getRank());
System.out.println("card0 suit is " + card0.getSuit());
System.out.println("card1 rank is " + card1.getRank());
System.out.println("card1 suit is " + card1.getSuit());
System.out.println("card2 rank is " + card2.getRank());
System.out.println("card2 suit is " + card2.getSuit());
System.out.println("Testing getRankAsString() and" + " getSuitAsString() Methods------>");
System.out.println("card0 rank as String is " +
card0.getRankAsString());
System.out.println("card0 suit as String is " +
card0.getSuitAsString());
System.out.println("card1 rank as String is " +
card1.getRankAsString()); 
System.out.println("card1 suit as String is " +
card1.getSuitAsString());
System.out.println("card2 rank as String is " +
card2.getRankAsString());
System.out.println("card2 suit as String is " +
card2.getSuitAsString());
System.out.println("Testing toString Method------>");
System.out.println("card1 toString returns " + card1.toString());
System.out.println("card2 toString returns " + card2.toString());
// test compareTo
System.out.println("Testing compareTo Method------>");
int comp1 = card1.compareTo(card2);
System.out.println("card1.compareTo(card2) returns " + comp1);
// test sameSuit
System.out.println("Testing sameSuit Method------>");
boolean same = card1.sameSuit(card2);
System.out.println("cards 1 and 2 are the same suit? " + same);
System.out.print("Testing sameSuit Method with a new card ");
Card card3 = new Card(3, 10);
System.out.printf("named card3 which is the %s ------>\n",
card3.toString());
same = card2.sameSuit(card3);
System.out.println("cards 2 and 3 are the same suit? " + same);
// test compareTo again
comp1 = card2.compareTo(card3);
System.out.println("Testing compareTo Method further------>");
System.out.println("card2 is " + card2.toString());
System.out.println("card3 is " + card3.toString());
System.out.println("card2.compareTo(card3) returns " + comp1);
Card card4 = new Card(3, 10);
comp1 = card3.compareTo(card4);
System.out.println("Testing compareTo Method to " + "see if two cards ith same face value return zero------>");
System.out.print("New card instantiated. ");
System.out.println("card4 is " + card4.toString());
System.out.println("card3.compareTo(card4) returns " + comp1);
System.out.println("Testing setter methods ------>");
card4.setRank(8);
card4.setSuit(1);
System.out.println("card4 is changed to " + card4.toString());
try {
card4.setRank(8);
card4.setSuit(5);
} catch (InvalidCardException e) {
System.out.println(e.getMessage());
}
System.out.println("card4 remains " + card4.toString());
System.out.println("Testing copy constructor ------>");
Card card5 = new Card(card4);
System.out.println("The new card, card5 is a copy " + "of card4. " +
card5.toString());
}
}
