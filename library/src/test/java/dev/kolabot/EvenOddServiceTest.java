package dev.kolabot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {EvenOddService.class})
public class EvenOddServiceTest {

    @Autowired
    private EvenOddService evenOddService;

    static final Logger logger = LoggerFactory.getLogger(EvenOddServiceTest.class);

    @Test
    public void isOdd() {
        Integer num = 11;
        String evenOrOdd = evenOddService.isEvenOrOdd(num);

        assertEquals("Odd", evenOrOdd);
        logger.info("@IsOdd - " + num + " is " + evenOrOdd);
    }

    @Test
    public void isEven() {
        Integer num = 22;
        String evenOrOdd = evenOddService.isEvenOrOdd(num);

        assertEquals("Even", evenOrOdd);
        logger.info("@IsEven - " + num + " is " + evenOrOdd);
    }

}
