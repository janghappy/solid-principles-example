package solid.ocp;

import java.util.List;

public class OcpDemo {
    public static void main(String[] args) {
        bad();
        good();
    }

    // OCP 위반: 면적을 구하는 방법을 AreaCalculator가 도형마다 instanceof 분기로 알고 있다.
    //
    //   새 도형 추가 시          | 해야 할 일
    //   -----------------------+------------------------------------------
    //   Triangle 추가          | Triangle 클래스 작성 + AreaCalculator#sum 분기 수정
    //
    // 분기 추가를 잊으면 컴파일 에러도 예외도 없이, 그 도형의 면적이 합계에서 조용히 빠진다.
    private static void bad() {
        System.out.println("\n[bad] OCP를 지키지 않은 방식\n");

        List<solid.ocp.bad.Shape> shapes = List.of(
                new solid.ocp.bad.Circle(4),
                new solid.ocp.bad.Circle(3),
                new solid.ocp.bad.Rectangle(5, 3),
                new solid.ocp.bad.Triangle(4, 3)); // ← 새로 추가했지만 AreaCalculator에 분기를 추가하지 않았다.

        System.out.println("Sum area: " + new solid.ocp.bad.AreaCalculator(shapes).sum());

        System.out.println("\n※ Triangle(면적 6.0)을 추가했지만 AreaCalculator를 수정하지 않아 합계에서 빠졌다.");
    }

    // OCP 준수: 면적을 구하는 방법을 각 도형이 area()로 직접 구현한다.
    //
    //   새 도형 추가 시          | 해야 할 일
    //   -----------------------+------------------------------------------
    //   Triangle 추가          | Shape를 구현한 Triangle 클래스 작성 (끝)
    //
    // 그래서 bad와 달리 AreaCalculator를 수정할 필요도, 수정을 잊을 위험도 없다.
    private static void good() {
        System.out.println("\n[good] OCP를 지킨 방식\n");

        List<solid.ocp.good.Shape> shapes = List.of(
                new solid.ocp.good.Circle(4),
                new solid.ocp.good.Circle(3),
                new solid.ocp.good.Rectangle(5, 3),
                new solid.ocp.good.Triangle(4, 3)); // ← 새로 추가한 도형. AreaCalculator는 한 줄도 수정하지 않았다.

        System.out.println("Sum area: " + new solid.ocp.good.AreaCalculator(shapes).sum());

        System.out.println("\n※ Triangle을 추가했지만 AreaCalculator는 수정하지 않았고, 면적도 합계에 정상 반영되었다.");
    }
}
