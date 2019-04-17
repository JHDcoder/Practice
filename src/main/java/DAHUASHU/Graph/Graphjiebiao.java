package DAHUASHU.Graph;

public class Graphjiebiao {
    public static int vertexNum;
    public char vertex;
    public Graphjiebiao next;
    public static boolean visited[]=null;

    public Graphjiebiao(char vertex){
        this.vertex=vertex;
    }

    public Graphjiebiao(int vertexNum){
        this.vertexNum=vertexNum;
        this.visited=new boolean[this.vertexNum];
    }


    public Graphjiebiao[] create(char [] vertexs,int [][] matrix){
        Graphjiebiao[] g=new Graphjiebiao[vertexNum];
        for(int i=0;i<matrix.length;i++){
            g[i]=new Graphjiebiao(vertexs[i]);//创建顶点表
            Graphjiebiao curr=g[i];
            for(int ii=0;ii<matrix[i].length;ii++){
                if(matrix[i][ii]!=0){//顶点i的邻接点
                    Graphjiebiao tmp=new Graphjiebiao(vertexs[ii]);//创建边表
                    curr.next=tmp;
                    curr=tmp;
                }

            }
        }
        return g;
    }

    // 得到图中顶点为vertex的索引
    public int indexof(Graphjiebiao[] g,char vertex){
        for(int i=0;i<vertexNum;i++){
            if(g[i].vertex==vertex){
                return i;
            }
        }
        return -1;//未找到
    }

}
