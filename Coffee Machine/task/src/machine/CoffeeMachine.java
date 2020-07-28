package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;
    static int money = 550;

    final static int ESPRESSO_WATER = 250;
    final static int LATTE_WATER = 350;
    final static int CAPPUCCINO_WATER = 200;

    final static int ESPRESSO_COFFEE = 16;
    final static int LATTE_COFFEE = 20;
    final static int CAPPUCCINO_COFFEE = 12;

    final static int ESPRESSO_MILK = 0;
    final static int LATTE_MILK = 75;
    final static int CAPPUCCINO_MILK = 100;

    final static int ESPRESSO_PRICE = 4;
    final static int LATTE_PRICE = 7;
    final static int CAPPUCCINO_PRICE = 6;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            input = scanner.next().trim().toLowerCase();

            if (input.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                String buy = scanner.next();
                buy(buy);
            } else if (input.equals("fill")) {
                fill(scanner);
            } else if (input.equals("take")) {
                System.out.println(String.format("I gave you $%d", money));
                money = 0;
            } else if (input.equals("remaining")) {
                printResult();
            } else if (input.equals("exit")) {
                System.exit(1);
            } else {
                System.out.println("Invalid inputs");
            }
        }


    }

    public static void buy(String input) {
        boolean w = false, m = false, c = false;
        if (input.equals("1")) {

            if (coffee >= ESPRESSO_COFFEE) {
                c = true;
            } else {
                System.out.println("Sorry, not enough coffee beans!");
            }
            if (water >= ESPRESSO_WATER) {
                w = true;
            } else {
                System.out.println("Sorry, not enough water!");
            }
            if (w && c) {
                water -= ESPRESSO_WATER;
                coffee -= ESPRESSO_COFFEE;
                money += ESPRESSO_PRICE;
                cups--;
            }
        } else if (input.equals("2")) {
            if (coffee >= LATTE_COFFEE) {
                c = true;
            } else {
                System.out.println("Sorry, not enough coffee beans!");
            }
            if (water >= LATTE_WATER) {
                w = true;
            } else {
                System.out.println("Sorry, not enough water!");
            }
            if (milk >= LATTE_MILK) {
                m = true;
            } else {
                System.out.println("Sorry, not enough milk!");
            }
            if (w && c && m) {
                water -= LATTE_WATER;
                milk -= LATTE_MILK;
                coffee -= LATTE_COFFEE;
                money += LATTE_PRICE;
                cups--;
                System.out.println("I have enough resources, making you a coffee!");
            }
        } else if (input.equals("3")) {
            if (coffee >= CAPPUCCINO_COFFEE) {
                c = true;
            } else {
                System.out.println("Sorry, not enough coffee beans!");
            }
            if (water >= CAPPUCCINO_WATER) {
                w = true;
            } else {
                System.out.println("Sorry, not enough water!");
            }
            if (milk >= CAPPUCCINO_MILK) {
                m = true;
            } else {
                System.out.println("Sorry, not enough milk!");
            }
            if (w && c && m) {
                water -= CAPPUCCINO_WATER;
                milk -= CAPPUCCINO_MILK;
                coffee -= CAPPUCCINO_COFFEE;
                money += CAPPUCCINO_PRICE;
                cups--;
                System.out.println("I have enough resources, making you a coffee!");
            }
        }
    }

    public static void fill(Scanner scanner) {

        System.out.println("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add");
        cups += scanner.nextInt();
    }

    public static void printResult() {
        System.out.println("The coffee machine has:");
        System.out.println(String.format("%d of water", water));
        System.out.println(String.format("%d of milk", milk));
        System.out.println(String.format("%d of coffee beans", coffee));
        System.out.println(String.format("%d of disposable cups", cups));
        System.out.println(String.format("$%d of money", money));
    }
}
