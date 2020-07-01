package com.publicept.edujava.list;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Write a description of class ArrayListT here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListT
{
    // instance variables - replace the example below with your own
    private List<String> myList; // declarated with "List" (not "ArrayList")

    /**
     * Constructor for objects of class ArrayListT
     */
    public ListT()
    {
        // initialise instance variables
        myList = new ArrayList<>(); // initialized with "ArrayList"
        
        myList.add("aklsdjfa");
        myList.add("kdjfasl");
        myList.add("ioerqio");
        myList.add("vcjkldjf");
        myList.add("aiuroiewqr");
    }

    /**
     * print ArrayList
     */
    public void printList() {
        Iterator<String> it = myList.iterator();
        while(it.hasNext()) {
            String content = it.next();
            System.out.println(content);
        }
    }
}