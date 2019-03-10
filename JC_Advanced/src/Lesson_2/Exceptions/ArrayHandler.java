package Lesson_2.Exceptions;

public class ArrayHandler {
    private String[][] arrayToHandle;
    private int arraySize = 4;


    public ArrayHandler(String[]... arrayToHandle){
        this.arrayToHandle = arrayToHandle;
    }

    // получить массив для обработки
    public String[][] getArrayToHandle() {
        return arrayToHandle;
    }

    // задать предпочтительный размер массива
    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    // обработка массива и сумма всех ячеек
    public void arrayExc(String[][] arr) throws MyArraySizeException, MyArrayDataException, NumberFormatException {
        int sum = 0;

        // проверка массива на предпочтительный размер
        for(int i = 0; i < arraySize; i++){
            if(arr.length != arraySize || arr[i].length != arraySize) throw new MyArraySizeException("Массив неверного размера");
        }

        // преобразование содержимого ячеек в int
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("Неверный формат ячейки", i, j, arr[i][j]);
                }
            }
        }

        System.out.println("Сумма всех элементов массива: " + sum);
    }

}
