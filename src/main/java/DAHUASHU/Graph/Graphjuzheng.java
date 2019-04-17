package DAHUASHU.Graph;

import java.util.ArrayList;

//邻接矩阵表示图信息
public class Graphjuzheng {
    public int vertexNum;//图中顶点个数
    public char [] vertex=null;//顶点信息
    public int [][] matrix=null;//顶点之间边的信息
    public boolean [] visited=null;//标记相应顶点是否访问

    public Graphjuzheng(int vertexNum,char [] vertex,int [][] matrix){
        this.vertexNum = vertexNum;
        this.vertex = vertex;
        this.matrix = matrix;
        visited = new boolean[vertexNum]; // 初始化所有顶点均未被访问
    }

    //得到i顶点的所有邻接点
    public ArrayList<Integer> getAllNeighbors(int i){

        ArrayList<Integer> vertex=new ArrayList<>();
        for(int ii=0;ii<vertexNum;ii++){
            if(matrix[i][ii]==1){
                vertex.add(ii);
            }
        }
        return vertex;
    }
}
