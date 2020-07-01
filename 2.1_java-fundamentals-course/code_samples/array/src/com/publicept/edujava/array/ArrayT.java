/**
 * 
 */
package com.publicept.edujava.array;

/**
 * Test class of arrays and for-loops.
 *
 * @author Urs Albisser
 * @version 0.1 (12.6.2019)
 */
public class ArrayT {
    // declaration of instance variables
    private int[] myArray; // unidimensional array
    private int[][] myBoard; // create a board with a 2D array

    /**
     * Constructor for objects of class ForArrayT
     */
    public ArrayT() {
        // initialize and fill array
        myArray = new int[100];
        for(int i = 0; i < myArray.length; i++) {
            myArray[i] = i;
        }
        
        // let's loop through the 2D array to populate board
        myBoard = new int[10][10];
        for(int row = 0; row < myBoard.length; row++) {
            for(int col = 0; col < myBoard[row].length; col++) {
                myBoard[row][col] = row * col;
            }
        }
    }
    
    /**
     * print all array content to console
     */
    public void printMyArray() {
        for(int i = 0; i < myArray.length; i++) {
            System.out.println("array field: " + i + " -> array content: " + myArray[i]);
        }
    }
    
    /**
     * print all content of the 2D array to console
     */
    public void printMyBoard() {
        System.out.print("row/col:\t");
        for(int col = 0; col < myBoard[0].length; col++) {
            System.out.print("col " + col + ":\t");
        }
        System.out.println();
        for(int row = 0; row < myBoard.length; row++) {
            System.out.print("row " + row + ":\t\t");
            for(int col = 0; col < myBoard[row].length; col++) {
                System.out.print(myBoard[row][col] + "\t");
            }
            System.out.println();
        }
    }
    
    /**
     * Iterator use in for-loops:
     * refer to IteratorT
     */
}
