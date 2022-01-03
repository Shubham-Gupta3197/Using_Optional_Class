package com.phonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The type Phone book entries.
 */
public class PhoneBookEntries {
    /**
     * The Phone map.
     */
    static HashMap<String, String> phoneMap = new HashMap<>();
         static {
                phoneMap.put("John","01-112354");
                phoneMap.put("Alex","02-845545");
            }

    /**
     * The Phone map entries.
     */
    Map<String, String> phoneMapEntries = phoneMap;

    /**
     * Find phone number by name optional.
     *
     * @param name the name
     * @return the optional
     */
    public Optional<String> findPhoneNumberByName(String name) {
        if (phoneMapEntries.containsKey(name)) {
            return Optional.of(phoneMapEntries.get(name));
        }
        return Optional.empty();
    }

    /**
     * Find name by phone number optional.
     *
     * @param phoneNumber the phone number
     * @return the optional
     */
    public Optional<String> findNameByPhoneNumber(String phoneNumber) {

        for (Map.Entry<String, String> entry : phoneMapEntries.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                return Optional.of(entry.getKey());
            }
        }
               return Optional.empty();
        }
    @Override
    public String toString() {
         return "PhoneBook{" +
                "phoneBookEntries=" + phoneMapEntries +
                '}';
    }
}


