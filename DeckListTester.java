package CardGame;

public class DeckListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeckList myDeck = new DeckList();
		System.out.println("Deck after construction");
		myDeck.showDeck(13);
		myDeck.shuffle();
		//
		System.out.println("\n*****Shuffled deck:");
		myDeck.showDeck(5);
		System.out.println(myDeck.getCardsDealt() + " cards have been dealt");
		Card dealt = myDeck.getCard();
		System.out.println("\nDeal first card->" + dealt.toString());
		dealt = myDeck.getCard();
		System.out.println("Deal second card->" + dealt.toString());
		dealt = myDeck.getCard();
		System.out.println("Deal third card->" + dealt.toString());
		dealt = myDeck.getCard();
		System.out.println("Deal 4th card->" + dealt.toString());
		System.out.println(myDeck.getCardsDealt() + " cards have been dealt");
		System.out.println("Deck now has these " + myDeck.getCardsLeft() + " cards:");
		myDeck.showDeck(5);
		System.out.println("\n*****Shuffling deck with only " + myDeck.getCardsLeft());
		myDeck.shuffle();
		// System.out.println("\nShuffle again\n"+myDeck.toString());
		myDeck.showDeck(5);
		dealt = myDeck.getCard();
		System.out.println("Removed another card -> " + dealt.toString());
		Card top = myDeck.getCard();

		System.out.println("Top card just peeking and not removing -> " + top.toString());
		/// System.out.println("\n"+myDeck.getDeck());
		System.out.println("Deck has " + myDeck.getCardsLeft() + " cards now.");
		myDeck.reset();
		System.out.println("\nDeck has " + myDeck.getCardsLeft() + " cards after reset.");
	}

}
