class Solution {

    private boolean possible(int[] bloomDay, int day, int m, int k) {
        int n = bloomDay.length;

        int count = 0;
        int bouquets = 0;

        for (int i = 0; i < n; i++) {

            // Flower has bloomed by the given day
            if (bloomDay[i] <= day) {
                count++;
            } else {
                // Current consecutive group has ended
                bouquets += count / k;
                count = 0;
            }
        }

        // Handle the final consecutive group
        bouquets += count / k;

        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        long requiredFlowers = (long) m * k;

        // Not enough flowers
        if (requiredFlowers > n) {
            return -1;
        }

        int minimumDay = Integer.MAX_VALUE;
        int maximumDay = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            minimumDay = Math.min(minimumDay, bloomDay[i]);
            maximumDay = Math.max(maximumDay, bloomDay[i]);
        }

        int low = minimumDay;
        int high = maximumDay;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (possible(bloomDay, mid, m, k)) {
                // mid is valid; search for an earlier day
                high = mid - 1;
            } else {
                // mid is too early
                low = mid + 1;
            }
        }

        return low;
    }
}