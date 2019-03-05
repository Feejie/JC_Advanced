package Lesson_2.Exceptions;

import java.lang.reflect.Array;

public class MyArraySizeException extends Exception{
    private String msg;

    public MyArraySizeException(String msg){
        super(msg);
    }

    public String getMsg(){
        return this.msg;
    }

}
