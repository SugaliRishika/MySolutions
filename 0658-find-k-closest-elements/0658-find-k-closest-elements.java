class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(
            (a,b)->{
                int diff1=Math.abs(a-x);
                int diff2=Math.abs(b-x);
                if(diff1==diff2) return b-a;
                return diff2-diff1;
            }
        );

        for(int num:arr){
            minHeap.offer(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        List<Integer> result=new ArrayList<>(minHeap);
        Collections.sort(result);
        return result;
    }
}