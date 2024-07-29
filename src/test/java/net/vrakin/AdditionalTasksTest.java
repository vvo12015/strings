package net.vrakin;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AdditionalTasksTest {

    private final Map<Integer, String> testMoney = new HashMap<>();

    @Before
    public void setUp(){
        testMoney.put(1, "one cent");
        testMoney.put(2, "two cents");
        testMoney.put(3, "three cents");
        testMoney.put(4, "four cents");
        testMoney.put(5, "five cents");
        testMoney.put(6, "six cents");
        testMoney.put(7, "seven cents");
        testMoney.put(8, "eight cents");
        testMoney.put(9, "nine cents");
        testMoney.put(10, "ten cents");
        testMoney.put(11, "eleven cents");
        testMoney.put(12, "twelve cents");
        testMoney.put(13, "thirteen cents");
        testMoney.put(14, "fourteen cents");
        testMoney.put(15, "fifteen cents");
        testMoney.put(16, "sixteen cents");
        testMoney.put(17, "seventeen cents");
        testMoney.put(18, "eighteen cents");
        testMoney.put(19, "nineteen cents");
        testMoney.put(20, "twenty cents");
        testMoney.put(21, "twenty one cents");
        testMoney.put(30, "thirty cents");
        testMoney.put(32, "thirty two cents");
        testMoney.put(40, "forty cents");
        testMoney.put(43, "forty three cents");
        testMoney.put(50, "fifty cents");
        testMoney.put(54, "fifty four cents");
        testMoney.put(60, "sixty cents");
        testMoney.put(65, "sixty five cents");
        testMoney.put(70, "seventy cents");
        testMoney.put(76, "seventy six cents");
        testMoney.put(80, "eighty cents");
        testMoney.put(87, "eighty seven cents");
        testMoney.put(90, "ninety cents");
        testMoney.put(98, "ninety eight cents");
        testMoney.put(99, "ninety nine cents");
        testMoney.put(1_00, "one dollar");
        testMoney.put(1_10, "one dollar ten cents");
        testMoney.put(1_51, "one dollar fifty one cents");
        testMoney.put(9_99, "nine dollars ninety nine cents");
        testMoney.put(10_00, "ten dollars");
        testMoney.put(11_00, "eleven dollars");
        testMoney.put(11_15, "eleven dollars fifteen cents");
        testMoney.put(11_20, "eleven dollars twenty cents");
        testMoney.put(23_67, "twenty three dollars sixty seven cents");
        testMoney.put(99_99, "ninety nine dollars ninety nine cents");
        testMoney.put(100_00, "one hundred dollars");
        testMoney.put(137_89, "one hundred thirty seven dollars eighty nine cents");
        testMoney.put(150_00, "one hundred fifty dollars");
        testMoney.put(250_00, "two hundred fifty dollars");
        testMoney.put(999_99, "nine hundred ninety nine dollars ninety nine cents");
        testMoney.put(1000_00, "one thousand dollars");//?
        testMoney.put(1268_41, "one thousand two hundred sixty eight dollars forty one cents");
        testMoney.put(7_000_00, "seven thousand dollars");
        testMoney.put(9_999_99, "nine thousand nine hundred ninety nine dollars ninety nine cents");
        testMoney.put(10_000_00, "ten thousand dollars");
        testMoney.put(34_857_69, "thirty four thousand eight hundred fifty seven dollars sixty nine cents");
        testMoney.put(100_000_00, "one hundred thousand dollars");
        testMoney.put(160_000_00, "one hundred sixty thousand dollars");
        testMoney.put(900_000_00, "nine hundred thousand dollars");
        testMoney.put(999_999_99, "nine hundred ninety nine thousand nine hundred ninety nine dollars ninety nine cents");
        testMoney.put(1_000_000_00, "one million dollars");
        testMoney.put(9_999_999_99, "nine million nine hundred ninety nine thousand nine hundred ninety nine dollars ninety nine cents");
        testMoney.put(10_000_000_00, "ten million dollars");
    }


    @Test
    public void printNumber() {
        for (Map.Entry<Integer, String> entry : testMoney.entrySet()){
                assertEquals(entry.getValue(), AdditionalTasks.printNumber(entry.getKey()));
        }
    }
}
