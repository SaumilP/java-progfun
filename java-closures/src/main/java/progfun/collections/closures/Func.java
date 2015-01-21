package progfun.collections.closures;

/**
 * Function interface to be able to create closures in pre Java 1.8 versions
 */
public interface Func<A, B> {

    /**
     * Method gets used by Collection specific Expressions for evaluation purpose.
     *
     * @param a    Reference Object to be evaluated
     * @return      Returns Expression Evaluation of Type B
     */
    public B evaluate(A a );
}
