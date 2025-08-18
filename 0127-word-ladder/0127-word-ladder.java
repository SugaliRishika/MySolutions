class Pair{
    String first;
    int second;
    Pair(String first1,int second1){
        this.first=first1;
        this.second=second1;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue=new LinkedList<>();
        Set<String> set= new HashSet<String>();
        queue.add(new Pair(beginWord,1));
        int len=wordList.size();
        for(int i=0;i<len;i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!queue.isEmpty()){
            String word= queue.peek().first;
            int step=queue.peek().second;
            queue.remove();
            if(word.equals(endWord)) return step;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedAll=word.toCharArray();
                    replacedAll[i]=ch;
                    String replacedAllChar= new String(replacedAll);
                    if(set.contains(replacedAllChar)){
                        set.remove(replacedAllChar);
                        queue.add(new Pair(replacedAllChar,step+1));
                    }
                }
            }
        }
        return 0;
    }
}
