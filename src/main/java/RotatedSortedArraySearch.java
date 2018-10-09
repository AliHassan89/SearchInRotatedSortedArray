/**

 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

 You are given a target value to search. If found in the array, return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Input : [4 5 6 7 0 1 2] and target = 4
 Output : 0

 Solution:

 - Look for the pivot in the rotated sorted array.
 - If the array is not rotated then pivot is returned as -1.
 - Perform binary search on the array.

 */
package main.java;

public class RotatedSortedArraySearch {

  public static void main(String[] args) {
    int[] arr = {4,5,6,7,0,1,2};

    System.out.println(search(arr, 4));
  }


  public static int search(int[] nums, int target) {
    if (nums.length == 0)
      return -1;

    int pivot = findPivot(nums, 0, nums.length-1);
    if (pivot == -1)
      return binarySearch(nums, target, 0, nums.length);
    if (nums[pivot] == target)
      return pivot;
    if (nums[0] <= target)
      return binarySearch(nums, target, 0, pivot-1);
    return binarySearch(nums, target, pivot, nums.length);
  }

  private static int findPivot(int[] nums, int low, int high) {
    if (high < low)
      return -1;
    if (high == low)
      return low;

    int mid = (high + low)/2;
    if (mid < high && nums[mid] > nums[mid + 1])
      return mid + 1;

    if (mid > low && nums[mid] < nums[mid - 1])
      return mid - 1;

    if (nums[low] >= nums[mid])
      return findPivot(nums, low, mid-1);

    return findPivot(nums, mid+1, high);
  }

  private static int binarySearch(int[] nums, int target, int low, int high) {
    if (high < low)
      return -1;

    int mid = (low + high) / 2;
    if (nums[mid] == target)
      return mid;

    if (nums[mid] < target)
      return binarySearch(nums, target, mid+1, high);

    return binarySearch(nums, target, low, mid-1);
  }
}
