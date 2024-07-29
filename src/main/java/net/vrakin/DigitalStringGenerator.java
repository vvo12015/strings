package net.vrakin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DigitalStringGenerator {

    public static final int MAX_VALUE_NUMBER2 = 99;
    public static final int MIN_VALUE_NUMBER2 = 0;
    public static final int DIGIT1_OF_NUMBER = 10;
    public static final int NUMBER_HUNDRED = 100;
    public static final int NUMBER_THOUSAND = 1_000;
    public static final int NUMBER_HUNDRED_THOUSAND = 100_000;
    public static final int NUMBER_MILLION = 1_000_000;
    public static final int NUMBER_BILLION = 1_000_000_000;
    public static final String SPACE = " ";
    public static final Long NUMBER_10_BILLION = 10_000_000_000L;
    private static final int MAX_ENTERED_NUMBER = 1_000_000_000;
    public static final int CENT_COUNT_IN_DOLLAR = 100;
    public static final String DOLLAR = " dollar";
    public static final String DOLLARS = " dollars";
    public static final String CENT = " cent";
    public static final String CENTS = " cents";
    public static final String ONE = "one";

    public static String generate2Digital(int number) {
        StringBuilder result = new StringBuilder();

        if ((number <= MAX_VALUE_NUMBER2) &&
                (number >= MIN_VALUE_NUMBER2) ){
            switch (number / DIGIT1_OF_NUMBER) {
                case 1 -> {
                    switch (number % DIGIT1_OF_NUMBER) {
                       case 0 -> result.append("ten");
                       case 1 -> result.append("eleven");
                       case 2 -> result.append("twelve");
                       case 3 -> result.append("thirteen");
                       case 4 -> result.append("fourteen");
                       case 5 -> result.append("fifteen");
                       case 6 -> result.append("sixteen");
                       case 7 -> result.append("seventeen");
                       case 8 -> result.append("eighteen");
                       case 9 -> result.append("nineteen");
                    }
                    return result.toString();
                }
                case 2 -> result.append("twenty");
                case 3 -> result.append("thirty");
                case 4 -> result.append("forty");
                case 5 -> result.append("fifty");
                case 6 -> result.append("sixty");
                case 7 -> result.append("seventy");
                case 8 -> result.append("eighty");
                case 9 -> result.append("ninety");
            }

            if (number / DIGIT1_OF_NUMBER < 1) {
                return generate1Digital(number);
            }

            if ((number / DIGIT1_OF_NUMBER > 1) &&
                    (number % DIGIT1_OF_NUMBER) > 0)
                    result
                                                .append(SPACE)
                                                .append(generate1Digital(number % DIGIT1_OF_NUMBER));

        } else throw new RuntimeException("The number is more than expected ");

        return result.toString();
    }

    public static String generate1Digital(int digital) {
        StringBuilder result = new StringBuilder();
        if (digital < DIGIT1_OF_NUMBER) {
            switch (digital % DIGIT1_OF_NUMBER) {
                case 1 -> result.append("one");
                case 2 -> result.append("two");
                case 3 -> result.append("three");
                case 4 -> result.append("four");
                case 5 -> result.append("five");
                case 6 -> result.append("six");
                case 7 -> result.append("seven");
                case 8 -> result.append("eight");
                case 9 -> result.append("nine");
            }
        }

        return result.toString();
    }

    public static String generate3Digital(int digital) {

        if (digital < 1) {
            return "";
        }

        String hundredCount = generate1Digital(digital / NUMBER_HUNDRED);
        String hundredPart = !hundredCount.isEmpty()?hundredCount + " hundred"
                                : "";
        String tenPart = generate2Digital(digital % NUMBER_HUNDRED);
        return getStringWithSpace(hundredPart, tenPart);
    }

    private static String getStringWithSpace(String firstPart, String lessPart) {
        if (!firstPart.isEmpty() && !lessPart.isEmpty()) {
            return firstPart + SPACE + lessPart;
        }else return firstPart + lessPart;
    }

    public static String generateThousands(int digital, DigitalNum digitalNum) {
        int coefficient = 0;
        switch (digitalNum) {
            case THOUSAND -> coefficient = NUMBER_THOUSAND;
            case MILLION -> coefficient = NUMBER_MILLION;
        }
        if (digital / coefficient < NUMBER_THOUSAND) {
            String thousandPart = generate3Digital(digital / coefficient);
            return !thousandPart.isEmpty()?(thousandPart + " " + digitalNum.toString().toLowerCase()):"";
        }else throw new RuntimeException(String.format("The number %d is more than expected ", digital));
    }

    public static String generateLessMillion(int digital) {
        if (digital < NUMBER_MILLION) {
            String thousandPart = generateThousands(digital, DigitalNum.THOUSAND);
            String lessPart = DigitalStringGenerator.generate3Digital(digital % NUMBER_THOUSAND);

            return getStringWithSpace(thousandPart, lessPart);
        } else throw new RuntimeException(String.format("The number %d is more than expected ", digital));
    }


    public static String generateLessBillion(int digital) {
        if (digital < NUMBER_BILLION) {

            String millionPart = generateThousands(digital, DigitalNum.MILLION);
            String lessPart = generateLessMillion(digital % NUMBER_MILLION);
            return getStringWithSpace(millionPart, lessPart);
        } else throw new RuntimeException(String.format("The number %d is more than expected ", digital));
    }

    public static String generateBillion(String stringNumber) {
        StringBuilder result = new StringBuilder();
        String millionPart = "";
        if (stringNumber.length() > DIGIT1_OF_NUMBER) throw new RuntimeException(String.format("The number %s is more than expected ", stringNumber));
        else if (stringNumber.length() == DIGIT1_OF_NUMBER) {
            result.append(DigitalStringGenerator.generate1Digital(Integer.parseInt(stringNumber.substring(0, 1))));
            result.append(" billion");
            millionPart = DigitalStringGenerator.generateLessBillion(Integer.parseInt(stringNumber.substring(1)));
        }else {
            millionPart = DigitalStringGenerator.generateLessBillion(Integer.parseInt(stringNumber));
        }

        String billionPart = result.toString();

        return getStringWithSpace(billionPart, millionPart);
    }

    public static String generateMoney(int number) {
        if (number > MAX_ENTERED_NUMBER) return "Error. Enter a lower number";
        else if (number == 0) return "Zero dollar zero cent";
        else if (number == 1) return "one cent";
        else if (number < 0) return "Error. the entered number must be greater than 0";

        int countDollars = number / CENT_COUNT_IN_DOLLAR;
        int remainder = number % CENT_COUNT_IN_DOLLAR;

        StringBuilder dollars = new StringBuilder(DigitalStringGenerator.generateBillion(Integer.toString(countDollars)));
        if (dollars.toString().equals(ONE)) dollars.append(DOLLAR);
        else if (!dollars.isEmpty()) dollars.append(DOLLARS);
        StringBuilder cents = new StringBuilder(DigitalStringGenerator.generate2Digital(remainder));
        if (cents.toString().equals(ONE)) cents.append(CENT);
        else if (!cents.isEmpty()) cents.append(CENTS);

        return getStringWithSpace(dollars.toString(), cents.toString());
    }
}