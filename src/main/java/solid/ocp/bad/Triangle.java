package solid.ocp.bad;

// 새로 추가한 도형. 면적 계산에 필요한 값(밑변, 높이)만 getter로 노출한다.
// AreaCalculator#sum에 Triangle 분기를 추가하지 않았으므로, 이 도형의 면적은 합계에서 빠진다.
public class Triangle implements Shape {
    private final int base;
    private final int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }
}
