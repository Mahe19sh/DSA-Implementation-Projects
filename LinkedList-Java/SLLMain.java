import java.util.Scanner;
public class SLLMain {
    public static void main(String[] args) throws Exception {
        //SingleLinkedList list = new SingleLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value to create list: ");
        int x = sc.nextInt();
        DoubleLinkedList ls = new DoubleLinkedList(x);
        ls.Insertion(1,2);
        ls.Insertion(1,3);
        ls.Insertion(4,4);
        ls.Insertion(4,6);
        ls.Traversalfwd();
        ls.Traversalbwd();
	ls.Search(3);
        ls.Deletion(3);
	ls.Traversalfwd();
        ls.DeleteWhole();
        ls.Traversalfwd();
        /*
        CircularLinkedList cl = new CircularLinkedList(x);
        System.out.println("The list is created: ");
        cl.Insertion(1,3);
        cl.Insertion(0,2);
        cl.Traversal();
        cl.Deletion(4);
        cl.Traversal(); 
        list.Insertion(4,2);
        list.Insertion(3,3);
        list.Insertion(2,4);
        list.Insertion(1,5);
        list.Traversal();
        list.Searching(2);
        list.Searching(6);
        list.Deletion(3);
        list.Traversal();
        list.Searching(3);
        */
    }
}
