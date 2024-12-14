package com.example.algorithmss_1;

import java.util.Arrays;
import java.util.Objects;

public class StringList implements StringListInterface {
    private final String[] strList;

    private final Integer size;

    public StringList(Integer size) {
        this.size = size;
        this.strList = new String[size];
    }

    @Override
    public String add(String item) throws StringException {
        for (int i = 0; i < strList.length; i++) {
            if (strList[i] == null) {
                strList[i] = item;
                return item;
            }
        }
        throw new StringException("Лист уже заполнен!");
    }

    @Override
    public String add(int index, String item) throws StringException {
        if (strList[size-1] != null) throw new StringException("Лист уже заполнен!");
        int realSize = 0;
        while (strList[realSize] != null){
            realSize++;
        }
        if (index >= realSize){
            throw new StringException("Индекс элемента превышевышает количество элементов!");
        }
        String helpStr = strList[index];
        strList[index] = item;
        item = helpStr;
        for (int i = index + 1; i < strList.length; i++){
            helpStr = strList[i];
            strList[i] = item;
            item = helpStr;
        }
        return strList[index];
    }

    @Override
    public String set(int index, String item) throws StringException {
        int realSize = 0;
        while (strList[realSize] != null){
            realSize++;
        }
        if (index >= realSize){
            throw new StringException("Индекс элемента превышевышает количество элементов!");
        }
        strList[index] = item;
        return strList[index];
    }

    @Override
    public String remove(String item) throws StringException {
        for (int i = 0; i < strList.length; i++) {
            if (strList[i] == item) {
                int j;
                for (j = i; j < strList.length - 1; j++) {
                    strList[j] = strList[j + 1];
                }
                strList[j] = null;
                return item;
            }
        }
        throw new StringException("Такого элемента нет!");
    }

    @Override
    public String remove(int index) throws StringException {
        int realSize = 0;
        while (strList[realSize] != null){
            realSize++;
        }
        if (index >= realSize){
            throw new StringException("Индекс элемента превышевышает количество элементов!");
        }
        int j;
        String str = strList[index];
        for (j = index; j < strList.length - 1; j++) {
            strList[j] = strList[j + 1];
        }
        strList[j] = null;
        return str;
    }

    @Override
    public boolean contains(String item) {
        for (String s : strList) {
            if (Objects.equals(s, item)) return true;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < strList.length; i++) {
            if (strList[i] == item)
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = strList.length - 1; i >= 0; i--) {
            if (strList[i] == item)
                return strList.length - i;
        }
        return -1;
    }


    @Override
    public String get(int index) throws StringException {
        int realSize = 0;
        while (strList[realSize] != null){
            realSize++;
        }
        if (index >= realSize){
            throw new StringException("Индекс элемента превышевышает количество элементов!");
        }
        return strList[index];
    }

    @Override
    public int size() {
        int i = 0;
        while (strList[i] != null){
            i++;
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        for (String s : strList) {
            if (s != null)
                return false;
        }
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(strList, null);
    }

    @Override
    public String[] toArray() {
        String[] strArray = new String[strList.length];
        System.arraycopy(strList, 0, strArray, 0, strList.length);
        return strArray;
    }

    @Override
    public String toString() {
        return
                "{strList=" + Arrays.toString(strList) +
                        ", size=" + size +
                        '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) throw new RuntimeException("Передан null!");
        StringList that = (StringList) o;
        return (Arrays.equals(strList, that.strList) && size.equals(that.size));
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(strList);
        return result;
    }
}
