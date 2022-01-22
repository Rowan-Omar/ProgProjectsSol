public class Ch10_Heap {

    // done It is a max heap implementation
    /*public class BinaryHeap {
        private int lastPosition; // will be the last available place to put our new item
        // also it will have the actual number of elements we do have
        private int[] data;

        public BinaryHeap(int size) {
            data = new int[size];
            lastPosition = 0;
        }

        public void add(int obj) {
            if(lastPosition == data.length) {
                System.out.println("The heap is full");
                return;
            }
            data[lastPosition++] = obj;
            trickleUp((lastPosition-1));
        }

        private void swap(int from, int to) {
            int temp = data[from];
            data[from] = data[to];
            data[to] = temp;
        }

        private void trickleUp(int childInd) {
            if (childInd == 0) return; // we reached the root so no need for any further trickle
            int parentInd = (int) Math.floor((double) ((childInd - 1) / 2));

            if (data[parentInd] < data[childInd]) {
                swap(childInd, parentInd);
                trickleUp(parentInd);
            }
        }

        public int remove() {
            if (lastPosition == 0) return -1;

            int removed = data[0];

            if (lastPosition == 1) //just one element exists
                return removed;

            swap(0, lastPosition--);

            trickleDown(0);

            return removed;
        }

        private void trickleDown(int parentInd) {
            int left = (2 * parentInd) + 1;
            int right = (2 * parentInd) + 2;

            if ((left == lastPosition) && (data[parentInd] < data[left])) {
                swap(parentInd, left);
                return;
            }

            if ((right == lastPosition) && (data[parentInd] < data[right])) {
                swap(parentInd, left);
                return;
            }

            if (left >= lastPosition || right >= lastPosition)
                return;

            if ((data[left] > data[right]) && (data[parentInd] < data[left])) {
                swap(parentInd, left);
                trickleDown(left);
            } else if (data[parentInd] < data[right]) {
                swap(parentInd, right);
                trickleDown(right);
            }
        }

        public void display() {
            for (int i =0; i<lastPosition;i++)
                System.out.print(data[i] + "  ");
            System.out.println();
        }

        public static void main(String[] args) {
            BinaryHeap heap = new BinaryHeap(20);
            for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
                heap.add(i);

            heap.display();

            System.out.println(heap.data[4]);
            System.out.println(heap.remove());
            System.out.println(heap.remove());
            System.out.println(heap.remove());
            heap.display();

            System.out.println(heap.data[0]);
            System.out.println(heap.data[4]);
        }
    }*/


}
