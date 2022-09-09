package callbacktest;

public class stat {

    int stat = 4;
    int amount = 10;
    int period = 2;
    int endPeriod = 3;

    callback callback;

    public void setCallback(callback callback) {
        this.callback = callback;
    }

    public void unmountBuff() {
        if (callback.checkTurn()) {
            this.stat -= amount;
        }
    }

    public void endBuff() {
        this.stat -= amount;
    }


}
