// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова:
        // Orange, Banana, Apple
        printThreeWords();

        //2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b,
        // и инициализируйте их любыми значениями, которыми захотите. Далее метод должен просуммировать
        // эти переменные, и если их сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”,
        // в противном случае - “Сумма отрицательная”;
        checkSumSign();

        //3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте
        // ее любым значением. Если value меньше 0 (0 включительно), то в консоль метод должен вывести
        // сообщение “Красный”, если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно),
        // то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
        printColor();

        //4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
        // и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b,
        // то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
        compareNumbers();

        //5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
        // в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
        System.out.println(checkLimitSumTwoNum(2,20));


        //6. Напишите метод, которому в качестве параметра передается целое число,
        // метод должен напечатать в консоль, положительное ли число передали или отрицательное.
        // Замечание: ноль считаем положительным числом.
        printOnConsoleSingNumber(15);

        //7. Напишите метод, которому в качестве параметра передается целое число.
        // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
        //Замечание: ноль считаем положительным числом
        System.out.println(checkSingNumberBoolean(-1));

        //8. Напишите метод, которому в качестве аргументов передается строка и число,
        // метод должен отпечатать в консоль указанную строку, указанное количество раз;
        printOnConsoleNTimes("Java is cool", 3);

        //9. Напишите метод, который определяет, является ли год високосным, и возвращает boolean
        // (високосный - true, не високосный - false).
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        System.out.println(isLeapYear(1900));

        //10. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] array10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array10.length; i++) {
            if (array10[i] == 0){
                array10[i] = 1;
            } else {
                array10[i] =0;
            }
        }
        for (int i : array10) {
            System.out.print(i);
        }
        System.out.println();
        //11. Задать пустой целочисленный массив длиной 100.
        // С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
        int[] array11 = new int[100];
        for (int i = 0; i < array11.length; i++) {
            array11[i] = i + 1;
        }
        for (int i : array11) {
            System.out.print(i + " ");
        }
        System.out.println();

        //12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2;

        int[] array12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < array12.length; i++){
            if (array12[i] < 6){
                array12[i] = array12[i] * 2;
            }
        }
        for (int i : array12) {
            System.out.print(i + " ");
        }
        System.out.println();

        //13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
        // Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
        int[][] matrix = new int[9][9];
        int с = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            с--;
            matrix[i][с] = 1;
            matrix[i][i] = 1;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        //14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
        // типа int длиной len, каждая ячейка которого равна initialValue.
        for (int variable : initialArrayValue(5, 100)) {
            System.out.print(variable + " ");
        }
        }

    private static int[] initialArrayValue(int n, int value) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = value;
        }
        return arr;
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    private static void printOnConsoleNTimes(String valueStr, int n) {
        for (int i = 1; i <= n; i++){
            System.out.print(valueStr);
        }
        System.out.println();
    }

    private static boolean checkSingNumberBoolean(int i) {
        return i >= 0;
    }

    private static void printOnConsoleSingNumber(int i) {
        if (i < 0){
            System.out.println("отрицательное");
        }else System.out.println("положительное");
    }

    private static boolean checkLimitSumTwoNum(int firstNum, int secondNum) {
        return (((firstNum + secondNum) >= 10) && ((firstNum + secondNum) <= 20));
    }

    private static void compareNumbers() {
        int a = 12, b = -15;
        if (a >= b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    private static void printColor() {
        int value = 101;
        if (value <= 0){
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }

    }

    private static void checkSumSign() {
        int a = 23, b = -100;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }
}
