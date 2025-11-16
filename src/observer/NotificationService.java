package observer;

import user.IUser;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private final List<IUser> receivers;

    public NotificationService() {
        receivers = new ArrayList<>();
    }

    public void subscribe(IUser user) {
        receivers.add(user);
    }

    public void unsubscribe(IUser user) {
        receivers.remove(user);
    }

    public void notifySubscribers(String message) {
        for (IUser receiver : receivers) {
            receiver.getNotification(message);
        }
    }

    public List<IUser> getReceivers() {
        return receivers;
    }
}
