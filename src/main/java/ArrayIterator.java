import java.util.Iterator;

public class ArrayIterator<Type> implements Iterator<Type> {
    private  int index;
    private final Type[] values;

    public ArrayIterator(Type[] values) {
        this.values = values;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.values.length;
    }

    @Override
    public Type next() {
        return this.values[index++];
    }
}