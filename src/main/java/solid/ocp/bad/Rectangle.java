package solid.ocp.bad;

// 면적 계산에 필요한 값(너비, 높이)만 getter로 노출하고, 계산은 AreaCalculator에 맡긴다.
public class Rectangle implements Shape {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
