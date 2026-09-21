package solid.srp.bad;

// 단일 책임 원칙 위반: '면적 계산'과 '단위 변환' 두 가지 책임을 갖는다.
// 계산 방식이 바뀌어도, 지원 단위가 늘어나도 이 클래스를 수정해야 한다(변경 이유가 2개).
public class RectangleAreaCalculator {
    private static final double INCH_TERM = 0.0254d;

    private final int width;
    private final int height;

    public RectangleAreaCalculator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }

    // 면적 계산과 무관한 단위 변환 책임. 단위가 늘어날 때마다 이 클래스에 메서드가 추가된다.
    public double metersToInches(int area) {
        return area / INCH_TERM;
    }
}
