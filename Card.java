public class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public static void main(String[] args) {
        Card card = new Card("Ace", "Spades");
        System.out.println("Card: " + card);
        System.out.println("Rank: " + card.getRank());
        System.out.println("Suit: " + card.getSuit());
    }
}
