package com.publicept.com.edujava.iterator;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Test of the class ArrayListT.
 *
 * @author Urs Albisser
 * @version 0.1(5.6.2019)
 */
public class IteratorT
{
    // instance variables
    private List<String> myList; // declared with "List"

    /**
     * Constructor for objects of class ArrayListT
     */
    public IteratorT()
    {
        // Initialize instance variables
        myList = new ArrayList<>(); // initialized with "ArrayList"

        myList.add("aaa");
        myList.add("bbb");
        myList.add("ccc");
        myList.add("ddd");
    }

    /**
     * print all entries of the ArrayList by iterating with the Iterator
     */
    public void printListWithWhile() {
        Iterator<String> it = myList.iterator();
        while(it.hasNext()) {
            String content = it.next();
            System.out.println(content);
        }
    }

    /**
     * print all entries of the ArrayList by iterating with the Iterator
     */
    public void printListWithFor() {
        for(Iterator<String> it = myList.iterator(); it.hasNext();   ) { // action keeps empty
            String content = it.next();
            System.out.println(content);
        }
    }
    
    /**
     * Add a new item to ArrayList.
     * 
     * @param addString String to be added to the ArrayList.
     */
    public void addItem(String addString) {
        myList.add(addString);
    }
    
    /**
     * Remove an item  from the ArrayList.
     * 
     * @param searchString Search for a Sting within the ArrayList to be removed.
     */
    public void removeItem(String searchString) {
        Iterator<String> it = myList.iterator();
        while(it.hasNext()) {
            String item = it.next();
            if(item.contains(searchString)) {
                it.remove();
            }
        }
    }
}
