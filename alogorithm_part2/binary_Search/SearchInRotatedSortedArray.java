package alogorithm_part2.binary_Search;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 0, 1, 2};
        int target = 1;

        int search = search(nums, target);
        System.out.println("search = " + search);

    }

    public static int search(int[] nums, int target) {
        //우선 pivot, 최소값 찾기
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int pivot = left;

        //이진검색 시작
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midPivot = (mid + pivot) % nums.length;

            if (nums[midPivot] < target) {
                left = mid + 1;
            } else if (nums[midPivot] > target) {
                right = mid - 1;
            } else {
                return midPivot;
            }
        }

        return -1;
    }
}
