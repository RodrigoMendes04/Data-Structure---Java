import java.util.Arrays;

public class BigNumber {
    private int[] digits;  // Array para armazenar os dígitos do número

    // Construtor que inicializa o BigNumber a partir de uma String
    public BigNumber(String n) {
        // Remove zeros à esquerda
        int startIndex = 0;
        while (startIndex < n.length() - 1 && n.charAt(startIndex) == '0') {
            startIndex++;
        }
        
        int length = n.length() - startIndex;
        digits = new int[length];
        
        for (int i = 0; i < length; i++) {
            digits[i] = Character.getNumericValue(n.charAt(startIndex + i));
        }
    }

    // Método que verifica se dois BigNumbers são iguais
    public boolean equals(BigNumber n) {
        return Arrays.equals(this.digits, n.digits);
    }

    // Método para representar o BigNumber como uma String
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int digit : digits) {
            result.append(digit);
        }
        return result.toString();
    }

    // Método para adicionar dois BigNumbers
    public BigNumber add(BigNumber n) {
        int carry = 0;
        int maxLen = Math.max(this.digits.length, n.digits.length);
        int[] result = new int[maxLen + 1];
        
        for (int i = 0; i < maxLen; i++) {
            int num1 = (i < this.digits.length) ? this.digits[this.digits.length - 1 - i] : 0;
            int num2 = (i < n.digits.length) ? n.digits[n.digits.length - 1 - i] : 0;
            
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            result[maxLen - i] = sum % 10;
        }
        
        if (carry > 0) {
            result[0] = carry;
            return new BigNumber(Arrays.toString(result).replaceAll("[^0-9]", ""));
        } else {
            return new BigNumber(Arrays.toString(Arrays.copyOfRange(result, 1, result.length)).replaceAll("[^0-9]", ""));
        }
    }

    // Método para multiplicar dois BigNumbers
    public BigNumber multiply(BigNumber n) {
        int len1 = this.digits.length;
        int len2 = n.digits.length;
        int[] result = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int num1 = this.digits[i];

            for (int j = len2 - 1; j >= 0; j--) {
                int num2 = n.digits[j];
                int product = num1 * num2 + result[i + j + 1] + carry;

                carry = product / 10;
                result[i + j + 1] = product % 10;
            }

            result[i] += carry;
        }

        return new BigNumber(Arrays.toString(result).replaceAll("[^0-9]", ""));
    }
}