package CardGame;

//Author: Mikey A.
//CSE 271- Final Game
public class DeckTester { 
 
 /** 
  * @param args 
  */ 
 public static void main(String[] args) { 
  // make a deck 
  Deck myDeck = new Deck(); 
  System.out.println(myDeck.toString()); 
  myDeck.randomShuffle(); 
  System.out.println("\nShuffled deck:\n"+myDeck.toString()); 
  Card dealt = myDeck.dealCard(); 
  System.out.println("\nDeal first card->"+dealt.toString()); 
  dealt = myDeck.dealCard(); 
  System.out.println("Deal second card->"+dealt.toString()); 
  dealt = myDeck.dealCard(); 
  System.out.println("Deal third card->"+dealt.toString()); 
  dealt = myDeck.dealCard(); 
  System.out.println("Deal 4th card->"+dealt.toString()); 
  myDeck.randomShuffle(); 
  System.out.println("\nShuffle again\n"+myDeck.toString()); 
  dealt = myDeck.dealCard(); 
  System.out.println("Top card-> "+dealt.toString()); 
///  System.out.println("\n"+myDeck.getDeck()); 
   
 } 
 
} 
