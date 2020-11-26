import java.util.*;
public class FriendZone {
    public static void main(String[] args) {
        int[][] friend = new int[][]{
                {1,0,1,1,0},
                {0,1,0,0,0},
                {1,0,1,0,0},
                {1,0,0,1,0},
                {0,0,0,0,1}};
        System.out.print(findFriend(friend));
    }

    public static int findFriend(int[][] friend){
        int count =0;
        for(int m = 0; m<5;m++){
            for(int n=m;n<=m;n++){
                if(friend[m][n]==1) {
                    findPath(friend, m, n);
                    count++;
                }
            }
        }
        return count;
    }
    public static void findPath(int[][]num,int x, int y){
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
