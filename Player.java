import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand;

    public Player() {
        hand = new ArrayList<>();
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public int calculateHandValue() {
        int handValue = 0;
        int numAces = 0;

        for (Card card : hand) {
            int cardValue = getCardValue(card);
            handValue += cardValue;

            if (cardValue == 11) {
                numAces++;
            }

            while (handValue > 21 && numAces > 0) {
                handValue -= 10; // Convert Ace from 11 to 1
                numAces--;
            }
        }

        return handValue;
    }

    public int getCardValue(Card card) {
        String rank = card.getRank();
        if (rank.equals("Ace")) {
            return 11; // Ace can be 1 or 11, we'll treat it as 11 initially
        } else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) {
            return 10;
        } else {
            return Integer.parseInt(rank);
        }
    }


    public void displayHand() {
        System.out.println("Player's hand:\n");
        for (Card card : hand) {
            System.out.println("\t" + card);
        }
        System.out.println("\nRunning total: " + calculateHandValue() + "\n");
    }

    public static void main(String[] args) {
        Player player = new Player();

        Card card1 = new Card("Ace", "Spades");
        Card card2 = new Card("10", "Hearts");

        player.addToHand(card1);
        player.addToHand(card2);

        player.displayHand();
    }
}
