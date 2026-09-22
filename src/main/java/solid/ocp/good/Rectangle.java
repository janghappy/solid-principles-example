package solid.ocp.good;

// 자신의 면적을 area()로 직접 계산한다. 너비와 높이는 외부에 노출하지 않는다.
public class Rectangle implements Shape {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
