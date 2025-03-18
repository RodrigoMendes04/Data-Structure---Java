import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SopaDeLetras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = 0;
        List<String> results = new ArrayList<>();

        while (true) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            if (rows == 0 && cols == 0) {
                break;
            }

            char[][] puzzle = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                String line = scanner.next();
                for (int j = 0; j < cols; j++) {
                    puzzle[i][j] = line.charAt(j);
                }
            }

            int numWords = scanner.nextInt();
            String[] words = new String[numWords];

            for (int i = 0; i < numWords; i++) {
                words[i] = scanner.next();
            }

            String result = solvePuzzle(puzzle, words);
            results.add("Input #" + (++testCase) + "\n" + result);
        }

        for (String result : results) {
            System.out.print(result);
        }
    }

    public static String solvePuzzle(char[][] puzzle, String[] words) {
        char[][] result = new char[puzzle.length][puzzle[0].length];

        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                result[i][j] = '.';
            }
        }

        for (String word : words) {
            // Procurar na horizontal da esquerda para a direita
            for (int i = 0; i < puzzle.length; i++) {
                for (int j = 0; j <= puzzle[i].length - word.length(); j++) {
                    if (matchHorizontalRight(puzzle, word, i, j)) {
                        fillHorizontalRight(result, word, i, j);
                    }
                }
            }

            // Procurar na horizontal da direita para a esquerda
            for (int i = 0; i < puzzle.length; i++) {
                for (int j = word.length() - 1; j < puzzle[i].length; j++) {
                    if (matchHorizontalLeft(puzzle, word, i, j)) {
                        fillHorizontalLeft(result, word, i, j);
                    }
                }
            }

            // Procurar na vertical de cima para baixo
            for (int i = 0; i <= puzzle.length - word.length(); i++) {
                for (int j = 0; j < puzzle[i].length; j++) {
                    if (matchVerticalDown(puzzle, word, i, j)) {
                        fillVerticalDown(result, word, i, j);
                    }
                }
            }

            // Procurar na vertical de baixo para cima
            for (int i = puzzle.length - 1; i >= word.length() - 1; i--) {
                for (int j = 0; j < puzzle[i].length; j++) {
                    if (matchVerticalUp(puzzle, word, i, j)) {
                        fillVerticalUp(result, word, i, j);
                    }
                }
            }
        }

        return formatResult(result);
    }

    public static boolean matchHorizontalRight(char[][] puzzle, String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            if (puzzle[row][col + i] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void fillHorizontalRight(char[][] result, String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            result[row][col + i] = word.charAt(i);
        }
    }

    public static boolean matchHorizontalLeft(char[][] puzzle, String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            if (puzzle[row][col - i] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void fillHorizontalLeft(char[][] result, String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            result[row][col - i] = word.charAt(i);
        }
    }

    public static boolean matchVerticalDown(char[][] puzzle, String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            if (puzzle[row + i][col] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void fillVerticalDown(char[][] result, String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            result[row + i][col] = word.charAt(i);
        }
    }

    public static boolean matchVerticalUp(char[][] puzzle, String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            if (puzzle[row - i][col] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void fillVerticalUp(char[][] result, String word, int row, int col) {
        for (int i = 0; i < word.length(); i++) {
            result[row - i][col] = word.charAt(i);
        }
    }

    public static String formatResult(char[][] result) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                builder.append(result[i][j]);
            }
            builder.append('\n');
        }

        return builder.toString();
    }
}