public interface MyList<T> extends Iterable<T> {
    void add(T value);
    void add(int idx, T value);
    void remove(T value);
    void remove(int idx);
    T get(int idx);
    boolean contains(T value);
    void set(int idx, T value);
}
