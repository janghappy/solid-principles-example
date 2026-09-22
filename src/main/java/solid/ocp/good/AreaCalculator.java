package solid.ocp.good;

import java.util.List;

public class AreaCalculator {
    private final List<Shape> shapes;

    public AreaCalculator(List<Shape> shapes) {
        this.shapes = shapes;
    }

    // 개방-폐쇄 원칙 준수: 면적 계산을 각 도형의 area()에 위임하므로 도형별 분기가 없다.
    // 새 도형(Triangle 등)은 Shape를 구현하기만 하면 되고, 이 메서드는 수정하지 않는다.
    public double sum() {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.area();
        }

        return sum;
    }
}
