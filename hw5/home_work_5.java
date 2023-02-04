package home_work.hw5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class home_work_5 {
    private static final String TASK_MENU = "Выберите нужный пункт меню: "
            + "\n\t1 - Задача 1"
            + "\n\t2 - Задача 2"
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

    static String request_Data_From_User(Scanner scanner) {
        System.out.println("Для добавления контакта введите имя и номер телефона через пробел: ");
        return scanner.next() + scanner.nextLine();
    }

    static void fill_Telephone_Directory(HashMap<String, List<String>> telephone_Directory,
            String user_data) {
        String[] array_Data = user_data.split(" ");
        List<String> list_number_user = new ArrayList<>();
        for (int i = 1; i < array_Data.length; i++) {
            list_number_user.add(array_Data[i]);
        }
        telephone_Directory.put(array_Data[0].toLowerCase(), list_number_user);
    }

    static void print_Telephone_Number(HashMap<String, List<String>> telephone_Directory, Scanner scanner) {
        System.out.println("Для поиска номера телефона введите имя: ");
        String name_User = scanner.nextLine().toLowerCase();
        System.out.println(
                "Номер телефона: " + telephone_Directory.get(name_User).toString().replaceAll("^\\[|\\]$", ""));
    }

    static void task_1(Scanner scanner) {
        // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
        // человек может иметь несколько телефонов.
        HashMap<String, List<String>> telephone_Directory_Task_One = new HashMap<>();
        fill_Telephone_Directory(telephone_Directory_Task_One, request_Data_From_User(scanner));
        fill_Telephone_Directory(telephone_Directory_Task_One, request_Data_From_User(scanner));
        print_Telephone_Number(telephone_Directory_Task_One, scanner);
    }

    static void task_2(Scanner scanner) {
        // Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова,
        // Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр
        // Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина
        // Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать
        // программу, которая найдет и выведет повторяющиеся имена с количеством
        // повторений. Отсортировать по убыванию популярности. Для сортировки
        // использовать TreeMap.

        String string_Data = "Иван Иванов, Светлана Петрова, Кристина Белова, " +
                "Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, " +
                "Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, " +
                "Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";

        print_Duplicat_Names_Emloyee(counting_Employee(conversion_To_Array(string_Data)));

    }

    static String[] conversion_To_Array(String string_Data) {
        String[] array_Data = string_Data.split(", ");
        for (int i = 0; i < array_Data.length; i++) {
            array_Data[i] = array_Data[i].replaceAll("\s[А-яёЁ]*", "");
        }
        return array_Data;
    }

    static HashMap<String, Integer> counting_Employee(String[] array_Employee_Data) {
        HashMap<String, Integer> repository = new HashMap<>();
        for (String data : array_Employee_Data) {
            if (!repository.containsKey(data)) {
                repository.put(data, 1);
            } else {
                repository.put(data, (repository.get(data) + 1));
            }
        }
        return repository;
    }

    static void print_Duplicat_Names_Emloyee(HashMap<String, Integer> repository_Employee) {
        TreeMap<Integer, List<String>> result_TreeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        for (Map.Entry element : repository_Employee.entrySet()) {
            List<String> list_Value = new ArrayList<String>();
            if (result_TreeMap.containsKey(element.getValue())) {
                list_Value = result_TreeMap.get(element.getValue());
            }
            list_Value.add(element.getKey().toString());
            result_TreeMap.put((Integer) element.getValue(), list_Value);

        }
        System.out.println(result_TreeMap.toString().replaceAll("[\\{\\[\\]\\}]", ""));
    }
}
