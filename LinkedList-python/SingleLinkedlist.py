class Node:
    def __init__(self, data = None):
        self.data = data
        self.next = None


class SingleLinkedlist:
    def __init__(self):
        self.head = None
        self.tail = self.head
        self.size = 1
    def Insert_begining(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head = new_node
            self.size += 1
    def Insert_end(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
            self.size += 1
    def Insert_position(self, pos, data):
        new_node = Node(data)
        if pos >= self.size:
            self.tail.next = new_node
            self.tail = new_node
            self.size += 1
        elif pos == 1:
            new_node.next = self.head
            self.head = new_node
            self.size += 1
        else:
            tmpnode = self.head
            for i in range(1,pos-1):
                tmpnode = tmpnode.next
            new_node.next = tmpnode.next
            tmpnode.next = new_node
            self.size += 1
    def Traverse(self):
        current = self.head
        while current.next != None:
            print(current.data,end = '->')
            current = current.next
        print(current.data)

    def Del_Position(self, pos):
        if not self.head:
            print("Linked List is Empty")
        if pos == 1:
            print(self.head.data)
            self.head = self.head.next
            self.size -= 1
        elif pos >= self.size:
            tempNode = self.head
            while tempNode.next != self.tail:
                tempNode = tempNode.next
            tempNode.next = None
            self.tail = tempNode
            self.size -= 1
    def Del_whole(self):
        self.head = None
        self.tail = None
    
if __name__ == "__main__":
    list = SingleLinkedlist()
    list.Insert_begining(2)
    list.Insert_begining(3)
    list.Traverse()
    list.Insert_position(3,4)
    list.Traverse()
    list.Del_Position(1)
    list.Traverse()











    

