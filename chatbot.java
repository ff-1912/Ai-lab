import java.util.Scanner;

public class ChatBot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to ShopBot! How can I assist you today?");
        System.out.println("Type 'exit' to end the chat.\n");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("exit")) {
                System.out.println("Bot: Thank you for visiting! Have a great day.");
                break;
            } else if (userInput.contains("hello") || userInput.contains("hi")) {
                System.out.println("Bot: Hello! How can I help you today?");
            } else if (userInput.contains("price")) {
                System.out.println("Bot: Our products range from $10 to $500. What are you looking for?");
            } else if (userInput.contains("hours") || userInput.contains("timing")) {
                System.out.println("Bot: We are open from 9 AM to 8 PM every day.");
            } else if (userInput.contains("location") || userInput.contains("address")) {
                System.out.println("Bot: We are located at 123 Main Street, Downtown.");
            } else if (userInput.contains("support") || userInput.contains("help")) {
                System.out.println("Bot: Sure! You can reach our support team at support@example.com.");
            } else {
                System.out.println("Bot: I'm sorry, I didn't understand that. Can you rephrase?");
            }
        }

        scanner.close();
    }
}
