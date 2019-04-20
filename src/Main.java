import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Numbers numbers = new Numbers(new PriorityQueue<>());
        Thread t1 = new Thread(new NumberReader(numbers));
        Thread t2 = new Thread(new NumberGetter(numbers));
        t1.start();
        t2.start();
    }

}
