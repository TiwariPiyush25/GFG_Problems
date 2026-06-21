class Solution {
    static class Node{
        Node[] children;
        boolean endOfWord;

        public Node(){
            children = new Node[26];
            Arrays.fill(children, null);
            endOfWord = false;
        }
    }

    static Node root; // always Empty only contains children value

    public static void insert(String word){
        Node node = root;
        for (int i = 0;i < word.length();i++){ // O(L)
            int idx = word.charAt(i) - 'a';

            if (node.children[idx] == null){ // add new Node
                node.children[idx] = new Node();
            }
            if (i == word.length()-1) node.children[idx].endOfWord = true;
            node = node.children[idx];
        }
    }

    public static boolean search(String word){
        Node node = root;
        for (int i = 0;i < word.length();i++){ // O(L)
            int idx = word.charAt(i) - 'a';

            if (node.children[idx] == null) return false;
            if (i == word.length()-1 && node.children[idx].endOfWord == false) return false;

            node = node.children[idx];
        }

        return true;
    }
    public static String ans;
    public static void longestword(Node root,StringBuilder temp){
        if(root == null) return;

        for (int i = 0;i < 26;i++){
            if (root.children[i] != null && root.children[i].endOfWord == true){
                temp.append((char)(i+'a'));
                if (temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestword(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1); // backtrack
            }
        }
    }
    public String longestValidWord(String[] words) {
        root = new Node();
        ans = "";
        for (String word : words) insert(word);
        longestword(root,new StringBuilder());
        
        return ans;
    }
}