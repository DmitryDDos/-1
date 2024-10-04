import java.util.Scanner;
import java.util.Random;

public class Main {

    public int sumLastNums(int x) { // Подсчёт суммы двух последних цифр числа
        x = Math.abs(x); // Приведение числа к модулю
        int lastDigit = x % 10; // Находим последнее число
        int secondLastDigit = (x / 10) % 10; // Находим предпоследнее число
        return lastDigit + secondLastDigit; // Складываем эти числа
    }

    public boolean isPositive(int x) { // Проверка на положительность числа
        return x > 0;
    }

    public boolean isUpperCase(char x) { // Проверка на заглавность буквы
        return x >= 'A' && x <= 'Z';
    }

    public boolean isDivisor(int a, int b) { // Проверка на делимость a на b || b на a
        return (a % b == 0) || (b % a == 0);
    }

    public int lastNumSum(int a, int b) { // Сумма цифр двух чисел из разряда единиц.
        return (a % 10) + (b % 10);
    }

    public double safeDiv(int x, int y) { // Безопасное деление
        if (y == 0) {
            return 0.0;
        } else {
            return (double) x / y;
        }
    }

    public String makeDecision (int x, int y){ // Сравнение x с y
        if (x > y){
            return x + ">" + y;
        }
        else if (x < y){
            return x + "<" + y;
        }
        else{
            return x + "==" + y;
        }
    }

    public boolean sum3 (int x, int y, int z){ // Сравнения сложения 1 и 2 переменной с 3-й
        return (x + y == z) || (x + z == y) || (y + z == x);
    }

    public String age (int x) { // Правильный вывод возраста
        String suffix;
        if (x % 10 == 1 && x % 100 != 11) {
            suffix = "год";
        } else if (x % 10 >= 2 && x % 10 <= 4 && (x % 100 < 12 || x % 100 > 14)) {
            suffix = "года";
        } else {
            suffix = "лет";
        }
        return x + " " + suffix;
    }

    public void printDays(String x) { // Вывод последующих дней недели
        String[] days = {"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};
        int index = -1;
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(x)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("это не день недели");
        } else {
            for (int i = index; i < days.length; i++) {
                System.out.println(days[i]);
            }
        }
    }

    public String reverseListNums(int x) { // Вывод от числа до 0 включительно
        StringBuilder result = new StringBuilder();
        for (int i = x; i >= 0; i--) {
            result.append(i).append(" ");
        }
        return result.toString().trim();
    }

    public int pow(int x, int y) { // Возведение числа в степень
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }

    public boolean equalNum(int x) { // Проверка на одинаковые знаки числа
        int digit = x % 10;
        x /= 10;
        while (x > 0) {
            if (x % 10 != digit) {
                return false;
            }
            x /= 10;
        }
        return true;
    }

    public void leftTriangle(int x) { // Вывод левого треугольника из *
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void guessGame() { // Угадай-ка с рандомайзером
        Random random = new Random();
        int secretNumber = random.nextInt(10);
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите число (от 0 до 9): ");
            int userNumber = scanner.nextInt();
            attempts++;

            if (userNumber < 0 || userNumber > 9) {
                System.out.println("Введено некорректное число!");
                continue;
            }

            if (userNumber == secretNumber) {
                System.out.println("Поздравляем! Вы угадали число.");
                System.out.println("Потрачено " + attempts + " попыток.");
                break;
            } else {
                System.out.println("Не повезло, попробуйте еще раз.");
            }
        }
    }

    public int findLast(int[] arr, int x) { // Нахождение последнего вхождения числа в массив
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int[] add(int[] arr, int x, int pos) { // Вставка числа в массив
        if (pos < 0 || pos > arr.length) {
            throw new IndexOutOfBoundsException("Такого индекса не существует");
        }

        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }

        newArr[pos] = x;

        for (int i = pos; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

    public void reverse(int[] arr) { // Реверс массива
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public int[] concat(int[] arr1, int[] arr2) { // Объединение массивов
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }
        return result;
    }

    public int[] deleteNegative(int[] arr) { // Удаление негативных чисел
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                count++;
            }
        }
        int[] result = new int[count];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                result[j] = arr[i];
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) { // Основная функция
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("Выберите действие от 0 до 20: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Ошибка! Введите целое число: ");
                scanner.next(); // Очистка ввода
            }
            int d = scanner.nextInt();
            if (d < 0 || d > 20) {
                System.out.println("Введено неверное значение!");
                continue;
            }

            switch (d) {
                case 0:
                    System.out.println("Программа остановлена.");
                    return;
                case 1:
                    System.out.print("Задача 1.2. Введите число x: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Ошибка! Введите целое число: ");
                        scanner.next(); // Очистка ввода
                    }
                    int x = scanner.nextInt();
                    System.out.println("Результат суммы: " + main.sumLastNums(x));
                    break;
                case 2:
                    System.out.print("Задача 1.4. Введите число x: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Ошибка! Введите целое число: ");
                        scanner.next(); // Очистка ввода
                    }
                    int x1 = scanner.nextInt();
                    System.out.println("Положительность числа: " + main.isPositive(x1));
                    break;

                case 3:
                    System.out.print("Задача 1.6. Введите английскую букву: ");
                    String input = scanner.next();
                    if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                        System.out.println("Введено неверное значение! Введите букву.");
                        continue;
                    }
                    char x2 = input.charAt(0);
                    System.out.println("Большая ли буква:  " + main.isUpperCase(x2));
                    break;
                case 4:
                    System.out.print("Задача 1.8. Введите a и b: ");
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    System.out.println("Делится ли a на b || b на a:  " + main.isDivisor(a, b));
                    break;
                case 5:
                    System.out.print("Задача 1.10. Введите пять чисел: ");
                    int[] numbers = new int[5];
                    for (int i = 0; i < 5; i++) {
                        numbers[i] = scanner.nextInt();
                    }
                    int result = 0;
                    for (int num : numbers) {
                        result = main.lastNumSum(result, num);
                    }
                    System.out.println("Результат суммы последних цифр: " + result);
                    break;
                case 6:
                    System.out.print("Задача 2.2. Введите x и y: ");
                    int x3 = scanner.nextInt();
                    int y = scanner.nextInt();
                    System.out.println("Результат деления: " + main.safeDiv(x3, y));
                    break;
                case 7:
                    System.out.print("Задача 2.4. Введите x и y: ");
                    int x4 = scanner.nextInt();
                    int y1 = scanner.nextInt();
                    System.out.println("Результат сравнения: " + main.makeDecision(x4, y1));
                    break;
                case 8:
                    System.out.print("Задача 2.6. Введите x, y и z: ");
                    int x5 = scanner.nextInt();
                    int y2 = scanner.nextInt();
                    int z = scanner.nextInt();
                    System.out.println("Результат сравнения суммы 1 и 2 числа с 3-м: " + main.sum3(x5, y2, z));
                    break;
                case 9:
                    System.out.print("Задача 2.8. Введите x: ");
                    int x6 = scanner.nextInt();
                    System.out.println("Возраст: " + main.age(x6));
                    break;
                case 10:
                    System.out.print("Задача 2.10. Введите день недели: ");
                    String day = scanner.next();
                    main.printDays(day);
                    break;
                case 11:
                    System.out.print("Задача 3.2. Введите x: ");
                    int x8 = scanner.nextInt();
                    System.out.println("Результат: " + main.reverseListNums(x8));
                    break;
                case 12:
                    System.out.print("Задача 3.4. Введите x, y: ");
                    int x9 = scanner.nextInt();
                    int y3 = scanner.nextInt();
                    System.out.println("Результат: " + main.pow(x9, y3));
                    break;
                case 13:
                    System.out.print("Задача 3.6. Введите x: ");
                    int x10 = scanner.nextInt();
                    System.out.println("Результат: " + main.equalNum(x10));
                    break;
                case 14:
                    System.out.print("Задача 3.8. Введите x: ");
                    int x11 = scanner.nextInt();
                    main.leftTriangle(x11);
                    break;
                case 15:
                    System.out.println("Задача 3.10. Начало игры!");
                    main.guessGame();
                    break;
                case 16:
                    System.out.print("Задача 4.2. Введите массив в формате [1,2,3,...] и число x: ");
                    String input1 = scanner.next();
                    String[] parts = input1.substring(1, input1.length() - 1).split(",");
                    int[] arr = new int[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        arr[i] = Integer.parseInt(parts[i].trim());
                    }
                    int x12 = scanner.nextInt();
                    int result1 = main.findLast(arr, x12);
                    if (result1 == -1) {
                        System.out.println("Число x не найдено в массиве.");
                    }
                    else {
                        System.out.println("Последнее вхождение числа x в массиве находится по индексу " + result1);
                    }
                    break;
                case 17:
                    System.out.print("Задача 4.4. Введите массив в формате [1,2,3,...], число x и позицию pos: ");
                    String input2 = scanner.next();
                    String[] parts1 = input2.substring(1, input2.length() - 1).split(",");
                    int[] arr1 = new int[parts1.length];
                    for (int i = 0; i < parts1.length; i++) {
                        arr1[i] = Integer.parseInt(parts1[i].trim());
                    }
                    int x13 = scanner.nextInt();
                    int pos = scanner.nextInt();
                    int[] result2 = main.add(arr1, x13, pos);
                    System.out.println("Результат: ");
                    for (int num : result2) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 18:
                    System.out.print("Задача 4.6. Введите массив в формате [1,2,3,...]: ");
                    String input3 = scanner.next();
                    String[] parts2 = input3.substring(1, input3.length() - 1).split(",");
                    int[] arr2 = new int[parts2.length];
                    for (int i = 0; i < parts2.length; i++) {
                        arr2[i] = Integer.parseInt(parts2[i].trim());
                    }
                    main.reverse(arr2);
                    System.out.println("Результат: ");
                    for (int num : arr2) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 19:
                    System.out.print("Задача 4.8. Введите два массива в формате [1,2,3,...] и [4,5,6,...]: ");
                    String input4 = scanner.next();
                    String[] parts3 = input4.substring(1, input4.length() - 1).split(",");
                    int[] arr3 = new int[parts3.length];
                    for (int i = 0; i < parts3.length; i++) {
                        arr3[i] = Integer.parseInt(parts3[i].trim());
                    }
                    String input5 = scanner.next();
                    String[] parts4 = input5.substring(1, input5.length() - 1).split(",");
                    int[] arr4 = new int[parts4.length];
                    for (int i = 0; i < parts4.length; i++) {
                        arr4[i] = Integer.parseInt(parts4[i].trim());
                    }
                    int[] result3 = main.concat(arr3, arr4);
                    System.out.println("Результат: ");
                    for (int num : result3) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 20:
                    System.out.print("Задача 4.10. Введите массив в формате [1,2,3,...]: ");
                    String input6 = scanner.next();
                    String[] parts5 = input6.substring(1, input6.length() - 1).split(",");
                    int[] arr5 = new int[parts5.length];
                    for (int i = 0; i < parts5.length; i++) {
                        arr5[i] = Integer.parseInt(parts5[i].trim());
                    }
                    int[] result4 = main.deleteNegative(arr5);
                    System.out.println("Результат: ");
                    for (int num : result4) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
            }
        }
    }
}
