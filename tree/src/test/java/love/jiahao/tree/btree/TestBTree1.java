package love.jiahao.tree.btree;

import love.jiahao.tree.bTree.BTree;

/**
 * <big></big>
 *
 * @author 13684
 * @date 2024/3/19
 */
public class TestBTree1 {
    public static void main(String[] args) {
        BTree bTree = new BTree(2);
        bTree.put(1);
        bTree.put(2);
        System.out.println(bTree);

        bTree.put(3);
        System.out.println(bTree);
        bTree.remove(2);
        System.out.println(bTree);

    }
}
