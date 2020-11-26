package huaqi;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }
    public static String solution(int N) {
        if (N==1) return "z";
        char ch = 'a';
        StringBuilder sb = new StringBuilder();
        sb.append(ch);
        int index = 1;
        while(sb.length()<N){
            if(sb.length()*2>N) break;
            index *=2;
            sb=sb.append(sb);
        }
        if(N%2!=0&&index<N){
            for(int i = 0; i < N-index; i++){
                sb.append(ch);
            }
        }else if(N%2==0&&index<N) {
            for(int i = 0; i < N-index-1; i++){
                sb.append(ch);
            }
            sb.append('b');
        }else if(index==N){
            sb.deleteCharAt(0);
            sb.append('e');
        }
        return sb.toString();
    }
}
