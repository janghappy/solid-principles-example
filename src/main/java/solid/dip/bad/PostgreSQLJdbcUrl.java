package solid.dip.bad;

// 저수준 모듈. 구현할 추상화가 없어서, 고수준 모듈(ConnectToDatabase)이 이 클래스를 직접 참조한다.
public class PostgreSQLJdbcUrl {
    private final String dbName;

    public PostgreSQLJdbcUrl(String dbName) {
        this.dbName = dbName;
    }

    public String get() {
        return "jdbc:postgresql:// ... " + this.dbName;
    }
}
