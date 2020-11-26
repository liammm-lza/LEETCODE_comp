public class Youzan_2 {
    public static void main(String[] args) {
        System.out.print(numBSTs(3));
    }
    public static int numBSTs (int n) {
        if (n==0) return 1;
        if (n==1) return 1;
        if (n%2==0){
            int count=0;
            for(int i = 0; i < n/2; i++){
                count = 2*(numBSTs(i)*numBSTs(n-1-i))+count;
            }
            return count;
        }else{
            int count=0;
            for(int i = 0; i < (n-1)/2; i++){
                count = 2*(numBSTs(i)*numBSTs(n-1-i))+count;
            }
            count = count+numBSTs((n-1)/2)*numBSTs((n-1)/2);
            return count;
        }
    }
}
