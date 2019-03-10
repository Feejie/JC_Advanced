package Lesson_3.Collection;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<Integer>> hashMap;

    public PhoneBook(HashMap hashMap){
        this.hashMap = hashMap;
    }

    public void add(String name, int phoneNumber){
        hashMap.putIfAbsent(name, new ArrayList<>());
        hashMap.get(name).add(phoneNumber);
    }

    public ArrayList get(String name){
        return hashMap.get(name);
    }
}
