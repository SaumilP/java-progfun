package progfun.collections.closures;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static progfun.collections.closures.ElementMatcher.matchAll;
import static progfun.collections.closures.ElementMatcher.matchFirst;

/**
 * Basic Unit Test for {@link ElementMatcher}
 */
public class NumericExpressionTest {

    private List<Integer> list = new ArrayList<>();
    final int refValue = 8;

    @Before
    public void setUp() throws Exception {
        for(int i=0;i<15;i++){
            list.add(i);
        }
    }

    private void printList(){
        System.out.println("List Values : " + StringUtils.join(list, ","));
        System.out.println("RefValue : " + refValue);
    }

    @Test
    public void testGreaterThanExpression(){
        System.out.println("\n[INFO]GreaterThan Test Case");
        printList();

        Func<Integer, Boolean> greaterThanTen = Expression.greaterThan(refValue);
        int retrievedValue = matchFirst(list, greaterThanTen);
        System.out.println("Matched First Value : " + retrievedValue);

        //Collect all the values
        List<Integer> retrievedValues = matchAll(list, greaterThanTen);
        System.out.println("Matched All Values : " + StringUtils.join(retrievedValues, ","));
    }

    @Test
    public void testLessThanExpression(){
        System.out.println("\n[INFO]LessThan Test Case");
        printList();

        Func<Integer, Boolean> lessThanTen = Expression.lessThan(refValue);
        int retrievedValue = matchFirst(list, lessThanTen);
        System.out.println("Matched First Value : " + retrievedValue);

        //Collect all the values
        List<Integer> retrievedValues = matchAll(list, lessThanTen);
        System.out.println("Matched All Values : " + StringUtils.join(retrievedValues, ","));
    }

    @Test
    public void testIsEqualsExpression(){
        System.out.println("\n[INFO]IsEquals Test Case");
        printList();

        Func<Integer, Boolean> equals = Expression.isEqual(refValue);
        int retrievedValue = matchFirst(list, equals);
        System.out.println("Matched First Value : " + retrievedValue);

        //Collect all the values
        List<Integer> retrievedValues = matchAll(list, equals);
        System.out.println("Matched All Values : " + StringUtils.join(retrievedValues, ","));
    }

    @Test
    public void testNotEqualsExpression(){
        System.out.println("\n[INFO]NotEquals Test Case");
        printList();

        Func<Integer, Boolean> notEquals = Expression.notEqual(refValue);
        int retrievedValue = matchFirst(list, notEquals);
        System.out.println("Matched First Value : " + retrievedValue);

        //Collect all the values
        List<Integer> retrievedValues = matchAll(list, notEquals);
        System.out.println("Matched All Values : " + StringUtils.join(retrievedValues, ","));
    }

    @Test
    public void testGreaterOrEqualsThanExpression(){
        System.out.println("\n[INFO]GreaterOrEquals Test Case");
        printList();

        Func<Integer, Boolean> greaterThanTen = Expression.greaterOrEquals(refValue);
        int retrievedValue = matchFirst(list, greaterThanTen);
        System.out.println("Matched First Value : " + retrievedValue);

        //Collect all the values
        List<Integer> retrievedValues = matchAll(list, greaterThanTen);
        System.out.println("Matched All Values : " + StringUtils.join(retrievedValues, ","));
    }

    @Test
    public void testLessThanOrEqualsExpression(){
        System.out.println("\n[INFO]LessOrEquals Test Case");
        printList();

        Func<Integer, Boolean> lessThanTen = Expression.lessOrEquals(refValue);
        int retrievedValue = matchFirst(list, lessThanTen);
        System.out.println("Matched First Value : " + retrievedValue);

        //Collect all the values
        List<Integer> retrievedValues = matchAll(list, lessThanTen);
        System.out.println("Matched All Values : " + StringUtils.join(retrievedValues, ","));
    }
}
