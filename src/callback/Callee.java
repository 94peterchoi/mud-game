package callback;

import java.util.Scanner;

public class Callee {
    private int count;
    private callback callBack;

    public Callee() {
        count=0;
    }
    public void setCallBack(callback callBack) {this.callBack=callBack;}

    public int getCount() {
        return count;
    }
    public void addCount()

    {this.count++;}

    public void subtractCount() {this.count--;}

    public boolean execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("InputData:");
        int condition= scanner.nextInt();
        switch(condition) {
        case 1:
            this.callBack.addCount();
            break;
        case 2:
            this.callBack.subtractCount();
            break;
        }
        return callBack.isLessZero();
    }


}
