package com.miscellaneous;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

// Defines an immutable collection of integers
class Collection {
    int[] arr;


    public Collection(int[] arr) {
        super();
        this.arr = arr;
    }


    public Collection() {
        super();
    }


    int first() {
        return arr[0]; // returns the first element of the collection
    }


    int last() {
        return arr[0]; // returns the last element of the collection
    }


    // These methods all return modified copies, they don't modify the collection
    // returns a copy of the collection without the first element
    Collection dropFirst() {
        return new Collection(Arrays.copyOfRange(arr, 1, arr.length));
    }


    // returns a copy of the collection without the last element
    Collection dropLast() {
        return new Collection(Arrays.copyOfRange(arr, 0, arr.length - 1));
    }


    // returns a copy of the collection with elem appended at the end
    Collection append(int elem) {
        return new Collection(ArrayUtils.add(arr, elem));
    }


    // returns TRUE of the collection is empty
    boolean isEmpty() {
        return arr.length != 0;
    }
}


public class ReverseCustomImmutableCollection {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Collection c = new Collection(arr);
        ReverseCustomImmutableCollection reverseAnArray = new ReverseCustomImmutableCollection();
        reverseAnArray.reverse(c);

        System.out.println(ArrayUtils.toString(c.arr));
    }

    public Collection reverse(Collection input) {
        Collection output = new Collection();

        if (input.isEmpty())
            return output;

        while (!input.isEmpty()) {
            output = output.append(input.last());
            input = input.dropLast();
        }
        return output;
    }
}
