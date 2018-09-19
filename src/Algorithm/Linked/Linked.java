package Algorithm.Linked;


/**
 * 单向链表和存储结构对比
 *
 * 存储方式
 * 链表：  链式结构，用一组任意的存储单元存放线性表的元素
 * 顺序结构： 一段联系的存储单元一次存储线性表数据元素
 *
 * 时间性能：        链表                      线性结构
 * 查找           o(n)                    o(1)
 * 插入和删除      o(1)已知位置的情况        o(n)  位移其他数据需要N次
 *
 * 空间性能：
 * 链表：  不需要预先分配空间，但是需要额外一个地址的存储空间存储地址
 * 顺序：  需要预先分配空间，但是空间大小不可控（固定），不灵活
 */
public class Linked {

    private Linked linked;
    private Integer integer;

    public Linked(int i){
        this.integer = i;
    }

    public boolean hasNext() {
        if(null == linked) {
            return false;
        }

        return true;
    }

    public void setNext(Linked linked) {
        this.linked = linked;
    }

    public boolean hasNextSec() {
        if(hasNext()) {
            return getNext().hasNext();
        }
        return false;
    }

    public void addNode(Linked linked) {
        this.linked = linked;
    }

    public Linked getNext() {
        return linked;
    }

    public Linked getLinkedWithPos(int i) {
        if(i < 1) {
            return null;
        }
        Linked l = this;
        int j = 1;

        while (hasNext() && j < i) {
            l = l.getNext();
            ++j;
        }
        if(!l.hasNext() || j > i) {
            return null;
        }

        return l;
    }

    public static boolean insertNode(Linked linked, Linked insert, int i) {
        linked = linked.getLinkedWithPos(i);
        if(linked == null) {
            return false;
        }
        Linked now = linked;
        Linked next = linked.getNext();
        now.setNext(insert);
        insert.setNext(next);

        return true;
    }

    public static boolean delNode(Linked linked, int i) {
        linked = linked.getLinkedWithPos(i);
        if(linked == null) {
            return false;
        }
        Linked now = linked;
        Linked next = linked.getNext();
        now.setNext(next.getNext());
        next = null;  //释放next  C/C++必要操作  JAVA 可能有回收机制

        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(integer);
    }

    public static void main(String[] args) {
        Linked l = new Linked(1);
        Linked l1 = l;
        for (int i = 2; i < 11; i++) {
            l.addNode(new Linked(i));
            l = l.getNext();
        }

        Linked.insertNode(l1,new Linked(33), 5);
        Linked.delNode(l1, 2);

        do {
            System.out.println(l1);
            l1 = l1.getNext();
        } while (l1.hasNext());

    }
}
