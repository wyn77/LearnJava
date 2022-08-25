package com.example.cleancode.enum_annotation;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author : wyn
 * @date : 2022-08-25 22:30
 **/
public class RunTests implements Serializable {

    public static void main(String[] args) throws Exception {
        test2();
    }
    public static void test2() throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.example.cleancode.enum_annotation.Sample2");
        for (Method m : testClass.getDeclaredMethods()) {
            if(m.isAnnotationPresent(ExceptionTest.class) ||
                m.isAnnotationPresent(ExceptionTestContainer.class)) {
                tests ++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    ExceptionTest[] excTypes = m.getAnnotationsByType(ExceptionTest.class);
                    for (ExceptionTest excType : excTypes) {
                        if (excType.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }

                    if (passed == oldPassed) {
                        System.out.printf("Test %s failed: %s %n", m, exc);
                    }
                } catch (Exception exc) {
                    System.out.println("Invalid @Test:" + m);
                }
            }
            System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
        }
    }


    public static void test1() throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.example.cleancode.enum_annotation.Sample");
        for (Method m : testClass.getDeclaredMethods()) {
            if(m.isAnnotationPresent(MyTest.class)) {
                tests ++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed:" + exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test:" + m);
                }
            }
            System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
        }
    }
}
