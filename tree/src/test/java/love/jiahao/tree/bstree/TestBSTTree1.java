package love.jiahao.tree.bstree;

import love.jiahao.tree.BSTree.BSTTree1;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * <big>测试树</big>
 *
 * @author 13684
 * @date 2024/3/2
 */
public class TestBSTTree1 {
    @Test
    public void test1(){
        /*
                4
              /   \
             2     6
            / \   / \
           1  3  5   7
         */
        BSTTree1.BSTNode<String> n1 = new BSTTree1.BSTNode<>(1,"张无忌");
        BSTTree1.BSTNode<String> n3 = new BSTTree1.BSTNode<>(3,"宋青书");
        BSTTree1.BSTNode<String> n2 = new BSTTree1.BSTNode<>(2, "周芷若", n1, n3);
        BSTTree1.BSTNode<String> n5 = new BSTTree1.BSTNode<>(5, "说不得");
        BSTTree1.BSTNode<String> n7 = new BSTTree1.BSTNode<>(7, "股离");
        BSTTree1.BSTNode<String> n6 = new BSTTree1.BSTNode<>(6, "赵敏", n5, n7);
        BSTTree1.BSTNode<String> root = new BSTTree1.BSTNode<>(4,"小昭", n2, n6);
        BSTTree1<String> tree = new BSTTree1<>();
        tree.root = root;


        assertEquals("张无忌", tree.get(1));
        assertEquals("周芷若", tree.get(2));
        assertEquals("宋青书", tree.get(3));
        assertEquals("小昭", tree.get(4));
        assertEquals("说不得", tree.get(5));
        assertEquals("赵敏", tree.get(6));
        assertEquals("股离", tree.get(7));
        assertNull(tree.get(8));

    }
}
