package item;

public class Item {

    protected boolean isWearable;
    protected boolean isUseable;
    protected double weight;
    protected String name;
    protected String description;

    @Override
    public String toString() {
        return "item.Item{" +
                "착용가능 여부=" + isWearable +
                ", 사용가능 여부=" + isUseable +
                ", 무게=" + weight +
                ", 이름='" + name + '\'' +
                ", 설명='" + description + '\'' +
                '}';
    }
}
