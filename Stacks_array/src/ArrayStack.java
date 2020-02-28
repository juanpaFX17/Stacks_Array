import java.util.*;

public class ArrayStack<T> implements Stack<T>{
    int top;
    T[] stack;

    //constructors
    public ArrayStack(int initialCapacity){
        if(initialCapacity < 1)
            throw new IllegalArgumentException
                    ("initialCapacity_must_be_>=_1");
        stack = ( T[] ) new Object[initialCapacity];
        top = -1;
    }
    public ArrayStack()
    {
        this(10);
    }

    //methods

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return stack[ top ];
    }

    @Override
    public void push(T theElement)
    {
        //increase array size if necessary
        if (top == stack.length-1)
        {
            T[] old = stack;
            stack = (T[]) new Object[2*stack.length];
            System.arraycopy(old, 0, stack, 0, old.length);
        }
        //put theElement at the top of the stack
        stack[ ++top ] = theElement;
    }

    @Override
    public T pop()
    {
        if (isEmpty())
            throw new EmptyStackException();
        T topElement = stack[top];
        stack[top--] = null; //enable garbage collection
        return topElement;
    }

    public static void main(String[] args)
    {
        int x;
        ArrayStack<Integer> s = new ArrayStack<>(3);

        // add a few elements
        s.push(new Integer(1));
        s.push(new Integer(2));
        s.push(new Integer(3));
        s.push(new Integer(4));

        //delete all elements
        while (!s.isEmpty())
        {
            System.out.println("Top element is " + s.peek());
            System.out.println("Remove the element " + s.pop());
            System.out.println("Esta vacio? " + s.isEmpty());
        }
    }
}
