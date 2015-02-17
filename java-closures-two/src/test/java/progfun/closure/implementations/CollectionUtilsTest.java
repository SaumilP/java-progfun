package progfun.closure.implementations;

import junit.framework.TestCase;
import org.junit.Test;
import progfun.closure.interfaces.OneArg;

import java.util.ArrayList;
import java.util.List;

import static progfun.closure.implementations.CollectionUtils.forEach;

/**
 * Basic Unit test for {@link CollectionUtils}
 */
public class CollectionUtilsTest extends TestCase {

    private List<String> names = new ArrayList<>();

    @Override public void setUp() throws Exception {
        names.add("John");
        names.add("Jane");
        names.add("Ferdi");
        names.add("Jessy");
        names.add("Jasmin");
    }

    @Test
    public void testForEach() throws Exception {
        OneArg<String> startsWithJ = new OneArg<String>() {
            @Override public void invoke(String arg) {
                System.out.println("Checking - " + arg );
                arg.startsWith("J");
            }
        };

        forEach(names, startsWithJ );
    }
}
