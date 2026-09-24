package solid.isp;

public class IspDemo {
    public static void main(String[] args) {
        bad();
        good();
    }

    // ISP 위반: 하나의 뚱뚱한 Connection 인터페이스가 모든 기능을 선언한다.
    //
    //   구현체                 | 실제로 필요한 기능     | 억지로 구현한 기능
    //   ----------------------+---------------------+----------------------
    //   WwwPingConnection     | http, connect       | socket (빈 메서드)
    //
    // 클라이언트는 Connection 타입만 보고 socket()이 동작할 거라 기대하지만, 실제로는 아무 일도 하지 않는다.
    private static void bad() {
        System.out.println("\n[bad] ISP를 지키지 않은 방식\n");

        solid.isp.bad.Connection www = new solid.isp.bad.WwwPingConnection("www.yahoo.com");
        www.http();
        www.socket(); // ← 컴파일도 되고 예외도 없지만, 아무 일도 하지 않는다(빈 메서드). 문제가 조용히 숨는다.
        www.connect();

        System.out.println("\n※ socket()을 호출했지만 아무것도 출력되지 않았다. 클라이언트는 이 사실을 알 수 없다.");
    }

    // ISP 준수: 역할별 인터페이스로 나눠, 각 구현체는 필요한 기능만 구현하고 노출한다.
    //
    //   구현체                 | 구현한 인터페이스       | 사용할 수 있는 기능
    //   ----------------------+----------------------+----------------------
    //   WwwPingConnection     | HttpConnection       | http, connect
    //   ChatSocketConnection  | SocketConnection     | socket, connect
    //
    // 그래서 bad와 달리 빈 메서드가 없다. 호출할 수 있는 메서드는 모두 실제로 동작한다.
    private static void good() {
        System.out.println("\n[good] ISP를 지킨 방식\n");

        // HTTP 역할(HttpConnection): http()와 connect()만 보인다.
        solid.isp.good.HttpConnection www = new solid.isp.good.WwwPingConnection("www.yahoo.com");
        www.http();
        www.connect();
        // www.socket();
        //   ↑ 주석을 풀면 컴파일 에러: HttpConnection에는 socket()이 없다.
        //     bad에서는 '조용히 아무 일도 안 하던' 호출을, good에서는 '컴파일 시점'에 막는다.

        System.out.println();

        // 소켓 역할(SocketConnection): socket()과 connect()만 보인다.
        solid.isp.good.SocketConnection chat = new solid.isp.good.ChatSocketConnection("chat.example.com:9000");
        chat.socket();
        chat.connect();
        // chat.http();
        //   ↑ 주석을 풀면 컴파일 에러: SocketConnection에는 http()가 없다.

        System.out.println("\n※ 각 연결은 자신이 지원하는 기능만 노출하므로, 지원하지 않는 메서드는 호출 자체가 불가능하다(컴파일 에러).");
    }
}
