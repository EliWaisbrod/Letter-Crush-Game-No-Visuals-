public class DoublyLinkedList {
    private Node head; //Head of list
    private Node tail; //Tail of list

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) { //If list empty
            head = newNode;
            tail = newNode;
        } else { //If list not empty
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    //Removes the first node with a specified value
    public boolean remove(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) { //If node is found
                if (current.prev != null) { //If not the head node
                    current.prev.next = current.next;
                } else { //If it is the head node
                    head = current.next;
                }

                if (current.next != null) { //If its not the tail node
                    current.next.prev = current.prev;
                } else { //If it is the tail node
                    tail = current.prev;
                }
                return true;
            }
            current = current.next;
        }
        return false; //Node not found
    }
    //Reverses order of nodes in the list
    public void reverse() {
        Node current = head;
        Node temp = null;
        while (current != null) { //Traverse the list
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev; //Update head node
        }
    }
    //Prints all values of all nodes heat to tail
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    //Deletes entire list
    public void deleteList() {
        head = null;
        tail = null;
    }

    // helper method to print to a StringBuilder (for testing purposes)
    public void printToString(StringBuilder sb) {
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }
    }
}
