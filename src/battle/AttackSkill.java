package battle;

import play.Damage;
import play.Skill;
import entity.Character;
import play.Stat;

public class AttackSkill extends Skill {

    protected AttackStrategy attackStrategy;

    public AttackSkill() {
        this.attackStrategy = new AttackAtype(1.0, 1.0);
    }

    public AttackSkill(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    @Override
    public void doEffect() {
        // motion
        Damage weaponDamage = Character.getCharacterInstance().getWeapon().getDamage();
        Stat stat = Character.getCharacterInstance().getStats().getMainStat(Character.getCharacterInstance().getMainStat());

        Damage damage = calculateAttackDamage(stat, weaponDamage);

        BattleInfo.getMonster().beAttacked(damage);
    }

    public Damage calculateAttackDamage(Stat stat, Damage damage) {
        return attackStrategy.calcDamage(stat, damage);
    }
}
