package solid;

import solid.dip.DipDemo;
import solid.isp.IspDemo;
import solid.lsp.LspDemo;
import solid.ocp.OcpDemo;
import solid.srp.SrpDemo;

/**
 * SOLID 원칙 예제 전체 실행.
 * 각 원칙은 solid.{srp,ocp,lsp,isp,dip} 패키지에 bad(위반) / good(준수) 버전으로 나뉘어 있다.
 */
public class Main {
    public static void main(String[] args) {
        section("S - 단일 책임 원칙 (SRP)");
        SrpDemo.main(args);

        section("O - 개방-폐쇄 원칙 (OCP)");
        OcpDemo.main(args);

        section("L - 리스코프 치환 원칙 (LSP)");
        LspDemo.main(args);

        section("I - 인터페이스 분리 원칙 (ISP)");
        IspDemo.main(args);

        section("D - 의존관계 역전 원칙 (DIP)");
        DipDemo.main(args);
    }

    private static void section(String title) {
        System.out.println();
        System.out.println("==================================================");
        System.out.println(" " + title);
        System.out.println("==================================================");
    }
}
