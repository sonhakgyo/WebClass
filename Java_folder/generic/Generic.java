package Java_folder.generic;

/* 클래스 이름 뒤에 '제네릭'이 붙는다. */
public class Generic<T> {
	/* 이때, private으로 지정했기 때문에 setData 메서드를 이용해 받아온다. */
	/* 외부에서 어떤 타입이 들어올지 모르기 때문에 String, Double 타입도 만든다. */
	/* 그러나 제네릭을 사용하면 타입을 여러개 만들 필요가 없다. */
	private int data;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	/* 제네릭 타입의 게터와 세터 */
	/* int 타입을 T로 바꿔주면 된다. */
	private T dataT;
	
	public T getDataT() {
		return dataT;
	}
	public void setData(T dataT) {
		this.dataT = dataT;
	}
	public static class Single {
        public static Single getInstance() {
            return null;
        }

        public void sayHello() {
        }
	}
}
