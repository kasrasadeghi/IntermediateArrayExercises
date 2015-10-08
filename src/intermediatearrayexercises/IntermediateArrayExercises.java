/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediatearrayexercises;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author DSTIGANT
 */
public class IntermediateArrayExercises
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int [] jenny = { 8, 6, 7, 5, 3, 0, 9 };
        int [] ap = { 3, 5, 7, 11 };
        int [] ea = { } ;
        String [] jennyString = { "eight", "six", "seven", "five", "three", "zero", "nine" };
        String [] stigantFam = { "Dave", "Steph", "Megan" };
        String [] eas = { };
        
        printIntArray( jenny );
        printStringArray( jennyString );
        System.out.println( intArrayToString(jenny) );
        System.out.println( "The entries in " + intArrayToString(jenny) + " add up to " + addIntArray(jenny) );
        System.out.println( "There are " + countOddElements( jenny ) + " odd numbers in " + intArrayToString( jenny ) );
        System.out.println( "There are " + countElementsGreaterThan( jenny, 5 ) + " numbers greater than 5 in " + intArrayToString( jenny ) );
        System.out.println( "There are " + countLongWords( jennyString, 4 ) + " strings in " + stringArrayToString( jennyString ) + " that are longer than 4 letters");
        System.out.println( "There are " + countLongWords( jennyString, 's' ) + " strings in " + stringArrayToString( jennyString) + " which start with 's'" );
        
        System.out.println( "The entries in " + intArrayToString(jenny) + " are all prime: " + allPrime(jenny) );
        System.out.println( "The entries in " + intArrayToString(ap) + " are all prime: " + allPrime(ap) );
        System.out.println( "The entries in " + intArrayToString(ea) + " are all prime: " + allPrime( ea ));
        
        System.out.println( "All the entries in " + stringArrayToString( jennyString ) + " contain 'e': " + allWordsContain( jennyString, 'e' ) );
        System.out.println( "All the entries in " + stringArrayToString( stigantFam ) + " contain 'e': " + allWordsContain( stigantFam, 'e' ) );
        System.out.println( "All the entries in " + stringArrayToString( eas ) + " contain 'e': " + allWordsContain( eas, 'e' ) );
        
        swap( jenny, 3, 5 );
        System.out.println( "jenny is now " + intArrayToString( jenny ) );
        swap( jenny, 0, 0 );
        System.out.println( "jenny is now " + intArrayToString( jenny ) );
        
        System.out.println( "The reverse of " + intArrayToString(jenny) + " is " + intArrayToString(reverseNewIntArray(jenny) ) );
        
        System.out.println( "The reverse of " + intArrayToString(ea) + " is " + intArrayToString( reverseNewIntArray(ea) ) );
        
        reverseInPlaceIntArray( jenny );
        
        System.out.println("jenny is now " + intArrayToString( jenny ) );
        
        
    }
    
    // printIntArray
    // prints out an array of ints
    // input: the array of ints
    // returns: nothing (void)
    // output: the array like this: [ 8, 6, 7, 5, 3, 0, 9 ]
    public static void printIntArray( int [] arr )
    {
        System.out.print("[ ");
        String middle = Arrays.stream(arr)
                .mapToObj(a -> String.valueOf(a))
                .collect(Collectors.joining(", "));
        System.out.print(middle);
        System.out.println(" ]");
    }
    
    // printStringArray
    // same as printIntArray but with Strings
    // print out something like [ "eight", "six", "seven", "five", "three", "zero", "nine" ]
    public static void printStringArray( String [] arr )
    {
        System.out.print("[ ");
        System.out.print(Arrays.stream(arr)
                .map(str -> "\"" + str + "\"")
                .collect(Collectors.joining(", "))
        );
        System.out.println(" ]");
    }
    
    // intArrayToString
    // creates a String representation of an array of ints
    // input: an array of ints
    // output: a String representing the array, like this : "[ 8, 6, 7, 5, 3, 0, 9 ]"
    public static String intArrayToString( int [] arr )
    {
        String output = "[ ";
        output += Arrays.stream(arr)
                .mapToObj(a -> String.valueOf(a))
                .collect(Collectors.joining(", "));
        output += " ]";
        return output;
    }
    
    // stringArrayToString
    // same as intArrayToString but with Strings
    // output: a String representing the array, like this : "[ "eight", "six", "seven", "five", "three", "zero", "nine" ]"
    public static String stringArrayToString( String [] arr )
    {
        return "[ " + Arrays.stream(arr)
                .map(str -> "\"" + str + "\"")
                .collect(Collectors.joining(", ")) + " ]";
    }
    
    // addIntArray
    // adds the entries in an array of ints
    // input: an array of ints
    // output: the sum of the ints
    // ex: addIntArray( {8, 6, 7, 5, 3, 0, 9} ) ==> 38
    public static int addIntArray( int [] arr )
    {
        return Arrays.stream(arr).sum();
    }
    
    // ***********************************
    // counting elements that meet a requirement
    // do at least countElementsGreaterThan and countWordsWith
    // ***********************************
    
    // countOddElements
    // counts the odd elements in an array of ints
    // input: an array of ints
    // output: the number of odd elements in the array
    // ex: countOddElements( {8, 6, 7, 5, 3, 0, 9} ) ==> 4
    public static int countOddElements( int [] arr )
    {
        return (int) Arrays.stream(arr)
                .filter(a -> a%2 == 1)
                .count();
    }
    
    // countElementsGreaterThan
    // counts all the elements in an array greater than a particular number
    // inputs: an array of ints and a target number
    // ouput: the number of elements in the array greater than the target number
    // ex: countElementsGreaterThan( {8, 6, 7, 5, 3, 0, 9}, 5 ) ==> 4
    public static int countElementsGreaterThan( int [] arr, int target )
    {
        return (int) Arrays.stream(arr)
                .filter(a -> a > target)
                .count();
    }
    
    // countLongWords
    // counts all the words which are longer than a target length
    // inputs: an array of Strings and a target number
    // ouput: the number of elements in the array with lengths greater than the target number
    // ex: countLongWords( { "eight", "six", "seven", "five", "three", "zero", "nine" }, 4 ) ==> 3
    public static int countLongWords( String [] arr, int target )
    {
        return (int) Arrays.stream(arr)
                .filter(a -> a.length() > target)
                .count();
    }
    
    // countWordsStartingWith
    // count the words in the array which start with initial
    // inputs: an array of String and an initial char
    // output: the number of elements in the array which start with initial (either capital or lowercase)
    // ex: countLongWords( { "eight", "six", "Seven", "five", "three", "zero", "nine" }, 's' ) ==> 2
    public static int countWordsStartingWith( String [] arr, char initial )
    {
        char initial2 = Character.toLowerCase(initial);
        return (int) Arrays.stream(arr)
                .filter(a -> initial2 == a.toLowerCase().charAt(0))
                .count();
    }
    
    // countWordsWith
    // counts the words in the array which contain the target letter
    // inputs: an array of Strings and a target char
    // output: the number of elements in the array which contain the target letter
    // ex: countWordsWith( { "eight", "six", "seven", "fivE", "three", "zero", "ninE" }, 'E' ) ==> 6
    public static int countWordsWith( String [] arr, char target )
    {
        return (int) Arrays.stream(arr)
                .filter(a -> a.toLowerCase().contains(String.valueOf(Character.toLowerCase(target))))
                .count();
    }
    
    // ***********************************
    // checking that all elements meet a requirement
    // at what point can you say "no"?  At what point can you say "yes"?
    // ***********************************
    
    public static boolean isPrime( int n )
    {
        if ( n < 2 ) return false;
        
        for ( int i = 2; i <= Math.sqrt(n); i++ )
        {
            if ( n % i == 0 )
            {
                return false;
            }
        }
        return true;
    }
    
    // allPrime
    // returns true if all the numbers in an array are prime
    // inputs: an array of ints
    // output: true if all the elements are prime
    // ex:
    // allPrime( { 8, 6, 7, 5, 3, 0, 9 } ) ==> false
    // allPrime( { 3, 2, 5, 11, 7 } ) ==> true
    // allPrime( { } ) ==> true
    public static boolean allPrime( int [] arr )
    {
        for (int i : arr)
            if (!isPrime(i))
                return false;
        return true;
    }
    
    // allWordsContain
    // returns true if all the Strings in an array contain a target character
    // inputs: an array of Strings and a character
    // output: true if all the Strings contain that character
    // ex:
    // allWordsContain( { "eight", "six", "seven", "five", "three", "zero", "nine" }, 'e' ) ==> false
    // allWordsContain( { "Dave", "Steph", "Megan" }, 'e' ) ==> true
    // allWordsContain( { } ) ==> true
    public static boolean allWordsContain( String [] arr, char c )
    {
        for (String word : arr) 
            if(!word.toLowerCase().contains(Character.toLowerCase(c) + ""))
                return false;
        return true;
    }
    
    // swap
    // swaps two elements in an array
    // inputs: the array and two indices (ints) of the elements to swap
    // output: none (void)
    // NOTE: the inpute array WILL BE CHANGED!
    // ex:
    // int [] jenny = { 8, 6, 7, 5, 3, 0, 9 }
    // swap( jenny, 3, 5 ) ==> jenny is now { 8, 6, 7, 0, 3, 5, 9 }
    // swap( jenny, 0, 0 ) ==> jenny is now { 8, 6, 7, 0, 3, 5, 9 }
    public static void swap( int [] arr, int i1, int i2 )
    {
        int elem1 = arr[i1];
        int elem2 = arr[i2];
        arr[i1] = elem2;
        arr[i2] = elem1;
    }
    
    // reverseNewIntArray
    // returns a new array in which all the elements of the input array have been reversed
    // inputs: the array to be reversed
    // output: the reversed array
    // NOTE: the input array MUST NOT BE CHANGED!
    // ex:
    // reverseNewIntArray( { 8, 6, 7, 5, 3, 0, 9 } ) ==> { 9, 0, 3, 5, 7, 6, 8 }
    // reverseNewIntArray( { 1 } ) ==> {1}
    // reverseNewIntArray( { } ) ==> { }
    public static int [] reverseNewIntArray( int [] oldArray )
    {
        int[] newArray = new int[oldArray.length];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[oldArray.length - 1 - i];
        }
        return newArray;
    }
    
    // reverseInPlaceIntArray
    // reverses the entries in an array
    // inputs: the array to be reversed
    // outputs: none (void)
    // NOTE: the input array WILL BE CHANGED!
    // ex:
    // int [] jenny = { 8, 6, 7, 5, 3, 0, 9 }
    // reverseInPlaceIntArray( jenny ) ==> jenny is now { 9, 0, 3, 5, 7, 6, 8 }
    public static void reverseInPlaceIntArray( int [] arr )
    {
        int l = arr.length;
        for (int i = 0; i < l/2; i++) {
            swap(arr, i, l-1-i);
        }
    }
}
