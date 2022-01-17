import java.util.*;

public class Ch7_Queue {

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
            } while (line != "exit");
        }

        public static boolean isWTWPalindrome(String expression) {
            Queue<String> q = new LinkedList<String>();
            Stack<String> s = new Stack<String>();
            int mismatches = 0;
            String word = "";
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (i == (expression.length() - 1)) {
                    q.add(word.toLowerCase());
                    s.push(word.toLowerCase());
                }
                if (!Character.isWhitespace(c) && !Character.isLetter(c)) continue;
                if (c == ' ') {
                    q.add(word.toLowerCase());
                    s.push(word.toLowerCase());
                    //System.out.println(word);
                    word = "";
                    continue;
                }
                word += c;
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
//You can cage a swallow, can’t you, but you can’t swallow a cage, can you?
    }*/


    // Q.2
    /*class LTLPalindrome {
        public static void main(String[] args) {
            System.out.println("Enter the lines: ");
            String line;
            do {
                Scanner input = new Scanner(System.in);
                line = input.nextLine();
                boolean result = isLTLPalindrome(line);
                System.out.println(result);
            } while (line != "exit");
        }

        public static boolean isLTLPalindrome(String expression) {
            Queue<String> q = new LinkedList<String>();
            Stack<String> s = new Stack<String>();
            int mismatches = 0;
            String word = "";
            //while( ){
            //char c = expression.charAt(i);

            q.add(word.toLowerCase());
            s.push(word.toLowerCase());
            //System.out.println(word);

            //}
            while (!q.isEmpty()) {
                String item1 = q.remove();
                String item2 = s.pop();
                if (!Objects.equals(item1, item2)) {
                    mismatches++;
                }
            }
            return (mismatches == 0);
        }
//You can cage a swallow, can’t you, but you can’t swallow a cage, can you?
    }*/


    //Q . 4 done
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
            queues = (ArrayBasedQueue<E>[]) new ArrayBasedQueue[highestPriority + 1];
            totalSize = 0;
        }

        public void add(E item, int priority) {
            if (priority > (queues.length - 1) || priority < 0)
                throw new IllegalArgumentException("Illegal priority");

            if (queues[priority] == null)
                queues[priority] = new ArrayBasedQueue<>();

            queues[priority].add(item);

            if (priority > highestPrio)
                highestPrio = priority;
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


    //Q. 5  //need to be checked
    /*class linkedPriorityQueue {
        Node front, rear;

        class Node {
            int data, priority;
            Node link;

            public Node(int d, int p) {
                this.data = d;
                this.priority = p;
                link = null;
            }
        }

        public void enqueue(int data, int priority) {
            Node node = new Node(data, priority);
            if (front == null || front.priority > node.priority) {
                node.link = front;
                front = rear = node;
            } else {
                Node temp = front;
                while (temp.link != null && temp.link.priority <= node.priority) {
                    temp = temp.link;
                }
                node.link = temp.link;
                temp.link = node;
            }
        }

        public void dequeue() {
            if (front == null) return;
            front = front.link;
        }
    }*/


    //Q. 6 // need to be checked
    /*class CircularQueue<E> {
        Node<E> rear;
        int manyNodes;

        public CircularQueue() {
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

    *//*public LinkedBasedQueue<E> clone() { // check self no. 19
        LinkedBasedQueue<E> answer;
        try {
            answer = (LinkedBasedQueue<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implement Cloneable");
        }
        answer.front = Node.listCopy(front);
        return answer;
    }*//*

    }*/


    //Q. 7 //double-ended queue .. adding and removing from both ends
    /*public class Deque<E> {
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

    *//*public void clear() {
        while (removeFirst() != null) {
            removeFirst();
        }
    }*//*
    }

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
    }*/


    //Q. 13
    /*class ArrayDeque<E> {
        E[] data;
        int front, rear;
        int manyItems;

        public ArrayDeque(int initCapacity) {
            if(initCapacity < 0) throw new IllegalArgumentException();
            data =  (E[]) new Object[initCapacity];
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
