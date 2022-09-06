package Property;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetProperty<T> {
    protected Set<T> values = null;

    public Set<T> get() {
        if (null == values)
            return null;
        return Collections.unmodifiableSet(values);
    }

    public Boolean add(T t) {
        boolean added = false;
        if (null == t)
            throw new NullPointerException();
        if (null == values)
            values = new HashSet<T>();
        if (!values.contains(t))
            added = values.add(t);
        return added;
    }

    public Boolean remove(T t) {
        boolean removed = false;
        if (null == t)
            throw new NullPointerException();
        if (null == values)
            throw new IllegalArgumentException();
        if (values.contains(t)) {
            removed = values.remove(t);
        }
        else
            throw new IllegalArgumentException();
        return removed;
    }

}
