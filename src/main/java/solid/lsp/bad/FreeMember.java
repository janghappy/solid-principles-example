package solid.lsp.bad;

// Member를 상속하는 바람에, 할 수 없는 '주최' 기능까지 떠안는다.
public class FreeMember extends Member {
    public FreeMember(String name) {
        super(name);
    }

    @Override
    public void joinTournament() {
        System.out.println("Free member " + name + " joins tournament ...");
    }

    // 리스코프 치환 원칙 위반: 무료 회원은 주최할 수 없으므로 상위 타입의 약속을 지킬 수 없다.
    // FreeMember는 Member를 대체할 수 없다.
    @Override
    public void organizeTournament() {
        throw new UnsupportedOperationException("A free member cannot organize tournaments");
    }
}
