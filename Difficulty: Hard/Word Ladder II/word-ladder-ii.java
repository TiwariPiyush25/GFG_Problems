// User function Template for Java

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String beginWord,
                                                      String endWord,
                                                      String[] wordList) {
       HashSet<String> set = new HashSet<>();
        for(String s:wordList){
            set.add(s);
        } 

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> begin = new ArrayList<>();
        begin.add(beginWord);
        q.add(begin);
        set.remove(beginWord);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        int level = 0;


        while(!q.isEmpty()){
            ArrayList<String> list = q.remove();

            if(list.size() > level){
                level++;

                for(String s:usedOnLevel){
                    set.remove(s);
                }
                usedOnLevel.clear();
            }

            String word = list.get(list.size()-1);
            if(word.equals(endWord)) {
                if(ans.size() == 0) ans.add(list);
                else if(ans.get(0).size() == list.size()) ans.add(list);
            }

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] arr = word.toCharArray();
                    arr[i] = ch;
                    String newString = new String(arr);

                    if(set.contains(newString)){
                        list.add(newString);

                        ArrayList<String> temp = new ArrayList<>(list);
                        q.add(temp);

                        usedOnLevel.add(newString);
                        list.remove(list.size()-1);
                    }
                }
            }
        }

        return ans;
    }
}