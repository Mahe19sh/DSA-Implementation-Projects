class SingleLinkedList{
    private SingleNode head;
    private SingleNode tail;
    private int size;
    public SingleNode createSingleLinkedList(int value){
        head = new SingleNode();
        SingleNode node = new SingleNode();
        node.setValue(value);
        node.setNext(null);
        head = node;
        tail = node;
        size = 1;
        return head;
    }
    public void Insertion(int value, int location){
        SingleNode node = new SingleNode();
        node.setValue(value);
        if(!existsLinkedList()){
           System.out.println("Linked List does not exist"); 
        }
        else if(location == 0){ // insert at first position
            node.setNext(head);
            head = node;
            size++;
        }
        else if(location >= size){ // insert at last position
            node.setNext(null);
            tail.setNext(node);
            tail = node;
            size++;
        }
        else{
            SingleNode Tempnode = head;
            int index = 1;
            while(index < location-1){
                Tempnode = Tempnode.getNext();
                index++;
            }
            SingleNode nodeNext = Tempnode.getNext();
            node.setNext(nodeNext);
            Tempnode.setNext(node);
            size++;
        }
    }
    public boolean existsLinkedList(){
       return head != null;
    }
    public void Traversal(){
        if(existsLinkedList()){
            SingleNode tempnode = head;
            while(tempnode.getNext() != null){
                System.out.print(tempnode.getValue()+"->");
                tempnode = tempnode.getNext();
            }
            if(tempnode.getNext() == null){
                System.out.print("->"+tempnode.getValue());
            }
        }
        else{
            System.out.println("Linked list does not exists");
        }
    }
    public void Searching(int value){
        if(existsLinkedList()){
            SingleNode current = head;
            while(current.getNext() != null){
                if(current.getValue() == value){
                    System.out.println("Value Found");
                }
            }
            if(current.getNext() == null && current.getValue() == value){
                System.out.println("Value found");
            } 
        }
        else{
            System.out.println("Value not found");
        }
    }
    public void Deletion(int location){
        SingleNode del = head;
        if(!existsLinkedList()){
            System.out.println("Linked List does not exists!");
        }
        if(location == 0){
            if(head.getNext() == null && tail.getNext() == null){
                head = tail = null;
            }
            else{
                head = head.getNext();
            }
        }
        else if(location >= size){
            if(head.getNext() == null && tail.getNext() == null){
                head = tail = null;
            }
            else{
                while(del.getNext() != tail){
                    del = del.getNext();
                }
                del.setNext(null);
                tail = del;
            }
        }
        else{
            int index = 1;
            while(index < location-1){
                del = del.getNext();
                index++;
            }
            del.setNext(del.getNext().getNext());
        }
    }
    public void Delete(){
        head = tail = null;
    }
}
