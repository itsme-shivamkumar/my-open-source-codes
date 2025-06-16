public class ObserverPattern{
    public static void main(String[] args){
        // main class
        NotificationService storeSubscriber = new NotificationService();
        storeSubscriber.addListener(Event.NET_ITEM, new EmailNotiificationListener("shivkumar@gmail.com"));
        storeSubscriber.addListener(Event.SALE, new PushNotificationListener("+91822878272"));

        storeSubscriber.notify(Event.SALE);
    }
}

/* Classes required 
    -> Subject(that will notify listeners e.g. NotificationService)
    -> Listener(that will get notified e.g. EmailNotiificationListener, PushNotificationListener etc...)
    -> Event( we can trigger different customers/observers based on the events they have subscribed to)
*/

public interface Listener {
    void notify(Event event);
}

public record EmailNotiificationListener(String email) imlements Listener {
    @Override
    void notify(Event event){
        sout("Sending email to " + email + " for event -> " + event);
    }
}

public record PushNotificationListener(String phone) imlements Listener {
    @Override
    void notify(Event event){
        sout("Sending push app notification to " + phone + " for event -> " + event);
    }
}

public class NotificationService{
    private Map<Event, List<Listener>> customers;

    public NotificationService(){
        this.customers = new HashMap<>();
    }

    public void addListener(Event event, Listener user) {
        this.customers.get(event).add(user);
    }

    public void removeListener(Event event, Listener listener){
        this.customers.get(event).remove(listener);
    }
    
    public void notify(Event event){
        this.customers.get(event)
        .forEach(user -> user.notify(event));
    }
}

public enum Event{
    NET_ITEM,
    SALE
}


/**
 * 🔐 Problem Statement: Real-Time Notification System for Card Transaction Monitoring
 * 
 * A digital bank offers users real-time updates on their card activity—such as transactions, declined payments, suspicious activity, 
 *   or balance updates. The system must notify various independent modules (like SMS alerts, email service, fraud detection, audit logs,
 *   and mobile push notifications) whenever a card transaction occurs.
 * 
 * (Functional Reqr) The business wants the system to:
 * Automatically notify multiple services when a card is used.
 * Allow adding/removing notification channels (like WhatsApp or Telegram) without touching core transaction logic.
 * Trigger specialized alerts for suspicious activity (e.g., multiple declines, high-value transactions, etc.).
 * Be extensible so that any third-party analytics or compliance system can also subscribe to card events.
 * 
 * 🎯 Implementational Reqr
 * You define a CardTransactionEventPublisher.
 * Modules like EmailNotifier, SMSNotifier, FraudDetector, AuditLogger, etc.
 * When a transaction is processed, CardTransactionEventPublisher notifies all registered listeners.
 * Observers handle the notification in their own way, decoupled from the transaction system.
 */



// ===== ENUM: Transaction Event Type =====
enum TransactionEventType {
    EMAIL_ALERT,
    SMS_ALERT,
    FRAUD_CHECK,
    AUDIT_LOG
}

// ===== DATA: Transaction Details =====
record TransactionDetails(String cardNumber, String email, String phone, double amount) {} // Using record (new way)

// ===== INTERFACE: Listener =====
interface TransactionListener {
    void onTransaction(TransactionEventType eventType, TransactionDetails details);
}

// ===== OBSERVERS =====

class EmailAlertService implements TransactionListener {
    @Override
    public void onTransaction(TransactionEventType eventType, TransactionDetails details) {
        System.out.println("EMAIL: Sending alert to " + details.email() + " for amount " + details.amount());
    }
}

class SMSAlertService implements TransactionListener {
    @Override
    public void onTransaction(TransactionEventType eventType, TransactionDetails details) {
        System.out.println("SMS: Sending alert to " + details.phone() + " for amount " + details.amount());
    }
}

class FraudDetectionService implements TransactionListener {
    @Override
    public void onTransaction(TransactionEventType eventType, TransactionDetails details) {
        if (details.amount() > 10000) {
            System.out.println("FRAUD: High-value transaction flagged for review: " + details.cardNumber());
        }
    }
}

class AuditLoggerService implements TransactionListener {
    @Override
    public void onTransaction(TransactionEventType eventType, TransactionDetails details) {
        System.out.println("AUDIT: Logging transaction for card " + details.cardNumber());
    }
}

// ===== PUBLISHER =====

class TransactionEventPublisher {
    private final Map<TransactionEventType, List<TransactionListener>> listenerMap = new HashMap<>();

    public void subscribe(TransactionEventType eventType, TransactionListener listener) {
        listenerMap
            .computeIfAbsent(eventType, k -> new ArrayList<>()) // to avoid NPE
            .add(listener);
    }

    public void unsubscribe(TransactionEventType eventType, TransactionListener listener) {
        List<TransactionListener> listeners = listenerMap.get(eventType);
        if (listeners != null) {
            listeners.remove(listener);
        }
    }

    public void notify(TransactionEventType eventType, TransactionDetails details) {
        listenerMap.getOrDefault(eventType, Collections.emptyList()) // to avoid NPE
        .forEach(listener -> listener.onTransaction(eventType, details));
    }
}

// ===== MAIN METHOD =====

public class CardTransactionObserverDemo {
    public static void main(String[] args) {
        TransactionEventPublisher publisher = new TransactionEventPublisher();

        // Subscribe services
        publisher.subscribe(TransactionEventType.EMAIL_ALERT, new EmailAlertService());
        publisher.subscribe(TransactionEventType.SMS_ALERT, new SMSAlertService());
        publisher.subscribe(TransactionEventType.FRAUD_CHECK, new FraudDetectionService());
        publisher.subscribe(TransactionEventType.AUDIT_LOG, new AuditLoggerService());

        // Sample transaction
        TransactionDetails txn = new TransactionDetails("1234-5678-9999-0000", "user@email.com", "9876543210", 15000);

        // Notify listeners
        publisher.notify(TransactionEventType.EMAIL_ALERT, txn);
        publisher.notify(TransactionEventType.SMS_ALERT, txn);
        publisher.notify(TransactionEventType.FRAUD_CHECK, txn);
        publisher.notify(TransactionEventType.AUDIT_LOG, txn);
    }
}
