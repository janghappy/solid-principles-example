package solid.dip.good;

// 의존관계 역전 원칙 준수: 고수준 모듈(DB 연결)이 구체 클래스가 아닌 추상화(JdbcUrl)에 의존한다.
// MySQL 등 다른 DB로 바꿔도 이 클래스는 수정하지 않는다.
public class ConnectToDatabase {
    private final JdbcUrl jdbcUrl;

    // 생성자 주입: 어떤 구현체를 쓸지는 바깥(조립자)이 결정해서 넣어 준다.
    // Spring에서 생성자로 빈을 주입받는 방식과 같은 모양이다.
    public ConnectToDatabase(JdbcUrl jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public void connect() {
        System.out.println("Connecting to " + jdbcUrl.get());
    }
}
