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
				deck.add(new Card("Clubs", "Ace"));
			} else if (i < 10) {
				deck.add(new Card("Clubs", String.valueOf(i + 1)));
			} else if (i == 10) {
				deck.add(new Card("Clubs", "Jack"));
			} else if (i == 11) {
				deck.add(new Card("Clubs", "Queen"));
			} else if (i == 12) {
				deck.add(new Card("Clubs", "King"));
			}
		}

		// Diamonds
		for (int i = 0; i < NUM_CARDS / 4; i++) {
			if (i == 0) {
				deck.add(new Card("Diamonds", "Ace"));
			} else if (i < 10) {
				deck.add(new Card("Diamonds", String.valueOf(i + 1)));
			} else if (i == 10) {
				deck.add(new Card("Diamonds", "Jack"));
			} else if (i == 11) {
				deck.add(new Card("Diamonds", "Queen"));
			} else if (i == 12) {
				deck.add(new Card("Diamonds", "King"));
			}
		}

		// Hearts
		for (int i = 0; i < NUM_CARDS / 4; i++) {
			if (i == 0) {
				deck.add(new Card("Hearts", "Ace"));
			} else if (i < 10) {
				deck.add(new Card("Hearts", String.valueOf(i + 1)));
			} else if (i == 10) {
				deck.add(new Card("Hearts", "Jack"));
			} else if (i == 11) {
				deck.add(new Card("Hearts", "Queen"));
			} else if (i == 12) {
				deck.add(new Card("Hearts", "King"));
			}
		}

		// Spades
		for (int i = 0; i < NUM_CARDS / 4; i++) {
			if (i == 0) {
				deck.add(new Card("Spades", "Ace"));
			} else if (i < 10) {
				deck.add(new Card("Spades", String.valueOf(i + 1)));
			} else if (i == 10) {
				deck.add(new Card("Spades", "Jack"));
			} else if (i == 11) {
				deck.add(new Card("Spades", "Queen"));
			} else if (i == 12) {
				deck.add(new Card("Spades", "King"));
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
		return deck.remove(0);
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
	public String toString() {

		String cards = "";

		for (int i = 0; i < deck.size(); i++) {
			cards += deck.get(i).toString() + "\n";
		}

		return cards;
	}
}