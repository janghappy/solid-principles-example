package solid.srp.good;

// 단일 책임 원칙 준수: '면적 계산' 책임만 갖는다.
// 단위 변환은 AreaConverter로 분리했으므로, 계산 방식이 바뀔 때만 이 클래스를 수정한다(변경 이유가 1개).
public class RectangleAreaCalculator {
    private final int width;
    private final int height;

    public RectangleAreaCalculator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }
}
