package progfun.collections.closures.expressions;

import org.apache.commons.lang.Validate;
import progfun.collections.closures.Func;

import java.util.Date;

/**
 * Basic Comparative Expressions for Date Object
 */
public class DateExpression {
    /** LessThan NumericExpression */
    public static <T> Func<T, Boolean> lessThan(final T refValue) {
        return new Func<T, Boolean>() {
            public Boolean evaluate(final T nValue) {
                if ( refValue.getClass() == Date.class ){
                    Date refValueDate = (Date)refValue;
                    Date nValueDate = (Date)nValue;
                    return refValueDate.before( nValueDate );
                }
                return false;
            }
        };
    }

    /** GreaterThan NumericExpression */
    public static <T> Func<T, Boolean> greaterThan(final T refValue) {
        return new Func<T, Boolean>() {
            public Boolean evaluate(final T nValue) {
                if ( refValue.getClass() == Date.class ){
                    Date refValueDate = (Date)refValue;
                    Date nValueDate = (Date)nValue;
                    return refValueDate.after( nValueDate );
                }
                return false;
            }
        };
    }

    /** LessOrEquals NumericExpression */
    public static <T> Func<T, Boolean> lessOrEquals(final T refValue) {
        return new Func<T, Boolean>() {
            public Boolean evaluate(final T nValue) {
                if ( refValue.getClass() == Date.class ){
                    Date refValueDate = (Date)refValue;
                    Date nValueDate = (Date)nValue;
                    return refValueDate.before( nValueDate )||refValueDate.equals( nValueDate );
                }
                return false;
            }
        };
    }

    /** GreaterOrEquals NumericExpression */
    public static <T> Func<T, Boolean> greaterOrEquals(final T refValue) {
        return new Func<T, Boolean>() {
            public Boolean evaluate(final T nValue) {
                if ( refValue.getClass() == Date.class ){
                    Date refValueDate = (Date)refValue;
                    Date nValueDate = (Date)nValue;
                    return refValueDate.after( nValueDate )||refValueDate.equals( nValueDate );
                }
                return false;
            }
        };
    }

    /** IsEqual NumericExpression */
    public static <T> Func<T, Boolean> isEqual(final T refValue) {
        Validate.notNull(refValue, "Supplied Value cannot be null");

        return new Func<T, Boolean>() {
            public Boolean evaluate(final T nValue) {
                Date refValueDate = (Date)refValue;
                Date nValueDate = (Date)nValue;
                return refValueDate.equals( nValueDate );
            }
        };
    }

    /** NotEqual NumericExpression */
    public static <T> Func<T, Boolean> notEqual(final T refValue) {
        return new Func<T, Boolean>() {
            public Boolean evaluate(final T nValue) {
                Date refValueDate = (Date)refValue;
                Date nValueDate = (Date)nValue;
                return !refValueDate.equals( nValueDate );
            }
        };
    }

}
