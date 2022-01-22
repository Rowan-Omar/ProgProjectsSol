public class Ch9_Tree {

    // done
    /*public void add(int element) {
        BTNode<Integer> cursor = root;
        boolean done = false;
        BTNode<Integer> newNode = new BTNode<Integer>(element, null, null);

        if (cursor == null) {
            root = newNode;
            return;
        }

        while (!done) {
            if (element <= cursor.getData()) {
                if (cursor.getLeft() == null) {
                    cursor.setLeft(newNode);
                    done = true;
                } else
                    cursor = cursor.getLeft();
            } else {
                if (cursor.getRight() == null) {
                    cursor.setRight(newNode);
                    done = true;
                } else
                    cursor = cursor.getRight();
            }
        }
    }*/


    //done
    /*public void addMany(int... elements) {
        for (int element : elements)
            add(element);
    }*/

    //done
    /*public void addAll(IntTreeBag addend) {
        BTNode<Integer> addroot;
        if (addend == null)
            return;
        if (addend.root == root) {
            addroot = BTNode.treeCopy(addend.root);
            addTree(addroot);
        } else
            addTree(addend.root);
    }

    private void addTree(BTNode<Integer> addRoot) {
        if (addRoot != null) {
            add(addRoot.getData());
            addTree(addRoot.getLeft());
            addTree(addRoot.getRight());
        }
    }*/

    /*public boolean removeRec(int target) { //done bs el condition mesh zahr sa7
        BTNode<Integer> targetNode = removeRec(root, target);
        return (targetNode != null);
    }

    private BTNode<Integer> removeRec(BTNode<Integer> node, int target) {
        if (node == null)
            return null;
        if (target > node.getData())
            node.setRight(removeRec(node.getRight(), target));
        else if (target < node.getData())
            node.setLeft(removeRec(node.getLeft(), target));
        else {// if key is same as node's key, then This is the node to be deleted
            // node with only one child or no child
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null)
                return node.getLeft();
            else {
                // node with two children: Get the inorder successor (smallest in the right subtree)
                node.setData(minValue(node.getRight()));
                // Delete the inorder successor
                node.setRight(removeRec(node.getRight(), node.getData()));
                return node;
            }
        }
        return node;
    }*/


    //done
    /*public IntTreeBag clone() {
        IntTreeBag answer;
        try {
            answer = (IntTreeBag) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("This class does not implement cloneable");
        }
        answer.root = BTNode.treeCopy(root);
        return answer;
    }*/

    //done
    /*public static IntTreeBag union(IntTreeBag b1, IntTreeBag b2) {
        IntTreeBag answer = new IntTreeBag();
        if (b1 == null || b2 == null)
            throw new IllegalArgumentException("One or both the bags is null");
        answer.addTree(b1.root);
        answer.addTree(b2.root);
        answer.root = answer.root.getRight();
        return answer;
    }*/


    //done
    /*public int countOccur(int target) {
        int count = 0;
        BTNode<Integer> cursor = root;
        while (cursor != null) {
            if (target == cursor.getData()) {
                count++;
                cursor = cursor.getLeft();
            } else if (target < cursor.getData())
                cursor = cursor.getLeft();
            else
                cursor = cursor.getRight();
        }
        return count;
    }*/

    //done
    /*public int size() {
        return BTNode.treeSize(root);
    }*/


    //No. 18 page 542 //done
    /*public void sortedDisplay() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        root.inorderPrint();
    }*/


    // No. 19 page 542  // need to be checked
   /* public static void join(IntTreeBag top, IntTreeBag left, IntTreeBag right) {
        if (top == null || left == null || right == null)
            throw new IllegalArgumentException("one of them is null");

        if (top.root == null)
            throw new IllegalArgumentException("top is empty");

        if (!top.root.isLeaf())
            throw new IllegalArgumentException("top has more than one node");

        if(right.root != null && right.root.getData() <= top.root.getData())
            throw new IllegalArgumentException("elements on right must be larger than that of top");

        if(left.root != null && left.root.getData() > top.root.getData())
            throw new IllegalArgumentException("elements on left must be smaller than or equal that of top");

        top.root.setLeft(left.root);
        left.root = null;
        top.root.setRight(right.root);
        right.root = null;
    }*/


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
