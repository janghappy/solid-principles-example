package solid.dip.bad;

// 의존관계 역전 원칙 위반: 고수준 모듈(DB 연결)이 저수준 모듈(PostgreSQL 구현체)에 직접 의존한다.
// MySQL로 바꾸려면 필드와 생성자의 타입을 수정해야 한다.
public class ConnectToDatabase {
    private final PostgreSQLJdbcUrl postgresql;

    // 생성자로 받긴 하지만, 타입이 구체 클래스라서 PostgreSQL 외에는 주입할 수 없다.
    public ConnectToDatabase(PostgreSQLJdbcUrl postgresql) {
        this.postgresql = postgresql;
    }

    public void connect() {
        System.out.println("Connecting to " + postgresql.get());
    }
}
