package edu.sdccd.cisc191;

class SinglyLinkedList<T>
{
    class Node
    {
        T data;
        Node next;

        //constructor
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    };

    /**
     * recursively finds k-th node, deletes, and returns new head
     *
     * @param head the node to start at
     * @param k the kth element to remove (first element at 0)
     * @return the new head node with the kth element removed
     */
    public Node remove(Node head, int k)
    {
        try {

            if (k == 1) {
                Node next = head.next;
                head.next = next.next;
                next.next = null;
                next.data = null;

            } else {
                remove(head.next, --k);
            }
        } catch (NullPointerException e) {
            System.err.println("End of linked list reached.");
        }
        return head;
    }

    /**
     *  inserts node at the beginning of the list
     * @param head the node to start at
     * @param newData data to insert into the list
     * @return the new head node containing new_data followed with the rest of the linked list
     */
    public Node push(Node head, T newData)
    {
        return new Node(newData, head);
    }

    /**
     * recursively prints list starting from head
     * @param head the node to start at
     * @return a space separated string containing the data of each node starting from the head to the tail, end with a trailing space
     */
    public String toString(Node head)
    {
        try {
            return head.data + " " + toString(head.next);
        }catch (NullPointerException e) {
            return head.data.toString();
        }
    }
}