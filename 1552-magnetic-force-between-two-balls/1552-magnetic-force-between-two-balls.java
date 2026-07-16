import java.util.Arrays;

class Solution {

    private boolean canWePlace(int[] position, int dist, int balls) {

        int n = position.length;

        int count = 1;
        int last = position[0];

        for (int i = 1; i < n; i++) {

            if (position[i] - last >= dist) {
                count++;
                last = position[i];
            }

            if (count >= balls)
                return true;
        }

        return false;
    }

    public int maxDistance(int[] position, int m) {

        int n = position.length;

        Arrays.sort(position);

        int low = 1;
        int high = position[n - 1] - position[0];

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canWePlace(position, mid, m)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}