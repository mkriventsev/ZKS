package model;

/**
 * @author Maksym Kriventsev
 */
public enum State {
    USA,
    CZECH_REPUBLIC,
    GERMANY,
    SLOVAKIA,
    GREAT_BRITAIN;

    public boolean isAbroad(State state) {
        return !state.equals(CZECH_REPUBLIC);
    }
}
