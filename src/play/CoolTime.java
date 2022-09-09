package play;

public class CoolTime {
    int leftTurn;

    public CoolTime(int turn) {
        if (turn < 0) {
            throw new IllegalArgumentException("쿨타임은 0보다 작을 수 없습니다.");
        }
        if (turn > 5) {
            throw new IllegalArgumentException("쿨타임은 5보다 클 수 없습니다.");
        }
        this.leftTurn = turn;
    }

    public int getTurn() {
        return leftTurn;
    }

    public void downCoolTime() {
        if (leftTurn > 0) {
            leftTurn = leftTurn - 1;
        }
    }

    public boolean isLeft() {
        return leftTurn > 0;
    }

    public void initialize() {
        this.leftTurn = 0;
    }
}
