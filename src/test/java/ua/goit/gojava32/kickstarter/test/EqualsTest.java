package ua.goit.gojava32.kickstarter.test;

import org.junit.Test;
import ua.goit.gojava32.kickstarter.model.User;

import static org.junit.Assert.assertEquals;

public class EqualsTest {
    @Test
    public void userEquals(){
        User user1 = new User();
        User user2 = new User();
        user1.setId(5);
        user2.setId(5);
        assertEquals(user1.equals(user2), true);
    }

    @Test
    public void userHashCode() {
        User user1 = new User();
        User user2 = new User();
        user1.setId(5);
        user2.setId(5);
        assertEquals(user1.hashCode() == user2.hashCode(), true);
    }

    @Test
    public void userHashCodeNotEquals() {
        User user1 = new User();
        User user2 = new User();
        user1.setId(2);
        user2.setId(5);
        assertEquals(user1.equals(user2), false);
    }
}
