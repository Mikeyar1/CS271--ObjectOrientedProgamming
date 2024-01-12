package CardGame;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
* Class: Card
* @author Mikey Arias
* @version 4.24.0
* Course : Cse271
* Written: April 23, 2022
*
*  The PlayGame class represents a card game where players try to form sets of four-of-a-kind.
* It inherits from the Hand class and includes methods to facilitate the gameplay.
*/

public class PlayGame extends Hand {

    // Instance variables
    private LinkedList<Hand> playerHands;
    private DeckList funDeck;
    private int numPlayers;
    private int[] playerScores;

    /**
     * Constructor to initialize the game with the given number of players and hand size.
     *
     * @param numPlayers Number of players in the game (2 to 4).
     * @param handSize   Size of each player's hand.
     * @throws InvalidCardReference if there is an issue with card references.
     */
    public PlayGame(int numPlayers, int handSize) throws InvalidCardReference {
        if (numPlayers < 2 || numPlayers > 4) {
            throw new IllegalArgumentException("Number of players must be between 2 and 4");
        }

        this.numPlayers = numPlayers;
        playerScores = new int[numPlayers];
        funDeck = new DeckList();
        funDeck.shuffle();
        playerHands = new LinkedList<>();

        dealHands(handSize);
    }

    /**
     * Private method to deal cards to each player's hand during game initialization.
     *
     * @param handSize Size of each player's hand.
     * @throws InvalidCardReference if there is an issue with card references.
     */
    private void dealHands(int handSize) throws InvalidCardReference {
        for (int i = 0; i < numPlayers; i++) {
            Hand hand = new Hand(handSize);
            for (int j = 0; j < handSize; j++) {
                Card card = funDeck.getCard();
                hand.addCard(card);
            }
            playerHands.add(hand);
        }
    }

    /**
     * Get the number of players in the game.
     *
     * @return The number of players.
     */
    public int getNumPlayers() {
        return numPlayers;
    }

    /**
     * Get the hand of a specific player.
     *
     * @param playerNum The player number.
     * @return The Hand of the specified player.
     */
    public Hand getHand(int playerNum) {
        return playerHands.get(playerNum);
    }

    /**
     * Show the hand of a specific player.
     *
     * @param playerNum The player number.
     */
    public void showHand(int playerNum) {
        Hand hand = playerHands.get(playerNum);
        hand.showHand();
    }

    /**
     * Check if a player has four of a kind in their hand.
     *
     * @param playerNum The player number.
     * @return True if the player has four of a kind, false otherwise.
     * @throws InvalidCardReference if there is an issue with card references.
     */
    public boolean hasFourOfaKind(int playerNum) throws InvalidCardReference {
        Hand hand = playerHands.get(playerNum);
        return hand.hasFourOfAKind();
    }

    /**
     * Check if a specific card rank is in a player's hand.
     *
     * @param playerNum  The player number.
     * @param wantedRank The rank of the card being checked.
     * @return True if the card is in the player's hand, false otherwise.
     */
    public boolean hasWantedCard(int playerNum, int wantedRank) {
        Hand hand = playerHands.get(playerNum);
        return hand.hasCardWithRank(wantedRank);
    }

    /**
     * Update the score of a player when they get a book.
     *
     * @param playerNum The player number.
     */
    public void updateScore(int playerNum) {
        playerScores[playerNum]++;
    }

    /**
     * Show the scores of all players.
     */
    public void showScores() {
        for (int i = 0; i < playerScores.length; i++) {
            System.out.println("Player " + (i + 1) + ": " + playerScores[i] + " books");
        }
    }
    
    /**
     * Collects books (sets of four cards with the same rank) from the hands of all players.
     * A book is removed from the hand and contributes to the player's score.
     *
     * @throws InvalidCardReference if there is an issue with card references.
     */
    private void collectBooks(int playerNum, int bookRank) throws InvalidCardReference {
        Hand hand = playerHands.get(playerNum);
        for (int i = hand.getHand().size() - 1; i >= 0; i--) {
            Card card = hand.getCard(i);
            if (card.getRank() == bookRank) {
                hand.removeCard(i);
            }
        }
        System.out.println("Player " + (playerNum + 1) + " collected a book of rank " + bookRank);
    }

    /**
     * Determine the winner of the game based on the scores.
     *
     * @return True if a winner is found, false otherwise.
     * @throws InvalidCardReference 
     */
    public Map.Entry<Integer, Integer> determineWinner() throws InvalidCardReference {
        int maxScore = -1;
        int maxBooks = -1;
        int winner = -1;

        for (int i = 0; i < playerScores.length; i++) {
            if (playerScores[i] > maxScore) {
                maxScore = playerScores[i];
                Map.Entry<Integer, Integer> booksAndRank = playerHands.get(i).countBooks();
                maxBooks = booksAndRank.getKey();
                int bookRank = booksAndRank.getValue();
                winner = i;

                if (maxBooks > 0) {
                    collectBooks(i, bookRank);
                }
            } else if (playerScores[i] == maxScore) {
                Map.Entry<Integer, Integer> booksAndRank = playerHands.get(i).countBooks();
                int books = booksAndRank.getKey();
                int bookRank = booksAndRank.getValue();

                if (books > maxBooks) {
                    maxBooks = books;
                    winner = i;

                    if (maxBooks > 0) {
                        collectBooks(i, bookRank);
                    }
                }
            }
        }

        if (maxScore > 0) {
            System.out.println("Player " + (winner + 1) + " wins with " + maxBooks + " books and " + maxScore + " points");
            return new AbstractMap.SimpleEntry<>(maxBooks, winner);
        } else {
            System.out.println("No winner yet.");
            return new AbstractMap.SimpleEntry<>(0, -1);
        }
    }

    /**
     * Play the game by taking turns and updating the game state.
     *
     * @throws InvalidCardReference if there is an issue with card references.
     */
    public void playNow() throws InvalidCardReference {
        Scanner scan = new Scanner(System.in);

        while (funDeck.getCardsLeft() > 0) {
            for (int i = 0; i < numPlayers; i++) {
                int targetPlayerIndex = (i + 1) % numPlayers;

                System.out.println("----- Player " + (i + 1) + "'s turn -----");
                System.out.println("Your hand:");
                showHand(i);

                boolean anotherTurn = false;  // Flag to check if the player gets another turn

                do {
                    System.out.println("Ask player " + (targetPlayerIndex + 1) + ": Do you have any card of rank? (Enter rank)");
                    int requestedRank = scan.nextInt();

                    if (hasWantedCard(targetPlayerIndex, requestedRank)) {
                        transferCards(i, targetPlayerIndex, requestedRank);
                        updateScore(i);

                        // Check if the player got a book
                        if (hasFourOfaKind(i)) {
                            collectBooks(i, requestedRank);
                            updateScore(i); // Increment the score again after collecting the book
                        }
                        System.out.println("You got the card you asked for!");
                        anotherTurn = true;  // Player gets another turn
                    } else {
                        System.out.println("Go fish!");
                        Card drawnCard = funDeck.getCard();
                        getHand(i).addCard(drawnCard);
                        System.out.println("You drew: " + drawnCard);

                        if (drawnCard.getRank() == requestedRank) {
                            System.out.println("You drew the card you asked for!");

                            // Check if the player got a book
                            if (hasFourOfaKind(i)) {
                                collectBooks(i, requestedRank);
                                updateScore(i); // Increment the score again after collecting the book
                            }

                            anotherTurn = true;  // Player gets another turn
                        } else {
                            anotherTurn = false;  // Player's turn ends
                        }
                    }
                } while (anotherTurn);  // Repeat the turn if the player gets another turn
            }
        }
        System.out.println("No cards left. Game over.");
        determineWinner();
    }


    /**
     * Transfer cards between players during the game.
     *
     * @param currentPlayerIndex The index of the current player.
     * @param targetPlayerIndex  The index of the target player.
     * @param rank               The rank of the card to transfer.
     * @throws InvalidCardReference 
     */
    private void transferCards(int currentPlayerIndex, int targetPlayerIndex, int rank) throws InvalidCardReference {
        Hand currentPlayerHand = playerHands.get(currentPlayerIndex);
        Hand targetPlayerHand = playerHands.get(targetPlayerIndex);

        for (int i = targetPlayerHand.getHand().size() - 1; i >= 0; i--) {
            Card card = targetPlayerHand.getCard(i);
            if (card.getRank() == rank) {
                targetPlayerHand.removeCard(i);
                currentPlayerHand.addCard(card);
            }
        }
    }

    /**
     * Main method to start the game.
     *
     * @param args Command-line arguments.
     * @throws InvalidCardReference if there is an issue with card references.
     */
    public static void main(String[] args) throws InvalidCardReference {
        PlayGame game = new PlayGame(2, 10);
        game.playNow();
    }
}
