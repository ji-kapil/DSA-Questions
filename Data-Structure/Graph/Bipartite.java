//   A Bipartite Graph is a graph whose vertices can be divided into two independent sets, 
//   U and V such that every edge (u, v) either connects a vertex from U to V or a vertex 
//   from V to U. In other words, for every edge (u, v), either u belongs to U and v to V, 
//   or u belongs to V and v to U. We can also say that there is no edge that connects 
//   vertices of same set.

//   Bonus - All acyclic graph and even number of node in cyclic graph always bipartite graph 
//   and odd number nodes node in cyclic graph is not bipartite graph....


import java.util.*;
public class Bipartite {
    static class Edge{
        int src, dest , Weight ;
        public Edge (int s , int d, int w){
            this.src = s;
            this.dest = d;
            this.Weight = w;
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


    public static boolean bipartite(ArrayList<Edge> [] graph){
        int[] colors = new int[graph.length];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i <graph.length ; i++) {
            if (colors[i] == -1) {
                q.add(i);
                colors[i] = 0 ; // black

                while (!q.isEmpty()){
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (colors[e.dest] == -1) {
                            int nextcol =  colors[curr]== 0 ? 1 : 0 ;
                            colors[e.dest] = nextcol;
                            q.add(e.dest);
                        } else if (colors[e.dest] == colors[curr]) {
                            return false ;
                        }
                    }
                }
            }
        }

        return true ;
    }


    public static void main(String[] args) {


        //           (component - 1)                       9            14   (components -2)
        //      0                                         / \           /
        //      |     2                                  /   \         /
        //      |     |                                 8     10     13
        //      1 --- 3 ---- 4 ---- 5 ---- 6           / \      \   /  \
        //                                            /   \      \ /    \
        //                                           7     11----12      15
        //
        // graph is combination of components so, above is only one graph


        int v = 16 ;
        ArrayList<Edge> [] graph = new ArrayList[v];
        createGraph(graph);
        System.out.println(bipartite(graph));        // output - false 

    }
}

//   note - if you want to print true then we remove cycle form the graph so comment out 
//          line no 63 and 67 lines form the code it remove the edge between 11 and 12.......
//          graph[10].add(new Edge(10, 12, 1));  line no 63
//          graph[12].add(new Edge(12, 10, 1));  line no 67   "then it become bipartite graph"
//
//

