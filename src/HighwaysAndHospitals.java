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
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // If hospitals are cheaper or the same cost as a highway, it's ultimately cheaper to have a hospital in every city
        if (hospitalCost <= highwayCost) {
            return (long) n *hospitalCost;
        }
        long minimumCost = 0;

        // The index is the node while the value is the root
        int[] nodes = new int[n+1];

        int a =0;
        int b =0;
        int firstRoot = 0;
        int secondRoot = 0;
        int temp = 0;

        for (int i=0; i < cities.length; i++) {
            a = cities[i][0];
            b = cities[i][1];
            firstRoot = a;
            secondRoot = b;

            // Find the root of the first node
            while (nodes[firstRoot] > 0) {
                firstRoot = nodes[firstRoot];
            }
            // Assign each lower node to have the same root from before
            while (nodes[a] > 0) {
                temp = nodes[a];
                nodes[a] = firstRoot;
                a = temp;
            }
            // Find the root of the second node
            while (nodes[secondRoot] > 0) {
                secondRoot = nodes[secondRoot];
            }
            // Assign each lower node to have the same root from before
            while (nodes[b] > 0) {
                temp = nodes[b];
                nodes[b] = secondRoot;
                b = temp;
            }

            // If the two roots aren't the same
            if (a != b) {
                // If root A has a larger order than root B
                if (nodes[a] < nodes[b]) {
                    // Add B's order to A's order and then make B's root A
                    nodes[a] += nodes[b] -1;
                    nodes[b] = a;
                }
                else {
                    // Add A's order to B's order and make A's root B
                    nodes[b] += nodes[a] -1;
                    nodes[a] = b;
                }
            }
        }

        int counter = 0;
        for (int i = 0; i < nodes.length -1; i++) {
            // If the node is its own root then it is one subgraph
            if (nodes[i+1] <= 0)
                counter++;
        }

        // You need one hospital per subgraph
        minimumCost += (long) hospitalCost * counter;
        // You need the amount of cities minus how many subgraphs there are highways
        minimumCost += (long) (n - counter) * highwayCost;
        return minimumCost;
    }
}
