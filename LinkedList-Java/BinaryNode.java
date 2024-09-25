class BinaryNode{
    private int value;
    private BinaryNode next;
    private BinaryNode prev;
    public BinaryNode(int value){
        this.value = value;
        this.prev = null;
        this.next = null;
    }
    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
    public void setPrev(BinaryNode prev){
        this.prev = prev;
    }
    public BinaryNode getPrev(){
        return this.prev;
    }
    public void setNext(BinaryNode next){
        this.next = next;
    }
    public BinaryNode getNext(){
        return this.next;
    }
}