package solid.lsp.good;

// 리스코프 치환 원칙 준수: 공통 상태(이름)만 갖고, 행위는 약속하지 않는다.
// 할 수 있는 일은 각 회원이 TournamentJoiner / TournamentOrganizer 중에서 골라 구현한다.
public abstract class Member {
    protected final String name;

    public Member(String name) {
        this.name = name;
    }
}
