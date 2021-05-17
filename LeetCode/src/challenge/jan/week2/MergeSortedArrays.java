package challenge.jan.week2;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int t = 0; t < n; t++) {
                nums1[t] = nums2[t];
            }
            return;
        }
        int i = 0;
        int j = 0;
        int[] res = new int[m+n];
        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] == nums2[j]) {
                res[k++] = nums1[i++];
                res[k++] = nums2[j++];
            } else if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        while (i < m) {
            res[k++] = nums1[i++];
        }
        while (j < n) {
            res[k++] = nums2[j++];
        }
        for (int t = 0; t < res.length; t++) {
            nums1[t] = res[t];
        }
    }
}
