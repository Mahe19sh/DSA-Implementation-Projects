import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        BinarySearchTree br = new BinarySearchTree(value);
        /* 
        BinaryTree br = new BinaryTree(value);
        
        br.Insertion(2);
        br.Insertion(3);
        br.Insertion(4);
        br.Insertion(5);
        br.Insertion(6);
        br.Insertion(9);
        br.Insertion(7);
        br.Insertion(10);
        */
        br.Insert(2);
        br.Insert(3);
        br.Insert(1);
        br.Insert(6);
        br.Insert(5);
        br.SearchBST(2);
        br.InorderRec();
        System.out.println();
        br.preOrderRec();
        System.out.println();
        br.postOrderRec();
        System.out.println();
        br.levelOrderTraversalRec();
        System.out.println();
        //br.deleteNodeRec(value);
        //System.out.println();
        //br.InorderRec();
        //System.out.println();
        br.findClosestValueBST(0);
    }
}
