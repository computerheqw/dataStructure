package com.hqw.array;

public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 构造函数
     * 传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 构造函数
     * 默认数组容量capacity为10，构造Array
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取指定下标的元素值
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed, index is illegal");
        }
        return data[index];
    }

    /**
     * 获取数组中第一个值
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取数组中最后一个值
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改元素值
     * @param index
     * @param value
     */
    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed, " + index + " is illegal");
        }
        data[index] = value;
    }


    /**
     * 查看是否包含该元素
     * @param value
     * @return
     */
    public boolean contains(E value) {
        if (findIndex(value) != -1) {
            return true;
        }
        return false;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 查询元素下标
     * @param value
     * @return
     */
    public int findIndex(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查询指定元素的最后一位的下标
     * @param value
     * @return
     */
    public int findLastIndex(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 向数组的指定位置添加元素
     * @param index
     * @param value
     */
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed, " + index + " is illegal");
        }
        if (size == data.length) {
            resize(data.length * 2);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size ++;
    }

    /**
     * 向数组首部添加元素
     * @param value
     */
    public void addFirst(E value) {
        add(0, value);
    }

    /**
     * 向所有元素后添加一个新的元素
     * @param value
     */
    public void addLast(E value) {
        add(size, value);
    }

    /**
     * 删除数组中指定位置的元素
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed, " + index + " is illegal");
        }
        E temp = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        if (size <= data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return temp;
    }

    /**
     * 删除数组中第一个元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除数组中指定的元素
     * @param value
     */
    public void removeElement(E value) {
        int index = findIndex(value);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 删除数组中指定元素的最后一个元素
     * @param value
     */
    public void removeLast(E value) {
        int index = findLastIndex(value);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 动态修改数组的容量
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array: size = %d, capactiy = %d\n", size, data.length));
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
