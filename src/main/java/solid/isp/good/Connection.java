package solid.isp.good;

// 인터페이스 분리 원칙 준수: 모든 연결의 공통 기능(connect)만 남겼다.
// HTTP와 소켓 기능은 HttpConnection과 SocketConnection으로 분리했다.
public interface Connection {
    void connect();
}
