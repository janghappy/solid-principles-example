package solid.lsp.bad;

// 프리미엄 회원은 참가와 주최가 모두 가능하므로 Member의 약속을 지킨다.
public class PremiumMember extends Member {
    public PremiumMember(String name) {
        super(name);
    }

    @Override
    public void joinTournament() {
        System.out.println("Premium member " + name + " joins tournament ...");
    }

    @Override
    public void organizeTournament() {
        System.out.println("Premium member " + name + " organizes tournament ...");
    }
}
