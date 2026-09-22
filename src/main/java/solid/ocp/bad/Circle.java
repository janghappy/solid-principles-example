package solid.ocp.bad;

// 면적 계산에 필요한 값(반지름)만 getter로 노출하고, 계산은 AreaCalculator에 맡긴다.
public class Circle implements Shape {
    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}
