public class ED197 {
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
        MyQueue<Integer> m = new LinkedListQueue<Integer>();

        int temp1 = a.dequeue();
        int temp2 = b.dequeue();

        boolean flag1 = true, flag2 = true;

        // Loop enquanto ambas as filas não estiverem vazias
        while (a.size() != 0 || b.size() != 0) {
            // Verifica se há elementos em 'a' e 'flag1' é false
            if ((a.size() != 0) && (flag1 == false)) {
                temp1 = a.dequeue();
                flag1 = true;
            }

            // Verifica se há elementos em 'b' e 'flag2' é false
            if ((b.size() != 0) && (flag2 == false)) {
                temp2 = b.dequeue();
                flag2 = true;
            }

            // Compara os elementos temporários e enfileira o menor em 'm'
            if (temp1 <= temp2 && flag1 == true) {
                m.enqueue(temp1);
                flag1 = false;
            } else if (temp2 < temp1 && flag2 == true) {
                m.enqueue(temp2);
                flag2 = false;
            } else if (flag2 == false) {
                m.enqueue(temp1);
                flag1 = false;
            } else if (flag1 == false) {
                m.enqueue(temp2);
                flag2 = false;
            }
        }

        // Enfileira os elementos restantes, se houver
        if (flag1 == true) {
            m.enqueue(temp1);
            flag1 = false;
        }
        if (flag2 == true) {
            m.enqueue(temp2);
            flag2 = false;
        }

        return m;
    }
}
