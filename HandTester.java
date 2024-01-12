package CardGame;

/**
* //This tester uses a Deck to generate cards to place in the Hand for testing
*
* @author wernerla
* @version for CSE 271 Spring 2018
*
*/
public class HandTester {
@SuppressWarnings("serial")
public static void main(String[] args) {
DeckList myDeck = new DeckList();// Deck to play with - no duplicate
// cards!
myDeck.shuffle();// shuffle it
int numcards = 7; // keep small to start
Hand myHand1 = new Hand(numcards);
System.out.printf("Tester for Hand class testing with a hand containing %d cards.\n", numcards);
Card dealt1 = myDeck.getCard();
System.out.println("Deal first card->" + dealt1.toString());
myHand1.addCard(dealt1);
System.out.println("Adding card to a hand--->\n");
myHand1.showHand();
System.out.println("Testing getTotalCards method--->" +
myHand1.getTotalCards());
Card dealt2 = myDeck.getCard();
System.out.println("\nDeal second card->" + dealt2.toString());
myHand1.addCard(dealt2);
System.out.println("Adding card to a hand--->\n");
myHand1.showHand();
System.out.println("getTotalCards returns--->" +
myHand1.getTotalCards());
// add cards to hand
for (int i = 0; i < myHand1.getHandSize(); i++) {
Card deal = myDeck.getCard();
myHand1.addCard(deal);
}
// Card newCard = myHand1.removeCard(i);
System.out.println("Testing getTotalCards()--->");
System.out.printf("My hand has %d cards.\n", myHand1.getTotalCards());
System.out.println("show full hand--->");
myHand1.showHand();
// testing addCard when hand is full
System.out.println("<--Testing addCard when full --> " +
myHand1.isFull());
Card add1 = new Card(2, 10);
boolean success = myHand1.addCard(add1);
System.out.println("Adding card?---> " + add1 + " " + success);
System.out.println("My hand should not change--> \n" +
myHand1.toString());
myHand1.sortHandBySuit();
System.out.println("After sorting by suit, hand is now--> ");
myHand1.showHand();
myHand1.sortHandByRank();
System.out.println("After sorting by rank, hand is now--> ");
myHand1.showHand();
// System.out.printf("My hand has %d cards.\n",myHand1.getTotalCards());
//
// Card add2 = new Card(4,2);
// myHand1.addCard(add2);
// System.out.println("Adding card---> "+add2);
// System.out.println("My hand is now--> \n"+myHand1);
// System.out.printf("My hand has %d cards.\n
// ",myHand1.getTotalCards());
//
// Card add3 = new Card(4,4);
// myHand1.addCard(add3);
// System.out.println("Adding card---> "+add3);
// System.out.println("My hand is now--> \n"+myHand1);
// System.out.printf("My hand has %d cards.\n
// ",myHand1.getTotalCards());
//
// testing remove card
// System.out.println("<--Testing removeCard--> ");
// try {
// Card removed = myHand1.removeCard(0);
// System.out.println("removed Card--> " + removed);
// System.out.println("My hand is now--> \n" + myHand1);
// System.out.println("0th Card--> " + myHand1.getCard(0));
// System.out.println("10th Card--> " + myHand1.getCard(10));
// System.out.println("1st Card--> " + myHand1.getCard(1));
// } catch (InvalidCardReference e) {
// System.out.println(e.getMessage());
// }
}
}
