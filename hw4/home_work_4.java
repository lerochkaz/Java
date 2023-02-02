import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class home_work_4 {
    private static final String TASK_MENU = "Выберите нужный пункт меню: "
            + "\n\t1 - Задача 1"
            + "\n\t2 - Задача 2"
            + "\n\t3 - Задача 3"
            + "\n\t0 - Выход";

    public static void main(String[] args) {
        Scanner scanner = open_Scanner();
        while (true) {
            System.out.println(TASK_MENU);
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    task_1(scanner);
                    break;
                case 2:
                    task_2();
                    break;
                case 3:
                    task_3(scanner);
                    break;
                case 0:
                    System.exit(0);
                    close_Scanner(scanner);
                default:
                    System.out.println("Такого действия не существует!");
                    break;
            }
        }

    }

    static Scanner open_Scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    static void close_Scanner(Scanner scanner) {
        scanner.close();
    }

    static LinkedList<Integer> creat_LinkedList() {
        LinkedList<Integer> created_List = new LinkedList<>();
        return created_List;
    }

    static void fill_LinkedList(LinkedList<Integer> created_List, Scanner scanner) {
        System.out.println("Укажите колличество элементов в списке: ");
        Random random = new Random();
        try {
            int input_number = Integer.parseInt(scanner.next());
            if (input_number < 1) {
                throw new Exception("Элементов в списке должно быть больше 0");
            } else {
                for (int i = 0; i < input_number; i++) {
                    created_List.add(random.nextInt(10));
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    static LinkedList<Integer> revers_LinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reversed_List = new LinkedList<>();
        int count = list.size();
        for (int i = 0; i < count; i++) {
            reversed_List.addFirst(list.pollFirst());
        }
        return reversed_List;
    }

    static void task_1(Scanner scanner) {
        // Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который
        // вернет “перевернутый” список.
        LinkedList<Integer> list_First_Task = creat_LinkedList();
        fill_LinkedList(list_First_Task, scanner);
        System.out.println("Сгенерирован спиисок: " + list_First_Task);
        System.out.println("Получен \"перевернутый\" список: " + revers_LinkedList(list_First_Task));

    }

    static void task_2() {
        // Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() -
        // помещает элемент в конец очереди, dequeue() - возвращает первый элемент из
        // очереди и удаляет его, first() - возвращает первый элемент из очереди, не
        // удаляя.
        MyQueue myQueue_Sekond_Task = new MyQueue();
        System.out.println(
                "Протестируем. Добавляем в очередь 1, 2, 3");
        myQueue_Sekond_Task.enqueue(1);
        myQueue_Sekond_Task.enqueue(2);
        myQueue_Sekond_Task.enqueue(3);
        System.out.println("Возвращаем и удалем первый элемент из очереди: " + myQueue_Sekond_Task.dequeue());
        System.out.println(
                "Повторяем действие. Возвращаем и удалем первый элемент из очереди: " + myQueue_Sekond_Task.dequeue());
        System.out.println("Возвращаем первый элемент из очереди: " + myQueue_Sekond_Task.first());
    }

    static void task_3(Scanner scanner) {
        // Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке.
        // Используйте итератор

        LinkedList<Integer> list_Third_Task = creat_LinkedList();
        fill_LinkedList(list_Third_Task, scanner);
        System.out.println("Сгенерирован спиисок: " + list_Third_Task);
        System.out.println("Сумма элементов списка: " + sum_Elements_of_list(list_Third_Task));
    }

    static int sum_Elements_of_list(LinkedList<Integer> list) {
        ListIterator<Integer> iterator = list.listIterator();
        int sum = 0;
        while (iterator.hasNext()) {
            int element = iterator.next();
            sum += element;
        }
        return sum;
    };
}
