/**  This deque must use arrays as the core data structure */

public class ArrayDeque <T> {
    public int index;
    public int size;


    /**change below to private when test */
    public int length;
    public T[] arr;
    public int nextFirst;
    public int nextLast;
    public double thresholdRateUp = 0.75;
    public double thresholdRateDown = 0.25;


    public ArrayDeque(){
        arr = (T[]) new Object[8];
        length = 8;
        size = 0;
        nextFirst = length - 1;
        nextLast = size;
    }

    public T[] getAllArray() {
        T[] newArr = (T[]) new Object[size];
        if (nextFirst <= nextLast) {
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i + nextFirst + 1];
            }
        } else {
            int partOneLength = length - nextFirst - 1;
            for (int i = 0; i < partOneLength; i++) {
                newArr[i] = arr[i + nextFirst + 1];
            }
            for (int i = 0; i < size - partOneLength; i++) {
                newArr[partOneLength + i] = arr[i];
            }
        }
        return newArr;
    }


    public void resizeTo(double toRate){
        int newLength = (int)(length * toRate);
        T[] newArr = (T[]) new Object[newLength];
        T[] oriArr = getAllArray();
        for (int i = 0; i <size; i++){
            newArr[i] = oriArr[i];
        }
        arr = newArr;
        length = newLength;
        nextFirst = length - 1;
        nextLast = size;
    }

    public void resizeArr(){
        if (size / length > thresholdRateUp){
            resizeTo(2);
        }
        else if (size / length < thresholdRateDown && length > 100){
            resizeTo(0.5);
        }
    }

/** upgrade the first and last, when add element, n=1, when delete, n = -1 */
    public int getUpdateFirst(int n){
        if (nextFirst == 0 && n ==1){
            return length - 1;
        }
        else if (nextFirst == length - 1 && n == -1){
            return 0;
        }
        return nextFirst - n;
    }

    public int getUpdateLast(int n){
        if (nextLast == length - 1 && n == 1){
            return 0;
        }
        else if (nextLast == 0 && n == -1){
            return length - 1;
        }
        return nextLast + n;
    }

    public void addFirstArray(T item){
        resizeArr();
        arr[nextFirst] = item;
        size++;
        nextFirst = getUpdateFirst(1);
    }

    public void addLastArray(T item){
        resizeArr();
        arr[nextLast] = item;
        size++;
        nextLast = getUpdateLast(1);
    }

    public boolean isEmptyArray(){
        return size == 0;
    }

    public int sizeArray(){
        return size;
    }

    public void arrayDequePrint(){
        T[] arrToPrint = getAllArray();
        for(int i = 0; i < size; i++){
            System.out.print(arrToPrint[i]);
            if (i < size - 1){
                System.out.print(' ');
            }
        }
    }

    public T arrayRemoveFirst(){
        nextFirst = getUpdateFirst(-1);
        size--;
        T res = arr[nextFirst];
        arr[nextFirst] = null;
        return res;
    }

    public T arrayRemoveLast(){
        nextLast = getUpdateLast(-1);
        size--;
        T res = arr[nextLast];
        arr[nextLast] = null;
        return res;
    }

    public T arrayGet(int index){
        int realIndex = nextFirst + 1 + index;
        if (realIndex >= length){
            realIndex = index - (length - nextFirst - 1);
        }
        return arr[realIndex];
    }


}
