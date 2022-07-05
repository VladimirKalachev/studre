package com.trainingstudre;

import com.trainingstudre.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CityUtils {

    public static List<City> parse() {
        List<City> cities = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/resources/city_ru.csv"));
            while (scanner.hasNextLine()) {
                cities.add(parse(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void print(List<City> cities) {
        cities.forEach(System.out::println);
    }

    private static City parse(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;
        if (scanner.hasNext()) {
            foundation = scanner.next();
        }
        scanner.close();
        return new City(name, region, district, population, foundation);
    }

    //сортировка по городу
    static List<City> sortCityByName(List<City> cities) {
        List<City> sortedCity = cities.stream()
                .sorted(Comparator.comparing(City::getName))
                .collect(Collectors.toList());
        return sortedCity;
    }

    //сортировка по городу и федеральному округу
    static List<City> sortCityByNameAndDistrict(List<City> cities) {
        List<City> sortedCity = cities.stream()
                .sorted(Comparator.comparing(City::getName))
                .sorted(Comparator.comparing(City::getDistrict))
                .collect(Collectors.toList());
        return sortedCity;
    }

    //преобразование списка в массив и поиск города с наибольшим количеством жителей
    static void indexOfMaxPopulation(List<City> cities) {
        City[] citiesArray = cities.toArray(new City[0]);
        int max = 0;
        int index = 0;
        for (int i = 0; i < citiesArray.length; i++) {

            if (citiesArray[i].getPopulation() > max) {
                max = citiesArray[i].getPopulation();
                index = i;
            }
        }
        System.out.println("[" + index + "] = " + max);

    }


}
