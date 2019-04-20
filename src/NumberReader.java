import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NumberReader implements Runnable{
    private final static Map<String, Integer> stringToDigit
            = new HashMap<String, Integer>(){
        {
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
            put("ten", 10);
            put("eleven", 11);
            put("twelve", 12);
            put("thirteen", 13);
            put("fourteen", 14);
            put("fifteen", 15);
            put("sixteen", 16);
            put("seventeen", 17);
            put("eighteen", 18);
            put("nineteen", 19);
            put("twenty", 20);
            put("thirty", 30);
            put("forty", 40);
            put("fifty", 50);
            put("sixty", 60);
            put("seventy", 70);
            put("eighty", 80);
            put("ninety", 90);
        }
    };

    Numbers numbers;

    public NumberReader(Numbers numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s;
            try {
                s = bf.readLine();
                String[] input = s.split(" ");
                Integer total = 0;
                Integer acc = 0;
                for (int i = 0; i < input.length; i++) {
                    String token = input[i];
                    if (stringToDigit.containsKey(token)) {
                        acc += stringToDigit.get(token);
                    } else if (token.equals("hundred")) {
                        acc *= 100;
                    } else if (token.equals("thousand")) {
                        total += acc*1000;
                        acc = 0;
                    }
                }
                total += acc;
                numbers.add(total);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
