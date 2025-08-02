# Quicksort: A Simple and Efficient Sorting Algorithm

Quicksort is an efficient sorting algorithm that uses a divide-and-conquer approach to sort an array of elements. It is
a widely used algorithm and has many real-world implications.

## How it Works

Quicksort works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays
according to whether they are less than or greater than the pivot. The sub-arrays are then recursively sorted.

The pivot element is chosen such that it divides the array into two parts: the left sub-array with elements less than
the pivot, and the right sub-array with elements greater than the pivot.

The algorithm then recursively sorts the left and right sub-arrays until the entire array is sorted.

Quicksort can be implemented in two ways: `Hoare` and `Lomuto` partition scheme. The difference between the two is the
way the pivot is placed in the array during the partitioning process.

In the Hoare partition scheme, the pivot is placed in its final sorted position, while in the Lomuto partition scheme,
the pivot is swapped with the last element of the array. The Lomuto partition scheme is more efficient in terms of the
number of swaps required, but the Hoare partition scheme is easier to understand and implement.

## Example

Suppose we have an array of numbers `[5, 2, 8, 3, 1, 6, 4]`. We want to sort this array in ascending order.

We select the first element `5` as the pivot. We then partition the array into two sub-arrays: `[2, 3, 1]` and
`[8, 6, 4]`.

The left sub-array is then sorted recursively using the same process: we select the first element `2` as the pivot, and
partition the array into `[1]` and `[3]`. The right sub-array is also sorted recursively: we select the first element
`8` as the pivot, and partition the array into `[6]` and `[4]`.

The final sorted array is `[1, 2, 3, 4, 5, 6, 8]`.

### Dry Run

The following is the output of a dry run of the Quicksort algorithm on the same array: `[5, 2, 8, 3, 1, 6, 4]`

```declarative
Selecting pivot: 5
Partitioning: [2, 3, 1] | 5 | [8, 6, 4]

Recursively sorting left sub-array: [2, 3, 1]
Selecting pivot: 2
Partitioning: [1] | 2 | [3]

Recursively sorting left sub-array: [1]
Selecting pivot: 1
Partitioning: [] | 1 | []

Recursively sorting right sub-array: [3]
Selecting pivot: 3
Partitioning: [] | 3 | []

Final sorted array: [1, 2, 3, 4, 5, 6, 8]
```

## Real-World Implications

Quicksort has many real-world implications. For example:

* **Data Analysis**: Quicksort can be used to sort large datasets quickly and efficiently, making it easier to analyze
  and gain insights from the data.
* **Database Query Optimization**: Quicksort can be used to optimize database queries by sorting the data in the most
  efficient way possible.
* **Search Engines**: Quicksort can be used to sort search results quickly and efficiently, making it easier for users
  to find what they are looking for.

## Time and Space Complexity

Quicksort has a time complexity of `O(n log n)` on average, making it one of the most efficient sorting algorithms. It
also has a space complexity of `O(log n)`, making it a very efficient algorithm.

## Conclusion

Quicksort is a simple and efficient sorting algorithm that has many real-world implications. It is widely used and has a
time complexity of `O(n log n)` on average, making it one of the most efficient sorting algorithms.