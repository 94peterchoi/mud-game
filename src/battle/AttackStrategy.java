package battle;

import play.Damage;
import play.Stat;

public interface AttackStrategy {

    Damage calcDamage(Stat stat, Damage damage);
}
