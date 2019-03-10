package Lesson_3.Dop_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegMain {
    public static void main(String[] args) {
        String str = "Qw'ertyui123";
        boolean result = false;

        if(checkNum(str) && checkSize(str) && checkCaseSens(str) && checkSpecSym(str)){
            result = true;
        }

        // солянка из методов
        System.out.println(result);

        // единый паттерн
        System.out.println(testRegEx(str));
    }

    public static boolean testRegEx(String str){
        Pattern p = Pattern.compile("^(?=.*[A-Za-z].*)(?=.*[A-Z].*)(?=.*[0-9].*)(?=.*[\\W].*)[A-Za-z0-9\\W]{8,20}$");
        Matcher m = p.matcher(str);

        return m.matches();
    }

    public static boolean checkNum(String str){
        Pattern p = Pattern.compile("^.*[0-9].*$");
        Matcher m = p.matcher(str);

        return m.matches();
    }

    public static boolean checkSize(String str){
        Pattern p = Pattern.compile("^.{8,20}$");
        Matcher m = p.matcher(str);

        return m.matches();
    }

    public static boolean checkCaseSens(String str){
        Pattern p = Pattern.compile("^.*[A-Z].*$");
        Matcher m = p.matcher(str);

        return m.matches();
    }

    public static boolean checkSpecSym(String str){
        Pattern p = Pattern.compile("^.*[\\W].*$");
        Matcher m = p.matcher(str);

        return m.matches();
    }
}
