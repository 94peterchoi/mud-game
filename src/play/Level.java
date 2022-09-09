package play;

public class Level implements Comparable<Level> {
    private final int level;
    private final Experience exp;

    public Level(int level, Experience exp) {
        if (level < 1) {
            throw new IllegalArgumentException("레벨은 1보다 작을 수 없습니다.");
        }
        this.level = level;
        this.exp = exp;
    }

    @Override
    public int compareTo(Level level) {
        return Double.compare(this.exp.getExperience(), level.exp.getExperience());
    }

    public boolean isSameLevel(Level level) {
        return this.level == level.level;
    }

    public boolean isLevelUp(Level afterLevel) {
        return this.level < afterLevel.level;
    }

    public boolean isQualifiedLevel(Level qualifiedLevel) {
        return this.level >= qualifiedLevel.level;
    }

    public boolean isUpperLevel(Level comparisonLevel) {
        return this.level >= comparisonLevel.level;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Level otherLevel = (Level) obj;

        return this.level == otherLevel.level;
    }

    @Override
    public int hashCode() {
        return level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "" + level;
    }
}
