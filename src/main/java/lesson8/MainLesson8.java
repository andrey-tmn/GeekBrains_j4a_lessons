package lesson8;

import cat.names.CatNames;

import java.io.IOException;

public class MainLesson8 {
    public static void main(String[] args) throws IOException {
        String[] humanNames = {"Джек", "Майк", "Келви", "Марк", "Жак", "Кен", "Ян"};
        final int PARTICIPANT_CNT = 10;
        final int OBSTACLES_CNT = 10;

        Participant[] participants = new Participant[PARTICIPANT_CNT];
        Obstacle[] obstacles = new Obstacle[OBSTACLES_CNT];

        System.out.println("Набираем участников:");

        for (int i = 0; i < participants.length; i++) {
            double pTypeBranch = Math.random();
            Participant tmp;
            if (0.33 > pTypeBranch) {
                tmp = new Cat(CatNames.getCatName());
            } else if (0.66 > pTypeBranch) {
                tmp = new Human(humanNames[(int) (Math.random() * humanNames.length)]);
            } else {
                tmp = new Robot("Робот-" + (int) ((Math.random() * 100) + 100));
            }
            participants[i] = tmp;
        }

        System.out.println();
        System.out.println("Формируем полосу препятствий:");

        for (int i = 0; i < obstacles.length; i++) {
            System.out.print((i + 1) + ". ");
            Obstacle tmp;
            if (0.5 > Math.random()) {
                tmp = new Wall();
            } else {
                tmp = new RunningTrack();
            }
            obstacles[i] = tmp;
        }

        System.out.println();
        System.out.println("Все участники стартуют одновременно.");

        for (int i = 0; i < obstacles.length; i++) {
            System.out.print((i + 1) + ". ");
            obstacles[i].printInfo();
            for (Participant curp : participants) {
                obstacles[i].overcome(curp);
            }
        }

        System.out.println();
        System.out.println("Финиш.");
        for (Participant curp : participants) {
            curp.printFinishInfo();
        }
    }

}
