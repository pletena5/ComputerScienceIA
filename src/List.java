public class List {
    public ListNode head;

    public List() {
        head = null;
    }

    public List(int[] values) {
        ListNode n = new ListNode(values[0]);
        head = n;
        for (int i=1; i<values.length; i++) {
            n.setNext(new ListNode(values[i]));
            n = n.getNext();
        }
    }

    public ListNode getHead() {
        return head;
    }

    public void addFirst(int n) {
        // adds a new node with value n
        // at the start of this list
        ListNode node = new ListNode(n);
        node.setNext(head);
        head = node;
    }

    public ListNode remove() {
        // retrieves and removes the head
        // (first element) of this list.
        ListNode first = getHead();
        head = head.getNext();
        return first;
    }

    public void display() {
        // print the list values
        ListNode current = head;
        System.out.print("Head -> ");
        while (current != null) {
            System.out.println("["+current.getValue()[0]+", "+current.getValue()[1]+"][ ]->");
            current = current.getNext();
        }
        System.out.println(" null");
    }
}
