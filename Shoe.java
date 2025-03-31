import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shoe {
    private List<Card> cards;

    public Shoe(int numDecks) {
        cards = new ArrayList<>();
        for (int i = 0; i < numDecks; i++) {
            Deck deck = new Deck();
            cards.addAll(deck.getCards());
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No cards left in the shoe.");
        }
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }

    public static void main(String[] args) {
        int numDecks = 6;
        Shoe shoe = new Shoe(numDecks);

        System.out.println("Shuffling the shoe...");
        shoe.shuffle();

        System.out.println("Dealing cards from the shoe:");
        for (int i = 0; i < 10; i++) {
            Card card = shoe.dealCard();
            System.out.println("Dealt: " + card);
        }

        System.out.println("Remaining cards in the shoe: " + shoe.size());
    }
}
