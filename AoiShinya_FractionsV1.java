/*
 *@Author Shinya Aoi
 * Class CSS143A
 * FractionsV1
 * 04/11/2018
 */

import java.io.*;
import java.util.*;

/**
 * This program reads fractions and count the current fraction,
 * and outputs the unique fractions and its count.
 */
public class AoiShinya_FractionsV1 {
    public static void main(String[] args){
        /*
          This part reads the file and counts the number of fractions.
          And declare tow arrays for numerator(top) and denominator (bottom).
         */
        Scanner inputFile = null;
        int numOfFraction = 0;
        try{
            inputFile = new Scanner (new FileInputStream("fractions.txt"));
        }
        catch(IOException e){
            System.out.println("File was not found!");
            System.exit(0);
        }
        //Calculate the number of fractions
        while(inputFile.hasNext()){
            numOfFraction++;
            inputFile.nextLine();
        }
        //define arrays for numerator(top) and denominator (bottom)
        int[] top = new int[numOfFraction];
        int[] bottom = new int[numOfFraction];
        inputFile.close();


        //This parts adds values in top and bottom arrays.

        Scanner keyboard = null;
        try{
            keyboard = new Scanner (new FileInputStream("fractions.txt"));
        }
        catch(IOException e){
            System.out.println("File was not found!");
            System.exit(0);
        }
        //put values in top and bottom arrays
        for (int i=0; i<numOfFraction; i++){
            String[] curFraction = keyboard.nextLine().split("/");
            top[i] = Integer.parseInt(curFraction[0]);
            bottom[i] = Integer.parseInt(curFraction[1]);
        }
        /* Fixed this problem!
          This part declares and creates new count and value of a fraction arrays.
          And update the top and bottom array - store only one value within the same value.
          Then compare the current value to the existing arrays of fractionValue.
          If it does not exist, add to the fractionValue of k and increments count of k.
         */
        int[] count = new int[numOfFraction];
        double[] fractionValue = new double[numOfFraction];
        // make new list of bottom and top
        int[] top2 = new int[numOfFraction];
        int[] bottom2 = new int[numOfFraction];

        //find the same value of fractions
        int k=0;
        label:
        for(int i=0; i<numOfFraction; i++){
            for(int j=0; j<k; j++){
                if((double)top[i]/bottom[i]==fractionValue[j]){
                    count[j]++;
                    continue label;
                }
            }
            top2[k] = top[i]; //updating the new value of the top array
            bottom2[k] = bottom[i]; //updating the new value of the bottom array
            fractionValue[k] = (double)top[i]/bottom[i];
            count[k]++;
            k++;
        }
        keyboard.close();

        /*
          This parts print out the result of number of current fraction.
          If the value of fractions is equal to 0, it wont print out.
         */
        for (int j = 0; j < fractionValue.length; j++) {
            if (fractionValue[j]!=0){
                System.out.println(top2[j]+"/"+bottom2[j]+" has a count of "+count[j]);
            }
        }
    }
}
/*
*Answers to questions:
*1.Can you complete this without using arrays?
*What is the least number of variables you can use to solve this problem?
*- I do not think you can complete this assignment without using arrays.
*- I believe one variable would be the minimum number.
*
*2.Can you use just one array to solve this?
*What would the data type be of that array?
*- I believe that you can. The data would be double to complete this assignment.
*
*3.Can you nest* one class (data type) within another, like we observe with nested loops?
*What is an example of this? (*compose)
*-Yes. An example is the Node.
*
*4.What are some solutions to the reduction problem other than
* Euclid's GCD (greatest common divisor) algorithm?
* (You may want to look up GCD online.)
* -Other solution would be binary GCD.
*/
