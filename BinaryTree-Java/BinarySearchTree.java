import java.util.*;

class BinarySearchTree{
    BinaryNode root;

    public BinarySearchTree(int value){
        root = new BinaryNode(value);
        System.out.println(root.getValue());
    }

    public void SearchBST(int value){
        Search(root, value);
    }

    public void Search(BinaryNode Node, int val){
        if(Node == null){
            return;
        }
        else if(Node.getValue() == val){
            System.out.println("Value found"+" "+Node.getValue());
        }
        else if(val < Node.getValue()){
            Search(Node.getLeft(), val);
        }
        else if(val > Node.getValue()){
            Search(Node.getRight(), val);
        }
    }

    public void Insert(int value){
        InsertBST(root, value);
    }

    public BinaryNode InsertBST(BinaryNode currNode, int value){
        if(currNode == null){
            BinaryNode Node = new BinaryNode(value);
            return Node;
        }
        else if(value <= currNode.getValue()){
            currNode.setLeft(InsertBST(currNode.getLeft(), value));   
        }
        else{
            currNode.setRight(InsertBST(currNode.getRight(), value));
        }
        return currNode;
    }

    public void InorderRec(){
        BinaryNode Node = root;
        InorderTraversal(Node);
    }

    public void InorderTraversal(BinaryNode root){
        if(root == null){
            return;
        }
        else{
            InorderTraversal(root.getLeft());
            System.out.println(root.getValue());
            InorderTraversal(root.getRight());
        }
    }

    public void preOrderRec(){
        preOrderBST(root);
    }

    public void preOrderBST(BinaryNode Node){
        if(Node == null){
            return;
        }
        else{
            preOrderBST(Node.getLeft());
            preOrderBST(Node.getRight());
            System.out.println(Node.getValue());
        }
    }

    public void postOrderRec(){
        postOrderBST(root);
    }

    public void postOrderBST(BinaryNode Node){
        if(Node == null){
            return;
        }
        else{
            System.out.println(Node.getValue());
            postOrderBST(Node.getLeft());
            postOrderBST(Node.getRight());
        }
    }

    public void levelOrderTraversalRec(){
        levelOrderTraversalBST(root);
    }

    public void levelOrderTraversalBST(BinaryNode Node){
        Queue<BinaryNode> Q = new LinkedList<BinaryNode>();
        Q.add(root);
        while(!Q.isEmpty()){
            BinaryNode temp = Q.poll();
            System.out.print(temp.getValue() +" ");
            if(temp.getLeft() != null){
                Q.add(temp.getLeft());
            }
            if(temp.getRight() != null){
                Q.add(temp.getRight());
            }
        }
    }

    public void deleteNodeRec(int value){
        deleteNodeBST(root, value);
    }

    public void deleteNodeBST(BinaryNode Node, int value){
        if(Node == null){
            return;
        }
        else if(value < Node.getValue()){
            deleteNodeBST(Node.getLeft(), value);
        }
        else if(value > Node.getValue()){
            deleteNodeBST(Node.getRight(), value);
        }
        else{
            if(Node.getLeft() != null && Node.getRight() != null){
                BinaryNode temp  = findMin(Node.getRight());
                Node.setValue(temp.getValue());
                temp = null;
            }
            else if(Node.getLeft() != null && Node.getRight() == null){
                Node = Node.getLeft();
            }
            else if(Node.getLeft() == null && Node.getRight() != null){
                Node = Node.getRight();
            }
            else{
                Node = null;
            }
        }
    }

    public BinaryNode findMin(BinaryNode Node){
        if(Node == null){
            throw new IllegalStateException("Tree is empty");
        }
        if(Node.getLeft() == null){
            return Node;
        }
        else{
            return findMin(Node.getLeft());
        }
    }

    public void findClosestValueBST(int target){
        int closest = root.getValue();
        int finalclosest = findClosestValueBSTHelper(root, target, closest);
        System.out.println("The closest Node to the given target is: "+finalclosest);
    }

    public int findClosestValueBSTHelper(BinaryNode Node, int target, int closest){
        if (Node == null)
            return closest;
        if(Math.abs(target - closest) > Math.abs(target - Node.getValue())){
            closest = Node.getValue();
        }
        if(target > Node.getValue()){
            return findClosestValueBSTHelper(Node.getRight(), target, closest);
        }
        else if(target < Node.getValue()){
            return findClosestValueBSTHelper(Node.getLeft(), target, closest);
        }
        else{
            return closest;
        }
    }
    
}