package Java_folder.abstractClass;

public abstract class ShapeAbstract {
    double area;

    abstract void showArea(double w, double h);

    /* 메서드에 final을 붙일 수 있다. 재정의는 불가능하고 사용만 할 수 있다. */
    /* 자식 클래스에서 재정의하는 것을 막기 위함이다. */
    final void function() {
        System.out.println("추상 클래스의 일반 메서드입니다.");
    }
}

/* 추상클래스 Shape를 상속받은 후 빨간 줄이 뜨는 이유를 생각해보자. */
class Rect extends ShapeAbstract {
    @Override
    void showArea(double w, double h) {
        area = w * h;
        /* ²는 'ㅊ+한자'다. */
        System.out.println("넓이 : " + area + "cm²");
    }
}

/* 클래스 주제는 사각형(Rect)과 삼각형(Tri)이다. */
class Tri extends ShapeAbstract {
    @Override
    void showArea(double w, double h) {
        area = (w * h) / 2;
        System.out.println("넓이 : " + area + "cm²");
    }
}