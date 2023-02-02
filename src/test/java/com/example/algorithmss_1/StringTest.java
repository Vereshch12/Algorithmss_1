package com.example.algorithmss_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {
    private final StringList actual = new StringList(10);
    private final StringList expected = new StringList(10);

    @BeforeEach
    public void setUp() throws StringException {
        actual.add("1");
        actual.add("2");
        actual.add("3");
        actual.add("4");
        expected.add("1");
        expected.add("2");
        expected.add("3");
        expected.add("4");
    }

    @Test
    public void addCheckingReturnValueTest() throws StringException {
        String expectedStr = "str";
        String actualStr = actual.add(expectedStr);
        assertEquals(actualStr, expectedStr);
    }

    @Test
    public void addResultTest() throws StringException {
        String value = "str";
        actual.add(value);
        expected.add(value);
        assertEquals(actual, expected);
    }

    @Test
    public void addFullListExcepionTest() throws StringException {
        String value1 = "str1";
        String value2 = "str2";
        String value3 = "str3";
        String value4 = "str4";
        String value5 = "str5";
        String value6 = "str6";
        actual.add(value1);
        actual.add(value2);
        actual.add(value3);
        actual.add(value4);
        actual.add(value5);
        actual.add(value6);
        String value7 = "str7";
        StringException thrown = assertThrows(StringException.class, () -> actual.add(value7), "Expected doThing() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("Лист уже заполнен!"));
    }

    @Test
    public void addWithIndexCheckingReturnValueTest() throws StringException {
        String expectedStr = "str";
        String actualStr = actual.add(2, expectedStr);;
        assertEquals(actualStr, expectedStr);
    }

    @Test
    public void addWithIndexResultTest() throws StringException {
        String value = "str";
        actual.add(2,value);
        expected.add(2,value);
        assertEquals(actual, expected);
    }

    @Test
    public void addWithIndexFullListExceptionTest() throws StringException {
        String value1 = "str1";
        String value2 = "str2";
        String value3 = "str3";
        String value4 = "str4";
        String value5 = "str5";
        String value6 = "str6";
        actual.add(value1);
        actual.add(value2);
        actual.add(value3);
        actual.add(value4);
        actual.add(value5);
        actual.add(value6);
        String value7 = "str7";
        StringException thrown = assertThrows(StringException.class, () -> actual.add(5,value7), "Expected doThing() to throw, but it didn't");
        assertTrue(thrown.getMessage().contentEquals("Лист уже заполнен!"));
    }

    @Test
    public void addWithIndexBigIndexExceptionTest(){
        String value = "str";
        StringException thrown = assertThrows(StringException.class, () -> actual.add(4,value), "Expected doThing() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("Индекс элемента превышевышает количество элементов!"));
    }

    @Test
    public void setCheckingReturnValueTest() throws StringException {
        String expectedStr = "str";
        String actualStr = actual.set(2, expectedStr);
        assertEquals(actualStr, expectedStr);
    }

    @Test
    public void setResultTest() throws StringException {
        String value = "str";
        actual.set(2,value);
        expected.set(2,value);
        assertEquals(actual, expected);
    }

    @Test
    public void setBigIndexExceptionTest(){
        String value = "str";
        StringException thrown = assertThrows(StringException.class, () -> actual.set(4,value), "Expected doThing() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("Индекс элемента превышевышает количество элементов!"));
    }

    @Test
    public void removeByItemCheckingReturnValueTest() throws StringException {
        String expectedStr = "3";
        String actualStr = actual.remove(expectedStr);
        assertEquals(actualStr, expectedStr);
    }

    @Test
    public void removeByItemResultTest() throws StringException {
        String value = "2";
        actual.remove(value);
        expected.remove(value);
        assertEquals(actual, expected);
    }

    @Test
    public void removeNoSuchElemntExceptionTest(){
        String value = "str";
        StringException thrown = assertThrows(StringException.class, () -> actual.remove(value), "Expected doThing() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("Такого элемента нет!"));
    }

    @Test
    public void removeByIndexCheckingReturnValueTest() throws StringException {
        String expectedStr = "3";
        String actualStr = actual.remove(2);
        assertEquals(actualStr, expectedStr);
    }

    @Test
    public void removeByIndexResultTest() throws StringException {
        actual.remove(2);
        expected.remove(2);
        assertEquals(actual, expected);
    }

    @Test
    public void removeByIndexBigIndexExceptionTest(){
        StringException thrown = assertThrows(StringException.class, () -> actual.remove(4), "Expected doThing() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("Индекс элемента превышевышает количество элементов!"));
    }

    @Test
    public void containsTrueTest(){
        boolean expectedBool = true;
        boolean actualBool = actual.contains("3");
        assertEquals(expectedBool, actualBool);
    }

    @Test
    public void indexOfTest(){
        int expectedIndex = 3;
        int actualIndex = actual.indexOf("4");
        assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void indexOfWithoutElementTest(){
        int expectedIndex = -1;
        int actualIndex = actual.indexOf("0");
        assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void lastIndexOfTest(){
        int expectedIndex = 7;
        int actualIndex = actual.lastIndexOf("4");
        assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void lastIndexOfWithoutElementTest(){
        int expectedIndex = -1;
        int actualIndex = actual.lastIndexOf("0");
        assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void getTest() throws StringException {
        String expectedStr = "4";
        String actualStr = actual.get(3);
        assertEquals(actualStr, expectedStr);
    }

    @Test
    public void getNoSuchElemntExceptionTest(){
        StringException thrown = assertThrows(StringException.class, () -> actual.get(6), "Expected doThing() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("Индекс элемента превышевышает количество элементов!"));
    }


    @Test
    public void equalsTrueTest(){
        Boolean expectedBool = true;
        Boolean actualBool = actual.equals(expected);
        assertEquals(actualBool, expectedBool);
    }

    @Test
    public void equalsFalseTest() throws StringException {
        Boolean expectedBool = false;
        expected.add("123");
        Boolean actualBool = actual.equals(expected);
        assertEquals(actualBool, expectedBool);
    }

    @Test
    public void equalsNullExceptionTest(){
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> actual.equals(null), "Expected doThing() to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contentEquals("Передан null!"));
    }

    @Test
    public void sizeTest(){
        int expectedSize = 4;
        assertEquals(expectedSize, actual.size());
    }

    @Test
    public void isEmptyTrueTest(){
        assertFalse(actual.isEmpty());
    }

    @Test
    public void isEmptyFalseTest(){
        StringList actual1 = new StringList(5);
        assertTrue(actual1.isEmpty());
    }

    @Test
    public void ClearTest(){
        StringList expected1 = new StringList(10);
        actual.clear();
        assertEquals(expected1, actual);
    }
}
