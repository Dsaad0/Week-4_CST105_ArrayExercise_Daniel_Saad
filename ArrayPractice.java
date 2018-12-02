/* Program:  ArrayPractice
  * File:     ArrayPractice.java
  * Summary:  Reads sentance from text file and enters data into arrays by Row Major order. Then creates new string with Column Major order.
  * Author:   Daniel Saad
  * Date:     12/01/18
 */
import java.io.FileNotFoundException;
//Import java scanner
import java.util.Scanner;

public class ArrayPractice {

    public static void main(String[] args) throws FileNotFoundException {
        //Input file to be read
        java.io.File file = new java.io.File("c:\\sentance.txt");
        //Integer to help with holding string spot
        int arrayspot = 0;
        //Intialize array 20 x 45
        char[][] array = new char[20][45];
        //Fills array Row-Major with char '@'
        for (int rows = 0; rows < array.length; rows++) {
            for (int cols = 0; cols < array[0].length; cols++) {
                array[rows][cols] = '@';
            }
        }
        //Initialize String words to build in to
        String words = "";
        //Initialize scanner to read file
        Scanner in = new Scanner(file);
        //Reads from file to string Words
        while (in.hasNext()) {
            words += in.nextLine();
        }
        //For loop to build array Row Major // Known Bounds (Rows < 20) (Column <45)
        for (int row = 0; row < 20; row++) {
            for (int cols = 0; cols < 45; cols++) {
                if (arrayspot < words.length()) {
                    //Fills array with characters from String Words
                    array[row][cols] = words.charAt(arrayspot);
                } else {
                    //Once the string is finished will replace rest with '@'
                    array[row][cols] = '@';
                }
                //Counter for characters goes up by 1
                arrayspot++;
            }
        }
        //Intialize string newwords to build string from column major array
        String newwords = "";
        //Reads Array by column major Known Bounds (Rows < 20) (Column <45)
        for (int cols = 0; cols < 45; cols++) {
            for (int rows = 0; rows < 20; rows++) {
                if (array[rows][cols] != '@') {
                    //Adds characters from array to Newwords as long as it is not @
                    newwords += Character.toString(array[rows][cols]);
                }
            }

        }
        //Prints out string Words with Row Major order
        System.out.print("Row Major Order: " + words + "\n" + "\n");
        //Prints newwords that were created with Column Major ignores @ characters
        System.out.print("Column Major Order: " + newwords + "\n" + "\n");
        //Prints out array
        printarr(array);

    }
    //Created new Method to help visualize Array
    public static void printarr(char[][] b) {
        for (int r = 0; r < b.length; r++) {
            for (int c = 0; c < b[0].length; c++) {
                System.out.print(b[r][c] + ", ");
            }
            System.out.println();
        }
    }
}