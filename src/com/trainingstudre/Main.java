package com.trainingstudre;

import com.trainingstudre.model.City;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String file = "src/resources/city_ru.csv";
        Scanner scanner = new Scanner(new File(file));
        Scanner valueScanner;
        int index = 0;
        List<City> cityList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            valueScanner = new Scanner(scanner.nextLine());
            valueScanner.useDelimiter(";");
            City city = new City();

            while (valueScanner.hasNext()) {
                String data = valueScanner.next();
                if (index == 1) {
                    city.setName(data);
                } else if (index == 2) {
                    city.setRegion(data);
                } else if (index == 3) {
                    city.setDistrict(data);
                } else if (index == 4) {
                    int population = parseInt(data);
                    city.setPopulation(population);
                } else if (index == 5) {
                    city.setFoundation(data);
                }
                index++;
            }
            index = 0;
            cityList.add(city);
        }
        scanner.close();

        for (City city : cityList) {
            System.out.println(city);
        }
    }

}
