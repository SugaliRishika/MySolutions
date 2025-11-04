class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int ans[]= new int[n-k+1];

        Map<Integer,Integer> freq=new HashMap<>();

        for(int i=0;i<k;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        ans[0]=computeXSum(freq,nums,0,k,x);

        for(int i=k;i<n;i++){
            int out=nums[i-k];
            int in=nums[i];

            freq.put(out,freq.get(out)-1);
            if(freq.get(out)==0) freq.remove(out);
            freq.put(in,freq.getOrDefault(in,0)+1);
            ans[i-k+1]=computeXSum(freq,nums,i-k+1,i+1,x);
        }
        return ans;
    }

    private int computeXSum(Map<Integer,Integer> freq,int[] nums,int start,int end,int x){
        List<int[]> list=new ArrayList<>();
        for(var e:freq.entrySet()){
            list.add(new int[]{e.getKey(),e.getValue()});
        }

        list.sort((a,b)->{
            if(b[1]==a[1]) return b[0]-a[0];
            return b[1]-a[1];
        });

        Set<Integer> top=new HashSet<>();
        for(int i=0;i<Math.min(x,list.size());i++){
            top.add(list.get(i)[0]);
        }

        int sum=0;
        for(int i=start;i<end;i++){
            if(top.contains(nums[i])) sum+=nums[i];
        }
        return sum;
    }
}
