import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    int count;
    int decks;
    ArrayList<Card> cards;

    public Deck(int d){
        decks = d;
        count = 52*d;
        this.cards = new ArrayList<Card>();
        int i = 1;
        for(int j = 1; j <= d; j++){
            for (int c = 2; c <= 14; c++){
                this.cards.add(new Card(c,"Diamond",i));
                i++;
                this.cards.add(new Card(c,"Club",i));
                i++;
                this.cards.add(new Card(c,"Heart",i));
                i++;
                this.cards.add(new Card(c,"Spade",i));
                i++;
            }
        }
        shuffle();
    }

    public ArrayList<Card> draw(int i){
        ArrayList<Card> drew = new ArrayList<Card>();
        if(cards.size() >= 0) {
            for (int j = 0; j <= i-1; j++) {
                drew.add(cards.getFirst());
                cards.removeFirst();
            }
        } else {
            System.out.println("The Deck is Empty");
        }
        return drew;
    }

    public void shuffle(){
        boolean doManual = false;
        if(doManual){
            ArrayList<Card> shuffle = new ArrayList<Card>();
            int tot = cards.size();
            for (int i = 0; i < tot; i++){
                int ranInt = Main.ranInt(0,cards.size()-1);
                shuffle.add(cards.get(ranInt));
                cards.remove(ranInt);
                cards = shuffle;
            }
        } else {
            Collections.shuffle(cards);
        }
    }

    public void addCard(Card c,boolean ifShuffle){
        if(ifShuffle){
            cards.add(Main.ranInt(0,cards.size()-1),c);
        } else{
            cards.addFirst(c);
        }
    }

    public void addCard(ArrayList<Card> c, boolean ifShuffle){
        for(Card k : c) {
            addCard(k, ifShuffle);
        }
    }
}


//public ArrayList<Card> draw(int i){
//    ArrayList<Card> drew = new ArrayList<Card>();
//    if(cards.size() >= 0) {
//        for (int j = 0; j <= i-1; j++) {
//            int id = Main.ranInt(0, cards.size() - 1);
//            drew.add(cards.get(id));
//            cards.remove(id);
//        }
//    } else {
//        System.out.println("The Deck is Empty");
//    }
//    return drew;
//}
