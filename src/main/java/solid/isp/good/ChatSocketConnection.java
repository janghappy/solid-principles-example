package solid.isp.good;

// 필요한 소켓 기능(SocketConnection)만 구현한다. http() 메서드는 구현하지 않는다.
public class ChatSocketConnection implements SocketConnection {
    private final String address;

    public ChatSocketConnection(String address) {
        this.address = address;
    }

    @Override
    public void socket() {
        System.out.println("Open a socket to " + address);
    }

    @Override
    public void connect() {
        System.out.println("Connect to " + address);
    }
}
