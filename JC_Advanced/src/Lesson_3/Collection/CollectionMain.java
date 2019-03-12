package Lesson_3.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CollectionMain {
    public static void main(String[] args) {

        /**
         * Task 1
         */
        ArrayList<String> wordList = new ArrayList<>();

        wordList.add("Dog");
        wordList.add("Bear");
        wordList.add("Fish");
        wordList.add("Fox");
        wordList.add("Dog");
        wordList.add("Chicken");
        wordList.add("Cat");
        wordList.add("Eagle");
        wordList.add("Horse");
        wordList.add("Cat");
        wordList.add("Dog");
        wordList.add("Fish");

        arrayHandler(wordList);

        System.out.println();

        /**
         * Task 2
         */
        PhoneBook phoneBook = new PhoneBook(new HashMap());
        phoneBook.add("Father", 111111);
        phoneBook.add("Brother", 333333);
        phoneBook.add("Mother", 777777);
        phoneBook.add("Father", 111222);
        phoneBook.add("Mother", 999999);

        System.out.println(phoneBook.get("Mother"));
        System.out.println(phoneBook.get("Father"));
        System.out.println(phoneBook.get("Brother"));

    }

    public static void arrayHandler(ArrayList arrayToHandle){
        ArrayList<Object> arr = new ArrayList<>();

        for(Object w: arrayToHandle){
            if(!arr.contains(w)) arr.add(w);
        }

        System.out.println(arr);
    }

}
