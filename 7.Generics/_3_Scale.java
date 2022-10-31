public class _3_Scale<T extends Comparable> {
    private T left;
    private T right;

    public _3_Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (left == right) {
            return null;
        }

        if(left.compareTo(right) > 0) {
            return left;
        }
        return right;
    }
}
