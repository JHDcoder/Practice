package DAHUASHU.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFSBFSjuzhneg {
    //以顶点i开始的图的DFS（邻接矩阵法）
    public void traverByDFS(Graphjuzheng g,int i){
        if(!g.visited[i]){
            DFS(g,i);
        }

        for (int ii = 0; ii < g.vertexNum; ii++) { // 对图中所有顶点进行查看是否访问过(从第0号节点开始访问)，因为图可能是非连通的(由几个连通分量组成)，那么由某个顶点开始就不能将图所有节点遍历到
            if (!g.visited[ii]) {
                DFS(g, ii); // 如果下标为i的顶点未被访问，那么对从i开始的顶点进行BFS
            }
        }

    }

    public void DFS(Graphjuzheng g,int i){
        System.out.println(g.vertex[i]);
        g.visited[i]=true;
        ArrayList<Integer> vertexs=g.getAllNeighbors(i);
        while(!vertexs.isEmpty()){
            int iii=vertexs.get(0);//得到ii的第一个邻接点
            vertexs.remove(0);
            if(!g.visited[iii]){
                DFS(g,iii);
            }
        }
    }

    // 以顶点i开始的图的广度优先搜索(邻接矩阵法)
    public ArrayList<Integer> traverseByBFS(Graphjuzheng g,int i){
        ArrayList<Integer> visitedSerialOfall=new ArrayList<>();
        if(!g.visited[i]){
            visitedSerialOfall.addAll(BFS(g,i));
        }

        for (int ii = 0; ii < g.vertexNum; ii++) { // 对图中所有顶点进行查看是否访问过(从第0号节点开始访问)，因为图可能是非连通的(由几个连通分量组成)，那么由某个顶点开始就不能将图所有节点遍历到
            if (!g.visited[ii]) {
                visitedSerialOfall.addAll(BFS(g, ii)); // 如果下标为i的顶点未被访问，那么对从i开始的顶点进行BFS
            }
        }
        return visitedSerialOfall;

    }

    public ArrayList<Integer> BFS(Graphjuzheng g,int i){
        ArrayList<Integer> visitedSerialOfPart=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        visitedSerialOfPart.add(i);
        g.visited[i]=true;
        ((LinkedList<Integer>) q).addLast(i);
        while(!q.isEmpty()){
            int ii=((LinkedList<Integer>) q).removeFirst();//出队
            ArrayList<Integer> vertexs=g.getAllNeighbors(ii);
            while(!vertexs.isEmpty()){
                int iii=vertexs.get(0);//得到顶点ii的第一个邻接点
                vertexs.remove(0);
                if(!g.visited[iii]){
                    visitedSerialOfPart.add(iii);
                    g.visited[iii]=true;
                    ((LinkedList<Integer>) q).addLast(iii);
                }
            }

        }
        return visitedSerialOfPart;
    }


}
