import java.util.*;
public class CyclicDetection {
    static class Edge{
        int dest ;
        int src ;
        int wt ;

        public Edge(int s, int d , int w){
            this.src = s;
            this.dest = d;
            this.wt = w ;
        }
    }

    public static void createGraph(ArrayList<Edge> [] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex - 0
        graph[0].add(new Edge(0, 1, 1));

        // vertex - 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // vertex - 2
        graph[2].add(new Edge(2, 3, 1));

        // vertex - 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 4, 1));

        // vertex - 4
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // vertex - 5
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // vertex - 6
        graph[6].add(new Edge(6, 5, 1));

        // vertex - 7
        graph[7].add(new Edge(7, 8, 1));

        // vertex - 8
        graph[8].add(new Edge(8, 7, 1));
        graph[8].add(new Edge(8, 9, 1));
        graph[8].add(new Edge(8, 11, 1));

        // vertex - 9
        graph[9].add(new Edge(9, 8, 1));
        graph[9].add(new Edge(9, 10, 1));

        // vertex - 10
        graph[10].add(new Edge(10, 9, 1));
        graph[10].add(new Edge(10, 12, 1));

        // vertex - 11
        graph[11].add(new Edge(11, 8, 1));
        graph[11].add(new Edge(11, 12, 1));

        // vertex - 12
        graph[12].add(new Edge(12, 10, 1));
        graph[12].add(new Edge(12, 11, 1));
        graph[12].add(new Edge(12, 13, 1));

        // vertex - 13
        graph[13].add(new Edge(13, 12, 1));
        graph[13].add(new Edge(13, 14, 1));
        graph[13].add(new Edge(13, 15, 1));

        // vertex - 14
        graph[14].add(new Edge(14, 13, 1));

        // vertex - 15
        graph[15].add(new Edge(15, 13, 1));

    }


    public static boolean cyclicDetection(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if(cyclicDetectionUtil(graph, i , visited , -1 )){
                    return true ;
                }
            }
        }
        return false ;
    }

    public static boolean cyclicDetectionUtil(ArrayList<Edge>[] graph , int src , boolean[] visited , int par){
        visited[src] = true;
        for (int i = 0; i < graph[src].size() ; i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.dest]) {
                if(cyclicDetectionUtil(graph , e.dest , visited , src)){
                    return true;
                }
            } else if (visited[e.dest] &&  e.dest != par) {
                return true ;
            }
        }
        return false ;
    }

    public static void main(String[] args) {


        //           (component - 1)                       9            14   (components -2)
        //      0                                         / \           /
        //      |     2                                  /   \         /
        //      |     |                                 8     10     13
        //      1 --- 3 ---- 4 ---- 5 ---- 6           / \      \   /  \
        //                                            /   \      \ /    \
        //                                           7     11----12       15
        //
        // graph is combination of components so, above is only one graph


        int v = 16 ;
        ArrayList<Edge> [] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(cyclicDetection(graph));
    }
}

// output
// true

//   note - if you want to print false then we remove cycle form the graph so cooment out 
//          line no 64 and 68 lines form the code it remove the edge between 11 and 12.......
//          graph[11].add(new Edge(11, 12, 1));  line no 64
//          graph[12].add(new Edge(12, 11, 1));  line no 68


