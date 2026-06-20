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

    static Node root;// always Empty only contains children value

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
    public static int countNodes(Node root){
        if (root == null) return 0;

        int count = 0;
        for (int i = 0;i < 26;i++){
            if (root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }

        return 1 + count;
    }
    public static int countSubs(String s) {
        root = new Node(); 
        for (int i = 0;i < s.length();i++){
            String suff = s.substring(i);
            insert(suff);
        }

        return countNodes(root) - 1;
    }
}