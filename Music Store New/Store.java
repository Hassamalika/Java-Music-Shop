public class Store {

    State t = new State();
    public String state;
    public String message;


    public String getMessage() {
        return this.message;
    }

    public String setMessage(String message) {
        this.message = message;
        return message;
    }
    public void getCurrentState() {
        System.out.println(t.getState());
    }

    public void setInitialState(String state) {
        t.state = state;
    }
}
