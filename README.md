# SearchInRotatedSortedArray
Suppose a sorted array is rotated at some pivot unknown to you beforehand.


 (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

 You are given a target value to search. If found in the array, return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
```
 Input : [4 5 6 7 0 1 2] and target = 4
 Output : 0
```
 Solution:
```
 - Look for the pivot in the rotated sorted array.
 - If the array is not rotated then pivot is returned as -1.
 - Perform binary search on the array.
```
