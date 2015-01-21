package progfun.collections.closures;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import static progfun.collections.closures.ElementMatcher.matchAll;

/**
 * String Expression related Unit Test
 */
public class ExpressionTest extends TestCase {

    private List<String> stringList = new ArrayList<>();

    public void setUp() throws Exception {
        stringList.add("John Wick");
        stringList.add("Johan Smith");
        stringList.add("Joan Stark");
        stringList.add("Buford Tabarez");
        stringList.add("Lovella Mast");
        stringList.add("Chin Payeur");
        stringList.add("Priscilla Neeld");
        stringList.add("Amal Cudjoe");
        stringList.add("Ranee Martini");
        stringList.add("Enoch Sheroan");
        stringList.add("Katharine Tome");
        stringList.add("Teisha Hofstetter");
        stringList.add("Enriqueta Rutkowski");
    }

    public void testFuzzyLike() throws Exception {
        System.out.println("\n[INFO]FuzzyLike Test Case");
        String likeString = "hn";

        Func<String, Boolean> like = Expression.fuzzyLike(likeString);
        List<String> retrievedValue = matchAll(stringList, like, likeString);
        System.out.println("Matched First Value : " + retrievedValue);
    }

    public void testFuzzyPattern() throws Exception {
        System.out.println("\n[INFO]FuzzyPattern Test Case");
        String likeString = "$";

        Func<String, Boolean> like = Expression.fuzzyPattern(likeString);
        List<String> retrievedValue = matchAll(stringList, like, likeString);
        System.out.println("Matched First Value : " + retrievedValue);
    }

    public void testLengthGreaterThan() throws Exception {
        System.out.println("\n[INFO]LengthGreaterThan Test Case");
        String likeString = "sha";

        Func<String, Boolean> like = Expression.lengthGreaterThan(3, false);
        List<String> retrievedValue = matchAll(stringList, like, likeString);
        System.out.println("Matched First Value : " + retrievedValue);
    }

    public void testLengthLessThan() throws Exception {
        System.out.println("\n[INFO]LengthLessThan Test Case");
        String likeString = "sha";

        Func<String, Boolean> like = Expression.lengthLessThan(10, false);
        List<String> retrievedValue = matchAll(stringList, like, likeString);
        System.out.println("Matched First Value : " + retrievedValue);
    }

    public void testStartsWith() throws Exception {
        System.out.println("\n[INFO]StartsWith Test Case");
        String likeString = "Jo";

        Func<String, Boolean> like = Expression.startsWith(likeString);
        List<String> retrievedValue = matchAll(stringList, like, likeString);
        System.out.println("Matched First Value : " + retrievedValue);
    }

    public void testEndsWith() throws Exception {
        System.out.println("\n[INFO]EndsWith Test Case");
        String likeString = "i";

        Func<String, Boolean> like = Expression.endsWith(likeString);
        List<String> retrievedValue = matchAll(stringList, like, likeString);
        System.out.println("Matched First Value : " + retrievedValue);
    }
}
