import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private List<Card> hand;

    public Dealer() {
        hand = new ArrayList<>();
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public void displayPartialHand() {
        System.out.println("Dealer's hand:\n");
        System.out.println("\tHidden card");
        if (!hand.isEmpty()) {
            System.out.println("\t" + hand.get(1) + "\n"); // Display the second card
        }
    }

    public void displayFullHand() {
        System.out.println("Dealer's hand:\n");
        for (Card card : hand) {
            System.out.println("\t" + card);
        }
        System.out.println();
    }

    public boolean shouldHit() {
        int handValue = calculateHandValue();
        return handValue < 17; // Dealer hits if hand value is less than 17
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

    public static void main(String[] args) {
        Dealer dealer = new Dealer();

        Card card1 = new Card("10", "Spades");
        Card card2 = new Card("7", "Hearts");

        dealer.addToHand(card1);
        dealer.addToHand(card2);

        dealer.displayPartialHand();
    }
}
