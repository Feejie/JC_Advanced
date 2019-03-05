package Lesson_1.Marathon;

import Lesson_1.Marathon.Competitors.Cat;
import Lesson_1.Marathon.Competitors.Dog;
import Lesson_1.Marathon.Competitors.Human;
import Lesson_1.Marathon.Competitors.Team;
import Lesson_1.Marathon.Obstacles.Course;
import Lesson_1.Marathon.Obstacles.Cross;
import Lesson_1.Marathon.Obstacles.Wall;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Солянка", new Human("Василевс"), new Cat("Кусок"), new Dog("Дружище1"), new Dog("Дружище2")); // Создаем команду
        Course c = new Course(new Cross(80), new Wall(200), new Wall(1)); // Создаем полосу препятствий
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты

    }
}