package DAHUASHU.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Demo3 {
    public static void main(String[] args) {
        int vertexNum = 5;
        char[] vertexs = { 'a', 'b', 'c', 'd', 'e' };
        int[][] matrix = { { 0, 1, 1, 0, 1 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0 } };
        Graph g = new Graph(vertexNum, vertexs, matrix);
        for(char ch : topologicalSort(g)){
            System.out.print(ch);
        }
    }

    // 对有向无环图DAG(Directed Acyclic Graph)图的排序，AOV(Activity On Vertex)网即DAG图表示一个工程，那么其顶点表示活动
    public static ArrayList<Character> topologicalSort(Graph g) {
        ArrayList<Character> topologySerials = new ArrayList<Character>();
        int[] inDegree = getInDegree(g);
        Stack<Integer> s = new Stack<Integer>(); // 这是用来存放当前图中入度为零的顶点的容器(不一定要用栈,队列、List等都行)
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){ // 所有无前驱顶点的顶点入栈
                s.push(i);
            }
        }
        while(!s.isEmpty()){
            int v = s.pop();
            topologySerials.add(g.vertexs[v]);
            for(int i = 0; i < g.matrix.length; i++){
                if(g.matrix[v][i] != 0){ // 顶点i的前驱为顶点v
                    if(--inDegree[i] == 0){ // 顶点i已无前驱
                        s.push(i);
                    }
                }
            }

        }
        return topologySerials;
    }

    public static int[] getInDegree(Graph g) {
        int[] inDegree = new int[g.vertexNum];
        for (int i = 0; i < g.matrix.length; i++) {
            for (int ii = 0; ii < g.matrix.length; ii++) {
                if (g.matrix[ii][i] != 0) {
                    inDegree[i]++;
                }
            }
        }
        return inDegree;
    }

    private static class Graph {
        private int vertexNum;
        private char[] vertexs;
        private int[][] matrix;

        public Graph(int vertexNum, char[] vertexs, int[][] matrix) {
            this.vertexNum = vertexNum;
            this.vertexs = vertexs;
            this.matrix = matrix;
        }
    }


}
