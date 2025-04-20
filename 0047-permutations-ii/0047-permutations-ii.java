import java.util.*;
class Solution {
    public static void helper(List<List<Integer>> mainlist, List<Integer> list, boolean[] track, int[] nums, Set<List<Integer>> set) {
        if (nums.length == list.size()) {
            List<Integer> ll = new ArrayList<>(list); 
            if (!set.contains(ll)) { 
                mainlist.add(ll);
                set.add(ll);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!track[i]) { 
                list.add(nums[i]); 
                track[i] = true; 
                helper(mainlist, list, track, nums, set); 
                track[i] = false; 
                list.remove(list.size() - 1); 
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> mainlist = new ArrayList<>(); 
        List<Integer> list = new ArrayList<>(); 
        boolean[] track = new boolean[nums.length]; 
        helper(mainlist, list, track, nums, new HashSet<>()); 
        return mainlist; 
    }
}