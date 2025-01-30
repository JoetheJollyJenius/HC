//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Deck d = new Deck(1);
        Hand h = new Hand(d.drw(1));

        BlackJack gameOne = new BlackJack(1,1,100,false);
    }

    public static int ranInt(int min, int max){
        int dif = max - min + 1;
        return (int) (Math.random() * dif) + min;
    }

    public static Card scan(ArrayList<Card> list, int i){
        for(Card c : list) {
            if(c.id == i){
                return(c);
            }
        }
        return null;
    }

    public static void print(String s){
        System.out.println("\033[0;0;0m\n"+s);
    }

    public static void clearDisplay(){
        for(int i = 0; i <= 15; i++){
            print(" ");
        }
    }

}