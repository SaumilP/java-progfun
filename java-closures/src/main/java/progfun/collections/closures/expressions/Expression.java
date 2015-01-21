package progfun.collections.closures.expressions;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.CompareToBuilder;
import progfun.collections.closures.Func;

import java.util.Date;

/**
 * Basic Comparative Expression
 */
public class Expression {

    /** LessThan Expression */
    public static <T> Func<T, Boolean> lessThan(final T refValue) {
        Validate.notNull(refValue, "Supplied Value cannot be null");

        return new Func<T, Boolean>() {
            public Boolean evaluate(final T nValue) {
                if ( refValue.getClass() == Integer.class ){
                    return ( (Integer)nValue < (Integer)refValue );
                } else if ( refValue.getClass() == Double.class ){
                    return ( (Double)nValue < (Double)refValue );
                } else if ( refValue.getClass() == Float.class ){
                    return ( (Float)nValue < (Float)refValue );
                } else if ( refValue.getClass() == Long.class ){
                    return ( (Long)nValue < (Long)refValue );
                } else if ( refValue.getClass() == Short.class ){
                    return ( (Short)nValue < (Short)refValue );
                } else if ( refValue.getClass() == Byte.class ){
                    return ( (Byte)nValue < (Byte)refValue );
                } else if ( refValue.getClass() == Date.class ){
                    Date refValueDate = (Date)refValue;
                    Date nValueDate = (Date)nValue;
                    return nValueDate.before( refValueDate );
                }
                return false;
            }
        };
    }

    /** GreaterThan Expression */
    public static <T> Func<T, Boolean> greaterThan(final T refValue) {
        Validate.notNull(refValue, "Supplied Value cannot be null");

        return new Func<T, Boolean>() {
            public Boolean evaluate(final T nValue) {
                if ( refValue.getClass() == Integer.class ){
                    return ( (Integer)nValue > (Integer)refValue );
                } else if ( refValue.getClass() == Double.class ){
                    return ( (Double)nValue > (Double)refValue );
                } else if ( refValue.getClass() == Float.class ){
                    return ( (Float)nValue > (Float)refValue );
                } else if ( refValue.getClass() == Long.class ){
                    return ( (Long)nValue > (Long)refValue );
                } else if ( refValue.getClass() == Short.class ){
                    return ( (Short)nValue > (Short)refValue );
                } else if ( refValue.getClass() == Byte.class ){
                    return ( (Byte)nValue > (Byte)refValue );
                } else if ( refValue.getClass() == Date.class ){
                    Date refValueDate = (Date)refValue;
                    Date nValueDate = (Date)nValue;
                    return nValueDate.after( refValueDate );
                }
                return false;
            }
        };
    }

    /** IsEqual Expression */
    public static <T> Func<T, Boolean> isEqual(final T refValue) {
        Validate.notNull(refValue, "Supplied Value cannot be null");

        return new Func<T, Boolean>() {
            public Boolean evaluate(final T nValue) {
                CompareToBuilder builder = new CompareToBuilder();
                builder.append( nValue, refValue );
                return builder.toComparison() == 0;
            }
        };
    }
}
