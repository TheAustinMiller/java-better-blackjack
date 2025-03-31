import java.sql.SQLOutput;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Shoe shoe = new Shoe(8);
        shoe.shuffle();
        Player player = new Player();
        Dealer dealer = new Dealer();
        // Deal to player
        player.addToHand(shoe.dealCard());
        // Deal to dealer
        dealer.addToHand(shoe.dealCard());
        // Deal to player
        player.addToHand(shoe.dealCard());
        // Deal to dealer
        dealer.addToHand(shoe.dealCard());
        // Show dealer hand
        dealer.displayPartialHand();
        // Show player hand
        player.displayHand();
        // Show player running total
        player.calculateHandValue();
        // Show options
        System.out.println(showPlayerChoices());
        int option = in.nextInt();
        // Repeat until bust or stand
        while (!isBusted(player) && option != 2) {
            Card newCard = shoe.dealCard();
            player.addToHand(newCard);
            player.displayHand();

            if (isBusted(player)) { break; } // if busted, don't show options
            System.out.println(showPlayerChoices());
            option = in.nextInt();
        }
        // If bust - end YOU BUSTED
        if (isBusted(player)) {
            System.out.println("YOU LOSE");
        } else { // MUST BE STANDING
            // If stand - dealer plays DEALER PLAYING
            System.out.println("DEALER PLAYING");
            // Show dealer hand
            dealer.displayFullHand();
            // Hit and display hand until bust or 22 <= total >= 17
            while (!isBusted(dealer) && dealer.shouldHit()) {
                System.out.println("HIT!");
                dealer.addToHand(shoe.dealCard());
                dealer.displayFullHand();
            }
            if (isBusted(dealer)) {
                // if bust - end YOU WIN
                System.out.println("DEALER BUST!");
                System.out.println("YOU WIN!");
            } else {
                // if other shit - end YOU WIN
                if (player.calculateHandValue() > dealer.calculateHandValue()) {
                    System.out.println("YOU WIN!");
                } else {
                    System.out.println("YOU LOSE!");
                }
            }
        }
    }

    private static String showPlayerChoices() {
        return "What you tryna do?\n" +
                "\t(1) - Hit\n" +
                "\t(2) - Stand\n";
    }

    private static boolean isBusted(Player player) {
        return player.calculateHandValue() >= 22;
    }

    private static boolean isBusted(Dealer dealer) {
        return dealer.calculateHandValue() >= 22;
    }


}
