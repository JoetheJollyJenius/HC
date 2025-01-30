public class Colors {

    public static void pRed(String s){
        System.out.println("\033[0;0;91m\n"+s);
    }

    public static void pYellow(String s){
        System.out.println("\033[0;93m\n"+s);
    }

    public static void pGreen(String s){
        System.out.println("\033[0;92m\n"+s);
    }

    public static void pBlue(String s){
        System.out.println("\033[0;34m\n"+s);
    }

    public static void pCyan(String s){
        System.out.println("\033[0;96m\n"+s);
    }

    public static void pPurple(String s){
        System.out.println("\033[0;35m\n"+s);
    }

    public static void pPink(String s){
        System.out.println("\033[0;95m\n"+s);
    }
}
