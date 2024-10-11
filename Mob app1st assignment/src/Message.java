import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message{
  private   String content;
   private String sender;
  private   String receiver;
  private   int messageId;

   private MessageStatus status;
   private LocalDateTime timestamp;
   //ENUM:
   public enum MessageStatus {  // Enum defined within the Message class
        SEEN, UNSEEN}
//Constructor:
        public Message(String content, String sender, String receiver, int messageId) {
        this.content = content;
        this.sender = "System";
        this.receiver = receiver;
        this.messageId = messageId;
        this.timestamp = LocalDateTime.now();
        this.status=MessageStatus.UNSEEN;//default status
        //Local Date time:It represents a date-time without a time zone
        //.now(): This is a static method of the LocalDateTime class that retrieves the current date
        // and time from the system clock in the default time zone
    }

//Getter methods:
    public int getMessageId() {
        return messageId;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getFormattedTimestamp() {
        // Define the desired date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Return the formatted timestamp
        return timestamp.format(formatter);
    }
    //Method:
    public void markAsSeen(){
        this.status = MessageStatus.SEEN;
    }

    public MessageStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("content=%s , sender=%s, receiver=%s ,messageId=%d,status=%s " +
                ",sent at:%s",content,sender,receiver,messageId,status,getFormattedTimestamp());}

    }

