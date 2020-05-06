package test.tyella.java.core.generic;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tyella.java.core.generic.Generic;

/**
 * Generic Tester.
 *
 * @author <tianyuan>
 * @version 1.0
 * @since <pre>5月 6, 2020</pre>
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
        /** 泛型方法，在调用方法时指明泛型的具体类型 */
        System.out.println("Key name of String is:" + Generic.showKeyName(generic));
        System.out.println("Key name of Integer is:" + Generic.showKeyName(generic1));
    }

    @Test
    public void testGeneric7() {
        Generic.printMsg("aa", 11, 22L, "cc", 12.3);
    }
}
