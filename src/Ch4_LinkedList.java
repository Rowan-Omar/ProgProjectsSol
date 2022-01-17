public class Ch4_LinkedList {
   // Q. 2 // done
    /* public static <E> void removeDuplicates(Node<E> head) {
        Node<E> current = head, dummy, temp2;

        while (current != null && current.getLink() != null) {
            dummy = current;
            temp2 = current.getLink();
            while (temp2 != null) {
                if (current.getData() == temp2.getData()) {
                    dummy.setLink(temp2.getLink());
                } else
                    dummy = temp2;
                temp2 = temp2.getLink();
            }
            current = current.getLink();
        }
    }*/


    // Q. 3  // done
   /* public static void nodesBetween(Node<Integer> head, int x, int y) {
        Node<Integer> start = listSearch(head, x);
        Node<Integer> end = listSearch(head, y);
        if (start == null || end == null) return;

        Node<Integer> ptr;
        System.out.print("The elements between the two num are: ");
        for (ptr = start; ptr != end; ptr = ptr.getLink())
            System.out.print(ptr.getData() + " ");
        System.out.println(ptr.getData());
    }*/


    //Q. 4 // done
   /* public static <E> Node<E> reverseList(Node<E> head) {
        if (head == null) return null;
        Node<E> answer = listCopy(head);
        Node<E> prev = null, current = answer, next = null;
        while (current != null) {
            next = current.link;
            current.link = prev;
            prev = current;
            current = next;
        }
        answer = prev;
        return answer;
    }*/


    //Q.5 // done
   /* public static Node<Integer> merge(Node<Integer> h1, Node<Integer> h2) {
        if (h1 == null || h2 == null) return null;
        Node<Integer> answer = new Node<Integer>(-1, null);
        Node<Integer> ptr = answer;
        while (h1 != null && h2 != null) {
            if (h1.getData() <= h2.getData()) {
                ptr.link = h1;
                h1 = h1.link;
            } else {
                ptr.link = h2;
                h2 = h2.link;
            }
            ptr = ptr.link;
        }
        if (h1 == null)
            ptr.link = h2;
        else if (h2 == null)
            ptr.link = h1;
        return answer.link;

      /*  //OR
        Node<Integer> answer= new Node<Integer>();
        if(h1 == null)
            return h2;
        else if(h2 == null)
            return h1;

        if(h1.getData() <= h2.getData()){
            answer = h1;
            answer.link = merge(h1.link, h2);
        }
        else {
            answer = h2;
            answer.link = merge(h1, h2.link);
        }
        return answer;//
    }*/


    //Q.6  //done
   /* public static Node<Integer>[] listSplitter(Node<Integer> head, int splitterValue) {
        Node<Integer>[] answer = new Node[2];
        Node<Integer> cursor = head;
        Node<Integer> dummyHead1 = new Node<Integer>(-1, null);
        Node<Integer> dummyHead2 = new Node<Integer>(-1, null);
        Node<Integer> tail1 = dummyHead1, tail2 = dummyHead2;

        for (; cursor != null; cursor = cursor.link) {
            if (cursor.data < splitterValue) {
                tail1.addNodeAfter(cursor.data);
                tail1 = tail1.link;
            } else {
                tail2.addNodeAfter(cursor.data);
                tail2 = tail2.link;
            }
        }
        answer[0] = dummyHead1.link;
        answer[1] = dummyHead2.link;
        display(answer[0]);
        display(answer[1]);
        return answer;
    }*/


    //Q. 7  // done
   /* public static Node<Integer> listSort(Node<Integer> head) {
        if (head == null) return null;
        Node<Integer> current = head, next = null;
        int temp; //for swapping

        while (current != null) {
            next = current.link;
            while (next != null) {
                if (current.data > next.data) {
                    temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                }
                next = next.link;
            }
            current = current.link;
        }
        return null;
    }*/


    //Q.8  // NOT done
    /*  public void subtract(LinkedList<Integer> Y) {
        LinkedList<Integer> temp;
        temp = (LinkedList<Integer>) this.clone();
        int max = -1, max2 = -1;

        while (temp.head != null) {
            if (max < temp.head.getData())
                max = temp.head.getData();
            temp.head = temp.head.getLink();
        }
        temp = (LinkedList<Integer>) this.clone();
        while (temp.head != null) {
            if (max2 < temp.head.getData())
                max2 = temp.head.getData();
            temp.head = temp.head.getLink();
        }
        int[] myArr = new int[max + 1];
        int[] myArr2 = new int[max2 + 1];

        temp = (LinkedList<Integer>) this.clone();

        while (temp.head != null) {
            if (myArr[temp.head.getData()] == 0)
                myArr[temp.head.getData()] = temp.countOccurrences(temp.head.getData());

            temp.head = temp.head.getLink();
        }
        LinkedList<Integer> temp2=(LinkedList<Integer>) this.clone();

        while (temp2.head != null) {
            if (myArr2[temp2.head.getData()] == 0)
                myArr2[temp2.head.getData()] = temp2.countOccurrences(temp2.head.getData());

            temp2.head = temp2.head.getLink();
        }
        for(int i=0; i <= (max<max2 ? max: max2); i++){
            myArr[i] = myArr[i] - myArr[i];
        }

        LinkedList<Integer> newBag = new LinkedList<>();
        for (int i=0; i<=max; i++){
            for(int j = 1; j<=myArr[i]; j++){
                if(myArr[i]>0)
                    //addLast(myArr[i]);
            }
        }
    }*/


}
