package cwl.unittest.assertj;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * http://joel-costigliola.github.io/assertj/
 */
public class AssertJTestExample {

    protected static <T extends Date> T getDate() {
        return (T) new Date();
    }

    @Test
    public void doesNotCompile() {
        // Error: reference to assertThat is ambiguous
//        Assertions.assertThat(getDate()).isEqualTo(getDate());


        Assertions.assertThat((Date) getDate()).isEqualTo(getDate());
    }

    @Test
    public void doAndNotDo() {
        String actual = "me";
        String expected = "me";
// BAD USAGE: DON'T DO THIS ! It does not assert anything
        Assertions.assertThat(actual.equals(expected));

// DO THIS:
        Assertions.assertThat(actual).isEqualTo(expected);

// OR THIS (less classy but ok):
        Assertions.assertThat(actual.equals(expected)).isTrue();
    }

    class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return this.age;
        }
    }

    Person frodo = new Person("frodo", 23);
    Person sauron = new Person("Sauron", 24);
    Person sam = new Person("sam", 45);

    Set<Person> fellowshipOfTheRing = new HashSet<Person>(){{
        add(frodo); add(new Person("okay", 43)); add(sam);
    }};

    @Test
    public void doAndNotDo2() {
// basic assertions
        Assertions.assertThat(frodo.getName()).isEqualTo("Frodo");
        Assertions.assertThat(frodo).isNotEqualTo(sauron);

// chaining string specific assertions
        Assertions.assertThat(frodo.getName()).startsWith("Fro")
                .endsWith("do")
                .isEqualToIgnoringCase("frodo");

// collection specific assertions (there are plenty more)
// in the examples below fellowshipOfTheRing is a List<TolkienCharacter>
        Assertions.assertThat(fellowshipOfTheRing).hasSize(3)
                .contains(frodo, sam)
                .doesNotContain(sauron);

// as() is used to describe the test and will be shown before the error message
        Assertions.assertThat(frodo.getAge()).as("check %s's age", frodo.getName()).isEqualTo(33);

// Java 8 exception assertion, standard style ...
        Assertions.assertThatThrownBy(() -> { throw new Exception("boom!"); }).hasMessage("boom!");
// ... or BDD style
        Throwable thrown = ThrowableAssert.catchThrowable(() -> { throw new Exception("boom!"); });
        Assertions.assertThat(thrown).hasMessageContaining("boom");

/*
// using the 'extracting' feature to check fellowshipOfTheRing character's names (Java 7)
        assertThat(fellowshipOfTheRing).extracting("name")
                .contains("Boromir", "Gandalf", "Frodo", "Legolas");
// same thing using a Java 8 method reference
        assertThat(fellowshipOfTheRing).extracting(TolkienCharacter::getName)
                .doesNotContain("Sauron", "Elrond");

// extracting multiple values at once grouped in tuples (Java 7)
        assertThat(fellowshipOfTheRing).extracting("name", "age", "race.name")
                .contains(tuple("Boromir", 37, "Man"),
                        tuple("Sam", 38, "Hobbit"),
                        tuple("Legolas", 1000, "Elf"));

// filtering a collection before asserting in Java 7 ...
        assertThat(fellowshipOfTheRing).filteredOn("race", HOBBIT)
                .containsOnly(sam, frodo, pippin, merry);
// ... or in Java 8
        assertThat(fellowshipOfTheRing).filteredOn(character -> character.getName().contains("o"))
                .containsOnly(aragorn, frodo, legolas, boromir);

// combining filtering and extraction (yes we can)
        assertThat(fellowshipOfTheRing).filteredOn(character -> character.getName().contains("o"))
                .containsOnly(aragorn, frodo, legolas, boromir)
                .extracting(character -> character.getRace().getName())
                .contains("Hobbit", "Elf", "Man");
*/
    }

}
