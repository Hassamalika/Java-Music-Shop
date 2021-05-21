public class Store {

    State t = new State();
    public String state;
    public String message;


    public void getMessage() {
        System.out.println(this.message);
    }



    public void getCurrentState() {
        System.out.println(t.getState());
    }

    public void setInitialState(String state) {
        t.state = state;
    }
}
