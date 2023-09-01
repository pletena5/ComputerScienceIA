public class ListNode {
    private int value;
    private Integer value1;
    private ListNode next;

    public ListNode(int value, int value1) {
        this.value = value;
        this.value1 = value1;
        this.next = null;
    }

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    public Integer[] getValue() {
        if (value1 == null) {
            Integer[] valuesArr = {value};
            return valuesArr;
        }// if statement
        else if (value1 != null){
            Integer[] valuesArr = {value , value1};
            return valuesArr;
        }// else if
        return null;
    }

    public void setNext(ListNode pointer) {
        next = pointer;
    }

    public void setValue(int newValue) {
        value = newValue;
    }
}
