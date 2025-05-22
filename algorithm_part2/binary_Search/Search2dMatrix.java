package algorithm_part2.binary_Search;

public class Search2dMatrix {

    public static void main(String[] args) {

        int [][] matrix = {
                {1, 4, 7, 11, 16},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 31}
        };

        boolean b = searchMatrix(matrix, 22);
        System.out.println("b = " + b);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length - 1;

        while (left < matrix.length && right >= 0) {

            if (matrix[left][right] > target) {
                right--;
            } else if (matrix[left][right] < target) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }

}
