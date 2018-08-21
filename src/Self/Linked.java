package Self;

public class Linked {

    protected Linked linked;
    protected Integer integer;

    public Linked(int i){
        integer = new Integer(i);
    }

    public boolean hasNext() {
        if(null == linked) {
            return false;
        }

        return true;
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

}
