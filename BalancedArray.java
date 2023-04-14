import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/*
*Given an array of numbers, find the index of the smallest array element (the pivot), for which the
sums of all elements to the left and to the right are equal. The array may not be reordered.
Example arr=[1,2,3,4,6]
the sum of the first three elements, 1+2+3=6. The value of the last element is 6.
Using zero based indexing, arr[3]=4 is the pivot between the two subarrays.
The index of the pivot is 3.
*/

public class BalancedArray {
    /**
     *
     * @param arr :  an array of integers
     * @return int: an integer representing the index of the pivot
     * Constraints
     * 3 ≤ n ≤ 10
     * 1 ≤ arr[i] ≤ 2 × 10 , where 0 ≤ i < n
     * It is guaranteed that a solution always exists.
     */
    public int balancedSum(int arr[]){
        if(arr==null || arr.length==0)
            return -1;
        int n = arr.length;
        AtomicInteger curSum = new AtomicInteger(0);
        int sum[] = Arrays.stream(arr).map(i -> curSum.addAndGet(i)).toArray();
        int leftSum, rightSum;
        for(int i=0;i<n;i++){
            leftSum = sum[i] - arr[i];
            rightSum = sum[n-1] - sum[i];
            if(leftSum == rightSum)
                return i;
        }
        return -1;
    }
}
