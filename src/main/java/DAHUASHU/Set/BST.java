package DAHUASHU.Set;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>>  {
    private class Node{
        public E e;
        public Node left,right;
        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }
    private Node root;
    private int size;
    public BST(){
        root=null;
        size=0;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }


    public void add(E e){

        if(root==null){
            root=new Node(e);
            size++;
        }
        else
           root=add(root,e);

    }
    //递归算法
    private Node add(Node node,E e){
        /*if(e.equals(node.e))
            return;
        else if(e.compareTo(node.e)<0&&node.left==null){
            node.left=new Node(e);
            size++;
            return;
        }
        else if(e.compareTo(node.e)>0&&node.right==null){
            node.right=new Node(e);
            size++;
            return;
        }*/

        if(node==null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e)<0)
            node.left=add(node.left,e);
        else if(e.compareTo(node.e)>0)
            node.right=add(node.right,e);

        return node;

    }


    public boolean contains(E e){
        return  contians(root,e);
    }


    private boolean contians(Node node,E e){
        if(node==null)
            return false;
        if(e.compareTo(node.e)==0)
            return true;
        else if(e.compareTo(node.e)<0)
            return contians(node.left,e);
        else
            return contians(node.right,e);
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node==null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //非递归
    public void preOrderNR(){
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            System.out.println(cur.e);

            if(cur.right!=null)
                stack.push(cur.right);
            if(cur.left!=null)
                stack.push(cur.left);
        }

    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node ==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }

    public void levelOrder(){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur=q.remove();
            System.out.println(cur.e);

            if(cur.left!=null)
                q.add(cur.left);
            if(cur.right!=null)
                q.add(cur.right);
        }
    }

    public E minimum(){
        if(size==0)
            throw new IllegalArgumentException("bst empty");
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left==null)
            return node;
        return minimum(node.left);
    }

    public E maximum(){
        if(size==0)
            throw new IllegalArgumentException("bst empty");
        return minimum(root).e;
    }

    private Node maximum(Node node){
        if(node.right==null)
            return node;
        return minimum(node.right);
    }

    public E removeMin(){
        E ret=minimum();
        root=removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){
        //左子树为空
        if(node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        //左子树不为空
        node.left=removeMin(node.left);
        return node;
    }

    //bst删除最大值在的点
    public E removeMax(){
        E ret=maximum();
        root=removeMax(root);
        return ret;
    }
    //删掉以node为根的二分搜索树中的最大节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right==null){
            Node leftNode=node.left;
            node.left=null;
            size--;
            return leftNode;
        }

        node.right=removeMax(node.right);
        return node;
    }

    //从bst删除任意值
    public void remove(E e){
       root= remove(root,e);
    }

    private Node remove(Node node,E e){
        if(node==null)
            return null;

        if(e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
            return node;
        }
        else if(e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return node;
        }
        else{//e==node.e
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }

            if(node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }

            //左右子树都不为空
            Node suceessor=minimum(node.right);
            suceessor.right=removeMin(node.right);
            suceessor.left=node.left;
            node.left=node.right=null;
            return suceessor;
        }
    }




    public String toString(){
        StringBuilder res=new StringBuilder();
        generateBstString(root,0,res);
        return res.toString();
    }

    private void generateBstString(Node node,int depth,StringBuilder res){
        if(node==null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBstString(node.left,depth+1,res);
        generateBstString(node.right,depth+1,res);

    }

    private String generateDepthString(int depth){
        StringBuilder res=new StringBuilder();
        for(int i=0;i<depth;i++)
            res.append("--");
        return res.toString();
    }
   

}
