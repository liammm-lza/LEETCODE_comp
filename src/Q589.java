import java.util.*;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */

public class Q589 {
    public List<Integer> preorder(Node root) {
        if(root==null) return new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        List<Integer> out = new ArrayList<>();
        //将子节点加入栈中，栈中第一个元素若有子节点，pop栈顶，将子节点加入栈
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            out.add(temp.val);
            List<Node> reverseChildern = new ArrayList<>();
            for (Node n: temp.children) {
                reverseChildern.add(n);
            }
            Collections.reverse(reverseChildern);
            for(Node n:reverseChildern){
                stack.add(n);
            }
        }
        return out;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

