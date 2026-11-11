class Solution3789 {

    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // 先全部提升为 long，后续运算都是 64 位
        long x = cost1, y = cost2, z = costBoth;
        long a = need1, b = need2;

        // 方案一：全部单独购买
        long c1 = a * x + b * y;

        // 方案二：全部按对购买（多买没关系，能配成对）
        long c2 = Math.max(a, b) * z;

        // 若单独买两个比打包买还便宜，则不会出现"部分配对"更优的情况
        if (x + y <= z) {
            return Math.min(c1, c2);
        }

        // 方案三：少的那个全部配对买，多出来的差额单独买
        long c3 = a <= b ? z * a + y * (b - a)
                : z * b + x * (a - b);

        return Math.min(c1, Math.min(c2, c3));
    }

}