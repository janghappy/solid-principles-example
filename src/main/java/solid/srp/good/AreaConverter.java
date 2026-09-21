package solid.srp.good;

// 단일 책임 원칙 준수: '단위 변환' 책임만 갖는다(bad.RectangleAreaCalculator#metersToInches에서 분리).
// 새 단위(metersToFeet 등)가 추가되어도 면적 계산기는 수정하지 않는다.
public class AreaConverter {
    private static final double INCH_TERM = 0.0254d;
    private static final double FEET_TERM = 0.3048d;

    public double metersToInches(int area) {
        return area / INCH_TERM;
    }

    public double metersToFeet(int area) {
        return area / FEET_TERM;
    }
}
