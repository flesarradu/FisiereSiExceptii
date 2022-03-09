import java.util.Scanner;

public class Queue<T>{
    private Object[] list;
    private int top;
    private int bottom;
    private final int size;


    public Queue(int size) {
        list = new Object[size];
        this.size = size;
        top = -1;
        bottom = -1;
    }

    public boolean plina(){
        if(top == 0 && bottom == size-1){
            System.out.println("Coada este plina!");
            return true;
        }
        else{
            return false;
        }
    }

    boolean goala(){
        if(top == -1){
            System.out.println("Coada este goala!");
            return true;
        }
        else{
            return false;
        }
    }

    public void enqueue(T x) {
        T element = x;
        if (plina()) {
            System.out.println("Coada este plina");
            return;
        }
        top = 0;
        bottom++;
        list[bottom] = element;
        System.out.println("Element introdus " + element);
    }

    public T dequeue(){
        if (goala()) {
            System.out.println("Coada este goala!");
            return null;
        }
        else {
            if (top >= bottom){
                int lasttop=top;
                top = -1;
                bottom = -1; // Este un singur element in coada
                return (T) list[lasttop];
            }
            else {
                System.out.println("Sa sters un element " + list[top]);
                top++;
                bottom--;
            }
        }
        return (T) list[top];
    }

    public int indexOf(int x) {
        int index = 0;

        for (int i = 0; i<=list.length; i++){
            if (list[i].equals(x)){
                index = i;
                break;
            }
        }
        return index;
    }


    public T peek(){
        if (goala()) {
            System.out.println("Coada este goala!");
            return null;
        }
        return (T) list[top];
    }


    void afisare(){
        int i;
        if (top == -1){
            System.out.println("Coada este goala!");
        }
        else {
            System.out.println("Elementele cozii sunt: ");
            for (i = top; i<=bottom; i++){
                System.out.println(list[i]);
            }

        }

    }



}

