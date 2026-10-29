public class Solution479 {
    private long mx;
    private long mn;

    public int largestPalindrome(int n) {
        // 特判 n=1，因为 generatePalindrome 生成的是偶数位回文，无法生成 9
        if (n == 1) {
            return 9;
        }

        mx = 1;
        for (int k = 0; k < n; k++) {
            mx *= 10;
        }
        mn = mx / 10;
        mx -= 1; // mx 现在是 n 位数的最大值，例如 n=2, mx=99

        // 从最大的 n 位数开始，作为回文数的左半部分
        for (long i = mx; i >= mn; i--) {
            long palindrome = generatePalindrome(i);
            
            // 检查这个回文数是否能分解为两个 n 位数的乘积
            if (check(palindrome)) {
                return (int) (palindrome % 1337);
            }
        }
        return 0;
    }

    private boolean check(long num) {
        // 从最大的 n 位数 mx 开始向下尝试作为因子
        // 优化：只需要尝试到 sqrt(num) 即可。
        // 因为如果 num = a * b，且 a <= b，那么 a <= sqrt(num) <= b。
        // 我们从大往小枚举 b (即这里的 i)。
        // 如果 i < num / i (即 i*i < num)，说明 i 已经小于 sqrt(num) 了。
        // 此时如果还没找到因子，说明不存在这样的因子对（因为较小的因子肯定 <= sqrt(num)，
        // 而我们在枚举较大因子时，如果存在解，较大因子肯定 >= sqrt(num)，应该已经被枚举到了）。
        
        for (long i = mx; i * i >= num; i--) {
            if (num % i == 0) {
                // i 是一个因子，检查另一个因子 num/i 是否也在 [mn, mx] 范围内
                // 由于 i <= mx 且 i*i >= num => i >= num/i，所以 num/i <= i <= mx。
                // 只需要检查 num/i >= mn 即可。
                if (num / i >= mn) {
                    return true;
                }
            }
        }
        return false;
    }

    private long generatePalindrome(long i) {
        long res = i;
        long temp = i;
        while (temp > 0) {
            res = res * 10 + temp % 10;
            temp /= 10;
        }
        return res;
    }
}
