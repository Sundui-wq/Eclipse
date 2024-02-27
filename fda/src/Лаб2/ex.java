package Лаб2;

import java.util.ArrayList;

public class ex<T> {
    private ArrayList<T> sundui;

    public ex() {
        sundui = new ArrayList<>();
    }

    public void addElement(T element) {
        sundui.add(element);
    }

    public T getElement(int index) {
        return sundui.get(index);
    }

    public int size() {
        return sundui.size();
    }
}

   