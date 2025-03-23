package Action;

import User.User;

import java.util.*;

public abstract class ListAction {

    protected Map<Integer, ActionInterface<User>> actions;

    public ListAction() {
        this.actions = new HashMap<>();
    }


    public void addAction(int key, ActionInterface<User> action) {
        actions.put(key, action);
    }

    public ActionInterface<User> getOrDefault(int choixInt, ActionInterface<User> defaultAction) {
        return actions.getOrDefault(choixInt, defaultAction);
    }

    public void afficherMenu() {
        actions.forEach((key, action) -> {
            System.out.println(key + " - " + action);
        });
        System.out.println("Choix : ");
    }

}
