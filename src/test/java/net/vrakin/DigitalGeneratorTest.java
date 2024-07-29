package net.vrakin;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class DigitalGeneratorTest {

    private Map<Integer, String> testNumbers = new HashMap<>();

    @Before
    public void setUp(){
        testNumbers.put(1, "one");
        testNumbers.put(2, "two");
        testNumbers.put(3, "three");
        testNumbers.put(4, "four");
        testNumbers.put(5, "five");
        testNumbers.put(6, "six");
        testNumbers.put(7, "seven");
        testNumbers.put(8, "eight");
        testNumbers.put(9, "nine");
        testNumbers.put(10, "ten");
        testNumbers.put(11, "eleven");
        testNumbers.put(12, "twelve");
        testNumbers.put(13, "thirteen");
        testNumbers.put(14, "fourteen");
        testNumbers.put(15, "fifteen");
        testNumbers.put(16, "sixteen");
        testNumbers.put(17, "seventeen");
        testNumbers.put(18, "eighteen");
        testNumbers.put(19, "nineteen");
        testNumbers.put(20, "twenty");
        testNumbers.put(21, "twenty one");
        testNumbers.put(30, "thirty");
        testNumbers.put(32, "thirty two");
        testNumbers.put(40, "forty");
        testNumbers.put(43, "forty three");
        testNumbers.put(50, "fifty");
        testNumbers.put(54, "fifty four");
        testNumbers.put(60, "sixty");
        testNumbers.put(65, "sixty five");
        testNumbers.put(70, "seventy");
        testNumbers.put(76, "seventy six");
        testNumbers.put(80, "eighty");
        testNumbers.put(87, "eighty seven");
        testNumbers.put(90, "ninety");
        testNumbers.put(98, "ninety eight");
        testNumbers.put(99, "ninety nine");
        testNumbers.put(100, "one hundred");
        testNumbers.put(110, "one hundred ten");
        testNumbers.put(151, "one hundred fifty one");
        testNumbers.put(999, "nine hundred ninety nine");
        testNumbers.put(1_000, "one thousand");
        testNumbers.put(1_100, "one thousand one hundred");
        testNumbers.put(1_115, "one thousand one hundred fifteen");
        testNumbers.put(1_120, "one thousand one hundred twenty");
        testNumbers.put(2_367, "two thousand three hundred sixty seven");
        testNumbers.put(9_999, "nine thousand nine hundred ninety nine");
        testNumbers.put(10_000, "ten thousand");
        testNumbers.put(13_789, "thirteen thousand seven hundred eighty nine");
        testNumbers.put(15_000, "fifteen thousand");
        testNumbers.put(25_000, "twenty five thousand");
        testNumbers.put(99_999, "ninety nine thousand nine hundred ninety nine");
        testNumbers.put(100_000, "one hundred thousand");//?
        testNumbers.put(126_841, "one hundred twenty six thousand eight hundred forty one");
        testNumbers.put(700_000, "seven hundred thousand");
        testNumbers.put(999_999, "nine hundred ninety nine thousand nine hundred ninety nine");
        testNumbers.put(1_000_000, "one million");
        testNumbers.put(3_485_769, "three million four hundred eighty five thousand seven hundred sixty nine");
        testNumbers.put(10_000_000, "ten million");
        testNumbers.put(16_000_000, "sixteen million");
        testNumbers.put(90_000_000, "ninety million");
        testNumbers.put(99_999_999, "ninety nine million nine hundred ninety nine thousand nine hundred ninety nine");
        testNumbers.put(100_000_000, "one hundred million");
        testNumbers.put(999_999_999, "nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine");
        testNumbers.put(1_000_000_000, "one billion");
    }

    @Test
    public void testNumberLess100(){
        for (Map.Entry<Integer, String> entry : testNumbers.entrySet()){
            if (entry.getKey() < DigitalStringGenerator.NUMBER_HUNDRED)
                assertEquals(entry.getValue(), AdditionalTasks.printNumber(entry.getKey()));
        }
    }

    @Test
    public void testNumberLess1000(){
        for (Map.Entry<Integer, String> entry : testNumbers.entrySet()){
            if ((entry.getKey() >= DigitalStringGenerator.NUMBER_HUNDRED) &&
                    (entry.getKey() < DigitalStringGenerator.NUMBER_THOUSAND))
                assertEquals(entry.getValue(), AdditionalTasks.printNumber(entry.getKey()));
        }
    }

    @Test
    public void testNumberLess100_000(){
        for (Map.Entry<Integer, String> entry : testNumbers.entrySet()){
            if ((entry.getKey() >= DigitalStringGenerator.NUMBER_THOUSAND) &&
                    (entry.getKey() < DigitalStringGenerator.NUMBER_HUNDRED_THOUSAND))
                assertEquals(entry.getValue(), AdditionalTasks.printNumber(entry.getKey()));
        }
    }

    @Test
    public void testNumberLess1_000_000(){
        for (Map.Entry<Integer, String> entry : testNumbers.entrySet()){
            if ((entry.getKey() >= DigitalStringGenerator.NUMBER_HUNDRED_THOUSAND) &&
                    (entry.getKey() < DigitalStringGenerator.NUMBER_MILLION))
                assertEquals(entry.getValue(), AdditionalTasks.printNumber(entry.getKey()));
        }
    }

    @Test
    public void testNumberLess1_000_000_000(){
        for (Map.Entry<Integer, String> entry : testNumbers.entrySet()){
            if ((entry.getKey() >= DigitalStringGenerator.NUMBER_MILLION) &&
                    (entry.getKey() < DigitalStringGenerator.NUMBER_BILLION))
                assertEquals(entry.getValue(), AdditionalTasks.printNumber(entry.getKey()));
        }
    }

    @Test
    public void testNumberLess10_000_000_000(){
        for (Map.Entry<Integer, String> entry : testNumbers.entrySet()){
            if ((entry.getKey() == DigitalStringGenerator.NUMBER_BILLION) &&
                    (entry.getKey() < DigitalStringGenerator.NUMBER_10_BILLION))
                System.out.printf("%s - %s%n", entry.getKey(), entry.getValue());
                assertEquals(entry.getValue(), AdditionalTasks.printNumber(entry.getKey()));
        }
    }
}
