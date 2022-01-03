
package com.phonebook;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * The type Phone book crawler.
 */
public class PhoneBookCrawler {

    /**
     * The Phone book.
     */
    PhoneBookEntries phoneBook;


    /**
     * Instantiates a new Phone book crawler.
     *
     * @param phoneBook the phone book
     */
    public PhoneBookCrawler(PhoneBookEntries phoneBook) {

        this.phoneBook = phoneBook;
    }

    /**
     * Find phone number by name and punish if nothing found string.
     *
     * @param name the name
     * @return the string
     */
    public String findPhoneNumberByNameAndPunishIfNothingFound(String name)  {
        return phoneBook.findPhoneNumberByName(name).orElseThrow(()->new IllegalArgumentException("No phone number found"));
    }

    /**
     * Find phone number by name and print phone book if nothing found string.
     *
     * @param name the name
     * @return the string
     */
    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){

        return phoneBook.findPhoneNumberByName(name).orElseGet(()->phoneBook.toString());
    }

    /**
     * Find phone number by name or name by phone number string.
     *
     * @param name        the name
     * @param phoneNumber the phone number
     * @return the string
     */
    public String findPhoneNumberByNameOrNameByPhoneNumber(String name, String phoneNumber){

        return Stream.of(phoneBook.findPhoneNumberByName(name), phoneBook.findNameByPhoneNumber(phoneNumber), phoneBook.findPhoneNumberByName(name))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst().get();
    }

    /**
     * Get phone book phone book entries.
     *
     * @return the phone book entries
     */
    public PhoneBookEntries getPhoneBook(){
        return phoneBook;
    }


}
