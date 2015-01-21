package progfun.collections.closures.expressions;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.CompareToBuilder;
import progfun.collections.closures.Func;

import java.util.Date;

/**
 * Basic Comparative Expressions for Number Primitive Types
 */
public class NumericExpression {

    /** LessThan NumericExpression */
    public static <T> Func<T, Boolean> lessThan(final T refValue) {
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
                } else if( refValue.getClass() == String.class ){
                    throw new IllegalArgumentException("Unsupported operation for String Object.");
                }
                return false;
            }
        };
    }

    /** GreaterThan NumericExpression */
    public static <T> Func<T, Boolean> greaterThan(final T refValue) {
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
                    throw new IllegalArgumentException("Unsupported operation for String Object.");
                } else if ( refValue.getClass() == String.class ){
                    throw new IllegalArgumentException("Unsupported operation for String Object.");
                }
                return false;
            }
        };
    }

    /** LessOrEquals NumericExpression */
    public static <T> Func<T, Boolean> lessOrEquals(final T refValue) {
        return new Func<T, Boolean>() {
            public Boolean evaluate(final T nValue) {
                if ( refValue.getClass() == Integer.class ){
                    return ( (Integer)nValue <= (Integer)refValue );
                } else if ( refValue.getClass() == Double.class ){
                    return ( (Double)nValue <= (Double)refValue );
                } else if ( refValue.getClass() == Float.class ){
                    return ( (Float)nValue <= (Float)refValue );
                } else if ( refValue.getClass() == Long.class ){
                    return ( (Long)nValue <= (Long)refValue );
                } else if ( refValue.getClass() == Short.class ){
                    return ( (Short)nValue <= (Short)refValue );
                } else if ( refValue.getClass() == Byte.class ){
                    return ( (Byte)nValue <= (Byte)refValue );
                } else if ( refValue.getClass() == Date.class ){
                    throw new IllegalArgumentException("Unsupported operation for String Object.");
                } else if( refValue.getClass() == String.class ){
                    throw new IllegalArgumentException("Unsupported operation for String Object.");
                }
                return false;
            }
        };
    }

    /** GreaterOrEquals NumericExpression */
    public static <T> Func<T, Boolean> greaterOrEquals(final T refValue) {
        return new Func<T, Boolean>() {
            public Boolean evaluate(final T nValue) {
                if ( refValue.getClass() == Integer.class ){
                    return ( (Integer)nValue >= (Integer)refValue );
                } else if ( refValue.getClass() == Double.class ){
                    return ( (Double)nValue >= (Double)refValue );
                } else if ( refValue.getClass() == Float.class ){
                    return ( (Float)nValue >= (Float)refValue );
                } else if ( refValue.getClass() == Long.class ){
                    return ( (Long)nValue >= (Long)refValue );
                } else if ( refValue.getClass() == Short.class ){
                    return ( (Short)nValue >= (Short)refValue );
                } else if ( refValue.getClass() == Byte.class ){
                    return ( (Byte)nValue >= (Byte)refValue );
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
                CompareToBuilder builder = new CompareToBuilder();
                builder.append( nValue, refValue );
                return builder.toComparison() == 0;
            }
        };
    }

    /** NotEqual NumericExpression */
    public static <T> Func<T, Boolean> notEqual(final T refValue) {
        return new Func<T, Boolean>() {
            public Boolean evaluate(final T nValue) {
                CompareToBuilder builder = new CompareToBuilder();
                builder.append( nValue, refValue );
                return builder.toComparison() != 0;
            }
        };
    }
}
