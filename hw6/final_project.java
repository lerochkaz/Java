package home_work.hw6;

import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class final_project {
    public static void main(String[] args) {
        // Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
        // методы. Реализовать в java.
        // Создать множество ноутбуков.
        // Написать метод, который будет запрашивать у пользователя критерий (или
        // критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии
        // фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую
        // необходимому критерию:
        // 1 - ОЗУ
        // 2 - Объем ЖД
        // 3 - Операционная система
        // 4 - Цвет …
        // Далее нужно запросить минимальные значения для указанных критериев -
        // сохранить параметры фильтрации можно также в Map.
        // Отфильтровать ноутбуки из первоначального множества и вывести проходящие по
        // условиям.

        Scanner sc = open_Scanner();
        Laptop[] databaseLaptop = creationDatabase(readFile("catalog.txt"));
        printNeededLaptop(databaseLaptop, requestValues(sc));
        close_Scanner(sc);

    }

    static Scanner open_Scanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    static void close_Scanner(Scanner scanner) {
        scanner.close();
    }

    static HashMap<String, String> requestValues(Scanner scanner) {
        HashMap<String, String> data = new HashMap<>();
        boolean flag = true;
        while (flag) {
            System.out.println("Выберите критерий поиска: " +
                    "\n1- Оперативная память" +
                    "\n2- Объем жесткого диска" +
                    "\n3- Операционная система" +
                    "\n4- Цвет" +
                    "\n0- Все критерии введены");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println("Введите размер оперативной памяти в Гб: ");
                    data.put("ram", scanner.next());
                    break;
                case 2:
                    System.out.println("Введите объем жесткого диска в Гб: ");
                    data.put("ssd", scanner.next());
                    break;
                case 3:
                    System.out.println("Введите операционную систему: ");
                    data.put("operatingSystem", scanner.next().toLowerCase());
                    break;
                case 4:
                    System.out.println("Введите цвет ноутбука: ");
                    data.put("color", scanner.next().toLowerCase());
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Такого действия не существует!");
                    break;
            }
        }
        return data;
    }

    static String readFile(String fileName) {
        String stringResult = new String();
        try (FileReader reader = new FileReader(fileName)) {
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                stringResult += sc.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringResult;
    }

    static Laptop[] creationDatabase(String someString) {
        String[] someArray = someString.split(";");
        Laptop[] database = new Laptop[someArray.length];
        for (int i = 0; i < someArray.length; i++) {
            String[] temporaryArray = someArray[i].split(", ");
            database[i] = new Laptop(temporaryArray[0], temporaryArray[1], temporaryArray[2], temporaryArray[3],
                    temporaryArray[4]);
        }
        return database;
    }

    static void printNeededLaptop(Laptop[] databaseArray, HashMap<String, String> characteristics) {
        String result = "";
        for (Laptop laptop : databaseArray) {
            if (laptop.compareLaptop(characteristics) == true) {
                result += laptop.toString() + "\n";
            }
        }
        if (result.equals("")) {
            System.out.println(
                    "Ни один ноутбук не подходит под данные характеристики. Попробуйте задать другие параметры поиска");
        } else {
            System.out.println(
                    "Ноутбуки с подходящими параметрами:\n" + result);
        }
    }

}
