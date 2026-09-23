package solid.lsp.good;

// VIP 회원은 참가와 주최가 모두 가능하므로 TournamentJoiner와 TournamentOrganizer를 모두 구현한다.
public class VipMember extends Member implements TournamentJoiner, TournamentOrganizer {
    public VipMember(String name) {
        super(name);
    }

    @Override
    public void joinTournament() {
        System.out.println("VIP member " + name + " joins tournament ...");
    }

    @Override
    public void organizeTournament() {
        System.out.println("VIP member " + name + " organizes tournament ...");
    }
}
