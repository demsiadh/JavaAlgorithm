package love.jiahao.linkedList.popj;

/**
 * 双链表节点
 */
public class PeopleNode {
    // 序号
    private int no;
    // 名字
    private String name;
    // 称号
    private String nickName;
    // 下一个节点的位置
    private PeopleNode next;
    // 上一个节点的位置
    private PeopleNode pre;

    public PeopleNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public PeopleNode getNext() {
        return next;
    }

    public void setNext(PeopleNode next) {
        this.next = next;
    }

    public PeopleNode getPre() {
        return pre;
    }

    public void setPre(PeopleNode pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "PeopleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
