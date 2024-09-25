class BinaryNode{
    private BinaryNode left;
    private BinaryNode right;
    private int value;
    BinaryNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
    public void setLeft(BinaryNode left){
        this.left = left;
    }
    public BinaryNode getLeft(){
        return this.left;
    }
    public void setRight(BinaryNode right){
        this.right = right;
    }
    public BinaryNode getRight(){
        return this.right;
    }
}