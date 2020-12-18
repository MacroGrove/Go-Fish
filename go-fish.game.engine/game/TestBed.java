package game;

public class TestBed {

	public static void main(String args[]) {
		
		// Testing Card class
		Card c = new Card();
		System.out.println(c.toString());
		
		// Testing Deck class
		Deck d = new Deck();
		d.reset();
		System.out.println(d.toString());
		d.shuffle();
		System.out.println(d.toString());
	}

}
