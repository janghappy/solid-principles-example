package solid.isp.bad;

// 인터페이스 분리 원칙 위반: 뚱뚱한(fat) 인터페이스.
// socket()과 http()처럼 성격이 다른 기능을 한데 묶어, 구현체가 쓰지 않는 메서드까지 구현하게 만든다.
public interface Connection {
    void socket();
    void http();
    void connect();
}
