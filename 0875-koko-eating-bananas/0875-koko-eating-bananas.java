class Solution {

    private int findMax(int[] piles) {
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++) {
            maxi = Math.max(maxi, piles[i]);
        }

        return maxi;
    }

    private long calcTotalHours(int[] piles, int rate) {
        long totalHours = 0;

        for (int i = 0; i < piles.length; i++) {
            totalHours += (long) Math.ceil((double) piles[i] / rate);
        }

        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long totalHours = calcTotalHours(piles, mid);

            if (totalHours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}