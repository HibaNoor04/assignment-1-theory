import java.time.LocalDateTime;
public class MessageApp {
    private Message messages[][];
    private int messageCounter[];
    private int maxMessagesPerReceiver;
    private int currentMessageId = 1;
    private String receivers[];


    //Constructor:
    public MessageApp(int receiverCount, int maxMessagesPerReceiver, String receivers[]) {
        this.maxMessagesPerReceiver = maxMessagesPerReceiver;
        //initializing 2D array:
        messages = new Message[receiverCount][maxMessagesPerReceiver];
        //initializing 1D array:
        messageCounter = new int[receiverCount];
        this.receivers = receivers;
    }


    //1.Send message:
    public void sendMessage(String content, int receiverIndex) {
        if (messageCounter[receiverIndex] < maxMessagesPerReceiver) {
            messages[receiverIndex][messageCounter[receiverIndex]] = new Message(content, "System"
                    , receivers[receiverIndex], currentMessageId++);
            messageCounter[receiverIndex]++;
        } else {
            System.out.println("message limit reached");
        }
    }

    //2.view messages:
    public void viewMessages(int receiverIndex) {
        System.out.println("Message for receiver" + receivers[receiverIndex] + ":");
        for (int i = 0; i < messageCounter[receiverIndex]; i++)
            System.out.println(messages[receiverIndex][i]);
    }

    // 3. Mark messages as seen:
   public void markMessagesAsSeen(int receiverIndex) {
        for (int i = 0; i < messageCounter[receiverIndex]; i++) {
            messages[receiverIndex][i].markAsSeen();
        }
    }


    //4.Delete a message:
    public void deleteMessage(int receiverIndex, int messageId) {
        for (int i = 0; i < messageCounter[receiverIndex]; i++) {
            if (messages[receiverIndex][i].getMessageId() == messageId) {
                for (int j = i; j < messageCounter[receiverIndex] - 1; j++) {
                    messages[receiverIndex][j] = messages[receiverIndex][j + 1];
                }
                messageCounter[receiverIndex]--;
                break;
            }
        }
    }

    //5.Search message:
    public Message searchMessageById(int receiverIndex, int messageId) {
        if (receiverIndex < 0 || receiverIndex >= receivers.length) {  // Check if receiverIndex is valid
            System.out.println("Invalid receiver index.");
            return null;
        }
        for (int i = 0; i < messageCounter[receiverIndex]; i++) {
            if (messages[receiverIndex][i].getMessageId() == messageId)
                return messages[receiverIndex][i];
        }
        System.out.println("Message with ID " + messageId + " not found for this receiver.");
        return null;  // Return null if no message is found
    }

    //6.Display messages:
    public void displayAllMessages(int receiverCount) {
        for (int i = 0; i < receiverCount; i++) {
            System.out.println("Messages for receiver " + receivers[i] + ":");
            for (int j = 0; j < messageCounter[i]; j++) {
                System.out.println(messages[i][j]);
            }
        }
    }

    //7.To view the status of the message:
    public void viewMessageStatus(int receiverIndex) {
        System.out.println("Message status for receiver " + receivers[receiverIndex] + ":");
        // Loop through all messages for this receiver:
        for (int i = 0; i < messageCounter[receiverIndex]; i++) {
            //creating an object:
            Message message = messages[receiverIndex][i];
            // Check if the message is seen or unseen using if-else:
            String status;
            if (message.getStatus() == Message.MessageStatus.SEEN) {
                status = "seen";
            } else {
                status = "unseen";
            }
            // Print the message ID and status
            System.out.println("Message ID: " + message.getMessageId() + " - Status: " + status);
        }
    }


    public void sortBytime() {
        Message temp;
        for (int i = 0; i < receivers.length; i++) {
            // Ensure there are messages to sort
            if (messageCounter[i] > 0) {
                // Bubble sort for this receiver's messages, sorting by time in descending order
                for (int j = 0; j < messageCounter[i] - 1; j++) {
                    for (int k = 0; k < messageCounter[i] - j - 1; k++) {
                        // Access messages[i][k] and messages[i][k + 1]
                        if (messages[i][k] != null && messages[i][k + 1] != null &&
                                messages[i][k].getTimestamp().isBefore(messages[i][k + 1].getTimestamp())) {
                            // Swap messages if the current message is older than the next one
                            temp = messages[i][k];
                            messages[i][k] = messages[i][k + 1];
                            messages[i][k + 1] = temp;
                        }
                    }
                }
            }
        }
    }
}











