package instigate.myArray;

import java.util.Arrays;

public class MyArray <T> {
    private T[] item ;
    private int i = 0;

    public MyArray() {
        this.item = (T[]) new Object[1];
    }

    public MyArray(int size){
        this.item = (T[]) new Object[size];
    }

    // adding element to last
    public void add(T ob){
      if (i < item.length){
          item[i++] = ob;
      }else {
          int size = item.length;
          size ++;

          T[] temp = (T[]) new Object[size];
          for (int j = 0; j < item.length; j++) {
              temp[j] = item[j];
          }
            temp[size-1] = ob;
            item = temp;
            i = size;
      }

    }

    //deleting last element
    public void pop(){
        int size = item.length -1;
        T[] temp = (T[]) new Object[size];
        for (int j = 0; j < temp.length; j++) {
            temp[j] = item[j];
        }
        item = temp;
        i = size;

    }

    //adding element to first
    public void shift(T ob){
        if (i < item.length){
            item[i++] = ob;
        }else {
            int size = item.length;
            size++;

            T[] temp = (T[]) new Object[size];
            temp[0] = ob;
            for (int j = 1; j < temp.length; j++) {
                temp[j] = item[j-1];
            }
            item = temp;
            i = size;
        }
    }

    //remove first element
    public void unshift(){
        if (isEmty()){
            System.err.println("[unshift()] : arry is Empty");
            return;
        }
        int size = item.length -1;
        T[] temp = (T[]) new Object[size];
        for (int j = 0; j < temp.length; j++) {
            temp[j] = item[j+1];
        }
        item = temp;
        i = size;
    }

    //add element to is index
    public void set(T ob, int index){
        if (i < item.length){
            item[i++] = ob;
        }else {
            int size = item.length;
            size ++;

            T[] temp = (T[]) new Object[size];
            for (int j = 0, k = 0; j < temp.length; j++, k++) {
                if (j == index){
                    temp[j] = ob;
                    k--;
                }else {
                    temp[j] = item[k];
                }
            }
            item = temp;
            i = size;
        }
    }

    // replase element at index
    public void replace(T ob, int index){
        for (int j = 0, k = 0; j < item.length; j++, k++) {
            if (j == index){
                item[j] = ob;
            }
        }
    }

    //remove element at index
    public void remove(int index){
        if (isEmty()){
            System.err.println("[remove()] : arry is Empty");
            return;
        }
        int size = item.length -1;
        T[] temp = (T[]) new Object[size];
        for (int j = 0, k = 0; j < temp.length; j++, k++) {
            if (j == index){
                k++;
                temp[j] = item[k];


            }else {
                temp[j] = item[k];
            }
        }
        item = temp;
        i = size;
    }

    //find element return if element true - false
    public boolean contains(T ob){
        for (T o : item) {
            if (o == ob){
                return true;
            }
        }
        return false;
    }

    //return if array isEmpty return true else return false
    public boolean isEmty(){
        int count = 0;
        for (int j = 0; j < item.length; j++) {
            count ++;
        }
        if (count == 0 ) return true;
        return false;
    }

    //find element & return first index of element & return -1 if element dos`t is in
    public int find(T ob){
        for (int j = 0; j < item.length; j++) {
            if (item[j] == ob) return j;
        }
        return -1;
    }

    //returnt size
    public int size(){
        return item.length;
    }

    //reversed array
    public void reverse(){
        T[] temp = (T[]) new Object[i];
        for (int j = item.length -1, k = 0; j >=0 ; j--,k++) {
            temp[k] = item[j];
        }
        item = temp;
    }

    //sorting array
    public void sort(){
        Arrays.sort(item);
    }

    //maximium of array
    public T max(){
        if (isEmty()){
            System.err.println("[max] : array is empty");
            T temp = null;
            return temp;
        }
        sort();
        return item[item.length -1];
    }

    //minimium of array
    public T min(){
        if (isEmty()){
            System.err.println("[max] : array is empty");
            T temp = null;
            return temp;
        }
        sort();
        return item[0];
    }

    //show array
    public void show(){
        if (isEmty()) {
            System.err.println("[show()] : array is Empty");
            return;
        }
        for (T o : item ) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

}
