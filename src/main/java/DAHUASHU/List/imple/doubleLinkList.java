package DAHUASHU.List.imple;

import DAHUASHU.List.List;

public class doubleLinkList implements List {
    @Override
    public void init() {}

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    //先搞定插入s的前驱和后继，再搞定后节点的前驱，最后搞定前节点的后继
    @Override
    public void insert(int idx, int num) {}

    @Override
    public int delete(int idx) {
        return 0;
    }

    @Override
    public void update(int idx, int num) {}

    @Override
    public void find(int num) {}

    @Override
    public void print() {}
}
