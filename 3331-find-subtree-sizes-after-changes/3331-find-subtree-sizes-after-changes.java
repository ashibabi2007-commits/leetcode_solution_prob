import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = s.length();
        List<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        findNewParents(0, s, children, newParent, lastSeen);

        List<Integer>[] newChildren = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            newChildren[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            newChildren[newParent[i]].add(i);
        }

        int[] ans = new int[n];
        computeSubtreeSize(0, newChildren, ans);
        return ans;
    }

    private void findNewParents(
            int u,
            String s,
            List<Integer>[] children,
            int[] newParent,
            int[] lastSeen
    ) {
        int c = s.charAt(u) - 'a';
        if (lastSeen[c] != -1) {
            newParent[u] = lastSeen[c];
        }

        int prev = lastSeen[c];
        lastSeen[c] = u;
        for (int v : children[u]) {
            findNewParents(v, s, children, newParent, lastSeen);
        }
        lastSeen[c] = prev;
    }

    private int computeSubtreeSize(int u, List<Integer>[] newChildren, int[] ans) {
        int size = 1;
        for (int v : newChildren[u]) {
            size += computeSubtreeSize(v, newChildren, ans);
        }
        ans[u] = size;
        return size;
    }
}