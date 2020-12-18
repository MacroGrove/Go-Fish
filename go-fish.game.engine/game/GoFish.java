package game;
import java.util.ArrayList;
import java.util.Scanner;

public class GoFish {

	private Deck deck;
	private int numPlayers;
	private int currentPlayer;
	private ArrayList<Card> hand1, hand2, hand3, hand4, hand5, hand6;
	private final int MIN_NUM_PLAYERS = 2;
	private final int MAX_NUM_PLAYERS = 5;
	private final int SMALL_HAND = 5;
	private final int LARGE_HAND = 7;

	public GoFish() {
		deck = new Deck();
		numPlayers = selectNumPlayers();
		currentPlayer = 0;
	}

	/**
	 * Game Loop
	 */
	public void play() {
		deck.reset();
		deck.shuffle();

		while (!deck.isEmpty()) {
			// TODO
			// human asks or draws 
			// if they ask and don't get a card, then draw
			// if they ask and get a card, then check for 4 card match
			// repeat for each AI
		}
	}

	/**
	 * Select Num Players
	 * @return
	 */
	private int selectNumPlayers() {
		Scanner scnr = new Scanner(System.in);
		System.out.println("How many players will play Go Fish?:");
		numPlayers = scnr.nextInt();

		boolean isValid = false;

		while (!isValid) { // ensures proper amount of players

			if (numPlayers < MIN_NUM_PLAYERS) {
				System.out.println("You need at least 2 players to begin.");
				System.out.println("Please re-enter number of players that will be joining this game:");
				numPlayers = scnr.nextInt();
			}

			else if (numPlayers > MAX_NUM_PLAYERS) {
				System.out.println("You can only have up to 5 players to begin.");
				System.out.println("Please re-enter number of players that will be joining this game:");
				numPlayers = scnr.nextInt();
			} else {
				System.out.println("Lets play Go Fish!");
				isValid = true;
			}
		}

		return numPlayers;
	}

	/**
	 * @throws Exception
	 * 
	 */
	private void deal() throws Exception {
		// TODO

		// Create a hand for each player.
		switch (numPlayers) {
		case 2: // 2 players
			hand1 = new ArrayList<Card>();
			hand2 = new ArrayList<Card>();
			break;
		case 3: // 3 players
			hand1 = new ArrayList<Card>();
			hand2 = new ArrayList<Card>();
			hand3 = new ArrayList<Card>();
			break;
		case 4: // 4 players
			hand1 = new ArrayList<Card>();
			hand2 = new ArrayList<Card>();
			hand3 = new ArrayList<Card>();
			hand4 = new ArrayList<Card>();
			break;
		case 5: // 5 players
			hand1 = new ArrayList<Card>();
			hand2 = new ArrayList<Card>();
			hand3 = new ArrayList<Card>();
			hand4 = new ArrayList<Card>();
			hand5 = new ArrayList<Card>();
			break;
		default:
			throw new Exception("Weird error in the deal method!");
		}

		// Deal cards to each hand
		switch (numPlayers) {
		case 2: // deals 7 cards
			for (int i = 0; i < LARGE_HAND; i++) {
				hand1.add(deck.draw());
				hand2.add(deck.draw());
			}
			break;

		case 3: // deals 7 cards
			for (int i = 0; i < LARGE_HAND; i++) {
				hand1.add(deck.draw());
				hand2.add(deck.draw());
				hand3.add(deck.draw());
			}
			break;

		case 4: // deals 5 cards
			for (int i = 0; i < SMALL_HAND; i++) {
				hand1.add(deck.draw());
				hand2.add(deck.draw());
				hand3.add(deck.draw());
				hand4.add(deck.draw());
			}
			break;

		case 5: // deals 5 cards
			for (int i = 0; i < SMALL_HAND; i++) {
				hand1.add(deck.draw());
				hand2.add(deck.draw());
				hand3.add(deck.draw());
				hand4.add(deck.draw());
				hand5.add(deck.draw());
			}
			break;
		}
	}

	/**
	 * Ask a player for a card
	 * 
	 * @param player
	 * @return
	 */
	private String ask(Player player) { // has current player choose what player they are asking for a card from
		// TODO
		return "";
	}

	/**
	 * Give a player a card
	 * 
	 * @param player
	 */
	private void give(Player player) {

	}

	/**
	 * Has Won
	 * 
	 * @return
	 */
	private boolean hasWon() {
		// TODO
		return true;
	}
}
