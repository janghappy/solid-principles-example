package solid.isp.good;

// HTTP 연결 역할. HTTP가 필요한 구현체만 이 인터페이스를 구현한다.
public interface HttpConnection extends Connection {
    void http();
}
