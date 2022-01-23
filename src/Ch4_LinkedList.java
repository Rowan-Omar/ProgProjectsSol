public class Ch4_LinkedList {
    // Q. 2 // done
    /* public static <E> void removeDuplicates(Node<E> head) {
        Node<E> current = head, prev, next;

        while (current != null && current.link != null) {
            prev = current;
            next = current.link;
            while (next != null) {
                if (current.data == next.data) {
                    prev.link = next.link;
                } else
                    prev = next;
                temp = temp.link;
            }
            current = current.link;
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

        OR
Stack<Node<E>> stack = new Stack<Node<E>>();
        Node<E> temp = head, reversedHead;
        while (temp.link != null) {
            stack.push(temp);
            temp = temp.link;
        }
        reversedHead = temp;
        while (!stack.isEmpty()) {
            temp.link = stack.pop();
            temp = temp.link;
        }
        temp.link = null;
        return reversedHead;

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
                if (current.data > next.data) { //need to swap
                    temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                }
                next = next.link;
            }
            current = current.link;
        }
        return head;
    }*/



    //Q.8  // done
    /*public IntLinkedBag subtract(IntLinkedBag Y) {
        Node<Integer> tempHead = this.head; //for the first list (x)
        Node<Integer> tempHead2 = Y.head; // to hold the second list

        int maxVal = -1, maxVal2 = -1; //to hold the biggest number in each list

        IntLinkedBag newBag = new IntLinkedBag();

        while (tempHead != null) {
            if (maxVal < tempHead.getData())
                maxVal = tempHead.getData();
            tempHead = tempHead.getLink();
        }

        while (tempHead2 != null) {
            if (maxVal2 < tempHead2.getData())
                maxVal2 = tempHead2.getData();
            tempHead2 = tempHead2.getLink();
        }

        int[] arr1 = new int[maxVal + 1]; //array to hold number of occurrence of each number and place it in the number's value
        int[] arr2 = new int[maxVal2 + 1]; //for the second list numbers

        tempHead = this.head;
        while (tempHead != null) {
            int tempData = tempHead.getData();
            arr1[tempData] = this.countOccurrences(tempData);
            tempHead = tempHead.getLink();
        }

        tempHead2 = Y.head;
        while (tempHead2 != null) {
            int temp2Data = tempHead2.getData();
            arr2[temp2Data] = Y.countOccurrences(temp2Data);
            tempHead2 = tempHead2.getLink();
        }

        //iterate to the min size among both arrays
        for (int i = 0; i <= (maxVal < maxVal2 ? maxVal : maxVal2); i++) {
            arr1[i] = arr1[i] - arr2[i];
        }

        for (int i = 0; i <= maxVal; i++) {
            for (int j = 1; j <= arr1[i]; j++) {
                if (arr1[i] > 0) {
                    newBag.addLast(i);
                }
            }
        }
        return newBag;
    }*/

    //Q.9 // done

    /*//done
    public void addFirst(E element) {
        head = new Node<E>(element, head);
        ;
        cursor = head;
        precursor = null;
        if (manyNodes == 0)  //empty list
            tail = head;
        manyNodes++;
    }

    //done
    public void addLast(E element) {
        if (manyNodes == 0) {
            head = tail = new Node<E>(element, null);
            cursor = head;
            precursor = null;
        } else {
            precursor = tail;
            tail.addNodeAfter(element);
            tail = tail.getLink();
            cursor = tail;
        }
        manyNodes++;
    }

    //done
    public E removeFirst() {
        if (manyNodes == 0)
            throw new IllegalStateException("There is no elements");
        E removed = head.getData();
        head = head.getLink();
        cursor = head;
        precursor = null;
        manyNodes--;
        if (manyNodes == 0)
            tail = null;
        return removed;
    }

    //done
    public E removeLast(){
        if(manyNodes == 0)
            throw new IllegalStateException();
        E removed = tail.getData();
        precursor = head;
        while(precursor.getLink() != tail)
            precursor = precursor.getLink();
        cursor = head;
        precursor.setLink(null);
        tail = precursor;
        manyNodes--;
        if(manyNodes == 0)
            tail = head = cursor = precursor = null;
        return removed;
    }

    //done
    public void makeLastCurrent() {
        if (manyNodes == 0) throw new IllegalStateException();
        precursor = head;
        while (precursor.getLink() != tail)
            precursor = precursor.getLink();
        cursor = tail;
        System.out.println("cur " + cursor.getData() + " pre " + precursor.getData());
    }

    //done
    public E getIth(int pos){
        int i = 0;
        Node<E> temp  = head;
        while(temp!=null && i<pos)
        {
            temp = temp.getLink();
            i++;
        }
        if(temp==null)
            throw new IllegalArgumentException("Not found");
        return temp.getData();
    }

    // done
    public void makeIthCurrent(int pos) {
        if (pos == 0) {
            precursor = null;
            cursor = head;
            return;
        }
        int i = 1;
        Node<E> temp = head;

        while (temp != null && i < pos) {
            temp = temp.getLink();
            i++;
        }
        precursor = temp;
        cursor = precursor.getLink();
        //System.out.println("crs: " + cursor.getData() + " pre: " + precursor.getData());
    }

    */


}
