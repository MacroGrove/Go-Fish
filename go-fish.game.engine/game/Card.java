package game;

public class Card {

	private String suit; // Clubs, Diamonds, Hearts, Spades
	private String face; // Ace, 2-10, Jack, Queen, King
	private String color; // Black, Red

	/**
	 * Default Constructor for Jokers
	 */
	public Card() {
		suit = "Duds";
		face = "Joker";
		color = "White";
	}

	/**
	 * Overloaded Constructor for standard cards
	 * 
	 * @param suit:  Clubs, Diamonds, Hearts, Spades
	 * @param face:  1-10, Jack, Queen, King
	 * @param value: 0-51
	 * @throws Exception
	 */
	public Card(String suit, String face) {
		this.suit = suit;
		this.face = face;
		this.color = setColor();
	}

	/**
	 * Set Color determines the color of the card based on its suit.
	 * 
	 * @throws Exception
	 */
	public String setColor() {

		if (suit.equalsIgnoreCase("Diamonds") || suit.equalsIgnoreCase("Hearts")) {
			color = "Red";
		} else if (suit.equalsIgnoreCase("Clubs") || suit.equalsIgnoreCase("Spades")) {
			color = "Black";
		} else {
			System.err.println("Invalid suit!");
		}

		return color;
	}

	/**
	 * Overrided toString
	 * 
	 * @return the card's suit and face.
	 */
	@Override
	public String toString() {
		return face + " of " + suit;
	}
}
