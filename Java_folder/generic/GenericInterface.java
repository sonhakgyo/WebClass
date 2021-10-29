package Java_folder.generic;

public interface GenericInterface<N1, N2> {
    /* abscract 생략 가능 */
    N1 sub(N1 data1, N2 data2);

    N2 mul(N2 data1, N2 data2);

    abstract N1 add(N1 data1, N1 data2);
}
