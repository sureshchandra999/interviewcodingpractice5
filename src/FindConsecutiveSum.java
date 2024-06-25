import java.util.ArrayList;
import java.util.List;

public class FindConsecutiveSum {
    public static void main(String args[]) {
        System.out.println("a: "+findDuplicates(new int[]{2,3,6,5,4,3,3,3,8,1,2,9,1,1,1,4,7,2,1}, 3));
    }

    private static List<List<Integer>> findDuplicates(int[] arr, int val) {
        List<List<Integer>> resultList = new ArrayList<>();
        int start=0;
        int end=0;
        int currSum=0;
        int windowSize =3;
        while(start<=end) {

            currSum+=arr[end];

            if(currSum==val) {
                List<Integer> tempList = new ArrayList<>();
                if(end-start==0) {
                    tempList.add(end);
                } else {
                    tempList.add(start);
                    tempList.add(end);
                }
                resultList.add(tempList);
            } else if(currSum>val) {

                while(currSum>val && start<=end) {
                    currSum=currSum-arr[start];
                    start++;
                }
            }

            if(end-start==windowSize) {
                currSum=currSum-arr[start];
                start++;
            }
            end++;

        }
        return resultList;
    }
}
