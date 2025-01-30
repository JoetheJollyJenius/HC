import java.util.ArrayList;

public class BlackJack {
    Deck deck;
    ArrayList<Player> players;
    int playerCount;
    private static Player dealer = new Player(0, 0);
    boolean inRound;

    public BlackJack(int d, int numPlayers, int numChips, boolean prompt) {
        deck = new Deck(d);
        playerCount = numPlayers;
        this.players = new ArrayList<Player>();
        if (prompt) {
            System.out.println("Welcome to Black Jack! How many chips would you like to start with?");
            players.add(new Player(Input.getInt(), 1));
            System.out.println("You currently have " + players.getFirst().chips + " Chips.");
        } else {
            players.add(new Player(numChips, 1));
        }
        for (int i = 2; i <= numPlayers; i++) {
            players.add(new Player(numChips, i));
        }
        boolean ifQuit = false;

        if (prompt) {
            while (!ifQuit) {
                Main.print("Are you ready to play some Black Jack?");
                if (Input.get().equals("yes")) {
                    ifQuit = true;
                } else if (Input.get().equals("no")) {
                    break;
                } else {
                    System.out.println("Invalid Input. (Enter yes/no)");
                }
            }
        }

        play();
    }

    public void play() {
        boolean ifQuit = false;
        boolean skipInput = false;
        boolean quitReady = false;

        displayGap1();

        System.out.println("Table Rules: \n");
        System.out.println("Blackjack pays 3 to 2");
        System.out.println("Dealer must draw to 16 and stand on all 17's");
        System.out.println("Insurance pays 2 to 1");

        while (!ifQuit) {
            inRound = true;
            displayTable();
            players.getFirst().bet(20);
            displayBets();
            cardsStart();
            actions();
            while (inRound) {
                displayBets();
                displayCards(false);
                actions();
            }
        }
    }

    public void displayTable() {
        displayGap1();
        int charCount = 190;
        for (Player p : players) {
            charCount -= p.getDisplay().length();
        }
        charCount /= playerCount;

        for (Player p : players) {
            p.display();
            for (int i = 0; i <= charCount; i++) {
                System.out.print(" ");
            }
        }

        displayGap1();

        System.out.println("How much would you like to bet? (Minimum bet is 20)");

        displayGap1();

    }

    public void displayBets() {
        displayGap1();
        System.out.println("Active Bets: ");
        for (Player p : players) {
            System.out.println("Player " + p.id + ": " + p.bet + " chips");
        }
        displayGap1();
    }

    public void cardsStart() {
        dealer.hand = new Hand(deck.draw(2));
        for (Player p : players) {
            p.hand = new Hand(deck.draw(2));
        }
        displayCards(true);
    }

    public void displayCards(boolean ifSort) {
        System.out.println("Dealer Card: ");
        dealer.hand.cards.getFirst().display();
        displayGap1();
        for (Player p : players) {
            System.out.println("Player " + p.id + ": ");
            p.hand.display(ifSort);
            System.out.println(" ");
        }
    }

    public void actions() {
        displayGap1();
        boolean validAct = false;
        System.out.println("What would you like to do? (Hit, Stand, Double Down, Split, Insurance, Surrender, Help)");

        while (!validAct) {
            validAct = true;
            String input = Input.getShort();
            switch (input) {
                case "hit" -> hit(players.getFirst());
                case "sta" -> stand();
                case "dou" -> doubleDown();
                case "spl" -> split();
                case "ins" -> insurance();
                case "sur" -> surrender();
                case "hel" -> help();
                default -> {
                    System.out.println("Invalid Action. Please try again!");
                    validAct = false;
                }
            }
        }

    }

    public void hit(Player p) {
        displayGap1();
        System.out.println("Your Card: ");
        ArrayList<Card> newCard = deck.draw(1);
        p.hand.addCard(newCard);
        newCard.getFirst().display();
        checkCards(p);
    }

    public void stand() {
        for (int i = 0; i <= 1; i++) {
            System.out.println(" ");
        }
    }

    public void doubleDown() {
        for (int i = 0; i <= 1; i++) {
            System.out.println(" ");
        }
    }

    public void split() {
        for (int i = 0; i <= 1; i++) {
            System.out.println(" ");
        }
    }

    public void insurance() {
        for (int i = 0; i <= 1; i++) {
            System.out.println(" ");
        }
    }

    public void surrender() {
        for (int i = 0; i <= 1; i++) {
            System.out.println(" ");
        }
    }

    public static void help() {
        displayGap1();
        boolean ifQuit = false;
        System.out.println("How to play: ");
        System.out.println("The goal of the game is to get a sum as close to 21 as possible with your cards.");
        System.out.println("If you are closer than the dealer by the end of the round, you win!");
        System.out.println("However, if at any point you go over 21, you bust! (Busting will cause you to lose your bet)");
        System.out.println("Once you are confident with your hand, you can stand to see if you get closer to 21 than the dealer.");
        System.out.println("If the dealer busts, you win! If you are closer to the dealer once the dealer receives all their cards, you win!");
        System.out.println("However, if the dealer is closer than you to 21, you lose!");
        displayGap1();
        System.out.println("Special Rules: ");
        System.out.println("Blackjack pays 3 to 2:");
        System.out.println("If you hit a Blackjack (21), you will receive 150% what you bet.\n");
        System.out.println("Insurance pays 2 to 1:");
        System.out.println("If you buy insurance, you will receive twice what you paid but only if the dealer hits a Blackjack.\n");
        System.out.println("Dealer must draw to 16 and stand on all 17's:");
        System.out.println("If the dealer has a 16 or below, they will always Hit. If they have a 17 or above, they will always Stand.");
        displayGap1();
        while (!ifQuit) {
            System.out.println("Which action would you like to learn about? (Hit, Stand, Double Down, Split, Insurance, Surrender, Quit)");
            String input = Input.getShort();
            displayGap1();
            if (input.equals("hit")) {
                System.out.println("When you choose to " + '"' + "Hit" + '"' + " you will receive an extra card to add to your total.");
                System.out.println("After this, you may choose to act again unless you bust or get Blackjack.");
                System.out.println("If you go over 21 with your card, you bust and immediately lose.");
                System.out.println("If you get exactly 21, then you have a Blackjack and you may no longer act for the remainder of the round.");
                System.out.println("In the case of a Blackjack, if the dealer gets under or over 21, you win with an additional 50% bonus!");
                System.out.println("However, if the dealer also gets a Blackjack, it's a tie or " + '"' + "Push" + '"' + " and neither player wins.");
                System.out.println("In the case of a push, you will get back the chips you bet with nothing more.");
                displayGap1();
            } else if (input.equals("sta")) {
                System.out.println("When you choose to " + '"' + "Stand" + '"' + " you will receive no extra cards and may not act for the remainder of the round.");
                System.out.println("Once you stand, you must wait until all remaining hands are dealt, including the dealer's.");
                System.out.println("Once the dealer is dealt, if you are closer to 21 than the dealer, you win! Otherwise, you lose.");
                displayGap1();
            } else if (input.equals("dou")) {
                System.out.println("When you choose to " + '"' + "Double Down" + '"' + " you double the current bet on your hand.");
                System.out.println("After choosing to double down, you will receive one additional card, then action is terminated for the remainder of the round.");
                System.out.println("If you win, you will receive twice what you bet at the start of the round. Otherwise, you'll lose twice as much!");
                displayGap1();
            } else if (input.equals("spl")) {
                System.out.println("If you have 2 cards of the same value, you may " + '"' + "Split" + '"' + " your cards.");
                System.out.println("When you split your cards, you repeat your initial bet in a second hand, giving each of your hands one of the 2 cards in your pair.");
                System.out.println("After splitting your cards, you will continue the round playing 2 hands at once but otherwise acting as normal.");
                System.out.println("Note: You may split multiple times in a round so long as you get a pair within the first 2 cards of your hand.");
                displayGap1();
            } else if (input.equals("ins")) {
                System.out.println("If the dealer reveals an Ace, you may choose to buy " + '"' + "Insurance." + '"');
                System.out.println("To buy insurance, you may additionally pay up to half the amount of chips in your initial bet.");
                System.out.println("After buying insurance, play continues as normal until the dealer deals their cards.");
                System.out.println("If the dealer gets a Blackjack, you will lose your initial bet but you will receive twice what you paid for insurance");
                System.out.println("in addition to the initial payment you made for it. However, if the dealer doesn't get a Blackjack, you will lose ");
                System.out.println("all that you paid for insurance regardless of whether or not you win the hand.");
                System.out.println("Note: You may only buy insurance if it is the first action you make in the round.");
                displayGap1();
            } else if (input.equals("sur")) {
                System.out.println("If you choose to " + '"' + "Surrender" + '"' + " you forfeit the hand, giving up any possibility of winning.");
                System.out.println("In return, you will only lose half the amount you bet, taking back the other half and cutting your losses.");
                displayGap1();
            } else if (input.equals("qui")) {
                ifQuit = true;
            } else {
                System.out.println("Invalid Action. Please try again!");
            }
        }
    }

    public void checkCards(Player p) {
        int sum = 0;
        int aceCount = 0;
        for (Card c : p.hand.cards) {
            if (c.value <= 10) {
                sum += c.value;
            } else if (c.value < 14) {
                sum += 10;
            } else if (c.value == 14) {
                aceCount++;
            }
        }
        int aceUse = aceCount;
        sum += aceCount * 11;
        while (sum > 21 && aceUse > 0) {
            sum -= 10;
            aceUse--;
        }

        if (sum > 21) {
            bust(p);
        } else if (sum == 21) {
            blackJack(p);
        }
    }

    public void bust(Player p) {
        endRound();
        System.out.println("Your cards exceed 21. You lose!");
        displayGap2();
    }

    public void blackJack(Player p) {
        displayGap1();
        System.out.println("Blackjack! You win!");
    }

    public void endRound() {
        inRound = false;
        displayGap1();
        System.out.println("Player " + players.getFirst().id + ": ");
        players.getFirst().hand.display(false);
        displayGap1();
    }

    public static void displayGap1(){
        for(int i = 0; i < 1; i++){
            System.out.println(" ");
        }
    }

    public static void displayGap2(){
        for(int i = 0; i <= 3; i++){
            System.out.println(" ");
        }
    }
}
