package edu.govschool.collections;

/**
 * This is a basic implementation of a data structure
 * <code>Node</code>. For now, it supports only a singly-linked 
 * list. It stores <code>int</code> data.
 * 
 * @author Bryce Davis
 * @version 1.0
 */
public class Node
{
    // Private instance variables. These do not get javadoc
    // because they are private, and therefore hidden.
    private int data;
    private Node next;
    
    /**
     * Primary constructor. 
     * This creates a new <code>Node</code>
     * with <code>int</code> data <code>data</code> and a 
     * reference to the next <code>Node</code> in the list
     * called <code>next</code>,
     * 
     * @param data data the <code>Node</code> holds
     * @param next the next <code>Node</code> in the list
     */
    public Node(int data, Node next) 
    {
        this.data = data;
        this.next = next;
    }
    
    /**
     * Gets the <code>int</code> data stored by this 
     * <code>Node</code>.
     * 
     * @return the data for this <code>Node</code>
     */
    public int getData()
    {
        return this.data;
    }
    
    /**
     * Gets the reference to the next <code>Node</code> linked
     * in the list.
     * 
     * @return the next <code>Node</code> in the list
     */
    public Node getNextReference()
    {
        return this.next;
    }
    
    /**
     * Sets the reference to the next <code>Node</code> in the 
     * list.
     * 
     * @param next the next <code>Node</code> in the list
     */
    public void setNextReference(Node next)
    {
        this.next = next;
    }
}
