package tyella.java.core.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Generic<T> {

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    /**
     * java.lang.ClassCaseException: java.lang.Integer cannot be cast to java.lang.String
     */
    public static void generic1() {
        List list = new ArrayList();
        list.add("aaa");
        list.add(111);
        for (int i = 0; i < list.size(); i++) {
            String item = (String) list.get(i);
            System.out.println("item is:" + item);
        }
    }

    /**
     * 编译直接不通过
     */
    public static void generic2() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        //list.add(111);
    }

    /**
     * Java中的泛型，只在编译阶段有效，编译结束后，Java会将泛型擦除。
     * 泛型信息不会进入到运行时阶段
     */
    public static void generic3() {
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        Class stringListClass = stringList.getClass();
        Class integerListClass = integerList.getClass();
        if (stringListClass.equals(integerListClass)) {
            System.out.println("stringListClass和integerListClass相同");
        }
    }

    public static void showKeyValue(Generic<String> obj) {
        System.out.println("The key of obj is:" + obj.getKey());
    }

    public static void generic4() {
        Generic<Integer> integerGeneric = new Generic<>(111);
        Generic<String> stringGeneric = new Generic<>("aaa");
        showKeyValue(stringGeneric);
        /** 编译错误 */
        //showKeyValue(integerGeneric);
    }

    public static void showKeyValue1(Generic<?> obj) {
        System.out.println("The key of obj is:" + obj.getKey());
    }

    /**
     * 泛型通配符，一般使用 ？ 代替具体的类型实参。可以把 ？ 看成所有类的父类，是一种真实的类型
     */
    public static void Generic5() {
        Generic<Integer> integerGeneric = new Generic<>(111);
        Generic<String> stringGeneric = new Generic<>("bbb");
        showKeyValue1(integerGeneric);
        showKeyValue1(stringGeneric);
    }

    /**
     * public与返回值之间的<T>必不可少，表明这是一个泛型方法，并且声明了一个泛型T
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> T showKeyName(Generic<T> obj) {
        T result = obj.getKey();
        return result;
    }

    /**
     * 这是一个泛型方法，泛型可以有多个
     */
    public <T, K> T showKeyName1(Generic<K> obj) {
        return null;
    }

    public void show_1(T obj) {
        System.out.println("obj is:" + obj.toString());
    }

    /**
     * 泛型方法
     */
    public <T> void show_2(T obj) {
        System.out.println("obj is:" + obj.toString());
    }

    /**
     * 在泛型类中声明了泛型方法，使用泛型K。其中泛型K是一种全新的类型，可以与T相同，也可以与T不同
     * 由于泛型方法在声明时使用了泛型K，即使泛型类没有声明泛型K，编译器仍然能够正确识别泛型方法中的泛型
     */
    public <K> void show_3(K obj) {
        System.out.println("obj is:" + obj.toString());
    }

    /**
     * Unknown class E
     */
    /*public void showKey(E obj) {
        System.out.println("obj is:" + obj.toString());
    }*/


    /**
     * 泛型方法与可变参数
     *
     * @param args
     * @param <T>
     */
    public static <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println(t);
        }
    }

    /**
     * 如果类中定义了使用泛型的静态方法，那么需要将这个方法声明为泛型方法
     * 下文中这个方法会编译错误
     */
    /*public static void showKeyValue(Generic<T> obj) {
        System.out.println("Obj is:" + obj.toString());
    }*/

    /** 泛型的上边界 */
    public static void showKeyValue2(Generic<? extends Number> obj) {
        System.out.println("Key value is:" + obj.getKey());
    }

    /** 泛型的下边界 */
    public static void showKeyValue3(Generic<? super HashMap> obj){
        System.out.println("Key value is:"+obj.getKey());
    }

    /** 泛型数组，Java中不能创建泛型数组，在编译时会擦除具体类型 */
    public static void genericArray() {
        /** Not really allowed. */
        //List<String>[] ls = new ArrayList<String>[10];

        /** 使用通配符创建泛型数组是可以的，因为通配符要做强制类型转换 */
        List<?>[] ls = new ArrayList<?>[10];
        Object ob = ls;
        Object[] oa = (Object[]) ob;
        List<Integer> list = new ArrayList<>();
        list.add(new Integer(2));
        oa[1] = list;
        Integer ite = (Integer) ls[1].get(0);
        System.out.println("Ite is:" + ite);
    }
}
