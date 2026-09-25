package solid.dip.good;

// 새로 추가한 저수준 모듈. JdbcUrl만 구현하면 ConnectToDatabase를 수정하지 않고 사용할 수 있다.
public class MySQLJdbcUrl implements JdbcUrl {
    private final String dbName;

    public MySQLJdbcUrl(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public String get() {
        return "jdbc:mysql:// ... " + this.dbName;
    }
}
