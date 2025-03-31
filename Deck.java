import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        List<Card> cards = deck.getCards();

        System.out.println("Deck contains " + cards.size() + " cards:");
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
