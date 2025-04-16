package lab;
import java.util.*;

public class PatentMaxFlowFordFulkerson {

    private double value;  // total max flow
    private boolean[] marked;
    private PatentFlowNetwork.FlowEdge[] edgeTo;

    public PatentMaxFlowFordFulkerson(PatentFlowNetwork G, Patent source, Patent sink) {
        int s = G.getPatentIndex().getId(source);
        int t = G.getPatentIndex().getId(sink);

        value = 0.0;
        int pathCount = 0;

        while (true) {
            System.out.println("\n=== BFS Start ===");
            double bottleneck = bfs(G, s, t);

            if (bottleneck == 0) {
                System.out.println("No augmenting path found. Algorithm ends.");
                break;
            }

            pathCount++;
            System.out.println("▶ Augmenting Path #" + pathCount + " found with bottleneck = " + bottleneck);
            value += bottleneck;

            int v = t;
            while (v != s) {
                PatentFlowNetwork.FlowEdge e = edgeTo[v];
                e.addResidualFlowTo(v, bottleneck);
                System.out.println(" - Updating flow along edge: " + e + " → added " + bottleneck);
                v = e.from();
            }

            System.out.println(">> Total flow so far = " + value);
        }

        System.out.println("=== Max Flow Complete. Final value: " + value + " ===");
    }

    private double bfs(PatentFlowNetwork G, int s, int t) {
        marked = new boolean[G.V()];
        edgeTo = new PatentFlowNetwork.FlowEdge[G.V()];
        Arrays.fill(edgeTo, null);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        marked[s] = true;

        System.out.println("Start BFS from node: " + s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.println("Dequeued node: " + v + " | Queue: " + queue);

            for (PatentFlowNetwork.FlowEdge e : G.adj(v)) {
                int w = e.to();
                double resCap = e.residualCapacityTo(w);

                System.out.printf("  Checking edge %s → to: %d | marked[%d]=%b | residual=%.1f\n",
                                  e.toString(), w, w, marked[w], resCap);

                if (!marked[w] && resCap > 0) {
                    edgeTo[w] = e;
                    marked[w] = true;
                    queue.offer(w);
                    System.out.println("  ✔️  Edge valid. Enqueue " + w + " and set edgeTo[" + w + "] = " + e);

                    if (w == t) {
                        // Compute bottleneck
                        double bottleneck = Double.POSITIVE_INFINITY;
                        int x = t;
                        System.out.println("  ✅ Sink reached. Calculating bottleneck...");
                        while (x != s) {
                            PatentFlowNetwork.FlowEdge edge = edgeTo[x];
                            bottleneck = Math.min(bottleneck, edge.residualCapacityTo(x));
                            System.out.println("    Edge " + edge + " → residual to " + x + " = " + edge.residualCapacityTo(x));
                            x = edge.from();
                        }
                        return bottleneck;
                    }
                }
            }
        }

        return 0.0; // No path found
    }

    public double value() {
        return value;
    }
}
