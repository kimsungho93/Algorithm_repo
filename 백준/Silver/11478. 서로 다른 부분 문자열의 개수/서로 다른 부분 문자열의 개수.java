import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        Trie trie = new Trie();
        for (int i = 0; i < S.length(); i++) {
            trie.insert(S.substring(i));
        }

        System.out.println(trie.countDistinctSubstrings());
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.isEndOfWord = true;
    }

    public int countDistinctSubstrings() {
        return countDistinctSubstrings(root) - 1; 
    }

    private int countDistinctSubstrings(TrieNode node) {
        int count = 1; 
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.containsKey(c)) {
                count += countDistinctSubstrings(node.get(c));
            }
        }
        return count;
    }
}