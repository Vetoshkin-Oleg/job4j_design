package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");

        String name = "Oleg";
        byte age = 33;
        short weight = 75;
        int height = 175;
        long numberOfHairs = 150000;
        boolean isRussian = true;
        char firstLetterSecondName = 'V';
        float powerOfVision = -5.5f;
        double numberOfArms = 2;
        LOG.debug("User info name : {}, age : {}, weight : {}, height : {}, numberOfHairs : {},"
                        + " isRussian : {}, firstLetterSecondName : {}, powerOfVision : {},"
                        + " numberOfArms : {}",
                name, age, weight, height, numberOfHairs, isRussian, firstLetterSecondName,
                powerOfVision, numberOfArms);
    }
}