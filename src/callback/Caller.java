package callback;

public class Caller {

    public static void main(String[] args) {

        Callee callee = new Callee();
        callee.setCallBack(new callback() {
            @Override
            public void addCount() {
                callee.addCount();
                System.out.println(callee.getCount());
            }

            @Override
            public void subtractCount() {
                callee.subtractCount();
                System.out.println(callee.getCount());
            }

            @Override
            public boolean isLessZero() {
                return callee.getCount() < 0;
            }
        });

        while (true) {
            if (callee.execute()) break;
        }

    }
}
