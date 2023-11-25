import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        MyClass myc = new MyClass();
        Class<?> clas = myc.getClass();

        Method[] methods = clas.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                System.out.println(method.invoke(myc, test.a(), test.b()));
            }
        }
    }
}