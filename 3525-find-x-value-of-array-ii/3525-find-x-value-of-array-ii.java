class Solution {
    class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            prod = 1;
            cnt = new int[k];
        }
    }

    int k;
    Node[] tree;
    int n;

    Node merge(Node a, Node b) {
        Node res = new Node(k);

        res.prod = (a.prod * b.prod) % k;

        for (int i = 0; i < k; i++) {
            res.cnt[i] += a.cnt[i];
            res.cnt[(a.prod * i) % k] += b.cnt[i];
        }

        return res;
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            tree[node] = new Node(k);
            int val = nums[l] % k;
            tree[node].prod = val;
            tree[node].cnt[val] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            tree[node] = new Node(k);
            val %= k;
            tree[node].prod = val;
            tree[node].cnt[val] = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid) {
            update(node * 2, l, mid, idx, val);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, val);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node query(int node, int l, int r, int start) {
        if (r < start) return null;

        if (l >= start) return tree[node];

        int mid = (l + r) / 2;

        Node a = query(node * 2, l, mid, start);
        Node b = query(node * 2 + 1, mid + 1, r, start);

        if (a == null) return b;
        if (b == null) return a;

        return merge(a, b);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        this.n = nums.length;

        int[][] veltrunigo = queries;

        tree = new Node[4 * n];
        build(1, 0, n - 1, nums);

        int[] ans = new int[veltrunigo.length];

        for (int i = 0; i < veltrunigo.length; i++) {
            int index = veltrunigo[i][0];
            int value = veltrunigo[i][1];
            int start = veltrunigo[i][2];
            int x = veltrunigo[i][3];

            update(1, 0, n - 1, index, value);

            Node res = query(1, 0, n - 1, start);

            ans[i] = res.cnt[x];
        }

        return ans;
    }
}