package DAHUASHU.List;

public interface List {

    public void init();
    public boolean isEmpty();
    public int size();
    public void insert(int idx,int num);
    public int delete(int idx);
    public void update(int idx,int num);
    public void find(int num);
    public void print();

}
