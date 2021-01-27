
import java.util.Scanner;

public class Shop {
    boolean exit;
    
    public static void main(String args[]) {
        Shop shop = new Shop();
        shop.runMenu();
    }

    public void runMenu() {
        printHeader();
        while(!exit) {
            printMenu();
            int choice = getInput();
            getAmount(choice);
        }
    }

    private void printHeader() {
        System.out.println("+----------------------------------------+");
        System.out.println("|          Welcome to my shop!           |");
        System.out.println("+----------------------------------------+");
    }

    private void printMenu() {
        System.out.println("\nWe have the following CD's in stock.\n");
        System.out.println("1 - Song1, Artist1, Price \u00A33.50");
        System.out.println("2 - Song2, Artist2, Price \u00A313.50");
        System.out.println("3 - Song3, Artist3, Price \u00A326.50");
        System.out.println("4 - Song4, Artist4, Price \u00A340.00");
        System.out.println("0 - Press to Exit");

    }    

    private int getInput() {
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        while(choice < 0 || choice > 4) {
            try {
                System.out.print("\nPlease input which CD you want:\n");
                choice = Integer.parseInt(kb.nextLine());
            }
            catch(NumberFormatException e) {
                System.out.println("Invalid selection. Pease try again.");
            }
        }
        return choice;
    }

    private void getAmount(int choice) {
        switch(choice) {
            case 0:
                exit = true;
                System.out.println("\nThank you for shopping. Goodbye.");
                break;
            case 1:
                double firstPrice = 3.50;
                System.out.println("\nThat will be " + firstPrice + ".\n");
                getChangeFirst();
                break;
            case 2:
                double secondPrice = 13.50;
                System.out.println("\nThat will be " + secondPrice + ".\n");
                getChangeSecond();
                break;
            case 3:
                double thirdPrice = 26.50;
                System.out.println("\nThat will be " + thirdPrice + ".\n");
                getChangeThird();
                break;
            case 4:
                double fourthPrice = 40.00;
                System.out.println("\nThat will be " + fourthPrice + ".\n");
                getChangeFourth();
                break;
            default:
                System.out.println("An error has occurred.");
        }
    }

    private void getChangeFirst() {
        Scanner ab = new Scanner(System.in);
        System.out.println("Please input how much you will give me:");
        int amount = Integer.parseInt(ab.nextLine());
        double firstPrice = 3.50;
        double tmp;

        if (amount >= firstPrice) {
            tmp = amount - firstPrice;
            System.out.println("\nThank you. Your change is: " + String.format("%.2f", tmp));
        }
        else if (amount == 5) {
            tmp = amount - firstPrice;
            System.out.println("\nThank you. Your change is: " + String.format("%.2f",tmp));
        }
        else {
            System.out.println("\nPlease input an amount greater than £3.50.");
        }
    }

    private void getChangeSecond() {
        Scanner ac = new Scanner(System.in);
        System.out.println("\nPlease input how much you will give me:");
        int amount = Integer.parseInt(ac.nextLine());
        double tmp;
        double secondPrice = 13.50;

        if (amount >= secondPrice) {
            tmp = amount - secondPrice;
            System.out.println("\nThank you. Your change is: " + String.format("%.2f",tmp));
        }
        else if (amount >= 15) {
            tmp = amount - secondPrice;
            System.out.println("\nThank you. Your change is: " + String.format("%.2f",tmp));
        }
        else {
            System.out.println("\nPlease input an amount greater than £13.50.");
        }
    }

    private void getChangeThird() {
        Scanner ad = new Scanner(System.in);
        System.out.println("\nPlease input how much you will give me:");
        int amount = Integer.parseInt(ad.nextLine());
        double tmp;
        double thirdPrice = 26.50;

        if (amount >= thirdPrice) {
            tmp = amount - thirdPrice;
            System.out.println("\nThank you. Your change is: " + String.format("%.2f", tmp));
        }
        else if (amount == 30) {
            tmp = amount - thirdPrice;
            System.out.println("\nThank you. Your change is: " + String.format("%.2f",tmp));
        }
        else {
            System.out.println("\nPlease input an amount greater than £26.50.");
        }
    }

    private void getChangeFourth() {
        Scanner ae = new Scanner(System.in);
        System.out.println("\nPlease input how much you will give me:");
        int amount = Integer.parseInt(ae.nextLine());
        double tmp;
        double fourthPrice = 40.00;

        if (amount >= 40) {
            tmp = amount - fourthPrice;
            System.out.println("\nThank you. Your change is: " + String.format("%.2f",tmp));
        }
        else {
            System.out.println("\nPlease input above 40.");
        }
    } 

}      

