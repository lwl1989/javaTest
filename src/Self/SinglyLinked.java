package Self;

public class SinglyLinked {
    protected String value;
    protected SinglyLinked next;

    public SinglyLinked(){

    }
    public SinglyLinked(String str) {
        this.value = str;
    }
    public boolean hasNext() {
        return this.next != null;
    }

    public void add(SinglyLinked singlyLinked) {
        SinglyLinked node = this;
        while (node.hasNext()) {
            node = node.next;
        }
        node.next = singlyLinked;
    }

    public void del(SinglyLinked singlyLinked) {
        SinglyLinked node = this;
        while (node.hasNext()) {
            SinglyLinked next = node.next;
            if(next.equals(singlyLinked)) {
                node.next = next.next;
                break;
            }

            node = next;
        }

    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setNext(SinglyLinked next) {
        this.next = next;
    }

    public SinglyLinked getEmit(int i) {
        int j = 0;
        SinglyLinked node = this;
        while (node.hasNext()) {
            if(j==i) {
                return node;
            }

            if(j>i) {
                return null;
            }

            node = node.next;
            j++;

        }
        return null;
    }

    public static void main(String[] args) {
        SinglyLinked head = new SinglyLinked("1");
        SinglyLinked node = new SinglyLinked("1");
    }
}
