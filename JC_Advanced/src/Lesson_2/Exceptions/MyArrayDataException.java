package Lesson_2.Exceptions;

public class MyArrayDataException extends Exception {
    private String msg;

    public MyArrayDataException(String msg, int row, int col, String cell){
        super(msg + ": " + "[" + row + "][" + col + "] - " + cell);
    }

    public MyArrayDataException(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
