import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Alex on 08.04.2017.
 */
public class Ref {
    public static void main(String args[]) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        //ссылка на класс
        Class aClass = Dr2.class;
        Class aClazz = aClass.getClass();

        //объект конструктора без параметров
        Dr2 obj1 = (Dr2) aClass.newInstance();

        aClass.getConstructors();

        //просмотр конструктора
        Constructor[] constructors = aClass.getDeclaredConstructors();
        Dr2 obj2;
        for (Constructor cons : constructors){
            if (cons.getParameterCount() == 2) {
                System.out.println();
                obj2 = (Dr2) cons.newInstance(3,3);
                System.out.println(obj2);
            }
        }

        //вывод всех полей класса
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields){
            Class fieldType = field.getType();
            System.out.println("Имя: " + field.getName());
            System.out.println("Тип: " + fieldType.getName());
            System.out.println();
        }
        //методы класса
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println("Имя: " + method.getName());
            System.out.println("Возвращаемый тип: " + method.getReturnType().getName());

            Class[] paramTypes = method.getParameterTypes();
            System.out.print("Типы параметров: ");
            for (Class paramType : paramTypes) {
                System.out.print(" " + paramType.getName());
            }
            System.out.println();
        }

        //вызываем методы класса

        for ( Method method : aClass.getDeclaredMethods()){

            if ("summ".equalsIgnoreCase(method.getName())){
                System.out.println("---summ---");
                method.invoke(obj1,(Dr2) aClass.newInstance(),true);
            }

            if ("difference".equalsIgnoreCase(method.getName())){
                System.out.println("---difference---");
                method.invoke(obj1,(Dr2) aClass.newInstance(),true);
            }

            if ("veiw".equalsIgnoreCase(method.getName())){
                System.out.println("---veiw!---");
                method.setAccessible(true);
                method.invoke(obj1);
            }
        }



    }
}