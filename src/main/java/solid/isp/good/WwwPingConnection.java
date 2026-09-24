package solid.isp.good;

// 필요한 HTTP 기능(HttpConnection)만 구현한다.
// socket() 메서드 자체가 없으므로, 빈 메서드를 억지로 구현할 필요가 없다.
public class WwwPingConnection implements HttpConnection {
    private final String www;

    public WwwPingConnection(String www) {
        this.www = www;
    }

    @Override
    public void http() {
        System.out.println("Setup an HTTP connection to " + www);
    }

    @Override
    public void connect() {
        System.out.println("Connect to " + www);
    }
}
