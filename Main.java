import java.util.ArrayList;
import java.util.Collections;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[1;32m";
    public static final String ANSI_CYAN = "\u001B[1;36m";

    private ArrayList<Integer> randomFill(ArrayList<Integer> arr)
    {
        int N = (int)(Math.random() * 9 + 1);
        for (int i = 0; i < N; i++)
        {
            int num = (int)(Math.random() * 100);
            num = num * (int)(Math.pow(-1, num % 2));
            arr.add(num);
        }
        return arr;
    }
    private boolean isNegativeArray(ArrayList<Integer> arr)
    {
        for (int a : arr) {
            if (a > 0)
                return false;
        }
        return true;
    }

    public void Task_1()
    {
        System.out.println(ANSI_CYAN + "Задание 1.1: Обобщенная коробка" + ANSI_RESET);
        Box<Integer> box = new Box<>(3);
        System.out.println(box);
        System.out.println("Извлекаем значение из коробки: " + box.getContent());
    }
    public void Task_2()
    {
        System.out.println(ANSI_CYAN + "Задание 1.2: Без null" + ANSI_RESET);
        Storage<Integer> store_1 = new Storage<>(null, 0);
        System.out.println(store_1);
        System.out.println("Извлечённое значение из хранилища: " + store_1.getContent());

        Storage<Integer> store_2 = new Storage<>(99, -1);
        System.out.println(store_2);
        System.out.println("Извлечённое значение из хранилища: " + store_2.getContent());

        Storage<String> store_3 = new Storage<>(null, "default");
        System.out.println(store_3);
        System.out.println("Извлечённое значение из хранилища: " + store_3.getContent());

        Storage<String> store_4 = new Storage<>("hello", "hello world");
        System.out.println(store_4);
        System.out.println("Извлечённое значение из хранилища: " + store_4.getContent());
    }
    public void Task_3()
    {
        System.out.println(ANSI_CYAN + "Задание 2.3: Начало отсчета" + ANSI_RESET);
        System.out.println("Положим в коробку двумерную точку.");
        int x1 = Check.inputInteger(ANSI_GREEN + "Введите координату X: " + ANSI_RESET);
        int y1 = Check.inputInteger(ANSI_GREEN + "Введите координату Y: " + ANSI_RESET);
        Point p1 = new Point(x1, y1);
        Box<Point> box1 = new Box<>(p1);
        System.out.println("Извлекаем значение из коробки: " + box1.getContent());

        System.out.println("Положим в коробку трёхмерную точку.");
        int x2 = Check.inputInteger(ANSI_GREEN + "Введите координату X: " + ANSI_RESET);
        int y2 = Check.inputInteger(ANSI_GREEN + "Введите координату Y: " + ANSI_RESET);
        int z2 = Check.inputInteger(ANSI_GREEN + "Введите координату Z: " + ANSI_RESET);
        Point3D p2 = new Point3D(x2, y2, z2);
        Box<Point3D> box2 = new Box<>(p2);
        System.out.println("Извлекаем значение из коробки: " + box2.getContent());
    }
    public void Task_4()
    {
        System.out.println(ANSI_CYAN + "Задание 3.1: Функция" + ANSI_RESET);
        GenericMethods<String, Integer> task1 = new GenericMethods<>();
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("qwerty");
        arr1.add("asdfg");
        arr1.add("zx");
        Function<String, Integer> f1 = s -> s.length();
        System.out.println("Исходный список: " + arr1);
        System.out.println("Обработанный список: " + task1.applyToList(arr1, f1));

        GenericMethods<Integer, Integer> task2 = new GenericMethods<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(-3);
        arr2.add(7);
        Function<Integer, Integer> f2 = n -> Math.abs(n);
        System.out.println("Исходный список: " + arr2);
        System.out.println("Обработанный список: " + task2.applyToList(arr2, f2));

        GenericMethods<ArrayList<Integer>, Integer> task3 = new GenericMethods<>();
        ArrayList<ArrayList<Integer>> arr3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            a = randomFill(a);
            arr3.add(a);
        }
        Function<ArrayList<Integer>, Integer> f3 = a -> Collections.max(a);
        System.out.println("Исходный список: " + arr3);
        System.out.println("Обработанный список: " + task3.applyToList(arr3, f3));
    }

    public void Task_5()
    {
        System.out.println(ANSI_CYAN + "Задание 3.2: Фильтр" + ANSI_RESET);
        GenericMethods<String, String> task1 = new GenericMethods<>();
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("qwerty");
        arr1.add("asdfg");
        arr1.add("zx");
        Predicate<String> p1 = p -> p.length() > 3;
        System.out.println("Исходный список: " + arr1);
        System.out.println("Обработанный список: " + task1.testToList(arr1, p1));

        GenericMethods<Integer, Integer> task2 = new GenericMethods<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(-3);
        arr2.add(7);
        Predicate<Integer> p2 = n -> n > 0;
        System.out.println("Исходный список: " + arr2);
        System.out.println("Обработанный список: " + task2.testToList(arr2, p2));

        GenericMethods<ArrayList<Integer>, Integer> task3 = new GenericMethods<>();
        ArrayList<ArrayList<Integer>> arr3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            a = randomFill(a);
            arr3.add(a);
        }
        Predicate<ArrayList<Integer>> p3 = a -> isNegativeArray(a);
        System.out.println("Исходный список: " + arr3);
        System.out.println("Обработанный список: " + task3.testToList(arr3, p3));
    }

    public void Task_6()
    {
        System.out.println(ANSI_CYAN + "Задание 3.3: Сокращение" + ANSI_RESET);
        GenericMethods<String, String> task1 = new GenericMethods<>();
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("qwerty");
        arr1.add("asdfg");
        arr1.add("zx");
        BinaryOperator<String> fold1 = (s1, s2) -> s1 + s2;
        System.out.println("Исходный список: " + arr1);
        System.out.println("Свёртка списка: " + task1.reduceList(arr1, fold1));

        GenericMethods<Integer, Integer> task2 = new GenericMethods<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(-3);
        arr2.add(7);
        BinaryOperator<Integer> fold2 = (n1, n2) -> n1 + n2;
        System.out.println("Исходный список: " + arr2);
        System.out.println("Свёртка списка: " + task2.reduceList(arr2, fold2));

        GenericMethods<ArrayList<Integer>, ArrayList<Integer>> task3 = new GenericMethods<>();
        ArrayList<ArrayList<Integer>> arr3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            a = randomFill(a);
            arr3.add(a);
        }
        System.out.println("Исходный список: " + arr3);

        ArrayList<Integer> temp_arr = arr3.get(0);
        int temp_size = temp_arr.size();
        temp_arr.clear();
        temp_arr.add(temp_size);

        BinaryOperator<ArrayList<Integer>> fold3 = (a1, a2) -> task3.addListSize(a1, a2);
        ArrayList<Integer> temp = task3.reduceList(arr3, fold3);
        System.out.println("Свёртка списка: " + task2.reduceList(temp, fold2));
    }

    public static void main(String args[])
    {   
        Main m = new Main();
        m.Task_1();
        m.Task_2();
        m.Task_3();
        m.Task_4();
        m.Task_5();
        m.Task_6();
    }
}