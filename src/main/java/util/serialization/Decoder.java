package util.serialization;

public abstract class Decoder<T> {
    public abstract T decode(byte[] bytes);
}
