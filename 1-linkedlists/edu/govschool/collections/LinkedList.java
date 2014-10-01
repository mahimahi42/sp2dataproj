package edu.govschool.collections;

/**
 * This is a basic singly-linked list to store <code>int</code>
 * data.
 * 
 * @author Bryce Davis
 * @version 1.0
 */
public class LinkedList
{
    // Private instance variables.
    private Node head;
    private Node tail;
    
    /**
     * Primary constructor.
     * Creates a new empty <code>LinkedList</code>.
     */
    public LinkedList()
    {
        head = null;
        tail = null;
    }
    
    /**
     * Adds a value to the end of the list.
     * Creates a new <code>Node</code> to hold the data,
     * then adds it to the end of the <code>LinkedList</code>.
     * 
     * @param num data to insert
     */
    public void insertAtBack(int num)
    {
        if (this.isEmpty()) {
            head = new Node(num, null);
            tail = head;
        } else {
            Node tempRef = tail;
            tail = new Node(num, null);
            tempRef.setNextReference(tail);
        }
    }
    
    /**
     * Adds a value to the beginning of the list.
     * Creates a new <code>Node</code> to hold the data,
     * then adds it to the beginning of the 
     * <code>LinkedList</code>.
     * 
     * @param num data to insert
     */
    public void insertAtFront(int num)
    {
        Node tempRef = new Node(num, null);
        
        if (this.isEmpty()) {
            head = tempRef;
            tail = head;
        } else {
            tempRef.setNextReference(head);
            head = tempRef;
        }
    }
    
    /**
     * Removes the last <code>Node</code>.
     * If the list is empty, it tells the user. Otherwise,
     * it removes the last <code>Node</code> in the
     * </code>LinkedList</code>
     */
    public void removeFromBack()
    {
        if (this.isEmpty()) {
            System.out.println("The list is empty");
        } else if (head != null && head == tail) {
            Node prev = head;
            Node curr = head;
            while (curr != tail) {
                prev = curr;
                curr = curr.getNextReference();
            }
            prev.setNextReference(null);
            tail = prev;
        }
    }
    
    /**
     * Removes the first <code>Node</code>.
     * If the list is empty, it tells the user. Otherwise,
     * it removes the first <code>Node</code> in the
     * </code>LinkedList</code>
     */
    public void removeFromFront()
    {
        if (this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            head = head.getNextReference();
        }
    }
    
    /**
     * Gets the maximum value.
     * Traverses the list and finds the largest <code>int</code>
     * data stored, returning it. Assumes all integers are
     * positive.
     * 
     * @return the max <code>int</code> in the list
     */
    public int getMaxValue()
    {
        Node tempRef = head;
        int max = -1000;
        
        while (tempRef != null) {
            int value = tempRef.getData();
            if (value > max) {
                max = value;
            }
            tempRef = tempRef.getNextReference();
        }
        return max;
    }
    
    /**
     * Gets the <code>Node</code> with the maximum data.
     * Traverses the list to find the <code>Node</code> 
     * containing the data returned by <code>getMaxValue</code>.
     * Assumes all values in the list are positive.
     * 
     * @return <code>Node</code> with maximum data
     */
    public Node getMaxReference()
    {
        Node tempRef = head;
        int max = this.getMaxValue();
        
        while (tempRef.getData() != max) {
            tempRef = tempRef.getNextReference();
        }
        return tempRef;
    }
    
    /**
     * Moves the largest data to the back.
     * If the list is empty, does nothing. Otherwise, moves
     * the <code>Node</code> with the largest stored value
     * to the back of the <code>LinkedList</code>.
     */
    public void maxToBack()
    {
        if (!this.isEmpty()) {
            int max = this.getMaxValue();
            Node maxRef = this.getMaxReference();
            if (head != tail) {
                if (head == maxRef) {
                    removeFromFront();
                    insertAtBack(max);
                } else if (tail != maxRef) {
                    Node curr = head;
                    Node prev = head;
                    
                    while (curr != maxRef) {
                        prev = curr;
                        curr = curr.getNextReference();
                    }
                    prev.setNextReference(curr.getNextReference());
                    insertAtBack(max);
                }
            }
        }
    }
    
    /**
     * Returns <code>true</code> if the list is empty.
     * Otherwise, returns <code>false</code>.
     * 
     * @return <code>true</code> if the list is empty, <code>false</code> otherwise.
     */
    public boolean isEmpty()
    {
        return head == null;
    }
    
    /**
     * Returns <code>true</code> if the list contains the value <code>num</code>.
     * Otherwise, the method returns <code>false</code>.
     * 
     * @param num the value to check the list for
     */
    public boolean contains(int num) {
        if (this.isEmpty()) {
            return false;
        } else if (head == tail && head.getData() != num) {
            return false;
        } else {
            Node curr = head;
            while (curr != null) {
                if (curr.getData() == num) {
                    return true;
                }
                curr = curr.getNextReference();
            }
            return false;
        }
    }
    
    /**
     * Prints a readable representation of the list.
     * If the list is empty, informs the user. Otherwise,
     * prints a representation of the <code>int</code> values
     * in the list in the following format:
     * <p>
     * 1 --> 2 --> 3 --> 4
     */
    public void printList()
    {
        if (this.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            Node tempRef = head;
            System.out.print("Values in the list: ");
            while (tempRef != null) {
                System.out.print(tempRef.getData());
                tempRef = tempRef.getNextReference();
                if (tempRef != null) {
                    System.out.print(" --> ");
                }
            }
            System.out.println();
        }
    }
}
