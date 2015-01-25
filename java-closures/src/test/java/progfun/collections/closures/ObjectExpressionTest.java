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
public class ObjectExpressionTest {
    private List<Person> persons = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        persons.add( new Person("John Doe", JobType.DOCTOR, MaritalStatus.MARRIED ));
        persons.add( new Person("Gregory House", JobType.DOCTOR, MaritalStatus.SINGLE));
        persons.add( new Person("Victor Frankenstien", JobType.DOCTOR, MaritalStatus.WIDOW));

        persons.add( new Person("Jane Doe", JobType.MANAGER, MaritalStatus.MARRIED ));
        persons.add( new Person("Roselyn Black", JobType.MANAGER, MaritalStatus.SINGLE ));
        persons.add( new Person("John Smit", JobType.MANAGER, MaritalStatus.SINGLE ));

        persons.add( new Person("Tommy lee-Jones", JobType.ENGINEER, MaritalStatus.SINGLE ));
        persons.add( new Person("Janette Doe", JobType.ENGINEER, MaritalStatus.WIDOW));
        persons.add( new Person("Jude Law", JobType.ENGINEER, MaritalStatus.SINGLE ));

        persons.add( new Person("Martin Riggs", JobType.SUPER_COP, MaritalStatus.SINGLE ));
        persons.add( new Person("Jackie Chan", JobType.SUPER_COP, MaritalStatus.MARRIED ));

        persons.add( new Person("Sting", JobType.MUSICIAN, MaritalStatus.SINGLE ));
        persons.add( new Person("Jamie Reidy", JobType.SALES_REPRESETNTIVE, MaritalStatus.MARRIED ));
    }

    private void print(List<Person> persons){
        System.out.print("************ [INPUT] *************\n");
        System.out.println(StringUtils.join(persons, "\n"));
        System.out.print("*********************************");
    }
     @Test public void shouldMatchElementsWithJobType() throws Exception {
        print(persons);
        Func<Person, Boolean> criteria = has(MaritalStatus.WIDOW);
        List<Person> widowdPerson = matchAll(persons, criteria);

        System.out.println("\n[Result] Single Managers : " + StringUtils.join( widowdPerson, "\n" ) );
    }

    @Test
    public void shouldReturnElements() throws Exception {
        print(persons);
        Func<Person, Boolean> criteria = has(MaritalStatus.SINGLE);
        List<Person> singlePersons = matchAll(persons, criteria);

        System.out.println("\n[Result] Bachelors : " + StringUtils.join( singlePersons, "\n" ) );

        criteria = has(JobType.ENGINEER);
        List<Person> singleEngineers = matchAll(singlePersons, criteria);
        System.out.println("\n[Result] Bachelor Engineers: " + StringUtils.join( singleEngineers, "\n" ) );
    }
}
