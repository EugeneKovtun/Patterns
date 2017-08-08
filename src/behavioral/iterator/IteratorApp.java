package behavioral.iterator;

import java.util.ArrayList;

/**
 * Created by eugene on 08.08.17.
 */
public class IteratorApp {
    public static void main(String[] args) {
        Tasks tasks = new Tasks();
        Iterator iterator = tasks.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
interface Iterator<T>{
    boolean hasNext();
    T next();
}
interface Container{
    Iterator getIterator();
}

class Tasks implements Container{
    String[] tasks = {"Build house", "To plant a tree", "Raise a son"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }
    private class TaskIterator implements Iterator<String>{
        int index = 0;
        @Override
        public boolean hasNext() {
            return index<tasks.length;
        }

        @Override
        public String next() {
            return tasks[index++];
        }
    }
}