package study;

public class ShapeMain {
  public static void main(String[] args) {
    /*
    - 도형 클래스를 생성하고 draw() 메서드를 만들고, 도형 클래스를 상속받는 사각형, 원, 선 class를 생성한다. 
    - 각 class에 맞게 오버라이딩한다.
    */

    Shape[] shapes = new Shape[3];
    // 객체 배열의 각 요소를 업캐스팅을 통한 자식값으로 채운다.
    shapes[0] = new Rect();
    shapes[1] = new Circle();
    shapes[2] = new Line();

    //오버라이딩한 자식 메서드가 동적 바인딩에 의해 실행한다.
    for(int i=0; i<3; i++) {
      shapes[i].draw();
    }
  }
}

//class Shape { 
//  void draw() {
//    // 어떤 도형을 그리는지 모르기 때문에 사실상 불필요한 기능이다.
//    System.out.println("도형을 그리다."); 
//  }
//}
abstract class Shape {
  abstract void draw(); 
}

class Rect extends Shape { 
  void draw() {
    System.out.println("사각형을 그리다.");
  }
}

class Circle extends Shape {
  void draw() {
    System.out.println("원을 그리다.");
  }
}

class Line extends Shape {
  void draw() {
    System.out.println("선을 그리다.");
  }
}