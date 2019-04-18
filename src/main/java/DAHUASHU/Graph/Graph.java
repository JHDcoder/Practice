package DAHUASHU.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    //基于无向图
    private int v;//顶点个数
    private LinkedList<Integer> adj[];//邻接表

    public Graph(int v){
        this.v=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }

    public void addEdge(int s,int t){//无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s,int t){  //s表示起点，t表示终点,我们搜索一条从s到t的路径
        if(s==t) return;
        boolean [] visited=new boolean[v];
        visited[s]=true;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(s);
        //pre记录搜索路径当我们从顶点 s 开始，广度优先搜索到顶点 t 后，prev 数组中
        //存储的就是搜索的路径。不过，这个路径是反向存储的。prev[w] 存储的是，顶点 w 是从
        //哪个前驱顶点遍历过来的。比如，我们通过顶点 2 的邻接表访问到顶点 3，那 prev[3] 就
        //等于 2。为了正向打印出路径，我们需要递归地来打印，你可以看下 print() 函数的实现方
        //式。
        int [] prev=new int[v];
        for(int i=0;i<v;i++){
            prev[i]=-1;
        }
        while(queue.size()!=0){
            int w=queue.poll();
            for(int i=0;i<adj[w].size();i++){
                int q=adj[w].get(i);
                if(!visited[q]){
                    prev[q]=w;
                    if(q==t){
                        print(prev,s,t);
                        return;
                    }
                    visited[q]=true;
                    queue.add(q);
                }
            }
        }

    }

    private void print(int [] prev,int s,int t){
        if(prev[t]!=-1&&t!=s){
            print(prev,s,prev[t]);
        }
        System.out.println(t+" ");
    }


    boolean found=false;//全局变量或者类变量

    public void dfs(int s,int t){
        found=false;
        boolean [] visited=new boolean[v];
        int [] prev=new int [v];
        for(int i=0;i<v;i++){
            prev[i]=-1;
        }
        recurDfs(s,t,visited,prev);
        print(prev,s,t);
    }

    private void recurDfs(int w,int t,boolean [] visited,int [] prev){
        if(found==true) return;
        visited[w]=true;
        if(w==t){
            found=true;
            return;
        }
        for(int i=0;i<adj[w].size();i++){
            int q=adj[w].get(i);
            if(!visited[q]){
                prev[q]=w;
                recurDfs(q,t,visited,prev);
            }
        }
    }

}
