
public class NumberGetter implements Runnable {
    Numbers numbers;
    public NumberGetter(Numbers numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(5000);
                Integer i = numbers.getMin();
                if (i != null) {
                    System.out.println("Min is: " + i);
                } else {
                    System.out.println("No numbers");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
