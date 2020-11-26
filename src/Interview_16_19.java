public class Interview_16_19 {
    public static void main(String[] args) {
        int[][] nums = {{1,0,0,0},
                        {2,3,0,0},
                        {0,3,0,1},
                        {0,3,0,1}};
        pool(nums);
    }
    public static void pool(int num[][]){
        int count = 0;
        for(int i=0;i<num.length;i++){
            for(int j=0;j<num[1].length;j++){
                //如果是0开始搜索
                if(num[i][j]==0) {
                    count=findPool(num,i,j);
                    System.out.print(count+" ");
                }
            }
        }

    }
    public static int findPool(int[][] land, int x, int y){
        int num = 0;
        //如果邻居是0，搜索邻居，count++
        if(x<0||x>=land.length||y<0||y>=land[0].length||land[x][y]!=0){
            return 0;
        }
        num++;
        land[x][y]=-1;
        num += findPool(land, x + 1, y);
        num += findPool(land, x - 1, y);
        num += findPool(land, x, y + 1);
        num += findPool(land, x, y - 1);
        num += findPool(land, x + 1, y + 1);
        num += findPool(land, x + 1, y - 1);
        num += findPool(land, x - 1, y + 1);
        num += findPool(land, x - 1, y - 1);
        return num;
    }

}
