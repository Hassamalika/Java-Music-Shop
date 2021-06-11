package secondStore;

public class State {
    //alter to states to be more specific for each state in each class?
    public static final String ready = "----------Ready. Message shown------------\n";
    public static final String pendingChoice = "------------Waiting for user choice------------\n";
    public static final String pendingAmount = "------------Waiting for user amount------------\n";
    public static final String selected = "-------------Selected. Input given------------\n";
    public static final String error = "-------------Error--------------\n";
    public static final String exit = "------------Finished-----------\n";

    public static final String errorMessage = "Please enter a number between 0 and 3";
    public String message;
    public String state;
    public State() {
        this.state = ready;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCurrentMessage() {
        return this.message;
    }

     public String getState() {

        if(state.equalsIgnoreCase(ready)) {
            return ready;
        }
        else if(state.equalsIgnoreCase(pendingChoice)) {
            return pendingChoice;

        }
        else if(state.equalsIgnoreCase(pendingAmount)) {
            return pendingAmount;

        }
        else if (state.equalsIgnoreCase(selected)) {
            return selected;
        }
        else if (state.equalsIgnoreCase(error)) {
            return error;
        }
        else if (state.equalsIgnoreCase(exit)) {
            return exit;
        }
        else if (state.equalsIgnoreCase(errorMessage)) {
            return errorMessage;
        }
        return null;
    }

}