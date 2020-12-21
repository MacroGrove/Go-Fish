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
	public Card(String face, String suit) {
		this.face = face;
		this.suit = suit;
		setColor();
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * Set Color determines the color of the card based on its suit.
	 * 
	 * @throws Exception
	 */
	public void setColor() {

		if (suit.equalsIgnoreCase("Diamonds") || suit.equalsIgnoreCase("Hearts")) {
			color = "Red";
		} else if (suit.equalsIgnoreCase("Clubs") || suit.equalsIgnoreCase("Spades")) {
			color = "Black";
		} else if (suit.equalsIgnoreCase("Duds")) {
			color = "White";
		} else {
			System.err.println("Invalid suit!");
		}
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Card)) {
			return false;
		}

		Card c = (Card) o;

		return this.face.equals(c.getFace()) && this.suit.equals(c.getSuit());
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + face.hashCode();
		result = 31 * result + suit.hashCode();

		return result;
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
