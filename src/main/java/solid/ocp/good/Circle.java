package solid.ocp.good;

// 자신의 면적을 area()로 직접 계산한다. 반지름은 외부에 노출하지 않는다.
public class Circle implements Shape {
    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
