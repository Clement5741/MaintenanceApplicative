package Action;

import User.User;

import java.util.*;

public class ListAction {

    private Map<Integer, ActionInterface<User>> actions;

    public ListAction() {
        this.actions = new HashMap<>();
    }


    public void addAction(int key, ActionInterface<User> action) {
        actions.put(key, action);
    }

    public ActionInterface<User> getOrDefault(int choixInt, ActionInterface<User> defaultAction) {
        return actions.getOrDefault(choixInt, defaultAction);
    }



}
