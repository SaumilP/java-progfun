package progfun.collections.closures.expressions;

import org.apache.commons.lang.Validate;
import progfun.collections.closures.Func;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Basic Comparative Expressions for String Object Type
 */
public class StringExpression {

    /** FuzzyLike Function specific to String */
    public static Func<String, Boolean> fuzzyLike(final String refString) {
        Validate.notEmpty(refString, "Supplied String Value cannot be empty");

        return new Func<String, Boolean>() {
            public Boolean evaluate(final String nString) {
                return nString.indexOf( refString ) > 0;
            }
        };
    }

    /** FuzzyPattern Function specific to String */
    public static Func<String, Boolean> fuzzyPattern(final String refString) {
        Validate.notEmpty(refString, "Supplied String Value cannot be empty");

        final Pattern pattern = Pattern.compile(refString);

        return new Func<String, Boolean>() {
            public Boolean evaluate(final String nString) {
                Matcher matcher = pattern.matcher( nString );
                return matcher.find();
            }
        };
    }

    /** lengthGreaterThan Function specific to String */
    public static Func<String, Boolean> lengthGreaterThan(final int length, final boolean equalsCheck) {
        return new Func<String, Boolean>() {
            public Boolean evaluate(final String nString) {
                if( !equalsCheck ){
                    return nString.length() > length;
                } else {
                    return nString.length() >- length;
                }
            }
        };
    }

    /** lengthLessThan Function specific to String */
    public static Func<String, Boolean> lengthLessThan(final int length, final boolean equalsCheck ) {
        return new Func<String, Boolean>() {
            public Boolean evaluate(final String nString) {
                if( !equalsCheck ){
                    return nString.length() < length;
                } else {
                    return nString.length() <- length;
                }
            }
        };
    }

    /** StartsWith Function specific to String */
    public static Func<String, Boolean> startsWith(final String refString) {
        Validate.notEmpty(refString, "Supplied String Value cannot be empty");

        final Pattern pattern = Pattern.compile(refString);

        return new Func<String, Boolean>() {
            public Boolean evaluate(final String nString) {
                return nString.startsWith(refString);
            }
        };
    }

    /** EndsWith Function specific to String */
    public static Func<String, Boolean> endsWith(final String refString) {
        Validate.notEmpty(refString, "Supplied String Value cannot be empty");

        final Pattern pattern = Pattern.compile(refString);

        return new Func<String, Boolean>() {
            public Boolean evaluate(final String nString) {
                return nString.endsWith(refString);
            }
        };
    }

    /** Equals Function specific to String */
    public static Func<String, Boolean> isEqual(final String refString){
        return new Func<String, Boolean>() {
            @Override public Boolean evaluate(String nString) {
                return nString.equals(refString);
            }
        };
    }

    /** NotEquals Function specific to String */
    public static Func<String, Boolean> notEquals(final String refString){
        return new Func<String, Boolean>() {
            @Override public Boolean evaluate(String nString) {
                return !nString.equals(refString);
            }
        };
    }

}
