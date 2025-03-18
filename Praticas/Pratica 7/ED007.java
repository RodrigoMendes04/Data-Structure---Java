import java.util.Scanner;
import java.util.Stack;

public class ED007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine()); // Número de expressões a analisar
        for (int i = 0; i < N; i++) {
            String expression = scanner.nextLine();
            String result = checkParentheses(expression);
            System.out.println(result);
        }

        scanner.close();
    }

    private static String checkParentheses(String expression) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> positions = new Stack<>(); // Guarda posições dos parênteses
        char[] chars = expression.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];

            // Verifica apenas os parênteses
            if (current == '(' || current == '[') {
                stack.push(current);
                positions.push(i);
            } else if (current == ')' || current == ']') {
                if (stack.isEmpty()) {
                    return "Erro na posicao " + i; // Não há parêntese de abertura correspondente
                }

                char top = stack.pop();
                positions.pop();
                if (!isMatchingPair(top, current)) {
                    return "Erro na posicao " + i; // Parênteses não correspondem
                }
            }
        }

        // Após processar a expressão, verifica se ficaram parênteses por fechar
        if (!stack.isEmpty()) {
            return "Ficam parenteses por fechar";
        }

        return "Expressao bem formada";
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']');
    }
}
