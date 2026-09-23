package solid.lsp.bad;

// 리스코프 치환 원칙 위반: '모든 회원은 토너먼트에 참가하고 주최할 수 있다'고 약속한다.
// 하지만 무료 회원은 주최할 수 없으므로, 이 약속을 지킬 수 없는 하위 타입(FreeMember)이 생긴다.
public abstract class Member {
    protected final String name;

    public Member(String name) {
        this.name = name;
    }

    public abstract void joinTournament();
    public abstract void organizeTournament();
}
