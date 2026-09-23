package solid.lsp;

import java.util.List;
import solid.lsp.good.TournamentJoiner;
import solid.lsp.good.TournamentOrganizer;

public class LspDemo {
    public static void main(String[] args) {
        bad();
        good();
    }

    // LSP 위반: FreeMember는 Member의 약속(organizeTournament)을 지키지 못한다.
    private static void bad() {
        System.out.println("\n[bad] LSP를 지키지 않은 방식\n");

        List<solid.lsp.bad.Member> members = List.of(
                new solid.lsp.bad.PremiumMember("Jack Hores"),
                new solid.lsp.bad.VipMember("Tom Johns"),
                new solid.lsp.bad.FreeMember("Martin Vilop"));

        // 참가는 모든 하위 타입이 약속대로 동작한다.
        for (solid.lsp.bad.Member member : members) {
            member.joinTournament();
        }

        System.out.println();

        // 주최는 FreeMember에서 약속이 깨진다. 호출하는 쪽은 Member 타입만 보고는 이를 알 수 없다.
        for (solid.lsp.bad.Member member : members) {
            try {
                member.organizeTournament();
            } catch (UnsupportedOperationException e) {
                System.out.println("!! " + e.getMessage());
            }
        }
    }

    // LSP 준수: 능력별 인터페이스로 나눠, 각 타입 자리에는 약속을 지킬 수 있는 객체만 들어간다.
    //
    //   타입 자리              | 들어갈 수 있는 객체          | 이유
    //   ----------------------+----------------------------+------------------------
    //   TournamentJoiner      | Premium, VIP, Free         | 모두 참가할 수 있다
    //   TournamentOrganizer   | Premium, VIP               | Free는 주최할 수 없다
    //
    // 그래서 bad와 달리 try-catch가 필요 없다. 어떤 객체가 들어 있든 약속대로 동작한다.
    private static void good() {
        System.out.println("\n[good] LSP를 지킨 방식\n");

        // 참가 능력(TournamentJoiner): 세 회원 모두 구현하므로 모두 들어갈 수 있다.
        List<TournamentJoiner> joiners = List.of(
                new solid.lsp.good.PremiumMember("Jack Hores"),
                new solid.lsp.good.VipMember("Tom Johns"),
                new solid.lsp.good.FreeMember("Martin Vilop"));

        // 주최 능력(TournamentOrganizer): 주최할 수 있는 회원만 들어갈 수 있다.
        List<TournamentOrganizer> organizers = List.of(
                new solid.lsp.good.PremiumMember("Jack Hores"),
                new solid.lsp.good.VipMember("Tom Johns")
                // , new solid.lsp.good.FreeMember("Martin Vilop")
                //   ↑ 주석을 풀면 컴파일 에러: FreeMember는 TournamentOrganizer를 구현하지 않는다.
                //     bad에서는 '실행 중 예외'로 드러나던 문제를, good에서는 '컴파일 시점'에 막는다.
        );

        for (TournamentJoiner member : joiners) {
            member.joinTournament();
        }

        System.out.println();

        // bad와 달리 try-catch 없이 호출해도 안전하다.
        for (TournamentOrganizer member : organizers) {
            member.organizeTournament();
        }

        System.out.println("\n※ FreeMember는 TournamentOrganizer가 아니므로 주최 목록에 넣을 수 없다(컴파일 에러).");
    }
}
