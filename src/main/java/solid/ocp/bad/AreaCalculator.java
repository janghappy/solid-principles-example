package solid.ocp.bad;

import java.util.List;

public class AreaCalculator {
    private final List<Shape> shapes;

    public AreaCalculator(List<Shape> shapes) {
        this.shapes = shapes;
    }

    // 개방-폐쇄 원칙 위반: 새 도형(삼각형 등)을 추가할 때마다 이 메서드에 분기를 추가해야 한다.
    // 즉, 확장하려면 기존 코드를 수정해야 한다.
    public double sum() {
        double sum = 0;
        for (Shape shape : shapes) {
            if (shape instanceof Circle circle) {
                sum += Math.PI * Math.pow(circle.getRadius(), 2);
            } else if (shape instanceof Rectangle rectangle) {
                sum += rectangle.getHeight() * rectangle.getWidth();
            }
        }

        return sum;
    }
}
