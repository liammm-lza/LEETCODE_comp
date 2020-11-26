package Zhijiang2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str= sc.next();
        int[] arr = new int[n+1];
        int minus = 0;
        arr[0] = 1;
        for(int i = 0; i < n; i++){
            if(str.charAt(i)=='-') {
                arr[i+1] = arr[i]-1;
                if(arr[i+1]==0) {
                    for (int j = minus; j <= i+1; j++) {
                        arr[j]++;
                    }
                }
            }else if(str.charAt(i)=='+'){
                arr[i+1] = arr[i]+1;
                minus=i+1;
            }
        }
        int count = 0;
        for(int i = 0; i < n+1; i++){
            count +=arr[i];
        }
        System.out.println(count);
    }
}
