package progfun.collections.closures;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import progfun.collections.closures.complex.JobType;
import progfun.collections.closures.complex.MaritalStatus;
import progfun.collections.closures.complex.Person;

import java.util.ArrayList;
import java.util.List;

import static progfun.collections.closures.ElementMatcher.matchAll;
import static progfun.collections.closures.Expression.has;

/**
 * Complex object Unit Test
 */
public class ExpressionTwoTest {
    private List<Person> persons = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        persons.add( new Person("John Doe", JobType.DOCTOR, MaritalStatus.MARRIED ));
        persons.add( new Person("Martin Riggs", JobType.SUPER_COP, MaritalStatus.SINGLE ));
        persons.add( new Person("Jane Doe", JobType.MANAGER, MaritalStatus.MARRIED ));
        persons.add( new Person("Janette Doe", JobType.ENGINEER, MaritalStatus.WIDOWD ));
        persons.add( new Person("Jackie Chan", JobType.SUPER_COP, MaritalStatus.MARRIED ));
        persons.add( new Person("Tommy lee-Jones", JobType.ENGINEER, MaritalStatus.SINGLE ));
        persons.add( new Person("Sting", JobType.MUSICIAN, MaritalStatus.SINGLE ));
        persons.add( new Person("Jamie Reidy", JobType.SALES_REPRESETNTIVE, MaritalStatus.MARRIED ));

        System.out.println( StringUtils.join(persons, "\n") );
    }

    @Test
    public void shouldReturnElements() throws Exception {
        Func<Person, Boolean> single = has(MaritalStatus.SINGLE);
        List<Person> singlePersons = matchAll(persons, single);
    }
}
