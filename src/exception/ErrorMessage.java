package exception;

public enum ErrorMessage {
    MONSTER_NOT_CREATION("몬스터 생성 도중 에러가 발생하였습니다. (생성된 몬스터 없음)"),
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
