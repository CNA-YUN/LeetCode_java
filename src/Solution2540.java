public class Solution2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                i++;
            }else if (nums1[i] > nums2[j]) {
                j++;
            }else {
                return nums1[i];
            }
        }
        return -1;
    }
}
