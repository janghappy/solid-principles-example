package solid.dip.good;

// 저수준 모듈. 추상화(JdbcUrl)를 구현하므로, 고수준 모듈은 이 클래스를 알지 못한다.
public class PostgreSQLJdbcUrl implements JdbcUrl {
    private final String dbName;

    public PostgreSQLJdbcUrl(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public String get() {
        return "jdbc:postgresql:// ... " + this.dbName;
    }
}
