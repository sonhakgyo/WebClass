/* 패키지명에 .을 사용하면 폴더가 하나 더 만들어진다. */
/* a.b.c.d ==> a폴더 안에 b폴더 안에 c폴더 안에 d */
package Java_folder.collection_folder;

public class SingleMain {
    public static void main(String[] args) {
    //  generic.Single single = new generic.Single.getInstance(); 
    //  single에 대한 접근 제어자가 private이기 때문에 new를 사용할 수 없다. 
    //  import가 되지 않으면? 패키지.클래스명으로 접근할 수 있다. 
    //  회사에서 쓴다구 한다.. 
        Generic.Single single = Generic.Single.getInstance();

        single.sayHello();
    }
}
