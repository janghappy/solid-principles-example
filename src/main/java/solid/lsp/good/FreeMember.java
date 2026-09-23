package solid.lsp.good;

// 실제로 할 수 있는 '참가'(TournamentJoiner)만 구현한다.
// organizeTournament() 자체가 없으므로 약속을 어길 일도 없다.
public class FreeMember extends Member implements TournamentJoiner {
    public FreeMember(String name) {
        super(name);
    }

    @Override
    public void joinTournament() {
        System.out.println("Free member " + name + " joins tournament ...");
    }
}
