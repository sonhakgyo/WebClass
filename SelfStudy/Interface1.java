package SelfStudy;

public class Interface1 {
    public static void main(String[] args) {
      
    }
}

// interface A { 
//   int a = 4; 
//   void methodA();
//   void methodB();
// }

interface Ainter {
  final int x=10;
  int y=20; // final 생략가능
  abstract void methodA();
  void methodB(); // abstract 생략가능
}

class B implements Ainter{
  @Override
  public void methodA() {
    System.out.println("methodA()");
  }

  @Override
  public void methodB() {
    
  }

}