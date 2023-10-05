package basics;

public class DynamicArray {
        int[] list;
        int capacity;
        int size = 0;

        public DynamicArray(int capacity) {
                this.list = new int[capacity];
                this.capacity = capacity;
        }

        public int get(int i) {
                return list[i];
        }

        public void set(int i, int n) {
                list[i] = n;
                if (i >= size) {
                        size++;
                }
        }

        public void pushback(int n) {
                if (size == capacity) {
                        resize();
                }
                list[size] = n;
                size++;
        }

        public int popback() {
                size--;
                return list[size];
        }

        private void resize() {
                int[] new_list = new int[capacity * 2];
                for (int i = 0; i < size; i++) {
                        new_list[i] = list[i];
                }
                list = new_list;
                capacity = capacity * 2;
        }

        public int getSize() {
                return this.size;
        }

        public int getCapacity() {
                return this.capacity;
        }

        /*
        resize(twice) when actual size reaches the capacity
         */
        public static void main(String[] args) {
                DynamicArray dynamicArray = new DynamicArray(2);
                dynamicArray.pushback(0);
                dynamicArray.pushback(1);
                dynamicArray.pushback(2);
                System.out.println(dynamicArray.getSize());
                System.out.println(dynamicArray.getCapacity());
        }
}
