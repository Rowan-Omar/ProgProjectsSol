public class Ch9_Tree {
    
    //Q.1  //done
    /*class ExpTree {
        private BTNode<String> root;

        public ExpTree(Object obj) {
            root = new BTNode<String>(obj.toString(), null, null);
        }

        public void add(Object obj) {
            BTNode newNode;
            try {
                int val = Integer.parseInt(obj.toString());
                recAdd(val, root);
            } catch (Exception e) {
                newNode = new BTNode<String>((String) obj, null, null);
                add(newNode, root);
            }
        }

        private void add(BTNode tn, BTNode<String> localRoot) {
            // if (localRoot == null)
            //   localRoot = (BTNode<String>) tn;
            // else {
            if (localRoot.getLeft() == null)
                localRoot.setLeft(tn);
            else if (localRoot.getRight() == null)
                localRoot.setRight(tn);
            // }
        }

        private BTNode recAdd(int element, BTNode<String> start) {
            if (start == null)
                start = new BTNode(element, null, null);
            else if (start.getRight() == null)
                start.setRight(recAdd(element, start.getRight()));
            else
                start.setLeft(recAdd(element, start.getLeft()));
            return start;
        }

        private double evaluate(Object localRoot) {
            try {
                return (double) ((BTNode<Integer>) (localRoot)).getData();
            } catch (Exception e) {
                String rootStr = ((BTNode<String>) localRoot).getData();
                Object left = ((BTNode<String>) localRoot).getLeft();
                Object right = ((BTNode<String>) localRoot).getRight();

                switch (rootStr) {
                    case "*":
                        return evaluate(left) * evaluate(right);
                    case "/":
                        return evaluate(left) / evaluate(right);
                    case "+":
                        return evaluate(left) + evaluate(right);
                    case "-":
                        return evaluate(left) - evaluate(right);
                    default:
                        return 0;
                }
            }
        }

        public double evaluate() {
            return evaluate(root);
        }

        public void display() {
            root.print(0);
        }
    }*/


    //Q.2
    /*class CompleteTree<E> {
        E[] data;
        int manyItems;
        private boolean[] isPresent;

        public CompleteTree() {
            data = (E[]) new Object[10];
        }

        public void display() {
            for (int i = 0; i < manyItems; i++) {
                System.out.println(data[i]);
            }
        }

        public void add(E item) {
            if (manyItems == data.length) {
                ensureCapacity(manyItems * 2 + 1);
            }
            data[manyItems] = item;
            manyItems++;
        }

        public void removeLast() {
            manyItems--;
        }

        public void ensureCapacity(int minCap) {
            E[] biggerArray;
            if (minCap < data.length) {
                return;
            }
            biggerArray = (E[]) new Object[minCap];
            System.arraycopy(data, 0, biggerArray, 0, data.length);
            data = biggerArray;
        }
    }*/


    // Q.2 and 3 // done
    /*public class ArrayTree {
        private int[] data;
        private int currentIndex;
        private boolean[] isPresent;

        public ArrayTree(int initCapacity) {
            data = new int[initCapacity];
            isPresent = new boolean[initCapacity];
            currentIndex = -1;
        }

        public void add(int value) {
            if (currentIndex == data.length - 1) {
                System.out.println("Tree is full");
            } else {
                data[++currentIndex] = value;
                isPresent[currentIndex] = true;
            }
        }

        public void preorderTraversal(int index) {
            if (index > currentIndex) return;
            System.out.print(data[index] + " ");
            preorderTraversal((index * 2) + 1);
            preorderTraversal((index * 2) + 2);
        }

        public void postorderTraversal(int index) {
            if (index > currentIndex) return;
            postorderTraversal((index * 2) + 1);
            postorderTraversal((index * 2) + 2);
            System.out.print(data[index] + " ");
        }

        public void inorderTraversal(int index) {
            if (index > currentIndex) return;
            inorderTraversal((index * 2) + 1);
            System.out.print(data[index] + " ");
            inorderTraversal((index * 2) + 2);
        }

        public void levelOrderTraversal() {
            for (int i = 0; i <= currentIndex; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println("\nThe isPresent values");
            for (int i = 0; i < data.length; i++) {
                System.out.print(isPresent[i] + " ");
            }
        }

        public int search(int key) {
            for (int i = 0; i <= currentIndex; i++) {
                if (data[i] == key)
                    return i;
            }
            return -1;
        }

        public boolean remove(int target) {
            int location = search(target);
            if (location == -1) return false;
            data[location] = data[currentIndex];
            isPresent[currentIndex] = false;
            currentIndex--;
            return true;
        }


}*/


    //Q.6  //done
    /*public void preorderVector(Vector<E> v) { //VLR
        if (v == null)
            throw new NullPointerException("v is null");

        v.addElement(this.data);
        if (left != null) left.preorderVector(v);
        if (right != null) right.preorderVector(v);
    }

    public void inorderVector(Vector<E> v) { //LVR
        if (v == null)
            throw new NullPointerException("v is null");
        if (left != null) left.inorderVector(v);
        v.addElement(this.data);
        if (right != null) right.inorderVector(v);
    }

    public void postorderVector(Vector<E> v) { //LRV
        if (v == null)
            throw new NullPointerException("v is null");
        if (left != null) left.postorderVector(v);
        if (right != null) right.postorderVector(v);
        v.addElement(this.data);
    }

    public void displayVector(Vector<E> v) {
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.elementAt(i) + " ");
        }
        System.out.println();
    }*/


    // Q.7  // done
    /*public static TreeBag<Integer> createBalancedTree(int[] arr) {
        if (arr == null)
            throw new IllegalArgumentException();

        int size = arr.length;
        TreeBag<Integer> t = new TreeBag<>();
        if (size == 1)
            t.add(arr[0]);
        else if (size > 1) {
            int middle = (arr.length) / 2;
            t.add(arr[middle]);
            int[] subLeftArray = new int[middle];
            System.arraycopy(arr, 0, subLeftArray, 0, middle);
            TreeBag<Integer> left = createBalancedTree(subLeftArray);

            int[] subRightArray = new int[arr.length - middle - 1];
            System.arraycopy(arr, middle + 1, subRightArray, 0, (size - middle - 1));
            TreeBag<Integer> right = createBalancedTree(subRightArray);
            join(t, left, right);
        }
        return t;
    }*/


}
