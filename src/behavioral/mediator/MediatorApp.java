package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 08.08.17.
 */
public class MediatorApp {
    public static void main(String[] args) {
        TextChat textChat = new TextChat();

        User admin = new Admin(textChat, "God of Chat");
        User u1 = new SimpleUser(textChat, "Guest1");
        User u2 = new SimpleUser(textChat, "Guest2");

        textChat.setAdmin(admin);
        textChat.addUser(u1);
        textChat.addUser(u2);

        u1.sendMessage("Hello, I'm user");
        u2.sendMessage("Hello, I'm user2");
        admin.sendMessage("I'm admin");
    }
}

abstract class User {
    Chat chat;
    String name;
    boolean isEnable = true;

    public User(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    abstract void getMessage(String message);
}

class Admin extends User {
    Chat chat;

    public Admin(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Admin.getMessage " + getName() + "   " + message);
    }
}

class SimpleUser extends User {
    Chat chat;

    public SimpleUser(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("SimpleUser.getMessage " + getName() + "    " + message);
    }
}

interface Chat {
    void sendMessage(String message, User user);
}

class TextChat implements Chat {
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        if (admin != null && admin instanceof Admin) {
            this.admin = admin;
        } else throw new IllegalArgumentException("Not admin");
    }

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            u.getMessage(message);
        }
        admin.getMessage(message);
    }
}