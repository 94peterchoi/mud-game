package play;

public class Experience {

    private double experience;

    public Experience(double exp) {
        expValidCheck(exp);
        this.experience = exp;
    }

    public double getExperience() {
        return experience;
    }

    public void obtainExp(Experience exp) {
        this.experience = this.experience + exp.experience;
    }

    public void expValidCheck(double exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("경험치는 0보다 작을 수 없습니다.");
        }
    }




}
