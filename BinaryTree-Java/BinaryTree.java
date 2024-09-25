import java.util.*;
class BinaryTree{
    BinaryNode root;
    int height = 1;
    public BinaryTree(){
        this.root = null;
    }
    public BinaryTree(int value){
       root = new BinaryNode(value);
    }
    public void Insertion(int data){
        root = InsertRec(root, data);
    }
    public BinaryNode InsertRec(BinaryNode root, int data){
        if(root == null){
            root = new BinaryNode(data);
            return root;
        }
        if(root.getValue() < data){
            root.setLeft(InsertRec(root.getLeft(), data));
        }
        else if(root.getValue() > data){
            root.setRight(InsertRec(root.getRight(), data));
        }
        return root;
    }
    public void inorder(){
        inorderRec(root);
    }
    public void inorderRec(BinaryNode root){
        if(root != null){
            inorderRec(root.getLeft());
            System.out.print(root.getValue()+"->");
            inorderRec(root.getRight());
        }
    }
    public void preOrder(BinaryNode root){
        if(root != null){
            System.out.println(root.getValue()+"->");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
    public void postOrder(BinaryNode root){
        if(root != null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getValue()+"->");
        }
    }
    public boolean Search(int key){
        return searchRec(root, key);
    }
    public boolean searchRec(BinaryNode root, int key){
        if(root == null){
            return false;
        }
        if(root.getValue() == key){
            return true;
        }
        if(key < root.getValue()){
            return searchRec(root.getLeft(), key);
        }
        else{
            return searchRec(root.getRight(), key);
        }
    }
    public int findMin(){
        return FindMinimum(root);
    }
    public int FindMinimum(BinaryNode root){
        if(root == null){
            throw new IllegalStateException("Tree is Empty");
        }
        if(root.getLeft() == null){
            return root.getValue();
        }
        return FindMinimum(root.getLeft());
    }
    public int findMax(){
        return findMaxRec(root);
    }
    public int findMaxRec(BinaryNode root){
        if(root == null){
            throw new IllegalStateException("Tree is Empty");
        }
        if(root.getRight() == null){
            return root.getValue();
        }
        return findMaxRec(root.getRight());
    }
    public void BalancedOrNot(BinaryNode root){
        if(heightcheck(root) == 1 || heightcheck(root) == 0){
            System.out.println("Given Binary Tree is balanced");
        }
        else{
            System.err.println("Given Binary Tree is not balanced");
        }
    }
    public int heightcheck(BinaryNode root){
        if(root == null){
            return 0;
        }
        int leftheight = heightcheck(root.getLeft());
        if(leftheight == -1){
            return -1;
        }
        int rightheight = heightcheck(root.getRight());
        if(rightheight == -1){
            return -1;
        }
        if(Math.abs(leftheight-rightheight) > 1){
            return -1;
        }
        return 1 + Math.max(leftheight, rightheight);

    }
    public void Depth(BinaryNode root){
        System.out.println("Depth of tree" + DepthofBinaryTree(root));
    }
    public int DepthofBinaryTree(BinaryNode root){
        if(root == null){
            return 0;
        }
        int leftheight = DepthofBinaryTree(root.getLeft());
        int rightheight = DepthofBinaryTree(root.getRight());
        if(leftheight > rightheight){
            return leftheight+1;
        }
        else{
            return rightheight+1;
        }
    }
    public void LevelOrderTraversal(BinaryNode root){
        Queue<BinaryNode> q = new LinkedList<BinaryNode>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryNode temp = q.poll();
            System.out.println(temp.getValue()+"->");
            if(temp.getLeft() != null){
                q.add(temp.getLeft());
            }
            if(temp.getRight() != null){
                q.add(temp.getRight());
            }
        }
    }
    public void LevelOrderTraversalSpiral(BinaryNode root){
        Stack<BinaryNode> s1 = new Stack<>();
        Stack<BinaryNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                BinaryNode temp = s1.peek();
                s1.pop();
                System.out.println(temp.getValue()+"->");
                if(temp.getRight() != null){
                    s2.push(temp.getRight());
                }
                if(temp.getLeft() != null){
                    s2.push(temp.getLeft());
                }
            }
            while(!s2.isEmpty()){
                BinaryNode temp = s2.peek();
                s2.pop();
                System.out.println(temp.getValue()+"->");
                if(temp.getLeft() != null){
                    s1.push(temp.getLeft());
                }
                if(temp.getRight() != null){
                    s1.push(temp.getRight());
                }
            }
        }
    }
    public void MorrisTraversal(BinaryNode root){
        
    }

}