package Lesson_2.Exceptions;

public class ExceptionMain {
    public static void main(String[] args) {

        ArrayHandler arrayHandler = new ArrayHandler(
                new String[]{"2", "3", "1", "4"},
                new String[]{"6", "5", "8", "7"},
                new String[]{"4", "7", "2", "5"},
                new String[]{"9", "3", "8", "1"});
//        String[][] stringArray = {{"2", "3", "1", "4"}, {"6", "5", "8", "7"},
//                {"4", "7", "2", "5"}, {"9", "3", "8", "1"}};
        try {
            arrayHandler.arrayExc(arrayHandler.getArrayToHandle());
//            arrayHandler.arrayExc(stringArray);
        } catch (MyArraySizeException e){
            System.out.println(e.getMsg());
            e.printStackTrace();
        }
        catch (NumberFormatException | MyArrayDataException e){
            e.printStackTrace();
        }

    }

}

