package solid.dip;

import solid.dip.good.JdbcUrl;

public class DipDemo {
    public static void main(String[] args) {
        bad();
        good();
    }

    // DIP 위반: 고수준 모듈이 저수준 모듈(구체 클래스)에 직접 의존한다.
    //
    //   고수준 모듈             | 의존 대상                 | 주입할 수 있는 DB
    //   -----------------------+-------------------------+------------------
    //   ConnectToDatabase      | PostgreSQLJdbcUrl (구체)  | PostgreSQL만
    //
    // DB를 바꾸려면 저수준 구현이 아니라 고수준 모듈(ConnectToDatabase)을 수정해야 한다.
    private static void bad() {
        System.out.println("\n[bad] DIP를 지키지 않은 방식\n");

        solid.dip.bad.ConnectToDatabase connector =
                new solid.dip.bad.ConnectToDatabase(new solid.dip.bad.PostgreSQLJdbcUrl("my_db"));
        connector.connect();

        // new solid.dip.bad.ConnectToDatabase(new solid.dip.good.MySQLJdbcUrl("my_db"));
        //   ↑ 주석을 풀면 컴파일 에러: MySQL 구현체가 있어도 생성자는 PostgreSQLJdbcUrl만 받는다.

        System.out.println("\n※ MySQL을 쓰려면 ConnectToDatabase의 필드와 생성자 타입을 수정해야 한다.");
    }

    // DIP 준수: 고수준 모듈과 저수준 모듈이 모두 추상화(JdbcUrl)에 의존하고,
    //           구현체를 고르는 일은 조립자(DipDemo)가 맡는다.
    //
    //   역할                    | 클래스                                | 구체 클래스를 아는가
    //   -----------------------+--------------------------------------+------------------
    //   고수준 모듈              | ConnectToDatabase                    | ❌ JdbcUrl만 안다
    //   저수준 모듈              | PostgreSQLJdbcUrl, MySQLJdbcUrl      | 자기 자신
    //   조립자                  | DipDemo (Spring에서는 컨테이너)          | ✅ 여기서만 안다
    //
    // 그래서 bad와 달리 DB를 바꿔도 ConnectToDatabase는 수정하지 않고, 조립자 코드 한 줄만 바뀐다.
    private static void good() {
        System.out.println("\n[good] DIP를 지킨 방식\n");

        // DipDemo는 조립자 역할: 어떤 구현체를 쓸지 여기서만 결정한다.
        JdbcUrl postgres = new solid.dip.good.PostgreSQLJdbcUrl("my_db");
        solid.dip.good.ConnectToDatabase postgresConnector = new solid.dip.good.ConnectToDatabase(postgres); // ← 생성자 주입
        postgresConnector.connect();

        // DB를 바꾸려면 주입하는 구현체만 바꾼다. ConnectToDatabase 코드는 그대로다.
        JdbcUrl mysql = new solid.dip.good.MySQLJdbcUrl("my_db");
        solid.dip.good.ConnectToDatabase mysqlConnector = new solid.dip.good.ConnectToDatabase(mysql);    // ← 생성자 주입
        mysqlConnector.connect();

        System.out.println("\n※ 조립자(DipDemo)가 주입하는 구현체만 바꿨을 뿐, ConnectToDatabase는 수정하지 않았다.");
    }
}
