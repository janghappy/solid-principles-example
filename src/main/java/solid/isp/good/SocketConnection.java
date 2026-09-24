package solid.isp.good;

// 소켓 연결 역할. 소켓이 필요한 구현체만 이 인터페이스를 구현한다.
public interface SocketConnection extends Connection {
    void socket();
}
