import java.util.*;


class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}
class Pair{
    Node node;
    int hd;   // horizontal distance

    Pair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

public class view {

    public static void left_rightView(Node root) {
        if (root == null) return;

        List<Integer> leftView = new ArrayList<>();
        List<Integer> rightView = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node temp = q.poll();

                // Left View (first element of level)
                if (i == 0) {
                    leftView.add(temp.data);
                }

                // Right View (last element of level)
                if (i == size - 1) {
                    rightView.add(temp.data);
                }

                if (temp.left != null) {
                    q.offer(temp.left);
                }

                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
        }

        System.out.println("Left View: " + leftView);
        System.out.println("Right View: " + rightView);
    }

    public static void allViews(Node root){
        if(root == null) return;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        List<Integer> leftView = new ArrayList<>();
        List<Integer> rightView = new ArrayList<>();

        TreeMap<Integer, Integer> topView = new TreeMap<>();
        TreeMap<Integer, Integer> bottomView = new TreeMap<>();

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Pair temp = queue.poll();
                Node current = temp.node;
                int hd = temp.hd;

                // LEFT VIEW
                if(i == 0){
                    leftView.add(current.data);
                }

                // RIGHT VIEW
                if(i == size - 1){
                    rightView.add(current.data);
                }

                // TOP VIEW (first occurrence of hd)
                if(!topView.containsKey(hd)){
                    topView.put(hd, current.data);
                }

                // BOTTOM VIEW (always update)
                bottomView.put(hd, current.data);

                if(current.left != null){
                    queue.add(new Pair(current.left, hd - 1));
                }

                if(current.right != null){
                    queue.add(new Pair(current.right, hd + 1));
                }
            }
        }

        System.out.println("Left View: " + leftView);
        System.out.println("Right View: " + rightView);
        System.out.println("Top View: " + topView.values());
        System.out.println("Bottom View: " + bottomView.values());
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(55);
        root.right.left = new Node(85);
        root.right.right = new Node(43);

        left_rightView(root);
        System.out.println("------------------------------------------");
        allViews(root);
    }
}