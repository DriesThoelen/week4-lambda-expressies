package be.pxl.ja.week4.opgave;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Opgave {

    public static void main(String[] args) {
        User ben = new User("Ben", "admin");
        User charlie = new User("Charlie", "member");
        User bonnie = new User("Bonnie", "member");
        Random random = new Random();
        DisplayOnly displayNameAndRole = user -> System.out.println(user.getName() + " [" + user.getRole() + "]");
        displayNameAndRole.print(ben);
        displayNameAndRole.print(charlie);
        displayNameAndRole.print(bonnie);

        Predicate<User> isAdmin = u -> "admin".equals(u.getRole());
        Predicate<User> isMember = u -> "member".equals(u.getRole());
        Predicate<User> startsWithB = u -> u.getName().startsWith("B");
        Predicate<User> isMemberAndStartsWithB = isMember.and(startsWithB);

        Function<User, String> createWachtwoord = u -> u.getName().substring(0,2).toUpperCase() + (random.nextInt(9000) + 1000);

        Consumer<User> printNameBackwards = u -> System.out.println(new StringBuilder(u.getName()).reverse().toString());

        ArrayList<User> users = new ArrayList<>();
        users.add(ben);
        users.add(charlie);
        users.add(new User("Sofie", "member"));
        users.add(bonnie);

//        toonUser(users, isAdmin, displayNameAndRole);
//        toonUser(users, isMember, displayNameAndRole);
//        toonUser(users, isAdmin, u -> System.out.println(u.getName().substring(0,1)));

        //System.out.println("Ben: " + isAdmin.test(ben));
        //System.out.println("Charlie: " + isAdmin.test(charlie));
        System.out.println();
        System.out.println("Ben: " + isMemberAndStartsWithB.test(ben));
        System.out.println("Bonnie: " + isMemberAndStartsWithB.test(bonnie));
        System.out.println("Wachtwoord Ben: " + createWachtwoord.apply(ben));
        System.out.println("Wachtwoord Charlie: " + createWachtwoord.apply(charlie));
        System.out.println("Wachtwoord Bonnie: " + createWachtwoord.apply(bonnie));
        printNameBackwards.accept(ben);
        printNameBackwards.accept(charlie);
        printNameBackwards.accept(bonnie);
    }

    private static void toonUser(ArrayList<User> users, Predicate<User> filter, DisplayOnly displayOnly) {
        System.out.println();
        System.out.println("********TOON " + "Users" + "********");
        for (User user:users) {
            if (filter.test(user)) {
                displayOnly.print(user);
            }
        }
        System.out.println("**************************");
        System.out.println();
    }

    private static void genereerWachtwoordVoorAlleUsers(ArrayList<User> users, Function<User, String> function) {
        for (User user: users) {
            System.out.println(function.apply(user));
        }
    }

}
