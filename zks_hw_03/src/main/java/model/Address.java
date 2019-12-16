package model;

/**
 * @author Maksym Kriventsev
 */
public class Address {
    private State state;
    private String addressInState;

    public Address(State state, String addressInState) {
        if (state == null)
            throw new IllegalArgumentException("State doesn't have to be null.");
        if (addressInState == null)
            throw new IllegalArgumentException("Address in state doesn't have to be null.");
        if (addressInState.equals(""))
            throw new IllegalArgumentException("Address in state doesn't have to be empty.");
        this.state = state;
        this.addressInState = addressInState;
    }

    public boolean isAbroad() {
        return this.state.isAbroad(state);
    }
}
