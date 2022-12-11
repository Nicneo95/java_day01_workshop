package shoppingCart;

import java.io.Console;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create a linkedlist object
        List<String> cart = new LinkedList<>();
        // running the program in console 
        Console cons = System.console();
        // if true the while loop will stop
        Boolean stop = false;
        
        System.out.println("Welcome to your shopping cart");
        // while is not stop run the code block inside 
        while (!stop) {
            // 1. run line by line 
            String line = cons.readLine("> ");
            // command line remove any spaces from and back of the words
            line = line.trim();
            // add apple => ["add", "apple"]
            // list => ["list"]
            String[] terms = line.split(" ");
            // terms[0] is the command line a
            switch (terms[0]) {
                case "list":
                    if (cart.size() <= 0) {
                        System.out.println("Your cart is empty");
                    } else {
                        System.out.println("The contents of your cart");
                        for (Integer idx = 0; idx < cart.size(); idx++)
                        // idx + 1 so it display 1. 2. 3. instead of starting with 0.
                            System.out.printf("%d. %s\n", idx + 1, cart.get(idx));
                    }
                    break;

                case "add": // add apple orange pear
                    // Check if add has any items
                    cart.add(terms[1]);
                    System.out.printf("Added %s to cart\n", terms[1]);
                    break;

                case "delete":
                    // delete has any number and if the number is valid
                    Integer index = Integer.parseInt(terms[1]);
                    cart.remove((int)index);
                    System.out.printf("Sucessfully remove %s to cart\n", terms[1]);
                    break;

                case "exit":
                    stop = true;
                    break;

                default:
                    System.err.printf("Unknown command: %s\n", terms[0]);
            }
        }
    }
}
