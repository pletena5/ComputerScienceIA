public class Stack extends List{

    public Stack(){
        super();
    }// constructor

    public void push(int i, int j){
        ListNode newHead = new ListNode(i, j);
        newHead.setNext(head);
        head = newHead;
    }// push

    public Integer[] pop (){
        ListNode temp = head;
        head = head.getNext();
        return temp.getValue();
    }// pop method

    public Integer peek (){
        if (head == null){
            return null;
        }// if statement
        return head.getValue()[0];
    }// peek method

}// class stack