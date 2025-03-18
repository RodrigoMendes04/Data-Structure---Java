import java.util.Scanner;

public class ED198{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int v[] = new int [n];
        int best[] = new int[n];
        for(int i=0;i<n;i++){
            v[i] = in.nextInt();
        }
        best[0]=v[0];
        int maxSoFar=v[0];
        for (int i=0; i<n-1; i++){
            if (best[i]>=0){
                best[i+1]=best[i]+v[i+1];
            }else{
                best[i+1]=v[i+1];
            }
            if(best[i]>maxSoFar){
                maxSoFar = best[i];
            }
        }
    System.out.println(maxSoFar);
    }
}