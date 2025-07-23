import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;


public class Main {
    public static void main(String[] args) {
        /*
         1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
            При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

         2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
         Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
         должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

         3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
         MyArrayDataException и вывести результат расчета.

         4. Напишите код для генерации и поимки ArrayIndexOutOfBoundsException.
         */
        String[][] arrayStrTest = {
                {"0", "1", "2", "3"},
                {"5", "6", "7", "8"},
                {"10", "11", "a", "14"},
                {"15", "16", "17", "19"},

        };
        String[][] noCorrectSizeArrStr = new String[4][5];
        try {
            System.out.println(sumNumArray4x4(arrayStrTest));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        int[] arrTask4 = {1, 2, 3, 4};
        task4(arrTask4);

    }

    private static void task4(int[] arr) {
        try {
            for (int i = 0; i <= arr.length; i++) {
                arr[i]++;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static int sumNumArray4x4(String[][] arrIncoming) throws MyArrayDataException {
        if (arrIncoming.length != 4) {
            throw new MyArraySizeException("В массиве не верное количесто строк");
        } else if (arrIncoming[0].length != 4) {
            throw new MyArraySizeException("В массиве не верное количесто столбцов");
        }
        int sum = 0, i = 0, j = 0;
        try {
            for (i = 0; i < arrIncoming.length; i++) {
                for (j = 0; j < arrIncoming[i].length; j++) {
                    sum = sum + Integer.parseInt(arrIncoming[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Некорректные данные в ячейке [" + (i + 1) + ", " + (j + 1) + "]");
        }
        return sum;
    }
}