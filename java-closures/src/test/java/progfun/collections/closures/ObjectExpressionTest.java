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
import static progfun.collections.closures.collection.ObjectExpression.contains;

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

    /** Internal Print method */
    private void print(List<Person> persons){
        System.out.print("************ [INPUT] *************\n");
        System.out.println(StringUtils.join(persons, "\n"));
        System.out.print("*********************************");
    }

    /** Test case for regular collection filter */
     @Test public void shouldMatchElementsWithJobType() throws Exception {
        Func<Person, Boolean> criteria = contains(JobType.DOCTOR);
        List<Person> doctors = matchAll(persons, criteria);

        System.out.println("\n[Result] Doctors : " + StringUtils.join( doctors, "\n" ) );
    }

    /** Test case for filtering custom object collection */
    @Test
    public void shouldReturnElements() throws Exception {
        Func<Person, Boolean> criteria = contains(MaritalStatus.SINGLE);
        List<Person> singlePersons = matchAll(persons, criteria);

        System.out.println("\n[Result] Bachelors : " + StringUtils.join( singlePersons, "\n" ) );

        criteria = contains(JobType.ENGINEER);
        List<Person> singleEngineers = matchAll(singlePersons, criteria);
        System.out.println("\n[Result] Bachelor Engineers: " + StringUtils.join( singleEngineers, "\n" ) );
    }

    /** Test case demonstrates of using method name instead of using matching property value criteria */
    @Test public void mustReturnElements() throws Exception{
        print(persons);

        Func<Person, Boolean> criteria = contains("getType", JobType.ENGINEER);
        List<Person> singlePersons = matchAll(persons, criteria);

        System.out.println("\n[Result] Bachelors : \n" + StringUtils.join( singlePersons, "\n" ) );
    }
}
