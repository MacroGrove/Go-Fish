package game;

import java.util.ArrayList;

public class Player {

	private ArrayList<Card> hand;
	private String name;
	private int points;

	public Player(String name) {
		this.name = name;
		hand = new ArrayList<Card>();
		points = 0;
	}

	public String getName() {
		return name;
	}

	public Card getCard(int c) {
		return hand.get(c);
	}

	public void take(Card c) {
		hand.add(c);
	}

	public void discard(Card c) {
		hand.remove(c);
	}

	public boolean contains(Card c) {
		return hand.contains(c);
	}

	public int size() {
		return hand.size();
	}

	@Override
	public String toString() {
		return "Computer " + name;
	}

}
