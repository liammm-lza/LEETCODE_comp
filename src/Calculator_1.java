/* + - * /四则运算
* 1. 如果碰到数字， 则把数字入栈
2. 如果碰到空格， 则继续下一步
3. 如果碰到 '+' '-' '*' '/', 则查找下一个数字num
    A.如果是'+', 下一个数字num直接入栈
    B.如果是'-'，-num入栈
    C.如果是'*', num = stack.pop() * num, 入栈
    D.如果是'/', num = stack.pop() / num, 入栈
4. 最后，把栈里的数相加就是结果*/
import java.util.*;
public class Calculator_1 {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] cs = s.toCharArray();
        int ans = 0, i = 0;
        int sum = 0;
        while(i < cs.length){
            if(cs[i] == ' ') {i++;continue;}
            char tmp = cs[i];
            if(tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-'){
                i++;
                while(i < cs.length && cs[i] == ' ') i++;
            }
            int num = 0;
            while(i < cs.length && Character.isDigit(cs[i])){
                num = num * 10 + cs[i] - '0';
                i++;
            }
            switch(tmp){
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = st.pop() * num;
                    break;
                case '/':
                    num = st.pop() / num;
                    break;
                default:
                    break;
            }
            st.push(num);
        }
        while(!st.isEmpty()) ans += st.pop();
        System.out.print(ans);


    }

}
