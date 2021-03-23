package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {


    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook= new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> list=new ArrayList<>();
        list.add(phoneNumber);
       phonebook.put(name,list);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> list =new ArrayList<String>(Arrays.asList(phoneNumbers));
        phonebook.put(name, list);

    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumbers){

        if (phonebook.containsKey(name)) {
//           for(String phoneNumber: phonebook.get(name)){
//               if(phoneNumber.equals(phoneNumbers)){
//                   return true;
//               }
//
//           }
//             return false;

        return phonebook.get(name).contains(phoneNumbers);
        } else return false;
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        List<String> names=getAllContactNames();
        for(String name:names){
            if (lookup(name).contains(phoneNumber)){
                return name;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> lists=new ArrayList<>(phonebook.keySet());
        return lists;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
