package core;

/**
 * Created by chv on 13.02.2017.
 * Key names to send keycode
 */
public enum Key {
    BACK_BUTTON(4),
    ENTER_BUTTON(66);

    private int value;

    Key(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
