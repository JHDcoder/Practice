package DAHUASHU.Tree;

import java.util.HashMap;

public class TrieTree {
    //使用hashmap实现前缀树
    private class Node{
        public HashMap<Character,Node> childs;  //子节点
        public boolean isLeaf; //当前节点是否为叶子节点

        public Node(){
            this.isLeaf=false;
            this.childs=new HashMap<>();
        }
    }

    public Node root;//根节点
    
    public TrieTree(){
        root=new Node();
    }
    
    //插入单词
    public void insert (String str){
        insert(root,str);
    }

    private void insert(Node root, String str) {
        if(str==null || str.length()==0) return;
        char [] chars=str.toCharArray();
        Node curr=root;
        for(int i=0;i<chars.length;i++){
            if(!curr.childs.containsKey(chars[i])){
                curr.childs.put(chars[i],new Node());
            }
            curr=curr.childs.get(chars[i]);
        }
        if(!curr.isLeaf)
           curr.isLeaf=true;
    }

    //查找
    public boolean search (String str){
        return search(root,str);
    }

    private boolean search(Node root, String str) {
        if(str==null || str.length()==0) return false;
        char [] chars=str.toCharArray();
        Node curr=root;
        for(int i=0;i<chars.length;i++){
            if(!curr.childs.containsKey(chars[i])){
                return false;
            }
            curr=curr.childs.get(chars[i]);
        }
        return curr.isLeaf;
    }

    public boolean startsWith(String str){
        if(str==null || str.length()==0) return false;
        char [] chars=str.toCharArray();
        Node curr=root;
        for(int i=0;i<chars.length;i++){
            if(!curr.childs.containsKey(chars[i]))
                return false;
            curr=curr.childs.get(chars[i]);
        }
        return true;
    }


}
