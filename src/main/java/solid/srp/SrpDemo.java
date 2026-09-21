package solid.srp;

public class SrpDemo {
    public static void main(String[] args) {
        bad();
        good();
    }

    // SRP 위반: 한 클래스가 서로 다른 이유로 바뀌는 두 가지 책임을 갖는다.
    //
    //   클래스                   | 책임                    | 변경 이유
    //   ------------------------+------------------------+------------------------------
    //   RectangleAreaCalculator | 면적 계산 + 단위 변환      | 면적 공식 변경, 지원 단위 추가 (2개)
    //
    // 단위 하나를 추가하려 해도 면적 계산기를 열어 수정해야 한다.
    private static void bad() {
        System.out.println("\n[bad] SRP를 지키지 않은 방식\n");

        solid.srp.bad.RectangleAreaCalculator calculator = new solid.srp.bad.RectangleAreaCalculator(4, 2);
        int area = calculator.area();

        System.out.println("Area in meters: " + area);
        System.out.println("Area in inches: " + calculator.metersToInches(area)); // ← 면적 계산기에게 단위 변환을 맡긴다.

        System.out.println("\n※ 면적 공식이 바뀌어도, 단위가 추가되어도 RectangleAreaCalculator를 수정해야 한다(변경 이유 2개).");
    }

    // SRP 준수: 책임마다 클래스를 나눠, 각 클래스는 하나의 이유로만 바뀐다.
    //
    //   클래스                   | 책임        | 변경 이유
    //   ------------------------+------------+------------------
    //   RectangleAreaCalculator | 면적 계산    | 면적 공식 변경 (1개)
    //   AreaConverter           | 단위 변환    | 지원 단위 추가 (1개)
    //
    // 그래서 bad와 달리 단위를 추가해도 면적 계산기는 건드리지 않는다.
    private static void good() {
        System.out.println("\n[good] SRP를 지킨 방식\n");

        // 면적 계산 책임
        solid.srp.good.RectangleAreaCalculator calculator = new solid.srp.good.RectangleAreaCalculator(4, 2);
        int area = calculator.area();
        // calculator.metersToInches(area);
        //   ↑ 주석을 풀면 컴파일 에러: 면적 계산기에는 더 이상 단위 변환 기능이 없다.

        // 단위 변환 책임
        solid.srp.good.AreaConverter converter = new solid.srp.good.AreaConverter();

        System.out.println("Area in meters: " + area);
        System.out.println("Area in inches: " + converter.metersToInches(area));
        System.out.println("Area in feet: " + converter.metersToFeet(area)); // ← 새로 추가한 단위. 면적 계산기는 수정하지 않았다.

        System.out.println("\n※ 피트 단위(metersToFeet)를 추가할 때 RectangleAreaCalculator는 수정하지 않았다(변경 이유 1개).");
    }
}
