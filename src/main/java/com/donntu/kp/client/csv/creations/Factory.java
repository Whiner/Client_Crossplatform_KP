package com.donntu.kp.client.csv.creations;


import com.donntu.kp.client.csv.creations.interfaces.Bird;
import com.donntu.kp.client.csv.creations.interfaces.Mammal;

public class Factory {
    public static Bird createBird(BirdType birdType){
        Bird bird = new Bird();
        switch (birdType){
            case CROW:
                bird.setArial("Везде кроме теплых стран");
                bird.setColor("Черный");
                bird.setLimbCount(2);
                bird.setManual(true);
                bird.setPet(false);
                bird.setSex(Sex.male);
                bird.setSound("Кар-кар");
                bird.setSpeaking(false);
                bird.setName("Ворон");
                break;
            case DODO:
                bird.setArial("Тыщу лет назад");
                bird.setColor("Разноцветный с клювом");
                bird.setLimbCount(17);
                bird.setManual(false);
                bird.setPet(false);
                bird.setSex(Sex.female);
                bird.setSound("Ку-ка-ре-ку");
                bird.setSpeaking(false);
                bird.setName("Додо");
                break;
            case COLLIBRI:
                bird.setArial("Африка");
                bird.setColor("Разноцветный");
                bird.setLimbCount(2);
                bird.setManual(false);
                bird.setPet(false);
                bird.setSex(Sex.female);
                bird.setSound("Бззззззззз");
                bird.setSpeaking(false);
                bird.setName("Коллибри");
                break;
        }

        return bird;
    }

    public static Mammal createMammal(MammalType mammalType){
        Mammal mammal = new Mammal();
        switch (mammalType){
            case CAT:
                mammal.setSound("Мияяяяяууууу");
                mammal.setArial("Да везде");
                mammal.setHorns(false);
                mammal.setLimbCount(4);
                mammal.setHooves(false);
                mammal.setPet(false);
                mammal.setSex(Sex.male);
                mammal.setScales(false);
                mammal.setWool(true);
                mammal.setName("Кошка");
                break;
            case COW:
                mammal.setSound("Мууууууу");
                mammal.setArial("Да везде где есть травка");
                mammal.setHorns(true);
                mammal.setLimbCount(4);
                mammal.setHooves(true);
                mammal.setPet(true);
                mammal.setSex(Sex.male);
                mammal.setScales(false);
                mammal.setWool(false);
                mammal.setName("Коровка");
                break;
            case DOG:
                mammal.setSound("Гафффф");
                mammal.setArial("Да везде");
                mammal.setHorns(false);
                mammal.setLimbCount(4);
                mammal.setHooves(false);
                mammal.setPet(false);
                mammal.setSex(Sex.male);
                mammal.setScales(false);
                mammal. setWool(true);
                mammal.setName("ПЁССС");
                break;
        }
        return mammal;
    }
}
