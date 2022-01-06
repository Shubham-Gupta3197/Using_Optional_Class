package PhoneBook;
import com.phonebook.PhoneBookEntries;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.Optional;

//import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;


public class PhoneBookTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBookEntries phoneBook_Test = new PhoneBookEntries();

    @Test
    public void findPhoneNumberByName() {
        Optional<String> phoneNumber = phoneBook_Test.findPhoneNumberByName("Alex");

       //assert phoneNumber.get().equals("193687412");
       assertThat(phoneNumber.get()).isEqualTo("193687412");
    }
    @Test
    public void findPhoneNumberByName_NotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBook_Test.findPhoneNumberByName("Kayle");
        phoneNumber.get();
    }
    @Test
    public void findNameByPhoneNumber(){
        Optional<String> name=phoneBook_Test.findNameByPhoneNumber("1234567890");
        assertThat(name.get()).isEqualTo("Shubham");
    }
    @Test
    public void findNameByPhoneNumber_NotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBook_Test.findNameByPhoneNumber("1234567891");
        phoneNumber.get();
    }
}
