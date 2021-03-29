package ln.practice;

import java.io.*;
import java.util.*;

public class BFS_Shortest_Reach {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] nodeAndEdge = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int node = nodeAndEdge[0];
            int edge = nodeAndEdge[1];

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < node; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < edge; i++) {
                int[] uv = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
                int u = uv[0];
                int v = uv[1];

                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            int source = Integer.parseInt(reader.readLine());
            int[] distaces = getDistanceFromSource(graph, source);
            for (int i : distaces) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int[] getDistanceFromSource(ArrayList<ArrayList<Integer>> graph, int source) {
        LinkedList<Integer> queue = new LinkedList<>();

        int[] distanceArr = new int[graph.size() + 1];
        for (int i = 1; i < distanceArr.length; i++) {
            distanceArr[i] = -1;
        }

        int distance = 6;
        queue.add(source);
        queue.add(null);


        HashMap<Integer, List<Integer>> distaceMap = new HashMap<>();

        while (!queue.isEmpty()) {
            Integer number = queue.poll();
            if (number == null) {

                if (queue.size() > 1) {
                    distance += 6;
                    queue.add(null);
                }

            } else {

                List<Integer> nodeList = graph.get(number);
                queue.addAll(nodeList);
                distaceMap.put(distance, nodeList);
            }

        }
        for (Map.Entry<Integer, List<Integer>> entry : distaceMap.entrySet()) {
            int dis = entry.getKey();
            List<Integer> nodes = entry.getValue();
            for (int node : nodes) {
                distanceArr[node] = dis;
            }
        }
        return distanceArr;
    }
}