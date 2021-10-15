package generic;

public class GenericCalculator implements GenericInterface<Double, Integer> {
    public static void main(String[] args) {
        GenericCalculator cal = new GenericCalculator();
        System.out.printf("%.2f\n", cal.add(2.7, 4.1));
        System.out.printf("%.2f\n", cal.sub(2.7, 4)); /* 매개변수도 타입에 맞게 */
        System.out.printf("%d\n", cal.mul(2, 4)); /* 매개변수도 타입에 맞게 */
    }

    @Override
    public Double add(Double data1, Double data2) {
        return data1 + data2;
    }

    @Override
    public Double sub(Double data1, Integer data2) {
        return data1 - data2;
    }

    @Override
    public Integer mul(Integer data1, Integer data2) {
        return data1 * data2;
    }
}
