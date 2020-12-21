package game;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private final int NUM_CARDS = 52;
	ArrayList<Card> deck;

	public Deck() {
		deck = new ArrayList<Card>();
	}

	/**
	 * Set Up fills the deck with cards
	 */
	public void reset() {

		// Clubs
		for (int i = 0; i < NUM_CARDS / 4; i++) {
			if (i == 0) {
				deck.add(new Card("Ace", "Clubs"));
			} else if (i < 10) {
				deck.add(new Card(String.valueOf(i + 1), "Clubs"));
			} else if (i == 10) {
				deck.add(new Card("Jack", "Clubs"));
			} else if (i == 11) {
				deck.add(new Card("Queen", "Clubs"));
			} else if (i == 12) {
				deck.add(new Card("King", "Clubs"));
			}
		}

		// Diamonds
		for (int i = 0; i < NUM_CARDS / 4; i++) {
			if (i == 0) {
				deck.add(new Card("Ace", "Diamonds"));
			} else if (i < 10) {
				deck.add(new Card(String.valueOf(i + 1), "Diamonds"));
			} else if (i == 10) {
				deck.add(new Card("Jack", "Diamonds"));
			} else if (i == 11) {
				deck.add(new Card("Queen", "Diamonds"));
			} else if (i == 12) {
				deck.add(new Card("King", "Diamonds"));
			}
		}

		// Hearts
		for (int i = 0; i < NUM_CARDS / 4; i++) {
			if (i == 0) {
				deck.add(new Card("Ace", "Hearts"));
			} else if (i < 10) {
				deck.add(new Card(String.valueOf(i + 1), "Hearts"));
			} else if (i == 10) {
				deck.add(new Card("Jack", "Hearts"));
			} else if (i == 11) {
				deck.add(new Card("Queen", "Hearts"));
			} else if (i == 12) {
				deck.add(new Card("King", "Hearts"));
			}
		}

		// Spades
		for (int i = 0; i < NUM_CARDS / 4; i++) {
			if (i == 0) {
				deck.add(new Card("Ace", "Spades"));
			} else if (i < 10) {
				deck.add(new Card(String.valueOf(i + 1), "Spades"));
			} else if (i == 10) {
				deck.add(new Card("Jack", "Spades"));
			} else if (i == 11) {
				deck.add(new Card("Queen", "Spades"));
			} else if (i == 12) {
				deck.add(new Card("King", "Spades"));
			}
		}

	}

	/**
	 * Shuffle randomly mixes the cards in the deck
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}

	/**
	 * Draw
	 * 
	 * @return card from the deck
	 */
	public Card draw() {
		return deck.get(0);
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return deck.size();
	}

	/**
	 * Is Empty
	 * 
	 * @return true if empty | false if not
	 */
	public boolean isEmpty() {
		return deck.isEmpty();
	}

	/**
	 * Overrided toString
	 * 
	 * @return all the cards
	 */
	@Override
	public String toString() {

		String cards = "";

		for (int i = 0; i < deck.size(); i++) {
			cards += deck.get(i).toString() + "\n";
		}

		return cards;
	}
}