package JavaStudy;

public class Generic {
    public static void main(String[] args) {
        TestGeneric g = new TestGeneric();
        g.setData(10);
        g.setData("안녕");
        g.setData(10.5);
        System.out.println(g.getData());

    }
}
