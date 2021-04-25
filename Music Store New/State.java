
public class State {
    //alter to states to be more specific for each state in each class?

    public static String state = " ";
    public static final String ready = "----------Ready. Message shown------------\n";
    public static final String pending = "------------Waiting for input------------\n";
    public static final String selected = "-------------Selected. Input given------------\n";
    public static final String exit = "------------Finished-----------\n";



    public void setState(String state) {
        State.state = state;
    }

    public String getState() {

        if(state.equalsIgnoreCase(ready)) {
            return ready;
        }
        else if(state.equalsIgnoreCase(pending)) {
            return pending;
        }
        else if (state.equalsIgnoreCase(selected)) {
            return selected;
        }
        else if (state.equalsIgnoreCase(exit)) {
            return exit;
        }
        return null;
    }

}