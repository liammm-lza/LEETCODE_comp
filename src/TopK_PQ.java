import java.util.*;
public class TopK_PQ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i <10;i++){
            pq.add(scanner.nextInt());
            if(pq.size()>3){
                pq.poll();
            }
        }
        while(pq.size()>0){
            stack.add(pq.poll());
        }
        for(int i =0;i<3;i++){
            System.out.print(stack.pop()+" ");
        }

    }
}
