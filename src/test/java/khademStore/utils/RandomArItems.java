package khademStore.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomArItems {
    public static String randomArData(){
    com.github.javafaker.Faker faker = new com.github.javafaker.Faker(new Locale("ar"));
     String itemNameAR = faker.lorem().word();
     return itemNameAR;
    }
    public static String  randomStringNumber() {
        Faker faker = new Faker();
       return faker.number().toString();
    }

    }
