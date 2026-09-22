package solid.ocp.good;

// 개방-폐쇄 원칙 준수: area()를 확장 지점으로 둔다.
// 면적을 구하는 방법은 각 도형이 직접 구현하므로, AreaCalculator는 도형의 종류를 알 필요가 없다.
public interface Shape {
    double area();
}
