import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Numbers {
    PriorityQueue<Integer> numbers;
    public Numbers(PriorityQueue<Integer> numbers) {
        this.numbers = numbers;
    }

    public void add(Integer i) {
        System.out.println(Thread.currentThread() + " in add");
        synchronized (this) {
            numbers.add(i);
        }
    }

    public Integer getMin() {
        synchronized (this) {
            try {
                Integer i = numbers.remove();
                return i;
            } catch (NoSuchElementException e) {
                return null;
            }
        }
    }
}
