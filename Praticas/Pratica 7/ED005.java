import java.util.Scanner;
import java.util.Stack;

public class ED005 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine()); // Número de expressões a analisar
        for (int i = 0; i < N; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String result = evaluateRPN(tokens);
            System.out.println(result);
        }

        scanner.close();
    }

    private static String evaluateRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    return "Expressao Incorrecta";
                }
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                return "Expressao Incorrecta";
            }
        }

        // Após processar todos os tokens, deve haver exatamente um elemento na pilha
        if (stack.size() != 1) {
            return "Expressao Incorrecta";
        }

        return String.valueOf(stack.pop());
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                // Garantia de divisão inteira por enunciado
                return a / b;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operator);
        }
    }
}
