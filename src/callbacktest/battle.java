package callbacktest;

public class battle {

    int round = 1;
    stat stat = new stat();

    public void conductRound() {
        round++;

//        if (round == stat.endPeriod) {
//            stat.endBuff();
//            stat = null;
//        }

        stat.setCallback(new callback() {
            @Override
            public boolean checkTurn() {
                 return round == stat.endPeriod;
            }
        });

        stat.unmountBuff();
    }
    
}

