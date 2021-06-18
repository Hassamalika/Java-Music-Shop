package fsm;

public class Store {

    private static final double[] CD_PRICES = {
            1.5, 5.0
    };

    private enum State {
        SELECT_PRODUCT, PAY, FINISH
    }

    private State state = State.SELECT_PRODUCT;
    private int choice;
    private double amount;


    public String getMessage() {
        switch (state) {
            case SELECT_PRODUCT:
                return "Hello, welcome to my shop. \n 1. CD1 - Artist - £1.50 \n 2. CD2 - Artist2 - £5.00 \n";
            case PAY:
                return "Please pay £" + CD_PRICES[choice - 1] + ".";
            case FINISH:
                double change = amount - CD_PRICES[choice - 1];
                return "Thank you, your change is £" + change;
        }
        return null;
    }

    public String userInput(String input) {
        // error checking if input is int
        switch (state) {
            case SELECT_PRODUCT:
                try {
                    final int choice = Integer.parseInt(input);
                    if (choice <= CD_PRICES.length && choice >= 1) {
                        this.choice = choice;
                        state = State.PAY;
                    } else {
                        return "Please enter between 1 and " + CD_PRICES.length;
                    }

                    break;
                } catch (NumberFormatException e) {
                    return "Please enter a numeric choice from list";
                }
            case PAY:
                try {
                    final double amount = Double.parseDouble(input);
                    if (amount > CD_PRICES[choice - 1]) {
                        this.amount = amount;
                        state = State.FINISH;
                        break;
                    }
                    else {
                        return "Please enter an amount greater than the price";
                    }

                } catch (NumberFormatException e){
                    return "Please enter a numeric amount";
                }
            case FINISH:
                return null;
        }
        return null;
    }

    public boolean hasFinished() {
        return state.equals(State.FINISH);
    }
}
