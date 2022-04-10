// Figure 13-6
//
//  Queue interface
//
//  If you implement this Queue interface you MUST provide the following
//  functionality  (requirement)

public interface Queue<T> {

    public int size();
    public boolean isEmpty();
    public void clear();
    public void add(T value);
    public T remove();
    public T peek();

}
