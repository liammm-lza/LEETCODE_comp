import java.util.*;
public class DIDI_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<Integer> array = new ArrayList<>();

        for(int i = 0; i < T ; i++){
            int n = sc.nextInt();
            int[][] island = new int[n][n];
            int m = sc.nextInt();
            int k = sc.nextInt();
            for(int j = 0; j < m ; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int cost = sc.nextInt();
                island[b-1][a-1] = cost;

            }

            if(connected(island,k)){
                array.add(1);
            }else{
                array.add(0);
            }
        }
            for(int i: array) {
                if(i==1){
                    System.out.println("Yes");
                }
                else if(i==0){
                    System.out.println("No");
                }

            }
        }
        public static boolean connected(int[][] island,int cost){
            int count = 0;
            for(int i = 0; i<island.length;i++){
                for(int j = 0; j<i;j++){
                    if(island[i][j]>0&&island[i][j]<=cost){
                        findPath(island,i,j);
                        count++;
                    }
                }
            }
            if(count!=1) return false;
            return true;
        }
    public static void findPath(int[][] num,int x,int y) {
        if (x < 0 || x >= num.length || y < 0 || y >= num[0].length) {
            return;
        }
        num[x][y] = 0;
        //往下找
        for (int i = x; i < num.length; i++) {
            if (num[i][y] != 0) findPath(num, i, y);
        }
        //往上找
        for (int i = x; i >= 0; i--) {
            if (num[i][y] != 0) findPath(num, i, y);
        }
        //往右找
        for (int i = y; i < num[0].length; i++) {
            if (num[x][i] != 0) findPath(num, x, i);
        }
        //往左找
        for (int i = y; i >= 0; i--) {
            if (num[x][i] != 0) findPath(num, x, i);
        }

    }

}
