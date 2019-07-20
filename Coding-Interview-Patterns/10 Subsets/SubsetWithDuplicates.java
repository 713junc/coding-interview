/*
Pattern: Subsets
02 Subsets with Duplicates (easy)

Given a set of numbers that might contain duplicates, find all of its distinct subsets.
Input: [1, 3, 3]
Output: [], [1], [3], [1,3], [3,3], [1,3,3]

# LeetCode 90. Subsets II [Medium]
[Result]
Runtime: 1 ms, faster than 100.00% of Java online submissions for Subsets II.
Memory Usage: 36.4 MB, less than 99.28% of Java online submissions for Subsets II.
*/

class SubsetWithDuplicates {
  public List<List<Integer>> findSubsets(int[] nums){
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());

    Arrays.sort(nums);
    int start = 0, end = 0;
    for(int i=0; i<nums.length; i++){
      start = 0;
      if(i > 0 && nums[i] == nums[i-1]){
        start = end + 1;
      }

      end = subsets.size()-1;
      for(int j=start; j <= end; j++){
        List<Integer> set = new ArrayList<>(subsets.get(j));
        set.add(nums[i]);
        subsets.add(set);
      }
    }
    return subsets;
  }/*
  Time Complexity: O(2^N)
  ; Since, in each step, the number of subsets could double (if not duplicate) as we add each element to all the existing subsets
  Space Complexity: O(2^N)
  ; for output list
  */
}
