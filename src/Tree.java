import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

    Node root;

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.left.left = new Node(11);
        tree.root.left.right = new Node(5);

//        tree.preOrder(tree.root);
//        System.out.println();
//
//        tree.inOrder(tree.root);
//        System.out.println();
//
//        tree.postOrder(tree.root);
//        System.out.println();
//        tree.iterativePreorder();
//        System.out.println();
//        int height = tree.heightOfTree(tree.root);
//        System.out.println(height);
//        tree.printLevelOrder();
//        System.out.println();
//        tree.insert(tree.root,10);
//        tree.insert(tree.root,12);
//
//        tree.printLevelOrderUsingQueue(tree.root);
    }
    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print("=>"+" " + node.key);
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(Node node){
        if(node == null){
            System.out.println();
            return;
        }
        preOrder(node.left);
        System.out.print("=>"+" " + node.key);
        preOrder(node.right);
    }
    public void postOrder(Node node){
        if(node == null){
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.print("=>"+" " + node.key);
    }
public void iterativePreorder(){
        if(root ==null){
            return;
        }
    Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node mynode = stack.pop();

            System.out.print("=>"+"" + mynode.key);
            if(mynode.left != null){
                stack.push(mynode.left);
            }
            if(mynode.right != null){
                stack.push(mynode.right);
            }
        }
}
public int heightOfTree(Node node){
        if(node == null){
            return 0;
        }
        int lheight = heightOfTree(node.left);
        int rheight = heightOfTree(node.right);
        if(lheight>rheight){
            return lheight+1;
        }
        else{
            return rheight+1;
        }
}
public void levelOrderTraversal(Node node,int level){
        if(node == null){
            return;
        }
        if(level == 1){
            System.out.print("=>"+node.key);
        }
        if(level >1){
            levelOrderTraversal(node.left,level-1);
            levelOrderTraversal(node.right,level-1);
        }

}
public void printLevelOrder(){
        int level = heightOfTree(root);
        for(int i = 1; i<=level;i++){
            levelOrderTraversal(root,i);
        }
}
public void printLevelOrderUsingQueue(Node node){
        if(node == null){
            return;
        }
    Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print("=>"+temp.key);
            if(temp.left !=null){
                queue.add(temp.left);
            }
            if(temp.right !=null){
                queue.add(temp.right);
            }
        }
}
public void insert(Node node , int key){
        if(node == null){
            root = new Node(key);
        }
        Queue<Node> que = new LinkedList<>();
        que.add(node);

    while (!que.isEmpty()) {
        Node temp = que.poll();
        if(temp.left == null){
            temp.left = new Node(key);
            break;
        }
        else {
            que.add(temp.left);
        }
        if (temp.right == null) {

            temp.right = new Node(key);
            break;
        }
        else {
            que.add(temp.right);
        }
    }

}
public void delete (Node node , int key){
        if(node.key == key){
            root = node.left;
        }
}
}
class Node{
    Node left,right;
    int key;
    public Node(int key){
        this.key = key;
        left = right = null;
    }
}
