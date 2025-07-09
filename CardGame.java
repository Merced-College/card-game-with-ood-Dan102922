//Daniel Mota
//July 3rd
//Card Game with OOP

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

	// Data structures to hold the deck of cards and the players hand
	private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
	private static ArrayList<Card> playerCards = new ArrayList<Card>();


	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			// error
			System.out.println("error");
			e.printStackTrace();
		}

		while(input.hasNext()) {
			String[] fields  = input.nextLine().split(",");
			//	public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
			Card newCard = new Card(fields[0], fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3]);
			deckOfCards.add(newCard);	
			// Added a forced duplicate to ensure the findAllPairs method works correctly
			deckOfCards.add(new Card("spade", "ace", 11, "ah.gif"));
			deckOfCards.add(new Card("spade", "ace", 11, "ah.gif"));

		}

		shuffle();

		//for(Card c: deckOfCards)
			//System.out.println(c);

		//deal the player 26 cards
		//raised the cards dealt to 26 due to the findAllPairs method not finding pairs often enough with only 5 cards
		for(int i = 0; i < 26; i++) {
			playerCards.add(deckOfCards.remove(i));
		}
		// shows the player cards
		System.out.println("players cards");
		for(Card c: playerCards)
			System.out.println(c);
			// Added feature: Implemented in the main method to print the matched pairs, the method can be found further below
			ArrayList<Card> foundPairs = findAllPairs();
		System.out.println("Matched pairs found:");
		if (foundPairs.isEmpty()) {
			System.out.println("No pairs found.");
		} else {
			for (Card pair : foundPairs) {
				System.out.println(pair);
			}
		}

		System.out.println("pairs is " + checkFor2Kind());

	}//end main

	public static void shuffle() {

		//shuffling the cards by deleting and reinserting
		for (int i = 0; i < deckOfCards.size(); i++) {
			int index = (int) (Math.random()*deckOfCards.size());
			Card c = deckOfCards.remove(index);
			//System.out.println("c is " + c + ", index is " + index);
			deckOfCards.add(c);
		}
	}

	public static ArrayList<Card> findAllPairs() {
		//Added feature: Finds and displays all pairs in the player's hand
		// This creates an array list to hold the pairs found in the player's hand
		ArrayList<Card> pairs = new ArrayList<Card>();
		// Loop through the player's cards to find pairs
		for(int i = 0; i < playerCards.size() - 1; i++) {
			Card current = playerCards.get(i);
			// Compare the current card with the rest of the cards in the player's hand
			// to find duplicates
			for(int j = i + 1; j < playerCards.size(); j++) {
				Card next = playerCards.get(j);
				// If the current card matches the next card and is not already in the pairs list
				// add it to the pairs list
				if(current.equals(next) && !pairs.contains(current)) {
					pairs.add(current);
				}
			}
		}
		return pairs;
	}

	//check for 2 of a kind in the players hand
	public static boolean checkFor2Kind() {

		int count = 0;
		for(int i = 0; i < playerCards.size() - 1; i++) {
			Card current = playerCards.get(i);
			Card next = playerCards.get(i+1);
			
			for(int j = i+1; j < playerCards.size(); j++) {
				next = playerCards.get(j);
				//System.out.println(" comparing " + current);
				//System.out.println(" to " + next);
				if(current.equals(next))
					count++;
			}//end of inner for
			if(count == 1)
				return true;

		}//end outer for
		return false;
	}
}//end class
