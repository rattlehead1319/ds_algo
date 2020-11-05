package ds.easy.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ReverseArray {

    static int[] reverseArray(int[] inputArray) {
        int[] output = new int[inputArray.length];
        int outputIndex = 0;
        int inputIndex = inputArray.length - 1;
        while (inputIndex >= 0) {
            output[outputIndex++] = inputArray[inputIndex--];
        }
        return output;
    }


    public static void main(String[] args) throws IOException {

    }
}
