import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.Random;
import java.lang.Exception;
import java.text.Format;

public class home_work_2 {
    private static final String TASK_MENU = "Выберите нужный пункт меню: "
            + "\n\t1 - Задача 1"
            + "\n\t2 - Задача 2"
            + "\n\t3 - Задача 3"
            + "\n\t4 - Задача 4"
            + "\n\t5 - Вернуться назад, в главное меню"
            + "\n\t0 - Выход";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(TASK_MENU);
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    task_1();
                    break;
                case 2:
                    task_2(task_1());
                    break;
                case 3:
                    task_3();
                    break;
                case 4:
                    task_4();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Такого действия не существует!");
                    break;
            }
        }

    }

    static StringBuilder task_1() {
        // Дана json строка { {
        // "фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}}
        // Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
        // Студент Иванов получил 5 по предмету Математика. Студент Петрова получил 4 по
        // предмету Информатика. Студент Краснов получил 5 по предмету Физика.
        // Используйте StringBuilder для подготовки ответа

        String result = read_File("text_hw2.txt");

        result = result.replaceAll("фамилия", "");
        result = result.replaceAll("оценка", "");
        result = result.replaceAll("предмет", "");
        result = result.replaceAll("\"\"", " ");
        result = result.replaceAll("\"", "");
        result = result.replaceAll("[{: ]", "");
        String[] array = result.split("},");
        String[] data_Array = new String[3];
        String[] text_Array = { "Студент ", " получил ", " по предмету " };
        StringBuilder result_text = new StringBuilder("");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].replaceAll("[}}]", "");
            data_Array = array[i].split(",");
            for (int j = 0; j < text_Array.length; j++) {
                result_text.append(text_Array[j]);
                result_text.append(data_Array[j]);
            }
            result_text.append(". ");
        }
        System.out.println(result_text);
        return result_text;
    }

    static void task_2(StringBuilder string) {
        // Создать метод, который запишет результат работы в файл Обработайте исключения
        // и запишите ошибки в лог файл
        Logger logger = Logger.getAnonymousLogger();
        SimpleFormatter formatter = new SimpleFormatter();
        try {
            FileHandler file_Handler = new FileHandler("log.txt");
            file_Handler.setFormatter(formatter);
            logger.addHandler(file_Handler);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            FileWriter writer = new FileWriter("text_hw2-2.txt", true);
            writer.write(string + "\n");
            writer.close();
            logger.log(Level.INFO, "Программа работает корректно");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.log(Level.WARNING, "Возникла ошибка");
        }
    }

    static void task_3() {
        // *Получить исходную json строку из файла, используя FileReader или Scanner
        System.out.println("*Получить исходную json строку из файла, используя FileReader или Scanner");
    }

    static void task_4() {
        // *Реализуйте алгоритм сортировки пузырьком числового массива, результат после
        // каждой итерации запишите в лог-файл.
        int[] final_Array = fill_Array(input_number());
        sorting_Array(final_Array);
        System.out.println(Arrays.toString(final_Array));
    }

    static String read_File(String file_name) {
        String string_Result = new String();
        try (FileReader reader = new FileReader(file_name)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                string_Result += scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string_Result;
    }

    static int input_number() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = scanner.nextInt();
        return num;
    }

    static int[] fill_Array(int number) {
        Random random = new Random();
        int[] array = new int[number];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    static void sorting_Array(int[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    String text = Arrays.toString(array);
                    try {
                        FileWriter writer = new FileWriter("text_hw2-1.txt", true);
                        writer.write(text + "\n");
                        writer.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

    }

}
