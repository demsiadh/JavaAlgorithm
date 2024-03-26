package love.jiahao.tree.bstree;

import love.jiahao.tree.BSTree.BSTTree1;
import love.jiahao.tree.BSTree.BSTTree2;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * <big>测试树</big>
 *
 * @author 13684
 * @date 2024/3/2
 */
public class TestBSTTree2 {
    private final BSTTree2<Integer, String> tree= new BSTTree2<>();
    @Before
    public void init() {
                /*
                4
              /   \
             2     6
            / \   / \
           1  3  5   7
         */
        BSTTree2.BSTNode<Integer, String> n1 = new BSTTree2.BSTNode<>(1,"张无忌");
        BSTTree2.BSTNode<Integer, String> n3 = new BSTTree2.BSTNode<>(3,"宋青书");
        BSTTree2.BSTNode<Integer, String> n2 = new BSTTree2.BSTNode<>(2, "周芷若", n1, n3);
        BSTTree2.BSTNode<Integer, String> n5 = new BSTTree2.BSTNode<>(5, "说不得");
        BSTTree2.BSTNode<Integer, String> n7 = new BSTTree2.BSTNode<>(7, "股离");
        BSTTree2.BSTNode<Integer, String> n6 = new BSTTree2.BSTNode<>(6, "赵敏", n5, n7);
        tree.root = new BSTTree2.BSTNode<>(4,"小昭", n2, n6);
    }

    @Test
    public void test1(){


        assertEquals("张无忌", tree.get(1));
        assertEquals("周芷若", tree.get(2));
        assertEquals("宋青书", tree.get(3));
        assertEquals("小昭", tree.get(4));
        assertEquals("说不得", tree.get(5));
        assertEquals("赵敏", tree.get(6));
        assertEquals("股离", tree.get(7));
        assertNull(tree.get(8));

    }

    @Test
    public void test2() {
        assertEquals("张无忌", tree.min());
        assertEquals("股离", tree.max());
    }

    @Test
    public void test3() {
        tree.put(7, "原");
        tree.put(9, "原神");
        assertEquals("原", tree.get(7));
        assertEquals("原神", tree.get(9));
    }

    @Test
    public void test4() {
        System.out.println(tree.less(5));
        System.out.println(tree.greater(5));
        System.out.println(tree.between(3, 6));
    }
}
