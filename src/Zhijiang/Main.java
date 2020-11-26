package Zhijiang;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.print(horseRace(arr,n));

    }
    public static int horseRace(int[] arr, int n){
        int count = 0;
        for(int i = n-1; i >= 0&&n>=1; i--){
            if(arr[i]>n) {
                count++;
                n--;
            }else if(arr[i]<=n){
                n--;
                i++;
            }
        }
        return count;
    }

}
