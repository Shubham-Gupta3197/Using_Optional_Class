package PhoneBook;
import com.phonebook.PhoneBookCrawler;
import com.phonebook.PhoneBookEntries;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;


public class PhoneBookCrawlerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(new PhoneBookEntries());

    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFound()  {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("No phone number found");

        phoneBookCrawler.findPhoneNumberByNameAndPunishIfNothingFound("John");
    }

    @Test
    public void findPhoneNumberByName_AndFindSomething(){
        String phoneNumber = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Alex");

        assertThat(phoneNumber).isEqualTo("193687412");
    }

    @Test
    public void findPhoneNumberByNameAndReturnEntirePhoneBookIfNothingFound() {
        String phoneBook = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("chandler");

        assertThat(phoneBook).isEqualTo("PhoneBook{phoneBookEntries={alex=193687412, Shaun=3269874521}}");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_foundByName() {
        String phoneNumber = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Shaun", "1234567890");

        assertThat(phoneNumber).isEqualTo("3269874521");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_foundByPhoneNumber() {
        String name = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("John", "9121546325");

        assertThat(name).isEqualTo("Shaun");
    }


}

