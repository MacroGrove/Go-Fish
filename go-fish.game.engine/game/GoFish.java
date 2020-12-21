package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GoFish {

	private final int MIN_NUM_PLAYERS = 2;
	private final int MAX_NUM_PLAYERS = 5;
	private final int SMALL_HAND = 5;
	private final int LARGE_HAND = 7;

	private Scanner sc;
	private Random r;
	private Deck deck;
	private ArrayList<Player> hands;
	private int numPlayers;
	private Player currentPlayer;
	private int choice;

	private Player tempPlayer;
	private Card tempCard;
	private String tempFace;
	private String tempSuit;

	public GoFish() {
		sc = new Scanner(System.in);
		r = new Random();
		deck = new Deck();
		hands = new ArrayList<Player>();
		numPlayers = 0;
		currentPlayer = null;
	}

	/**
	 * Game Loop
	 */
	public void play() {
		boolean isValid = false;
		boolean isPlaying = false;

		deck.reset();
		System.out.println("Setting up deck.");
		System.out.println("There are " + deck.size());
		deck.shuffle();
		System.out.println("Shuffling deck.");
		selectNumPlayers();
		System.out.println("Dealing cards for " + numPlayers + " hands.");
		deal();
		System.out.println("There are " + deck.size());

		for (int i = 0; i < numPlayers; i++) {
			currentPlayer = hands.get(i);

			while (!isValid) {
				if (currentPlayer.getName().equals("0")) {
					System.out.println("1. Draw");
					System.out.println("2. Ask");
					choice = sc.nextInt();

					if (choice == 1) {
						tempCard = deck.draw();
						System.out.println("You drew a " + tempCard.toString());
						currentPlayer.take(tempCard);
						isValid = true;

					} else if (choice == 2) {
						if (numPlayers > 2) {
							System.out.println("Who do you want to ask? (1-" + numPlayers + ")");
							choice = sc.nextInt();
							tempPlayer = hands.get(choice);
						} else {
							tempPlayer = hands.get(1);
						}

						System.out.println("What do you want to ask for? ([face] of [suit]");
						tempFace = sc.next();
						sc.next();
						tempSuit = sc.next();

						tempCard = new Card(tempFace, tempSuit);

						if (tempPlayer.contains(tempCard)) { // match
							System.out.println(" has an " + tempCard.toString());
							currentPlayer.take(tempCard);
							tempPlayer.discard(tempCard);
							isValid = true;
						} else { // no match
							if (!deck.isEmpty()) {
								System.out.println(tempPlayer.toString() + " does not have a " + tempCard.toString());
								tempCard = deck.draw();
								System.out.println("You drew a " + tempCard.toString());
								currentPlayer.take(tempCard);
							} else {
								System.out.println("Deck is empty.");
								i = numPlayers;
							}
							isValid = true;
						}

					} else {
						System.out.println("Please choose to draw or ask.");
					}
				}
			}

			isPlaying = false;
			while (!isPlaying) {

				isPlaying = false;

				choice = r.nextInt(2) + 1;

				if (choice == 1) {
					tempCard = deck.draw();
					System.out.println(currentPlayer.toString() + " drew a " + tempCard.toString());
					currentPlayer.take(tempCard);
					isValid = true;

				} else if (choice == 2) {
					if (numPlayers > 2) {
						choice = r.nextInt(numPlayers);

						System.out.println(currentPlayer.toString() + " is asking Player " + choice);

						tempPlayer = hands.get(choice);
					} else {
						tempPlayer = hands.get(1);
					}

					tempCard = currentPlayer.getCard(r.nextInt(currentPlayer.size()));
					System.out.println(" for a(n) " + tempCard.toString());

					if (tempPlayer.contains(tempCard)) { // match
						System.out.println(tempPlayer.toString() + " has a(n) " + tempCard.toString());
						currentPlayer.take(tempCard);
						tempPlayer.discard(tempCard);
						isPlaying = true;
					} else { // no match
						if (!deck.isEmpty()) {
							System.out.println(tempPlayer.toString() + " does not have a " + tempCard.toString());
							tempCard = deck.draw();
							System.out.println(currentPlayer.toString() + " drew a " + tempCard.toString());
							currentPlayer.take(tempCard);
						} else {
							System.out.println("Deck is empty.");
							i = numPlayers;
						}
						isPlaying = true;
					}

				}
			}
		} // while
	}

	/**
	 * Select Num Players
	 * 
	 * @return
	 */
	private int selectNumPlayers() {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many people are playing?:");
		numPlayers = sc.nextInt();

		boolean isValid = false;

		while (!isValid) { // ensures proper amount of players

			if (numPlayers < MIN_NUM_PLAYERS) {
				System.out.println("You need at least 2 players to begin.");
				System.out.println("Please re-enter number of players that will be joining this game:");
				numPlayers = sc.nextInt();
			}

			else if (numPlayers > MAX_NUM_PLAYERS) {
				System.out.println("You can only have up to 5 players to begin.");
				System.out.println("Please re-enter number of players that will be joining this game:");
				numPlayers = sc.nextInt();
			} else {
				System.out.println("Lets play Go Fish!");
				isValid = true;
			}
		}

		return numPlayers;
	}

	/**
	 * 
	 */
	private void deal() {

		// Create a hand for each player.
		for (int hand = 0; hand < numPlayers; hand++) {
			hands.add(new Player(String.valueOf(hand)));
		}

		// Deal cards to each hand
		for (int player = 0; player < numPlayers; player++) {
			if (numPlayers < 4) { // 2-3 players
				for (int cards = 0; cards < LARGE_HAND; cards++) {
					hands.get(player).take(deck.draw());
				}
			} else { // 4-5 players
				for (int cards = 0; cards < SMALL_HAND; cards++) {
					hands.get(player).take(deck.draw());
				}
			}
		}
	}

}
