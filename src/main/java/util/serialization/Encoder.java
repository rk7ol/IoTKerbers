package util.serialization;

public abstract class Encoder<T> {

    public abstract byte[] encode(T t);

}
