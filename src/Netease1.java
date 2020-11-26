import java.util.Scanner;

public class Netease1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][][] squ = new int[time][n][m];
        for(int i =0;i<time;i++){
            for (int j = 0; j<n; j++){
                String s = sc.nextLine();
                for(int k =0;k<s.length();k++){
                    squ[i][j][k] = s.charAt(k);
                }
            }

        }
        for(int i =0;i<time;i++){
            int largestSize = 0;
            int a= -1, b = -1,c = -1, d = -1;
            for(int x =0;x+2<m;x++){
                for(int y =0;y+2<n;y++){
                    for (int p = 0; p +2 <min(m,n);p++) {
                        int len = p+3;
                        int[][] currentSquare = new int[len][len];
                        for (int q = 0; q<len;q++) {
                            for (int w = 0;w < len; w++) {
                                currentSquare[q][w] = squ[i][q][w];
                                if (hasSquare(currentSquare,len)){
                                    if(len>largestSize){
                                        largestSize = len;
                                        a = x;
                                        b = y;
                                        c = x+len-1;
                                        d = y+len-1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(a+","+b+","+c+","+d);
        }
    }
    public static int min(int m,int n){
        if (m<n) return m;
        else return n;
    }
    public static boolean hasSquare(int square[][],int len){
        int index_0 = len/3;
        int index_1 = index_0*3;
        for(int x =0;x+index_1<=len;x++){
            for(int y =0;y+index_1<=len;y++){
                int[][] currentSquare = new int[index_1][index_1];
                for(int p =0;p<index_1;p++) {
                    for (int q = 0; q < index_1; q++) {
                        currentSquare[p][q] = square[x][y];
                    }
                }
                if (hasCross(currentSquare,index_1)) return true;
            }
        }
        return false;
    }
    public static boolean hasCross(int square[][],int len){
        int index_0 = len/3;

        for(int i =0; i <index_0;i++){
            for(int j =0; j <index_0;j++){
                if (square[i][j] ==1) return false;
                if (square[i][len-1-i] ==1) return false;
                if (square[len-1-i][j] ==1) return false;
                if (square[len-1-i][len-1-i] ==1) return false;
                if (square[index_0+i][j]==0)return false;
                if (square[i][index_0+j]==0)return false;
                if (square[index_0+i][index_0+j]==0)return false;
            }
        }
        return true;
    }
}
