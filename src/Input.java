import java.util.Scanner;

public class Input {
    static Scanner Inp = new Scanner(System.in);

    public static String get(){
        return (Inp.nextLine().toLowerCase());
    }

    public static String getShort(){
        boolean validInput = false;
        while (!validInput) {
            try {
                return (Inp.nextLine().toLowerCase().substring(0, 3));
            } catch (Exception e) {
                System.out.println("Invalid Input. Please Try Again!");
            }
        }
        return null;
    }

    public static int getInt(){
        int amount = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                amount = Inp.nextInt();
                if (amount <= 0) {
                    System.out.println("Invalid Amount. Amount must be Positive.");
                } else if (amount > 0) {
                    validInput = true;
                    Input.Inp.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Invalid Amount. Please enter a Positive Number.");
                Inp.nextLine();
            }
        }
        return amount;
    }
}
