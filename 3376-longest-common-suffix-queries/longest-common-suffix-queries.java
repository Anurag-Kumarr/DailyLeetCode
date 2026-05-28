class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestIndex = -1;
    }
    TrieNode root = new TrieNode();
    private int better(int curr, int next, String[] wordsContainer) {
        if (curr == -1) return next;

        if (wordsContainer[next].length() < wordsContainer[curr].length()) {
            return next;
        }
        return curr;
    }
    private void insert(String word, int index, String[] wordsContainer) {
        TrieNode node = root;
        node.bestIndex = better(node.bestIndex, index, wordsContainer);

        for (int i = word.length() - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';

            if (node.children[ch] == null) {
                node.children[ch] = new TrieNode();
            }

            node = node.children[ch];
            node.bestIndex = better(node.bestIndex, index, wordsContainer);
        }
    }
    private int search(String query) {
        TrieNode node = root;

        for (int i = query.length() - 1; i >= 0; i--) {
            int ch = query.charAt(i) - 'a';

            if (node.children[ch] == null) {
                break;
            }

            node = node.children[ch];
        }

        return node.bestIndex;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i, wordsContainer);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}