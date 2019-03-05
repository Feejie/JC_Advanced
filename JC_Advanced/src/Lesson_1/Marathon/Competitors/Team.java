package Lesson_1.Marathon.Competitors;

import Lesson_1.Marathon.Obstacles.Obstacle;

public class Team {
    String teamName;
    Competitor[] competitors;

    // вывод массива участников команды
    public Competitor[] getTeamArray(){
        return competitors;
    }

    public Team(String teamName, Competitor... competitors){
        this.teamName = teamName;
        this.competitors = competitors;
    }

    public Team(Competitor... competitor){
        this.competitors = competitor;
    }

    // задать название команды
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }

    // вывод названия команды
    public void getTeamName(){
        System.out.println(teamName);
    }

    // результат прохождения всей полосы препятствий
    public void showResults(){
        for (Competitor c : competitors) {
            if(o.isOnDistance()) {
                c.info();
            }
        }
    }

    // участники, удачно проходящие препятствия
    public void teamInfo(Obstacle[] course){
        for (Competitor c : competitors) {
            for (Obstacle o : course) {
                if (!c.isOnDistance()) break;
                o.doIt(c);
            }
        }
    }

}
