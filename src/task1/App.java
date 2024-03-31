package task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

/*
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
*/



public class App {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Рекс", 6));
        animals.add(new Cat("Барсик", 3, "Серый"));
        animals.add(new Fish("Дори", 1, "Гуппи"));
        getInfo(animals.getFirst());
        getInfo(animals.get(1));
        getInfo(animals.get(2));
        getSound(animals.get(0));
    }

    public static void getInfo(Object obj) {
        Class<?> clazz = obj.getClass().getSuperclass();
        Class<?> clazz2 = obj.getClass();

        Arrays.stream(Stream.concat(Arrays.stream(clazz.getDeclaredFields()),
                        Arrays.stream(clazz2.getDeclaredFields()))
                        .toArray(Field[]::new)).forEach(field -> {
            field.setAccessible(true);
            try {
                System.out.println(field.getName() + " " +field.get(obj));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

        public static void getSound(Object obj) {
            Class<?> clazz = obj.getClass();
            Method[] methods = clazz.getDeclaredMethods();
            Arrays.stream(methods)
                    .filter(a -> a.getName().contains("makeSound"))
                    .forEach(a -> {
                        try {
                            a.invoke(obj);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
}
