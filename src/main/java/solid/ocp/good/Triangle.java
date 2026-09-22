package solid.ocp.good;

// 확장의 예: 새로 추가한 도형. Shape만 구현했고 AreaCalculator 등 기존 코드는 수정하지 않았다.
// bad 방식이었다면 bad.AreaCalculator#sum에 삼각형 분기를 추가해야 한다.
public class Triangle implements Shape {
    private final int base;
    private final int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return base * height / 2.0;
    }
}
