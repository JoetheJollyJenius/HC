import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;

    public Hand(ArrayList<Card> car){
        this.cards = new ArrayList<Card>();
        cards.addAll(car);
    }

    public void display(boolean ifSort) {
        if(ifSort){
            ArrayList<Card> orderedCards = new ArrayList<Card>();
            ArrayList<Card> cloneHand = cards;
            int handSize = cloneHand.size() - 1;
            for (int i = 0; i <= handSize; i++){
                orderedCards.add(findHigh(cloneHand));
                cloneHand.remove(findHigh(cloneHand));
            }
            for (Card c : orderedCards){
                c.display();
            }
            cards = orderedCards;
        }
        else{
            for (Card c : cards){
                c.display();
            }
        }
    }

    public Card findHigh(ArrayList<Card> cs) {
        int highVal = 0;
        Card highCard = null;
        for (Card c : cs){
            if (c.value > highVal && c.value != 1){
                highCard = c;
                highVal = c.value;
            } else if (c.value == 1){
                highCard = c;
                highVal = 14;
            }
        }
        return(highCard);
    }

    public void addCard(Card c){
        cards.add(c);
    }

    public void addCard(ArrayList<Card> c){
        for(Card k : c) {
            addCard(k);
        }
    }
}
