package CardGame;

import java.util.LinkedList;
import java.util.Random;

public class DeckList {
	public static final int DECKSIZE = 52;
	private LinkedList<Card> deck;
	private int cardsDealt = 0;

	/**
	 * Default constructor initializes the deck with Card objects.
	 */
	public DeckList() {
		deck = new LinkedList<Card>();
		this.initializeDeck();
		this.cardsDealt = 0;
	}

    /**
	* Initializes the deck by appending objects the end of the list.
    */
	private void initializeDeck() {
		for (int suit = Card.SPADES; suit <= Card.DIAMONDS; suit++) {
			for (int rank = Card.TWO; rank <= Card.ACE; rank++) {
				Card e = new Card(suit, rank);
				deck.addLast(e);
			}
		}
	}

	/**
	 * reset the deck and initializes a new complete deck. 	 
    */
	public void reset() {
		cardsDealt = 0;
		this.initializeDeck();
	}

	/**
	 * @return the cards left.	 
    */
	public int getCardsLeft() {
		return this.DECKSIZE - cardsDealt;
	}

	/**
	 * @return the cards dealt.	
    */
	public int getCardsDealt() {
		return cardsDealt;
	}

	/**
	 * returns the first card of the deck and then remove it.
    */
	public Card getCard() {
		if (this.getCardsLeft() <= 0 || this.deck.isEmpty()) {
			return null;
		}
		this.cardsDealt++;
		Card deal = (Card) deck.getFirst();
		deck.removeFirst();
		return deal;
	}

	/**
	 * @return the first card of the deck	 
    */
	public Card peek() {
		if (this.deck.isEmpty())
			return null;// no card to see
		else {
			return new Card(deck.getFirst());// use copy constructor
		}
	}

	/**
	 * shuffles card by storing two random cards from the deck
	 * and swapping them with each other
    */
	public void shuffle() {
		Random random = new Random(System.nanoTime());
		for (int i = 0; i < deck.size(); i++) {
			int pos1 = random.nextInt(deck.size()); 

			// swap two Cards in deck
			// get and remove a random card
			Card temp1 = (Card) this.deck.get(pos1);
			this.deck.remove(pos1);
			// get and remove another random card
			int pos2 = random.nextInt(deck.size());
			// make sure you are not swapping the same two
			while (pos2 == pos1)
			     pos2 = random.nextInt(deck.size());
			Card temp2 = (Card) this.deck.get(pos2);
			this.deck.remove(pos2);
			// replace pos2 card with pos1 card
			deck.add(pos2, temp1);
			// replace pos1 card with pos2 card
			deck.add(pos1, temp2);
		}
	}

   /**
	 * print the card objects from the deck
	 * 
	 * insert a line break when 5 cards are displayed
    */

	public void showDeck() {
		for (int i = 0; i < deck.size(); i++) {
			System.out.print(this.deck.get(i) + ", ");
			if ((i + 1) % 5 == 0) { 
				System.out.println();
			}
		}
		System.out.println();
	}
   /**
	 * print the card objects from the deck
	 * 
	 * insert a line break given by @param numPerLine 
    */

	public void showDeck(int numPerLine) {
		for (int i = 0; i < deck.size(); i++) {
			System.out.print(this.deck.get(i) + ", ");
			if ((i + 1) % numPerLine == 0 && i != 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// returns the reference of deck in the memory and the number of cards dealt
		return "DeckList [deck=" + deck + ", cardsDealt=" + cardsDealt + "]";
	}
}
