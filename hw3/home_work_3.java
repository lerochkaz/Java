package home_work.hw3;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class home_work_3 {
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
                    task_2(scanner);
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

    static void task_1(Scanner scanner) {
        // Пусть дан произвольный список целых чисел, удалить из него четные числа

        List<Integer> list_First_Task = new ArrayList<>();
        fill_List(list_First_Task, input_Number(scanner));
        System.out.println("Список до удаления четных чисел: " + list_First_Task);
        removing_Even_Numbers(list_First_Task);
        System.out.println("Результат: " + list_First_Task);
    }

    static void task_2(Scanner scanner) {
        // Задан целочисленный список ArrayList. Найти минимальное, максимальное и
        // среднее арифметическое из этого списка. Collections.max()

        List<Integer> list_Second_Task = new ArrayList<>();
        fill_List(list_Second_Task, input_Number(scanner));
        System.out.println("Сгенерирован целочисленный список: " + list_Second_Task);
        System.out.println("Максимальное число в списке: " +
                Collections.max(list_Second_Task));
        System.out.println("Минимальное число в списке: " +
                Collections.min(list_Second_Task));
        System.out.println("Среднее арифметическое списка: " + search_Arithmetical_Mean(list_Second_Task));
    }

    static void task_3(Scanner scanner) {
        // *Реализовать алгоритм сортировки слиянием
        // Сортировка возможна только с длиной массива: 2,4,6,8

        List<Integer> list_Third_Task = new ArrayList<>();
        fill_List(list_Third_Task, input_Number(scanner));
        System.out.println(list_Third_Task);
        merge_Sort(list_Third_Task, 2);
    }

    static Scanner open_Scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    static void close_Scanner(Scanner scanner) {
        scanner.close();
    }

    static void fill_List(List<Integer> list, int number) {
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            list.add(random.nextInt(11));
        }
    }

    static int input_Number(Scanner scanner) {
        System.out.println("Введите целое число(размер списка): ");
        Integer created_Number = null;
        try {
            scanner.hasNextInt();
            created_Number = scanner.nextInt();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return created_Number;
    }

    static void removing_Even_Numbers(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
    }

    static Double search_Arithmetical_Mean(List<Integer> list) {
        Double sum_element = 0.0;
        for (Integer element : list) {
            sum_element += element;
        }
        Double arithmetical_Mean = (sum_element / list.size());
        return arithmetical_Mean;
    }

    static List<Integer> merge_Sort(List<Integer> list, int coefficient) {
        if (list.size() / coefficient < 2) {
            Collections.sort(list);
            System.out.println(list);
            return list;
        } else {
            List<Integer> result_list = new ArrayList<>(list.size());
            for (int i = 0; i < list.size(); i += coefficient) {
                List<Integer> interim_list = new ArrayList<>(coefficient);
                for (int j = 0; j < coefficient; j++) {
                    interim_list.add(list.get(i + j));
                }
                Collections.sort(interim_list);
                result_list.addAll(interim_list);
            }
            System.out.println(result_list);
            return merge_Sort(result_list, coefficient * 2);
        }
    }

}
