//import sun.security.util.Length;

public class singleLinkedList {
    /**
     * InnersingleLinkedList
     */
    public class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }

        public int length(Node headNode) {
            int length = 0;
            Node currentNode = headNode;
            while (currentNode != null) {
                length++;
                currentNode = currentNode.next;
            }
            return length;
        }

    }

    public singleLinkedList() {
        length = 0;
    }

    Node head;
    private int length = 0;

    public synchronized Node getHead() {
        return head;
    }

    public synchronized void insertAtBegin(Node node) {
        node.next = head;
        head = node;
        length++;
    }

    public synchronized void insertAtEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node p, q;
            for (p = head; (q = p.next) != null; p = q)
                ;
            p.next = node;
            length++;
        }
    }

    public void insert(int data, int position) {
        if (position < 0)
            position = 0;
        if (position > length)
            position = length;
        if (head == null)
            head = new Node(data);
        else if (position == 0) {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
        } else {
            Node temp = head;
            for (int i = 1; i < position; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }
        length++;
    }

    public synchronized Node removeFromBegin() {
        Node temp = head;
        if (temp != null) {
            head = temp.next;
            temp.next = null;
        }
        return temp;
    }

    public synchronized Node removeFromLast() {
        if (head == null)
            return null;
        Node temp = head, next = head.next, previous = null;
        if (next == null) {
            head = null;
            return temp;
        }
        while ((next = temp.next) != null) {
            previous = temp;
            temp = next;
        }
        previous.next = null;
        return temp;
    }

    public synchronized void removeMatched(Node node) {
        if (head == null)
            return;
        if (node.equals(head)) {
            head = head.next;
            return;
        }
        Node temp = head, previous = null;
        while ((previous = temp.next) != null) {
            if (node.equals(temp)) {
                previous.next = temp.next;
                return;
            }
            temp = previous;
        }
    }

    public void remove(int position) {
        if (position < 0) {
            position = 0;
        }
        if (position >= length) {
            position = length - 1;
        }
        if (head == null) {
            return;
        }
        if (position == 0) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 1; i < position; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        length -= 1;
    }

    public String toString() {
        String result = "|";
        if (head == null) {
            return result + "|";
        }
        result = result + head.data;
        Node temp = head.next;
        while (temp != null) {
            result = result + "," + temp.data;
            temp = temp.next;
        }
        return result + "|";
    }

    public int length() {
        return length;
    }

    // Check For the First Positon which is equal to a given position
    public int getPosition(int data) {
        Node temp = head;
        int position=0;
        while(temp!=null){
            if(temp.data==data)
            return position;
            position += 1;
            temp = temp.next;
        }
        return Integer.MIN_VALUE;
    }
    public void clearList(){
        head = null;
        length = 0;
    }

    public static void main(String[] args) {
        singleLinkedList list = new singleLinkedList();
         
        //list.insertAtBegin(new Node(80));
        list.insert(3,15);
        list.insert(1,5);
        list.insert(2,35);
        System.out.println(list.toString());

    }
}