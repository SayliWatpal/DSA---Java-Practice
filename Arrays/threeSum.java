/*
Problem: 3Sum
Platform: LeetCode 15
Difficulty: Medium

Approach:
The idea is to generate every possible triplet in the array and check whether
the sum of the three elements is equal to 0.

Since different combinations can produce the same triplet, we use a HashSet
to store only unique triplets. Before inserting a triplet into the HashSet,
we sort it so that triplets containing the same elements are stored in the
same order, allowing the HashSet to identify and remove duplicates.

Step-by-step:
1. Run the first loop with index 'i' to select the first element.
2. Run the second loop with index 'j' (starting from i+1) to select the second element.
3. Run the third loop with index 'k' (starting from j+1) to select the third element.
4. Calculate the sum of array[i] + array[j] + array[k].
5. If the sum equals 0:
      → Create a new list containing the three elements.
      → Sort the triplet.
      → Insert the sorted triplet into the HashSet.
6. After checking all possible triplets, convert the HashSet into a List (if required) and return the result.

Time Complexity: O(n³)
Space Complexity: O(k)
(where k is the number of unique triplets stored in the HashSet)
*/



import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {-1,0,1,2,-1,-4};
       List<List<Integer>> ans = threeSum(array);
        System.out.println(ans);
    }

    public static List<List<Integer>> threeSum(int[] array) {
        int n = array.length;
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                   int sum = array[i] + array[j] + array[k];
                   if(sum == 0){
                       List<Integer> curr = new ArrayList<>();
                       curr.add(array[i]);
                       curr.add(array[j]);
                       curr.add(array[k]);
                       Collections.sort(curr);
                       ans.add(curr);
                   }
                }
            }

        }
        return new ArrayList<>(ans);
    }
}

/*
Problem: 3Sum
Platform: LeetCode 15
Difficulty: Medium

Approach:
The idea is to first sort the array and then fix one element at a time.
For every fixed element, use the two-pointer technique to find the other
two elements whose sum equals the negative of the fixed element.

Since the array is sorted, we can efficiently move the left and right
pointers based on the current sum. Duplicate triplets are avoided by
skipping repeated elements.

Step-by-step:
1. Sort the array in ascending order.
2. Traverse the array using index 'i' to fix the first element of the triplet.
3. If the current element is the same as the previous one, skip it to avoid duplicate triplets.
4. Initialize two pointers:
      → left = i + 1
      → right = n - 1
5. While left < right:
      → Calculate sum = array[i] + array[left] + array[right].
      → If sum == 0:
           - Add the triplet to the answer.
           - Move both pointers inward.
           - Skip duplicate values at the left pointer.
           - Skip duplicate values at the right pointer.
      → If sum < 0:
           - Move the left pointer to increase the sum.
      → If sum > 0:
           - Move the right pointer to decrease the sum.
6. Repeat the process until all possible triplets have been checked.
7. Return the list of unique triplets.

Time Complexity: O(n²)
Space Complexity: O(1) (excluding the output list)
*/


import java.util.*;

public class practice {
    public static void main(String[] args) {
        int[] array = {-1,0,1,2,-1,-4};
       List<List<Integer>> ans = threeSum(array);
        System.out.println(ans);
    }

    public static List<List<Integer>> threeSum(int[] array) {
        int n = array.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(array);
        for(int i=0;i<n-2;i++){
            if(i > 0 && array[i] == array[i-1]) continue;
            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum = array[i] + array[left] + array[right];
                if(sum == 0){
                    ans.add(Arrays.asList(array[i],array[left],array[right]));
                    left++;
                    right--;

                    while(left<right && array[left] == array[left - 1]) left++;
                    while(left<right && array[right] == array[right+1]) right--;
                }
                else if(sum > 0){
                    right --;
                }
                else{
                    left++;
                }
            }
        }
        return ans;
    }
}






