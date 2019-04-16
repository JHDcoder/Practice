package DAHUASHU.Tree;



/*
1. 给定一组数据，比如 1，3，5，6，9，10。你来算算，可以构建出多少种不同的二叉
树？
2. 我们讲了三种二叉树的遍历方式，前、中、后序。实际上，还有另外一种遍历方式，也
就是按层遍历，你知道如何实现吗？递归和非递归
 */
public class binarysearchtree {
    private Node tree;

    public Node find(int data){
        Node p=tree;
        while(p!=null){
            if(data<p.data) p=p.left;
            else if(data>p.data) p=p.right;
            else return p;
        }
        return null;
    }

    public void insert(int data){
        if(tree==null){
            tree=new Node(data);
            return;
        }

        Node p=tree;
        while(p!=null){
            if(data>p.data){
                if(p.right==null){
                    p.right=new Node(data);
                    return;
                }
                p=p.right;
            }else {
                if(p.left==null){
                    p.left=new Node(data);
                    return;
                }
                p=p.left;
            }
        }

    }


    /*
    第一种情况是，如果要删除的节点没有子节点，我们只需要直接将父节点中，指向要删除
    节点的指针置为 null。比如图中的删除节点 55。
     第二种情况是，如果要删除的节点只有一个子节点（只有左子节点或者右子节点），我们
    只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点就可以了。
    比如图中的删除节点 13。
     第三种情况是，如果要删除的节点有两个子节点，这就比较复杂了。我们需要找到这个节
    点的右子树中的最小节点，把它替换到要删除的节点上。然后再删除掉这个最小节点，因
    为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了），所以，我们可
     以应用上面两条规则来删除这个最小节点。
     */

    //删除就比较复杂了，分三种情况
    public void delete(int data){
        Node p=tree;//p指向要删除的节点，初始化指向根节点
        Node pp=null;//pp记录的是p的父节点
        while(p!=null&&p.data!=data){
            pp=p;
            if(data>p.data) p=p.right;
            else p=p.left;
        }
        if(p==null) return;//没有找到



        //要删除的节点有两个子节点
        if(p.left!=null&&p.right!=null){//查找右子树中的最小节点
            Node minP=p.right;
            Node minPP=p;//minPP表示minP的父节点
            while(minP.left!=null){
                minPP=minP;
                minP=minP.left;
            }
            p.data=minP.data;//将minP的数据替换到p中
            p=minP;//下面就变成了删除minP了
            pp=minPP;
        }

        //删除节点是叶子节点或者仅有一个子节点
        Node child;//p的子节点
        if(p.left!=null) child=p.left;
        else if(p.right!=null) child=p.right;
        else child=null;

        if(pp==null) tree=child;//删除的是根节点
        else if(pp.left==p) pp.left=child;
        else pp.right=child;

    }








}
