package com.suirtech.automation.resttest.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.springframework.stereotype.Component;

import static java.util.regex.Pattern.matches;

@Component
public class CustomAssertions {

    private static Logger logger = LogManager.getLogger(CustomAssertions.class);

    public void sAssertNotNull(Object obj, String message){
        logger.info("Asserting Not Null " + message);
        Assert.assertNotNull(obj);
    }


    public void sAssertNull(Object obj, String message){
        logger.info("Asserting Null " + message);
        Assert.assertNull(obj);
    }

    public void sStringEquals(String expected, String actual, String message){
        logger.info(String.format("Asserting equals %s == %s | %s", expected, actual, message));
        Assert.assertEquals(expected, actual);
    }

    public void sMatchesRegex(String actual, String regex, String message){
        logger.info(String.format("Asserting regex  %s matches %s | %s", regex, actual, message));
        Assert.assertTrue(matches(regex, actual));

    }

}
