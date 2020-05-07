package test.tyella.java.core.generic;

import java.util.LinkedHashMap;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tyella.java.core.generic.Generic;

/**
 * Generic Tester.
 *
 * @author <tianyuan>
 * @version 1.0
 * @since <pre>5�� 6, 2020</pre>
 */
public class GenericTest {


    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: generic1()
     */
    @Test
    public void testGeneric1() throws Exception {
        Generic.generic1();
    }

    @Test
    public void testGeneric2() throws Exception {
        Generic.generic2();
    }

    @Test
    public void testGeneric3() {
        Generic.generic3();
    }

    @Test
    public void testGeneric4() {
        Generic.generic4();
    }

    @Test
    public void testGeneric5() {
        Generic.Generic5();
    }

    @Test
    public void testGeneric6() {
        Generic<String> generic = new Generic<>("ccc");
        Generic<Integer> generic1 = new Generic<>(111);
        /** ���ͷ������ڵ��÷���ʱָ�����͵ľ������� */
        System.out.println("Key name of String is:" + Generic.showKeyName(generic));
        System.out.println("Key name of Integer is:" + Generic.showKeyName(generic1));
    }

    @Test
    public void testGeneric7() {
        Generic.printMsg("aa", 11, 22L, "cc", 12.3);
    }

    @Test
    public void testGeneric8() {
        Generic<Integer> integerGeneric = new Generic<>(111);
        Generic<Long> longGeneric = new Generic<>(222L);
        Generic<Double> doubleGeneric = new Generic<>(2.1);
        Generic<Float> floatGeneric = new Generic<>(2.2f);
        Generic<String> stringGeneric = new Generic<>("aaa");

        Generic.showKeyValue2(integerGeneric);
        Generic.showKeyValue2(longGeneric);
        Generic.showKeyValue2(doubleGeneric);
        Generic.showKeyValue2(floatGeneric);
        /** �������,String����Number������ */
        //Generic.showKeyValue2(stringGeneric);
    }

    @Test
    public void testGeneric9() {
        Generic<LinkedHashMap> linkedHashMapGeneric = new Generic<>(new LinkedHashMap());
        Generic<Object> objectGeneric = new Generic<>(new Object());

        /** �������LinkedHashMap����HashMap�ĸ��� */
        //Generic.showKeyValue3(linkedHashMapGeneric);
        Generic.showKeyValue3(objectGeneric);
    }

    @Test
    public void testGeneric10() {
        Generic.genericArray();
    }

    @Test
    public void testGeneric11() {
        Generic<Integer> integerGeneric = new Generic<>(11);
        /**������󣬴��뷺�͵����Ͳ���ֻ��ʹ�����ͣ������Ǽ����� */
        //Generic<int> intGeneric = new Generic<int>(11);
    }
}
