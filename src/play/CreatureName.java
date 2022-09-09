package play;

import java.util.regex.Pattern;

public class CreatureName {

    String name;

    public CreatureName(String name) {

        boolean isValidName = Pattern.matches("^[ㄱ-ㅎ가-힣a-zA-Z0-9]*$", name);

        if (!isValidName) {
            throw new IllegalArgumentException("이름은 한글, 영문자, 숫자만 입력이 가능합니다.");
        }
        if (name.length() < 1) {
            throw new IllegalArgumentException("이름은 한 글자 이상이어야 합니다.");
        }
        if (name.length() > 10) {
            throw new IllegalArgumentException("이름은 10자를 넘을 수 없습니다.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
