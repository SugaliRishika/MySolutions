class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));

        for(int i=0;i<points.length;i++){
            int dist=points[i][0]*points[i][0]+points[i][1]*points[i][1];
            minHeap.offer(new int[]{dist,i});

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int[][] result=new int[k][2];
        int index=0;
        while(!minHeap.isEmpty()){
            int point_index=minHeap.poll()[1];
            result[index++]=points[point_index];
        }
        return result;
    }
}