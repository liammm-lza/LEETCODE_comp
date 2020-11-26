public class Q547 {
    public static void main(String[] args) {
        int[][] num = {{1,0,0,1},
                       {0,1,1,0},
                       {0,1,1,1},
                       {1,0,1,1}};
        System.out.print(findCircleNum(num));
    }
    public static int findCircleNum(int[][] num) {
        int count = 0;
        for(int i = 0;i<num.length;i++){
            for(int j = 0; j<num[0].length;j++){
                if(num[i][j]!=0){
                    findCircle(num,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void findCircle(int[][] num, int x, int y){

        if(x<0||x>=num.length||y<0||y>=num[0].length){
            return;
        }
        num[x][y]=0;
        //往下找
        for(int i = x;i<num.length;i++){
            if(num[i][y]!=0) findCircle(num,i,y);
        }
        //往上找
        for(int i = x;i>=0;i--){
            if(num[i][y]!=0) findCircle(num,i,y);
        }
        //往右找
        for(int i = y;i<num[0].length;i++){
            if(num[x][i]!=0) findCircle(num,x,i);
        }
        //往左找
        for(int i = y;i>=0;i--){
            if(num[x][i]!=0) findCircle(num,x,i);
        }

    }

}
