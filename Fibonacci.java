import java.util.*;

class Fibonacci {



    int input = 0;
    int MAX = 70;
    long[] memory = new long[MAX + 1];
    long answer = 0;

    

    Fibonacci () {

        Scanner scanner = new Scanner(System.in);
        String line;
        initMemory();

        while (true) {

            System.out.println("Enter a number...");
            line = scanner.next();
            
            if (line.equals("quit") || line.equals("exit")) {
                return;
            }
            
            try {
                input = Integer.parseInt(line);
            }
            catch (NumberFormatException e) {
                System.out.println("Input must be an Integer!");
                continue;
            }

            if (input > MAX) {
                System.out.println("Input is too large!");
                continue;
            }

            answer = calc(input);

            showFibonacciNumber();
            showFibonacciNumbers();
            
        }
    }



    long calc(int index) {

        long answer;

        if (index < 2) {
            answer = index;
        } else {
            long a = memory[index - 1] > 0 ? memory[index - 1] : calc(index - 1);
            long b = memory[index - 2] > 0 ? memory[index - 2] : calc(index - 2);
            answer = a + b;
        }

        memory[index] = answer;
        return answer;
    }

    void initMemory() {
        for (int i = 0; i < MAX + 1; i++) {
            memory[i] = 0;
        }
    }

    void showFibonacciNumber() {
        System.out.println(input + " th Fibonacci Number is " + answer + ".");
    }

    void showFibonacciNumbers() {
        System.out.println("0 to " + input + " th Fibonacci Numbers are");
        System.out.println(Arrays.toString(Arrays.copyOfRange(memory, 0, input + 1)));
    }

}
