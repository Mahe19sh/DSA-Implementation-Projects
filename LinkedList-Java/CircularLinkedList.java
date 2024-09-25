class CircularLinkedList{
    private SingleNode head;
    private SingleNode tail;
    int size;
    public CircularLinkedList(int value){
        head = new SingleNode();
        SingleNode node = new SingleNode();
        node.setValue(value);
        node.setNext(node);
        head = node;
        tail = node;
        size = 1;
    }
    public void Insertion(int pos, int value){
        if(!existsLinkedList()){
            System.out.println("Error! Linked list does not exist");
        }
        SingleNode node = new SingleNode();
        node.setValue(value);
        if(pos == 0 || pos == 1){
            node.setNext(head);
            head = node;
            tail.setNext(node);
            size++;
        }
        else if(pos >= size){
            node.setNext(tail.getNext());
            tail.setNext(node);
            tail = node;
            size++;
        }
        else{
            SingleNode Tempnode = head;
            int index = 1;
            while(index < pos-1){
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
            SingleNode current = head;
            while(current.getNext() != head){
                System.out.print(current.getValue()+"->");
                current = current.getNext();
            }
            System.out.println(current.getValue());
        }
        else{
            System.out.println("List Does not exist ");
        }
    }
    public void Search(int value){
        if(existsLinkedList()){
            SingleNode current = head;
            while(current.getNext() != head){
                if(current.getValue() == value){
                    System.out.println(current.getValue()+" Value Found");
                }
                current = current.getNext();
            }
            if(current.getValue() == value){
                System.out.println(current.getValue()+" Value Found");
            }
        }
        else{
            System.out.println("Value not found");
        }
    }
    public void Deletion(int pos){
        if(!existsLinkedList()){
            System.out.println("List not exists");
        }
        else{
            SingleNode temp = head;
            if(pos == 1 || pos == 0){
                if(head.getNext() == head){
                    head.getNext().setNext(null);
                    head = tail = null;
                }
                else{
                    head = head.getNext();
                    tail.setNext(head);
                }
            }
            else if(pos >= size){
                if(head.getNext() == head){
                    head.getNext().setNext(null);
                    head = tail = null;
                }
                else{
                    while(temp.getNext() != tail){
                        temp = temp.getNext();
                    }
                    temp.setNext(tail.getNext());
                    tail = temp;
                }
            }
            else{
                int index = 1;
                while(index < pos-1){
                    temp = temp.getNext();
                    index++;
                }
                temp.setNext(temp.getNext().getNext());
            }
        }
    }
    public void DeleteWhole(){
        head = tail = null;
    }
}