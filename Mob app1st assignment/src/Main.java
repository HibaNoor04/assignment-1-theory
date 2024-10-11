import java.util.Scanner;
import java.time.LocalDateTime;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Initialize the number of receivers and maximum messages per receiver:basically jo pehla constructor hai uski bs values set kr rhy hain hum:
        int receiverCount = 3;
        int maxMessagesPerReceiver = 5;
        String[] receivers = {"Alice", "Bob", "Charlie"};
        //creating an obj of  class:
        MessageApp messageApp = new MessageApp(receiverCount, maxMessagesPerReceiver, receivers);//messageApp mai constructor mai yehi 3 thy to yaha bhi pass only these
        // Send some messages
      {messageApp.sendMessage("Hello, Alice!", 0);
            messageApp.sendMessage("yay mayte!", 0);
        messageApp.sendMessage("Hi, Bob!", 1);
        messageApp.sendMessage("Good morning, Charlie!", 2);
        messageApp.sendMessage("How are you?", 0);
        messageApp.sendMessage("Just checking in!", 1);
        messageApp.sendMessage("Let's meet up!", 2);}

        while (true) {
            System.out.println("\nMessage App Menu:");
            System.out.println("1. Send Message");
            System.out.println("2. View Messages");
            System.out.println("3. Mark Messages as Seen");
            System.out.println("4. View Message Status"); // New option to view message status
            System.out.println("5. Delete a Message");
            System.out.println("6. Search Message by ID");
            System.out.println("7. Display All Messages");
            System.out.println("8. Sort Messages by Time");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    //send message:
                    System.out.println("Enter message content:");
                    s.nextLine();
                    String content = s.nextLine();
                    System.out.println("Choose receiver (0 for Alice, 1 for Bob, 2 for Charlie):");
                    int receiverIndex = s.nextInt();
                    //calling the function:
                    messageApp.sendMessage(content, receiverIndex);
                    break;
                case 2:
                    // View Messages
                    System.out.println("Choose receiver (0 for Alice, 1 for Bob, 2 for Charlie):");
                    receiverIndex = s.nextInt();
                    s.nextLine();//consume the next line agr na kron to its not working properly
                    messageApp.viewMessages(receiverIndex);
                    break;
                case 3:
                    // Mark Messages as Seen
                    System.out.println("Choose receiver (0 for Alice, 1 for Bob, 2 for Charlie):");
                    receiverIndex = s.nextInt();
                    s.nextLine();
                    messageApp.markMessagesAsSeen(receiverIndex);
                    System.out.println("All messages marked as seen.");
                    break;
                case 4:
                    // View Message Status
                    System.out.println("Choose receiver (0 for Alice, 1 for Bob, 2 for Charlie):");
                    receiverIndex = s.nextInt();
                    s.nextLine();
                    messageApp.viewMessageStatus(receiverIndex);
                    break;
                case 5://Delete messages:
                    System.out.println("Choose receiver (0 for Alice, 1 for Bob, 2 for Charlie):");
                    receiverIndex = s.nextInt();
                    s.nextLine();
                    System.out.println("Enter message ID to delete:");
                    int messageId = s.nextInt();
                    s.nextLine();
                    messageApp.deleteMessage(receiverIndex, messageId);
                    break;
                case 6:
                    // Search Message by ID
                    System.out.println("Choose receiver (0 for Alice, 1 for Bob, 2 for Charlie):");
                    receiverIndex = s.nextInt();
                    s.nextLine();
                    System.out.println("Enter message ID to search:");
                    messageId = s.nextInt();
                    s.nextLine();
                    Message message = messageApp.searchMessageById(receiverIndex, messageId);
                    if (message != null) {
                        System.out.println("Message found: " + message);
                    }
                    break;
                case 7://Display all messages:
                    messageApp.displayAllMessages(receiverCount);
                    break;
                case 8:
                    // Sort Messages by Time
                    System.out.println("Sorting messages by time...");
                    messageApp.sortBytime();
                    System.out.println("Messages sorted.");
                    break;
                case 9:
                    // Exit
                    System.out.println("Exiting Message App.");
                    s.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        }
    }
}