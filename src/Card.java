public class Card {
    int value;
    String suit;
    int id;

    public Card(int val, String s, int i){
        value = val;
        suit = s;
        id = i;
    }

    public void display(){
        if(value == 14){
            System.out.println("A of " + suit + "s");
        } else if(value == 11){
            System.out.println("J of " + suit + "s");
        } else if(value == 12){
            System.out.println("Q of " + suit + "s");
        } else if(value == 13){
            System.out.println("K of " + suit + "s");
        } else
            System.out.println(String.valueOf(value) + " of " + suit + "s");
    }
}
