package DAHUASHU.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFSBFSjiebiao {
    public void traverbyDFS(Graphjiebiao [] g,int i){
        if(!Graphjiebiao.visited[i]){
            DFS(g,i);
        }
        for(int ii=0;ii<Graphjiebiao.vertexNum;ii++){
             if(!Graphjiebiao.visited[ii]){
                 DFS(g,ii);
             }
        }
    }

    // 以顶点i开始的连通图的深度优先搜素(邻接表法)
    public static void DFS(Graphjiebiao [] g,int i){
        System.out.println(g[i].vertex);
        Graphjiebiao.visited[i]=true;
        Graphjiebiao cur=g[i];
        while(cur.next!=null){
            cur=cur.next;
            int ii=Graphjiebiao.indexof(g,cur.vertex);
            if(!Graphjiebiao.visited[i]){
                DFS(g,i);
            }
        }

    }


    // 以顶点i开始的图的广度优先搜索(邻接表法)
    public  ArrayList<Integer> traverseByBFS(Graphjiebiao [] g,int i){
        ArrayList<Integer> visitedSerialOfAll=new ArrayList<>();
        if(!Graphjiebiao.visited[i]){
            visitedSerialOfAll.addAll(BFS(g,i));
        }

        for(int ii=0;ii<Graphjiebiao.vertexNum;i++){
            if(!Graphjiebiao.visited[ii]){
                visitedSerialOfAll.addAll(BFS(g,ii));
            }
        }
        return visitedSerialOfAll;
    }

    public ArrayList<Integer> BFS(Graphjiebiao [] g,int i){
        ArrayList<Integer> visitedSerialOfpart=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        visitedSerialOfpart.add(i);
        Graphjiebiao.visited[i]=true;
        ((LinkedList<Integer>) q).addLast(i);
        while(!q.isEmpty()){
            int ii=((LinkedList<Integer>) q).removeFirst();
            Graphjiebiao cur=g[ii];
            while(cur.next!=null){
                cur=cur.next;
                int iii=Graphjiebiao.indexof(g,cur.vertex);
                if(!Graphjiebiao.visited[iii]){
                    visitedSerialOfpart.add(iii);
                    Graphjiebiao.visited[iii]=true;
                    ((LinkedList<Integer>) q).addLast(iii);
                }
            }
        }
        return visitedSerialOfpart;
    }
}
