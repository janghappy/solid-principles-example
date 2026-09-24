package solid.isp.bad;

// HTTP 기능만 필요하지만, Connection을 구현하느라 socket()까지 구현해야 한다.
public class WwwPingConnection implements Connection {
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

    // 인터페이스 분리 원칙 위반: socket()이 필요 없는데도 강제로 구현해야 한다.
    // 빈 메서드라서 호출해도 아무 일도 일어나지 않지만, 클라이언트는 그 사실을 알 수 없다.
    @Override
    public void socket() { }
}
