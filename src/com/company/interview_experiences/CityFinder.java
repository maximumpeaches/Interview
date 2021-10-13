package com.company.interview_experiences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
This is the solution I wrote for second Facebook phone screen.
The question was a variation of this question: https://leetcode.com/problems/random-pick-with-weight/
Here is the question:
"You're given several cities with their population. Implement a function nextCity()
which returns a random city based on the population. For instance if you have the following
NY 7,000,000
LA 8,000,000
SEA 5,000,000

and nextCity() is called 20 times, then on average 7 times it should return NY, 5 times it should return SEA,
and 8 times it should return LA."

My solution was just to generate a random number that is between 0 and the total population of all cities. I then
put all the cities into an array, and find out where that random number would lie in the array by using binary search.
This is the same approach as in the Leetcode equivalent problem https://leetcode.com/problems/random-pick-with-weight/
It seemed like I passed, but I didn't get an on-site offer.
I don't have a copy of my code, but recreated it from memory below.
I made mistakes where I didn't check if the initial Map was of size zero, and my binary search has a bug because I
should check if lower <= higher instead of just lower < higher. Other than that it seems like it should work okay.
 */
public class CityFinder {
    private static final class City {
        private String name;
        private int lower;
        private int higher;
        private City(String name, int lower, int higher) {
            this.name = name;
            this.lower = lower;
            this.higher = higher;
        }
        private boolean valueIsLower(int value) {
            return value < this.lower;
        }
        private boolean valueIsHigher(int value) {
            // I clarified with interviewer that the range lower-higher was inclusive on the low end and exclusive on
            // the high end, so that is why you see >= below instead of just >
            return value >= this.higher;
        }
    }

    private final Random random = new Random();
    private List<City> cities;
    private int totalPopulation = 0;

    public CityFinder(Map<String, Integer> cityByPopulation) {
        this.cities = new ArrayList<>(cityByPopulation.size());

        for (Map.Entry<String, Integer> city : cityByPopulation.entrySet()) {
            int lower = totalPopulation;
            // I mentioned to interviewer that totalPopulation could have int overflow, and he said to assume this is not
            // possible
            this.totalPopulation += city.getValue();
            int higher = totalPopulation;
            City newCity = new City(city.getKey(), lower, higher);
            this.cities.add(newCity);
        }
    }

    public String nextCity() {
        // I told interviewer I wasn't 100% familiar with the Random API, and he said it's okay just assume you have
        // some reasonable API. So I said that I'm assuming nextInt() returns an integer between 0 and Integer.MAX_VALUE
        // I also said I wanted a random value between 0 (inclusive) and this.totalPopulation (exclusive) so I am
        // taking mod as you can see on the next line.
        // I mentioned that maybe we want to generate a random seed each time, but that's probably beyond the scope
        // of this exercise.
        int r = random.nextInt() % this.totalPopulation;
        int lower = 0;
        int higher = this.cities.size() - 1;
        int guess = 0;
        // you can see my binary search has a bug where lower < higher instead of lower <= higher. I didn't notice
        // this (or have time to check it) during the interview.
        while (lower < higher) {
            guess = ((higher - lower) / 2) + lower;
            if (this.cities.get(guess).valueIsLower(r)) {
                higher = guess - 1;
            } else if (this.cities.get(guess).valueIsHigher(r)) {
                lower = guess + 1;
            } else {
                return this.cities.get(guess).name;
            }
        }
        return this.cities.get(guess).name;
    }
}
