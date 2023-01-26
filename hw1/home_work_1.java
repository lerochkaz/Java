import java.util.Scanner;

public class home_work_1 {

    public static void main(String[] args) {

        // // Решение задачи №1
        // System.out.printf("Результат первой задачи: %d", task_1(input_number(), 0));

        // // Решение задачи №2
        // System.out.printf("Результат второй задачи: %d", task_2(input_number()));

        // // Решение задачи №3
        // task_3();

        // // // // Решение задачи №4
        // System.out.printf("Ответ: %s", task_4());

    }

    static int input_number() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = scanner.nextInt();
        scanner.close();
        return num;
    }

    static int task_1(int number, int sum) {
        // 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n)
        if (number == 0) {
            return sum;
        } else {
            return task_1(number - 1, sum = sum + number);
        }

    }

    static int task_2(int number) {
        // 2. Вычислить n! (произведение чисел от 1 до n)
        int result = 1;
        for (int i = number; i > 0; i--) {
            result = result * i;
        }
        return result;
    }

    static void task_3() {
        // 3. Вывести все простые числа от 1 до 1000 (простые числа - это числа которые
        // делятся только на себя и на единицу без остатка. Чтобы найти остаток от
        // деления используйте оператор % , например 10%3 будет равно единице)
        String result_string = "";
        for (int i = 1; i <= 1000; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                result_string += i + " ";
            }
        }
        System.out.printf("Простые числа от 1 до 1000: %s", result_string);

    }

    static double task_4() {
        // Реализовать простой калькулятор ("введите первое число"... "Введите второе
        // число"... "укажите операцию, которую надо выполнить с этими числами"...
        // "ответ: ...")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double number_One = scanner.nextDouble();
        System.out.println("Введите второе число: ");
        double number_Two = scanner.nextDouble();
        System.out.println("Укажите операцию: ");
        String sign = scanner.next();
        scanner.close();
        double result = 0.0;
        switch (sign) {
            case "+":
                result = number_One + number_Two;
                break;
            case "-":
                result = number_One - number_Two;
                break;
            case "*":
                result = number_One * number_Two;
                break;
            case "/":
                result = number_One / number_Two;
                break;
        }
        return result;
    }
}
