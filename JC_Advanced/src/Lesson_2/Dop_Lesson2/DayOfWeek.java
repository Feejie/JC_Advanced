package Lesson_2.Dop_Lesson2;

public enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    private static int workingHours;
    private static int dayWorkingHours = 8;
    private static int weekWorkingHours = 40;

    public static String getWorkingHours(DayOfWeek day){
        String message;
        if(day != SATURDAY && day != SUNDAY) {
            workingHours = weekWorkingHours - (day.ordinal() * dayWorkingHours);
            message = "На текущей неделе вам осталось " + workingHours + " часов работы";
        }
        else {
            message = "Уже выходные!";
        }
        return message;
    }
}
