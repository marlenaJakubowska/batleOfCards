package com.codecool.battleofcards;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AI extends Player {

    public AI() {
        this.name = createName();
    }

    @Override
    public String chooseStatToCompare() {
        return "ourScore";
    }

    private String createName() {
        String[] alphabet = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d"
                , "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
        String chosen = "AI";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            chosen += alphabet[random.nextInt(alphabet.length)];
        }
        return this.name = chosen;
    }


//TO BE USED IN THE FUTURE
//    public String chooseRandomAttribute() {
//        List<String> attributeNames = new ArrayList<>();
//
//        Map<String, Float> attributesMap = topCard.getCardStats();
//        for (String key : attributesMap.keySet()) {
//            attributeNames.add(key);
//        }
//
//        Random random = new Random();
//        int randomIndex = random.nextInt(attributeNames.size());
//
//        return attributeNames.get(randomIndex);
//    }
//
//    public String chooseBiggestAttribute() {
//        Map<String, Float> attributesMap = topCard.getCardStats();
//        String biggestAttribute = "";
//
//        float biggestAttributeValue = 0;
//        for (String key : attributesMap.keySet()) {
//            if (attributesMap.get(key) > biggestAttributeValue) {
//                biggestAttributeValue = attributesMap.get(key);
//            }
//        }
//        for (String key : attributesMap.keySet()) {
//            if (attributesMap.get(key) == biggestAttributeValue) {
//                biggestAttribute = key;
//            }
//        }
//        return biggestAttribute;
//    }


}
