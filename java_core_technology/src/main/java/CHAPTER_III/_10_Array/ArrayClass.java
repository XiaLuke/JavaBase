package CHAPTER_III._10_Array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author XF
 * @date 2023/09/05
 */

public class ArrayClass {
    /**
     * 3.10.1
     * declaration of array
     * \n
     * An array is a data structure used to store a collection of values of the same type.
     * accessing array elements by shaping subscript
     */
    @Test
    public void declareArray() {
        // When declaring an array variable, you need to indicate the array type,
        // and the data element is followed by [] and the name of the array variable.
        int[] a;
        // This only declares the variable a, and does not initialize a as a real array,
        // which should be created using the new operator.
        int[] b = new int[100];
        // The above statement creates an array of 100 integers,
        // When an array is created, its length cannot be changed, and if you need to expand the size of the array,
        // you should use another data structure, the array list.will be introduced later.

        // In java, provides a shorthand for creating array objects and providing initial values at the same time
        int[] smallPrimes = {2, 3, 5, 7, 11, 13};
        // You don't need to use new, or even specify the array size, as long as you keep adding values to the array.
        String[] names = {
                "h",
                "e",
                "l",
                "l",
                // add more elements
        };
    }

    /**
     * 3.10.2
     * accessing array elements
     * \n
     */
    @Test
    public void accessEle() {
        // when you create a array,you can set elements of array
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        // when create a new array, every element of array is 0, boolean array is false

        // if you want access array elements, you can use subscript
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * 3.10.3
     * for-each loop
     */
    @Test
    public void forEach() {
        // for-each loop is a concise way to traverse an array
        int[] a = new int[100];
        for (int i : a) {
            System.out.println(i);
        }
        // for-each loop is not only used to traverse arrays, but also to traverse other data structures.
    }

    /**
     * 3.10.4
     * array copy
     * \n
     */
    @Test
    public void arrayCopy() {
        // array copy is a common operation, java provides a method to copy array
        int[] a = new int[3];
        a[1] = 12;
        int[] b = Arrays.copyOf(a, a.length);
        // or increase the length of the array
        int[] c = Arrays.copyOf(a, 2 * a.length);
    }

    /**
     * 3.10.6
     * array sort
     * \n
     */
    @Test
    public void ArraySort() {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            // random number
            a[i] = (int) (Math.random() * 100);
        }
        // sort
        Arrays.sort(a);
        // print
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 3.10.7
     * multi-dimensional array
     * \n
     * */
    @Test
    public void multiDimensionalArray() {
        // declare a multi-dimensional array
        int[][] a;
        // initialize a multi-dimensional array
        a = new int[3][5];
        // set value in multi-dimensional array
        int[][] b = {
                {1, 2, 3},
                {4, 5, 6}
        };
        // access multi-dimensional array
        System.out.println(b[1][2]);
    }
}
