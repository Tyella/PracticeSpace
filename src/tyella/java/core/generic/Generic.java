package tyella.java.core.generic;

import java.util.ArrayList;
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
     * ����ֱ�Ӳ�ͨ��
     */
    public static void generic2() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        //list.add(111);
    }

    /**
     * Java�еķ��ͣ�ֻ�ڱ���׶���Ч�����������Java�Ὣ���Ͳ�����
     * ������Ϣ������뵽����ʱ�׶�
     */
    public static void generic3() {
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        Class stringListClass = stringList.getClass();
        Class integerListClass = integerList.getClass();
        if (stringListClass.equals(integerListClass)) {
            System.out.println("stringListClass��integerListClass��ͬ");
        }
    }

    public static void showKeyValue(Generic<String> obj) {
        System.out.println("The key of obj is:" + obj.getKey());
    }

    public static void generic4() {
        Generic<Integer> integerGeneric = new Generic<>(111);
        Generic<String> stringGeneric = new Generic<>("aaa");
        showKeyValue(stringGeneric);
        /** ������� */
        //showKeyValue(integerGeneric);
    }

    public static void showKeyValue1(Generic<?> obj) {
        System.out.println("The key of obj is:" + obj.getKey());
    }

    /**
     * ����ͨ�����һ��ʹ�� �� ������������ʵ�Ρ����԰� �� ����������ĸ��࣬��һ����ʵ������
     */
    public static void Generic5() {
        Generic<Integer> integerGeneric = new Generic<>(111);
        Generic<String> stringGeneric = new Generic<>("bbb");
        showKeyValue1(integerGeneric);
        showKeyValue1(stringGeneric);
    }

    /**
     * public�뷵��ֵ֮���<T>�ز����٣���������һ�����ͷ���������������һ������T
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
     * ����һ�����ͷ��������Ϳ����ж��
     */
    public <T, K> T showKeyName1(Generic<K> obj) {
        return null;
    }

    public void show_1(T obj) {
        System.out.println("obj is:" + obj.toString());
    }

    /**
     * ���ͷ���
     */
    public <T> void show_2(T obj) {
        System.out.println("obj is:" + obj.toString());
    }

    /**
     * �ڷ������������˷��ͷ�����ʹ�÷���K�����з���K��һ��ȫ�µ����ͣ�������T��ͬ��Ҳ������T��ͬ
     * ���ڷ��ͷ���������ʱʹ���˷���K����ʹ������û����������K����������Ȼ�ܹ���ȷʶ���ͷ����еķ���
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
     * ���ͷ�����ɱ����
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
     * ������ж�����ʹ�÷��͵ľ�̬��������ô��Ҫ�������������Ϊ���ͷ���
     * ���������������������
     */
    /*public static void showKeyValue(Generic<T> obj) {
        System.out.println("Obj is:" + obj.toString());
    }*/

}
