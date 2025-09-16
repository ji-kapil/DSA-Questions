import java.util.ArrayList;

public class CreateGraph {
    static class Edge{
        int src, dest , Weight ;
        public Edge (int s , int d, int w){
            this.src = s;
            this.dest = d;
            this.Weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge> [] graph){
        for (int i = 0; i <graph.length ; i++) {
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
        graph[3].add(new Edge(3,4, 1));

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

    public static void print(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                System.out.print("{ src " + e.src + ", dest " + e.dest + ", weigth " + e.Weight + " } ");
            }
            System.out.println();
        }
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
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        print(graph);
    }
}

// output 
// { src 0, dest 1, weigth 1 } 
// { src 1, dest 0, weigth 1 } { src 1, dest 3, weigth 1 } 
// { src 2, dest 3, weigth 1 } 
// { src 3, dest 1, weigth 1 } { src 3, dest 2, weigth 1 } { src 3, dest 4, weigth 1 } 
// { src 4, dest 3, weigth 1 } { src 4, dest 5, weigth 1 } 
// { src 5, dest 4, weigth 1 } { src 5, dest 6, weigth 1 } 
// { src 6, dest 5, weigth 1 } 
// { src 7, dest 8, weigth 1 } 
// { src 8, dest 7, weigth 1 } { src 8, dest 9, weigth 1 } { src 8, dest 11, weigth 1 } 
// { src 9, dest 8, weigth 1 } { src 9, dest 10, weigth 1 } 
// { src 10, dest 9, weigth 1 } { src 10, dest 12, weigth 1 } 
// { src 11, dest 8, weigth 1 } { src 11, dest 12, weigth 1 } 
// { src 12, dest 10, weigth 1 } { src 12, dest 11, weigth 1 } { src 12, dest 13, weigth 1 } 
// { src 13, dest 12, weigth 1 } { src 13, dest 14, weigth 1 } { src 13, dest 15, weigth 1 } 
// { src 14, dest 13, weigth 1 } 
// { src 15, dest 13, weigth 1 } 


