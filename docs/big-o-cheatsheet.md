
# 📊 Big-O Algorithm Complexity Cheat Sheet

**Know Thy Complexities!**  
Source: [bigocheatsheet.com](https://www.bigocheatsheet.com)

---

## 🧠 Big-O Complexity Chart

| Rating     | Complexity Class       |
|------------|------------------------|
| Excellent  | O(1), O(log n)         |
| Good       | O(n)                   |
| Fair       | O(n log n)             |
| Bad        | O(n²)                  |
| Horrible   | O(2ⁿ), O(n!)           |

---

## 📦 Common Data Structure Operations

### Time & Space Complexities

| Data Structure       | Access Avg | Search Avg | Insertion Avg | Deletion Avg | Access Worst | Search Worst | Insertion Worst | Deletion Worst | Space Worst |
|----------------------|------------|-------------|----------------|----------------|---------------|----------------|------------------|------------------|---------------|
| Array                | Θ(1)       | Θ(n)        | Θ(n)           | Θ(n)           | O(1)          | O(n)           | O(n)             | O(n)             | O(n)          |
| Stack                | Θ(n)       | Θ(n)        | Θ(1)           | Θ(1)           | O(n)          | O(n)           | O(1)             | O(1)             | O(n)          |
| Queue                | Θ(n)       | Θ(n)        | Θ(1)           | Θ(1)           | O(n)          | O(n)           | O(1)             | O(1)             | O(n)          |
| Singly-Linked List   | Θ(n)       | Θ(n)        | Θ(1)           | Θ(1)           | O(n)          | O(n)           | O(1)             | O(1)             | O(n)          |
| Doubly-Linked List   | Θ(n)       | Θ(n)        | Θ(1)           | Θ(1)           | O(n)          | O(n)           | O(1)             | O(1)             | O(n)          |
| Skip List            | Θ(log n)   | Θ(log n)    | Θ(log n)       | Θ(log n)       | O(n)          | O(n)           | O(n)             | O(n)             | O(n log n)    |
| Hash Table           | N/A        | Θ(1)        | Θ(1)           | Θ(1)           | N/A           | O(n)           | O(n)             | O(n)             | O(n)          |
| Binary Search Tree   | Θ(log n)   | Θ(log n)    | Θ(log n)       | Θ(log n)       | O(n)          | O(n)           | O(n)             | O(n)             | O(n)          |
| Cartesian Tree       | N/A        | Θ(log n)    | Θ(log n)       | Θ(log n)       | N/A           | O(n)           | O(n)             | O(n)             | O(n)          |
| B-Tree               | Θ(log n)   | Θ(log n)    | Θ(log n)       | Θ(log n)       | O(log n)      | O(log n)       | O(log n)         | O(log n)         | O(n)          |
| Red-Black Tree       | Θ(log n)   | Θ(log n)    | Θ(log n)       | Θ(log n)       | O(log n)      | O(log n)       | O(log n)         | O(log n)         | O(n)          |
| Splay Tree           | N/A        | Θ(log n)    | Θ(log n)       | Θ(log n)       | N/A           | O(log n)       | O(log n)         | O(log n)         | O(n)          |
| AVL Tree             | Θ(log n)   | Θ(log n)    | Θ(log n)       | Θ(log n)       | O(log n)      | O(log n)       | O(log n)         | O(log n)         | O(n)          |
| KD Tree              | Θ(log n)   | Θ(log n)    | Θ(log n)       | Θ(log n)       | O(n)          | O(n)           | O(n)             | O(n)             | O(n)          |

---

## 🔃 Array Sorting Algorithms

| Algorithm       | Best       | Average      | Worst       | Space       |
|------------------|------------|--------------|-------------|-------------|
| Quicksort        | Ω(n log n) | Θ(n log n)   | O(n²)       | O(log n)    |
| Mergesort        | Ω(n log n) | Θ(n log n)   | O(n log n)  | O(n)        |
| Timsort          | Ω(n)       | Θ(n log n)   | O(n log n)  | O(n)        |
| Heapsort         | Ω(n log n) | Θ(n log n)   | O(n log n)  | O(1)        |
| Bubble Sort      | Ω(n)       | Θ(n²)        | O(n²)       | O(1)        |
| Insertion Sort   | Ω(n)       | Θ(n²)        | O(n²)       | O(1)        |
| Selection Sort   | Ω(n²)      | Θ(n²)        | O(n²)       | O(1)        |
| Tree Sort        | Ω(n log n) | Θ(n log n)   | O(n²)       | O(n)        |
| Shell Sort       | Ω(n log n) | Θ(n(log n)²) | O(n(log n)²)| O(1)        |
| Bucket Sort      | Ω(n + k)   | Θ(n + k)     | O(n²)       | O(n)        |
| Radix Sort       | Ω(nk)      | Θ(nk)        | O(nk)       | O(n + k)    |
| Counting Sort    | Ω(n + k)   | Θ(n + k)     | O(n + k)    | O(k)        |
| Cubesort         | Ω(n)       | Θ(n log n)   | O(n log n)  | O(n)        |

---

## 🔗 References

- [Array](http://en.wikipedia.org/wiki/Array_data_structure)
- [Stack](http://en.wikipedia.org/wiki/Stack_(abstract_data_type))
- [Queue](http://en.wikipedia.org/wiki/Queue_(abstract_data_type))
- [Singly Linked List](http://en.wikipedia.org/wiki/Singly_linked_list#Singly_linked_lists)
- [Doubly Linked List](http://en.wikipedia.org/wiki/Doubly_linked_list)
- [Skip List](http://en.wikipedia.org/wiki/Skip_list)
- [Hash Table](http://en.wikipedia.org/wiki/Hash_table)
- [Binary Search Tree](http://en.wikipedia.org/wiki/Binary_search_tree)
- [Cartesian Tree](https://en.wikipedia.org/wiki/Cartesian_tree)
- [B-Tree](http://en.wikipedia.org/wiki/B_tree)
- [Red-Black Tree](http://en.wikipedia.org/wiki/Red-black_tree)
- [Splay Tree](https://en.wikipedia.org/wiki/Splay_tree)
- [AVL Tree](http://en.wikipedia.org/wiki/AVL_tree)
- [KD Tree](http://en.wikipedia.org/wiki/K-d_tree)
- [Quicksort](http://en.wikipedia.org/wiki/Quicksort)
- [Merge Sort](http://en.wikipedia.org/wiki/Merge_sort)
- [Timsort](http://en.wikipedia.org/wiki/Timsort)
- [Heapsort](http://en.wikipedia.org/wiki/Heapsort)
- [Bubble Sort](http://en.wikipedia.org/wiki/Bubble_sort)
- [Insertion Sort](http://en.wikipedia.org/wiki/Insertion_sort)
- [Selection Sort](http://en.wikipedia.org/wiki/Selection_sort)
- [Tree Sort](https://en.wikipedia.org/wiki/Tree_sort)
- [Shell Sort](http://en.wikipedia.org/wiki/Shellsort)
- [Bucket Sort](http://en.wikipedia.org/wiki/Bucket_sort)
- [Radix Sort](http://en.wikipedia.org/wiki/Radix_sort)
- [Counting Sort](https://en.wikipedia.org/wiki/Counting_sort)
- [Cubesort](https://en.wikipedia.org/wiki/Cubesort)
