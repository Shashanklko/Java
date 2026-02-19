class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
    Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
public class maxElementTree {
    public static int Maxele(Node root){
        if(root==null){
           return Integer.MIN_VALUE;
        }

         int leftnode = Maxele(root.left);
        int rightnode = Maxele(root.right);
        return Math.max(root.data, Math.max(leftnode, rightnode));
    }
    
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(55);
        root.right.left = new Node(85);
        root.right.right = new Node(43);
        System.out.println(Maxele(root));
        }
    
}
