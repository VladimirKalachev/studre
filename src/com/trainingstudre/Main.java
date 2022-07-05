package com.trainingstudre;

import static com.trainingstudre.CityUtils.*;

public class Main {

    public static void main(String[] args) {

        //вывод на экран содержимого csv
        print(parse());

        //вывод на экран содержимого csv отсортированного по наименованию города
        print(sortCityByName(parse()));

        //вывод на экран содержимого csv отсортированного по наименованию города и фед. округа
        print(sortCityByNameAndDistrict(parse()));

    }

}
