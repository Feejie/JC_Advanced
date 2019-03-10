package Lesson_1.Marathon.Obstacles;

import Lesson_1.Marathon.Competitors.Competitor;
import Lesson_1.Marathon.Competitors.Team;

public class Course {
    Obstacle[] course;

    public Course(Obstacle... course){
        this.course = course;
    }

    // прохождение полосы препятствий
    public void doIt(Team team){
        for (Competitor c : team.getTeamArray()) {
            for (Obstacle o : course) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }

    // получить массив препятствий
    public Obstacle[] getCourseArray(){
        return this.course;
    }

}


