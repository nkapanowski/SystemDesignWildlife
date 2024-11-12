// Emulating package structure within a single file for simplicity.

// Package animalKingdom
abstract class Animal {
    public String species;
    protected int age;

    public Animal() {
        this.species = "Unknown";
        this.age = 1;
    }

    public Animal(String species, int age) {
        this.species = species;
        this.age = age;
    }

    public void grow() {
        age += 1;
    }

    public abstract void makeSound();
}

abstract class Mammal extends Animal {
    private int furLength;

    public Mammal() {
        super();
        this.furLength = 5;
    }

    public Mammal(String species, int age, int furLength) {
        super(species, age);
        this.furLength = furLength;
    }

    @Override
    public void grow() {
        age += 2;
        furLength += 1;
    }

    public int getFurLength() {
        return furLength;
    }

    public void setFurLength(int furLength) {
        this.furLength = furLength;
    }

    public abstract void hibernate();
}

class Dog extends Mammal {
    private String breed;

    public Dog() {
        super();
        this.breed = "Unknown";
    }

    public Dog(String species, int age, int furLength, String breed) {
        super(species, age, furLength);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("The " + breed + " barks.");
    }

    @Override
    public void hibernate() {
        System.out.println("Dogs typically do not hibernate.");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void fetch() {
        System.out.println("The " + breed + " is fetching a ball.");
    }

    public void fetch(String toy) {
        System.out.println("The " + breed + " is fetching a " + toy + ".");
    }
}

// Package behaviors
interface Carnivore {
    void hunt();
}

interface Herbivore {
    void graze();
}

// Package environment
class Forest extends Mammal implements Carnivore {
    private int preyDensity;

    public Forest() {
        super();
        this.preyDensity = 50;
    }

    public Forest(String species, int age, int furLength, int preyDensity) {
        super(species, age, furLength);
        this.preyDensity = preyDensity;
    }

    @Override
    public void hunt() {
        System.out.println("The " + species + " hunts in the forest with prey density of " + preyDensity + ".");
    }

    @Override
    public void makeSound() {
        System.out.println("The " + species + " roars.");
    }

    @Override
    public void hibernate() {
        System.out.println("The " + species + " hibernates during winter.");
    }
}

class Savannah extends Animal implements Herbivore {
    private int grassHeight;

    public Savannah() {
        super();
        this.grassHeight = 100;
    }

    public Savannah(String species, int age, int grassHeight) {
        super(species, age);
        this.grassHeight = grassHeight;
    }

    @Override
    public void makeSound() {
        System.out.println("The " + species + " trumpets or makes a distinct sound.");
    }

    @Override
    public void graze() {
        System.out.println("The " + species + " grazes with a grass level of " + grassHeight + ".");
    }

    public void grow(int extraHeight) {
        grassHeight += extraHeight;
    }

    public void grow(String condition) {
        System.out.println("The " + species + " is growing under " + condition + " conditions.");
    }
}

// Package utilities
class Weather {
    private int temperature;
    private static final int DEFAULT_TEMP = 25;

    public Weather() {
        this.temperature = DEFAULT_TEMP;
    }

    public Weather(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void changeSeason(int level) {
        temperature += level;
        System.out.println("Changing season to level " + level + ". New temperature: " + temperature + "°C");
        displayTemperatureEffect();
    }

    public void changeSeason(String season) {
        switch (season.toLowerCase()) {
            case "winter":
                temperature -= 10;
                break;
            case "summer":
                temperature += 10;
                break;
            case "spring":
            case "fall":
                temperature += 5;
                break;
            default:
                System.out.println("Unknown season. No temperature change.");
                return;
        }
        System.out.println("Changing season to " + season + ". New temperature: " + temperature + "°C");
        displayTemperatureEffect();
    }

    private void displayTemperatureEffect() {
        if (temperature < 10) {
            System.out.println("It's cold! Temperature is below 10°C.");
        } else if (temperature > 30) {
            System.out.println("It's hot! Temperature is above 30°C.");
        } else {
            System.out.println("Temperature is moderate.");
        }
    }
}

class Constants {
    public static final int MAX_AGE = 20;
    public static final int MIN_AGE = 1;
    public static final String DEFAULT_SPECIES = "Lion";
}

class Utils {
    public static int calculateHunger(int hungerLevel) {
        return hungerLevel * 2;
    }

    public static int calculateHunger(String hungerType) {
        return hungerType.equals("high") ? 10 : 5;
    }
}

// Main class to run the simulation
public class WildlifeSimulation {
    public static void main(String[] args) {
        Dog dog = new Dog("Golden Retriever", 5, 2, "Golden Retriever");
        dog.grow();
        dog.makeSound();
        dog.fetch();

        Carnivore forestPredator = new Forest("Tiger", 8, 10, 80);
        forestPredator.hunt();

        Savannah herbivore = new Savannah("Elephant", 15, 200);
        herbivore.grow();
        herbivore.makeSound();
        herbivore.graze();

        Weather climate = new Weather();
        climate.changeSeason("Spring");
        System.out.println("Current temperature: " + climate.getTemperature() + "°C");

        climate.changeSeason(3);
        System.out.println("Current temperature after adjustment: " + climate.getTemperature() + "°C");

        System.out.println("Simulation complete.");
    }
}
