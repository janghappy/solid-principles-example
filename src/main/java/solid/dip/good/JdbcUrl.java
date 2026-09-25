package solid.dip.good;

// 추상화: 고수준 모듈(ConnectToDatabase)과 저수준 모듈(PostgreSQLJdbcUrl, MySQLJdbcUrl)이 모두 이 인터페이스에 의존한다.
public interface JdbcUrl {
    String get();
}
