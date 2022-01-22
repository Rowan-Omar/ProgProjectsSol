public class DLLNode<E> implements Cloneable  {

        private E data;
        private DLLNode<E> prev, next;

        public DLLNode() {
        }

        public DLLNode(E data, DLLNode<E> previous, DLLNode<E> next) {
            this.data = data;
            this.prev = previous;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public DLLNode<E> getPrev() {
            return prev;
        }

        public DLLNode<E> getNext() {
            return next;
        }

        public void setData(E newData) {
            data = newData;
        }

        public void setPrev(DLLNode<E> previous) {
            prev = previous;
        }

        public void setNext(DLLNode<E> next) {
            this.next = next;
        }


        public void addNodeAfter(E element) {  //done
            DLLNode<E> node = new DLLNode<E>(element, this, next);
            if (next != null) //adding at the end
                next.prev = node;
            next = node;
        }

        public void addNodeBefore(E element) {
            DLLNode<E> node = new DLLNode<E>(element, prev, this);
            prev.next = node;
            prev = node;
        }

        public void remove() {
            if (prev != null)
                prev.next = next;
            if (next != null)
                next.prev = prev;
        }

        //done
        public static <E> DLLNode<E> listCopy(DLLNode<E> source) {
            DLLNode<E> copyHead;
            DLLNode<E> copyTail;

            if (source == null)
                return null;

            copyHead = new DLLNode<E>(source.data, null, null);
            copyTail = copyHead;

            while (source.next != null) {
                source = source.next;
                copyTail.addNodeAfter(source.data);
                copyTail = copyTail.next;
            }
            return copyHead;
        }

        // done
        public static <E> int listLength(DLLNode<E> head) {
            DLLNode<E> cursor;
            int answer = 0;

            for (cursor = head; cursor != null; cursor = cursor.next)
                answer++;

            return answer;
        }

    /*public static <E> Node<E> listPosition(Node<E> head, int position) {
        Node<E> cursor;
        int i;

        if (position == 0)
            throw new IllegalArgumentException("position is zero");

        cursor = head;
        for (i = 1; (i < position) && (cursor != null); i++)
            cursor = cursor.link;

        return cursor;
    }*/

        //done
        public static <E>DLLNode<Integer> listSearch(DLLNode<Integer> head, int target) {
           DLLNode<Integer> cursor;
        /*if (target == null) {
            for (cursor = head; cursor != null; cursor = cursor.link)
                if (cursor.data == null)
                    return cursor;
        }
        else*/
            {
                for (cursor = head; cursor != null; cursor = cursor.next)
                    if (target == cursor.data)
                        return cursor;
            }

            return null;
        }

        public static <E> void display(DLLNode<E> head) {
            DLLNode<E> cursor = head;
            for (; cursor != null; cursor = cursor.next) {
                System.out.print(cursor.data + " ");
            }
            System.out.println();
        }


    

}
