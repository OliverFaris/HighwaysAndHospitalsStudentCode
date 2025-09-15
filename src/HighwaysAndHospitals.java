import java.util.ArrayList;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Oliver Faris
 *
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // If hospitals are cheaper or the same cost as a highway, it's ultimately cheaper to have a hospital in every city
        if (hospitalCost <= highwayCost) {
            return (long) n *hospitalCost;
        }
        int minimumCost = 0;
        // ArrayList<Integer> numGroups = new ArrayList<>();
        int[][] numGroups = new int[4][4];
        for (int i=0; i < cities.length; i++) {
            if (cities[i][0] == 0) {

            }
        }

        return 0;
    }
}
