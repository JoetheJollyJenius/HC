public class Player {
    Hand hand;
    int chips;
    int id;
    int bet;

    public Player(int cp, int i){
        chips = cp;
        id = i;
    }

    public void addChips(int amount){
        chips += amount;
    }

    public void bet(int min){
        boolean validAmount = false;
        int amount = 0;

        while(!validAmount){
            amount = Input.getInt();
            if (amount <= chips && amount >= min){
                chips -= amount;
                bet = amount;
                validAmount = true;
            } else if (amount < min){
                System.out.println("Must bet at least " + min + " chips!\n");
            } else{
                System.out.println("Not enough chips to bet.\n");
            }
        }
    }

    public String getDisplay(){
        return("Player " + id + ": " + chips + " Chips");
    }

    public void display(){
        System.out.print("Player " + id + ": " + chips + " Chips");
    }
}
