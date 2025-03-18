public class ED194{
    public static void reverse(MyStack<Integer> s, int n){
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.pop(); // adiciona os elementos da pilha até à posicão n
        }
        for(int i=0;i<n;i++){
            s.push(a[i]); // retira os elementos da pilha até à primeira posição
        }
    }
}