class DoubleLinkedList{
    private BinaryNode head;
    private BinaryNode tail;
    private int size;
    public DoubleLinkedList(int value){
        BinaryNode node = new BinaryNode(value);
        head = node;
        tail = node;
        size = 1;
    }
    public int getSize(){
        return this.size;
    }
    public void Insertion(int pos, int value){
        if(!existsLinkedList()){
            System.out.println("Linked List does not exist");
        }
        BinaryNode node = new BinaryNode(value);
        if(pos == 0 || pos == 1){
            node.setNext(head);
            head.setPrev(node);
            head = node;
            size++;
        }
        else if(pos > size){
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
            size++;
        }
        else{
            int index = 1;
            BinaryNode curr = head;
            while(index < pos - 1){
                curr = curr.getNext();
                index++;
            }
            node.setPrev(curr);
            node.setNext(curr.getNext());
            curr.getNext().setPrev(node);
            curr.setNext(node);
            size++;
        }
    }
    public boolean existsLinkedList(){
        return head != null && tail != null;
    }
    public void Traversalfwd(){
        if(existsLinkedList()){
            BinaryNode curr = head;
            while(curr.getNext() != null){
                System.out.print(curr.getValue()+"->");
                curr = curr.getNext();
            }
            System.out.print(curr.getValue());
	    System.out.println();
        }
        else{
            System.out.println("List does not exist");
	    
        }
    }
    public void Traversalbwd(){
        if(existsLinkedList()){
            BinaryNode curr = tail;
            while(curr.getPrev() != null){
                System.out.print(curr.getValue()+"<-");
                curr = curr.getPrev();
            }
            System.out.print(curr.getValue());
            System.out.println();

        }
        else{
            System.out.println("List does not exist");
   
	}
    }
    public void Search(int value){
        if(!existsLinkedList()){
            System.out.println("List does not exists, Value not found");
        }
        else{
            BinaryNode curr = head;
            while(curr.getNext() != null){
                if(curr.getValue() == value){
                    System.out.println("Value Found");
                }
                curr = curr.getNext();
            }
            if(curr.getValue() == value){
                System.out.println("Value found");
            }
        }
    }
    public void Deletion(int pos){
        if(!existsLinkedList()){
            System.out.println("List does not exists");
        }
        else{
            BinaryNode curr = head;
            if(pos == 0 || pos == 1){
                head = head.getNext();
                head.setPrev(null);
                size--;
            }
            else if(pos >= size){
                tail = tail.getPrev();
                tail.setNext(null);
            }
            else{
                int index = 1;
                while(index < pos-1){
                    curr = curr.getNext();
                    index++;
                }
                curr.setNext(curr.getNext().getNext());
                curr.getNext().getNext().setPrev(curr);
            }
        }
    }
    public void DeleteWhole(){
        head = tail = null;
    }

}