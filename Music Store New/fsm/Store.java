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

    public String error = "Please enter a numeric choice from list";

    // error
//    public boolean ifError() {
//        return getMessage().equals(error);
//    }

    public boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

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
        return error;
    }

    public String userInput(String input) {
        // error checking if input is int
        boolean isValid = isNumeric(input);
        switch (state) {
            case SELECT_PRODUCT:
                if (isValid) {
                    choice = Integer.parseInt(input);
                    state = State.PAY;
                    return null;
                } else {
                    break;
                }
            case PAY:
                if (isValid) {
                    amount = Double.parseDouble(input);
                    state = State.FINISH;
                    return getMessage();
                } else {
                    break;
                }
            case FINISH:
                return getMessage();
        }
        return error;
    }

    public boolean hasFinished() {
        return state.equals(State.FINISH);
    }
}
