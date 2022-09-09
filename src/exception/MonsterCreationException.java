package exception;

public class MonsterCreationException extends RuntimeException {
    public MonsterCreationException() {
        super("몬스터 생성 도중 에러가 발생하였습니다. (생성된 몬스터 없음)");
    }

}
