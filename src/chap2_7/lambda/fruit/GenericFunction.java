package chap2_7.lambda.fruit;

@FunctionalInterface
public interface GenericFunction<X, Y> {

    // X객체를 주면 그 안에서 Y객체를 추출해서 리턴
    Y apply(X x);
}
