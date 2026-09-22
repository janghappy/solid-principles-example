package solid.ocp.bad;

// 개방-폐쇄 원칙 위반: 행위가 없는 표식(marker) 인터페이스다.
// 면적을 구하는 방법은 AreaCalculator가 도형마다 알고 있어야 한다.
public interface Shape { }
