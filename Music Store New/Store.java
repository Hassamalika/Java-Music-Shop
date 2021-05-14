public class Store {

    State t = new State();
    public String state;
    public String message;


    public String getMessage() {
        return message;
    }

    public String getCurrentState() {
        return t.getState();
    }

    public void setInitialState(String state) {
        t.state = state;
    }
}
