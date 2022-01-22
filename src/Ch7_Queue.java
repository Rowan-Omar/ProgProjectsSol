import java.util.*;

public class Ch7_Queue {

    //Self-test No. 18 page 427
    /*public void trimToSize() {
        E[] trimmedArray;
        int frontNums, rearNums;
        if (manyItems == data.length)
            return;
        else if (manyItems == 0)
            data = (E[]) new Object[0];
        else if (front <= rear) {
            trimmedArray = (E[]) new Object[manyItems];
            System.arraycopy(data, front, trimmedArray, front, manyItems);
            data = trimmedArray;
        } else {
            trimmedArray = (E[]) new Object[manyItems];
            frontNums = data.length - front;
            rearNums = rear + 1;
            System.arraycopy(data, front, trimmedArray, 0, frontNums);
            System.arraycopy(data, 0, trimmedArray, frontNums, rearNums);
            front = 0;
            rear = manyItems - 1;
            data = trimmedArray;
        }
    }*/


    //No. 19  //done
    /*public LinkedBasedQueue<E> clone() {
        LinkedBasedQueue<E> answer;
        Node<E>[] copyInfo;
        try {
            answer = (LinkedBasedQueue<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implement Cloneable");
        }
        copyInfo = (Node<E>[]) Node.listCopyWithTail(front);
        answer.front = copyInfo[0];
        answer.rear = copyInfo[1];
        return answer;
    }*/


    //No. 25 page 433  //NOT done
    /*public void add(E item, int priority) {
        if (priority < 0)
            throw new IllegalArgumentException("Illegal priority");

        if (priority > highestPrio) {
            highestPrio = priority;
            //HERE we should handle that we need to enlarge the queue array
            //queues = (ArrayBasedQueue<E>[]) new Object[highestPrio + 1];
        }

        if (queues[priority] == null)
            queues[priority] = new ArrayBasedQueue<>();

        queues[priority].add(item);
        totalSize++;
    }*/


    // Q.1 // done
    /*class WTWPalindrome {
        public static void main(String[] args) {
            System.out.println("Enter the expression: ");
            String line;
            do {
                Scanner input = new Scanner(System.in);
                line = input.nextLine();
                boolean result = isWTWPalindrome(line);
                System.out.println(result);
            } while (line.length() != 0);
        }

        public static boolean isWTWPalindrome(String input) {
        Queue<String> q = new LinkedList<String>();
        Stack<String> s = new Stack<String>();
        int mismatches = 0;
        String word = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isLetter(c))
                word += Character.toLowerCase(c);

            if (c == ' ' || i == (input.length() - 1)) {
                q.add(word);
                s.push(word);
                //System.out.println(word);
                word = "";
            }
        }

        while (!q.isEmpty()) {
            String item1 = q.remove();
            String item2 = s.pop();
            if (!Objects.equals(item1, item2)) {
                mismatches++;
            }
        }
        return (mismatches == 0);
    }
    }*/


    //Q.2  //Not done
    /*class LTLPalindrome {
        public static void main(String[] args) {
            String passage;
            do {
                System.out.println("Enter the lines (enter 'end' to end passage or 'exit' to quit): ");
                Scanner input = new Scanner(System.in);
                passage = input.nextLine();
                boolean result = isLTLPalindrome();
                System.out.println(result);
            } while (!passage.equals("exit"));
        }

        public static boolean isLTLPalindrome() {
            Queue<String> q = new LinkedList<String>();
            Stack<String> s = new Stack<String>();
            ArrayList<String> arr = new ArrayList<String>();
            int mismatches = 0;
            int index = 0;

            Scanner lines = new Scanner(System.in);

            while (lines.hasNextLine()) {
                String line = lines.nextLine();
                if (line == null || line.equals("end"))
                    break;

                arr.add(index++, line);
            }

            for (String item : arr) {
                //System.out.println(i + " : " + arr.get(i));
                String line = item.toLowerCase().replaceAll("\\p{Punct}", "");
                q.add(line);
                s.push(line);
            }
            while (!q.isEmpty()) {
                System.out.println(q.peek() + " --- " + s.peek());
                if (!Objects.equals(q.remove(), s.pop())) {
                    mismatches++;
                    //break;
                }
            }
            return (mismatches == 0);
        }
    }*/


    //Q.4  // Not done
    /*public class PriorityQueue<E> {
        private int highestPrio;
        private ArrayBasedQueue<E>[] queues;
        private int totalSize; //keeps track of total number of items in all of the queues

        //lw el highest prio b 2 f hn2sm el array of queues le 3 queues .
        // tabor lel nas el 3ndha 23la awlwia (2)
        // tabor lel nas el 3ndha prio = 1
        // tabor lel nas el 3ndha awlwia 0
        public PriorityQueue(int highestPriority) {
            if (highestPriority < 0)
                throw new IllegalArgumentException("The highest priority cannot be negative");
            // el creation hit3mlkeda mesh zi el mrg3
            queues = (ArrayBasedQueue<E>[]) new Object[highestPriority + 1];
            totalSize = 0;
        }

        //No. 25 page 433  //not done
        public void add(E item, int priority) {
            if (priority < 0)
                throw new IllegalArgumentException("Illegal priority");

            if (priority > highestPrio) {
                highestPrio = priority;
                //HERE we should handle that we need to enlarge the queue array
                //queues = (ArrayBasedQueue<E>[]) new Object[highestPrio + 1];
            }

            if (queues[priority] == null)
                queues[priority] = new ArrayBasedQueue<>();

            queues[priority].add(item);
            totalSize++;
        }

        public E remove() {
            E answer;
        *//*for (int i = highestPrio; i >= 0; i--) {
            if (queues[i]==null)
                continue; //throw new NoSuchElementException("The queue is empty");

            answer = queues[i].remove();
            totalSize--;
            break;
        }*//*
            if (highestPrio < 0) {
                return null;
            }
            if (queues[highestPrio] == null) {
                highestPrio--;
                return null;
            }
            answer = queues[highestPrio].remove();
            if (queues[highestPrio].size() == 0)
                highestPrio--;

            totalSize--;
            return answer;
        }

        public void displayQueue() {
            String str;
            if (totalSize == 0) {
                System.out.println("Queues are empty");
                return;
            }

            for (int i = highestPrio; i >= 0; i--) {
                if (queues[i] == null) {
                    System.out.println("queues[" + i + "]: empty queue");
                    continue;
                }
                str = queues[i].displayQueue();
                System.out.println("queues[" + i + "]: " + str);
            }

        }

    }*/


    //Q. 5  //may be done
    /*class linkedPriorityQueue {
        PrioNode front;

        class PrioNode {
            int data, priority;
            PrioNode link;

            public PrioNode(int d, int p) {
                this.data = d;
                this.priority = p;
                link = null;
            }
        }

        public void enqueue(int data, int priority) {
            PrioNode node = new PrioNode(data, priority);
            if (front == null || front.priority > node.priority) {
                node.link = front;
                front = node;
            } else {
                PrioNode temp = front;
                while (temp.link != null && temp.link.priority <= node.priority) {
                    temp = temp.link;
                }
                node.link = temp.link;
                temp.link = node;
            }
        }

        public int dequeue() {
            if (isEmpty()) return -1;
            int removed = front.data;
            front = front.link;
            return removed;
        }

        public int peek() {
            if (!isEmpty())
                return front.data;
            return -1;
        }

        public boolean isEmpty() {
            return (front == null);
        }
    }*/


    //Q.6 // need to be checked
    /*class CircularLinkedQueue<E> {
        Node<E> rear;
        int manyNodes;

        public CircularLinkedQueue() {
            rear = null;
            manyNodes = 0;
        }

        public void add(E obj) {
            Node<E> node = new Node<E>(obj, null);
            if (isEmpty()) {
                rear = node;
                node.setLink(node); //da el 3ml el circular
            } else if(manyNodes == 1){
                rear.addNodeAfter(obj);
                rear = node;
            }
            manyNodes++;
        }

        public boolean isEmpty() {
            return (rear == null);
        }

        public E remove() {
            E answer;
            if (isEmpty())
                throw new NoSuchElementException("Queue underflow");

            answer = rear.getLink().getData();
            manyNodes--;
            if (rear.getLink() == rear)
                rear = null;
            else
                rear.setLink(rear.getLink().getLink());

            return answer;
        }

        public int size() {
            return manyNodes;
        }

        public E peek() {
            E answer;
            if (isEmpty())
                return null;
            answer = rear.getLink().getData();
            return answer;
        }

    }*/


    //Q. 7 //double-ended queue .. adding and removing from both ends
    /*
     class DLLNode<E> {
        private E data;
        private DLLNode<E> prev, next;

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
    }

    public class Deque<E> {
        DLLNode<E> front, rear;
        int manyNodes;

        public Deque() {
            front = rear = null;
            manyNodes = 0;
        }

        public void addFirst(E element) {
            DLLNode<E> node = new DLLNode<>(element, null, front);
            if (front == null) //empty list
                front = rear = node;
            else { //single element and other cases
                front.setPrev(node);
                front = node;
            }
            manyNodes++;
        }

        public void addLast(E element) {
            DLLNode<E> node = new DLLNode<>(element, rear, null);
            if (front == null) //empty list
                front = rear = node;
            else {
                rear.setNext(node);
                rear = node;
            }
            manyNodes++;
        }

        public boolean isEmpty() {
            return (manyNodes == 0);
        }

        public E removeFirst() {
            E answer;
            if (isEmpty()) throw new NoSuchElementException();
            answer = front.getData();
            front = front.getNext();
            manyNodes--;
            if (isEmpty()) rear = null;
            return answer;
        }

        public E removeLast() {
            E answer;
            if (isEmpty()) throw new NoSuchElementException();
            answer = rear.getData();
            rear = rear.getPrev();
            manyNodes--;
            if (isEmpty()) front = null;
            return answer;
        }

        public E getFirst() {
            if (isEmpty()) throw new NoSuchElementException();
            return front.getData();
        }

        public E getLast() {
            if (isEmpty()) throw new NoSuchElementException();
            return rear.getData();
        }

        public void displayFromFront() {
            DLLNode<E> cursor = front;
            System.out.print("Queue from front is: ");
            for (; cursor != null; cursor = cursor.getNext()) {
                System.out.print(cursor.getData() + " - ");
            }
            System.out.println();
        }

        public void displayFromRear() {
            DLLNode<E> cursor = rear;
            System.out.print("Queue from rear is: ");
            for (; cursor != null; cursor = cursor.getPrev()) {
                System.out.print(cursor.getData() + " - ");
            }
            System.out.println();
        }
    }*/


    //Q. 13 //not done
    /*class CircularArrayDeque<E> {
        Object[] data;
        int front, rear;
        int manyItems;

        public CircularArrayDeque(int initCapacity) {
            if(initCapacity < 0) throw new IllegalArgumentException();
            data =  new Object[initCapacity];
            front = rear = -1;
            manyItems = 0;
        }

        public void addFirst(E element) {
            if(front == 0) return; //can not add in the front
            if (isEmpty()) //empty list
                front = rear = 0;
            else { //single element and other cases
                front--;
            }
        }
        public boolean isEmpty() {
            return (manyItems == 0);
        }

   *//* public void addLast(E element) {
        DLLNode<E> node = new DLLNode<>(element, rear, null);
        if (front == null) //empty list
            front = rear = node;
        else {
            rear.setNext(node);
            rear = node;
        }
        manyNodes++;
    }

    public E removeFirst() {
        E answer;
        if (isEmpty()) throw new NoSuchElementException();
        answer = front.getData();
        front = front.getNext();
        manyNodes--;
        if (isEmpty()) rear = null;
        return answer;
    }

    public E removeLast() {
        E answer;
        if (isEmpty()) throw new NoSuchElementException();
        answer = rear.getData();
        rear = rear.getPrev();
        manyNodes--;
        if (isEmpty()) front = null;
        return answer;
    }

    public E getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return front.getData();
    }

    public E getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return rear.getData();
    }

    public void displayFromFront() {
        DLLNode<E> cursor = front;
        System.out.print("Queue from front is: ");
        for (; cursor != null; cursor = cursor.getNext()) {
            System.out.print(cursor.getData() + " - ");
        }
        System.out.println();
    }

    public void displayFromRear() {
        DLLNode<E> cursor = rear;
        System.out.print("Queue from rear is: ");
        for (; cursor != null; cursor = cursor.getPrev()) {
            System.out.print(cursor.getData() + " - ");
        }
        System.out.println();
    }*//*
    }*/


}
