package progfun.collections.closures;

import org.apache.commons.lang.Validate;
import progfun.collections.closures.expressions.DateExpression;
import progfun.collections.closures.expressions.NumericExpression;
import progfun.collections.closures.expressions.StringExpression;

import java.util.Date;

/**
 * Final Expression Class to consolidate functions for all Primitive Data Types
 */
@SuppressWarnings("unchecked")
public final class Expression {

    public static <T> Func<T, Boolean> notEqual(final T refValue){
        if(Number.class.isInstance( refValue )){
            return NumericExpression.notEqual(refValue);
        } else if ( String.class == refValue.getClass() ){
            return (Func<T, Boolean>) StringExpression.notEquals((String) refValue);
        } else if ( Date.class == refValue.getClass() ){
            return DateExpression.notEqual(refValue);
        } else {
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        }
    }

    public static <T> Func<T, Boolean> isEqual(final T refValue){
        Validate.notNull(refValue, "Supplied Value cannot be null");
        if(Number.class.isInstance( refValue )){
            return NumericExpression.isEqual(refValue);
        } else if ( String.class == refValue.getClass() ){
            return (Func<T, Boolean>) StringExpression.isEqual((String)refValue);
        } else if ( Date.class == refValue.getClass() ){
            return DateExpression.isEqual(refValue);
        } else {
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        }
    }

    public static <T> Func<T, Boolean> greaterOrEquals(final T refValue){
        Validate.notNull(refValue, "Supplied Value cannot be null");
        if(Number.class.isInstance( refValue )){
            return NumericExpression.greaterOrEquals(refValue);
        } else if ( String.class == refValue.getClass() ){
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        } else if ( Date.class == refValue.getClass() ){
            return DateExpression.greaterOrEquals(refValue);
        } else {
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        }
    }

    public static <T> Func<T, Boolean> lessOrEquals(final T refValue){
        Validate.notNull(refValue, "Supplied Value cannot be null");
        if(Number.class.isInstance( refValue )){
            return NumericExpression.lessOrEquals(refValue);
        } else if ( String.class == refValue.getClass() ){
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        } else if ( Date.class == refValue.getClass() ){
            return DateExpression.lessOrEquals(refValue);
        } else {
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        }
    }

    public static <T> Func<T, Boolean> greaterThan(final T refValue){
        Validate.notNull(refValue, "Supplied Value cannot be null");
        if(Number.class.isInstance( refValue )){
            return NumericExpression.greaterThan(refValue);
        } else if ( String.class == refValue.getClass() ){
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        } else if ( Date.class == refValue.getClass() ){
            return DateExpression.greaterThan(refValue);
        } else {
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        }
    }

    public static <T> Func<T, Boolean> lessThan(final T refValue){
        Validate.notNull(refValue, "Supplied Value cannot be null");
        if(Number.class.isInstance( refValue )){
            return NumericExpression.lessThan(refValue);
        } else if ( String.class == refValue.getClass() ){
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        } else if ( Date.class == refValue.getClass() ){
            return DateExpression.lessThan(refValue);
        } else {
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        }
    }

    public static Func<String, Boolean> fuzzyLike(final String refString){
        Validate.notNull(refString, "Supplied Value cannot be null");
        if ( String.class != refString.getClass() ){
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        } else {
            return StringExpression.fuzzyLike(refString);
        }
    }

    public static Func<String, Boolean> fuzzyPattern(final String refString){
        Validate.notNull(refString, "Supplied Value cannot be null");
        if ( String.class != refString.getClass() ){
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        } else {
            return StringExpression.fuzzyPattern(refString);
        }
    }

    public static Func<String, Boolean> lengthGreaterThan(final int length, final boolean equalsCheck){
        return StringExpression.lengthGreaterThan(length, equalsCheck);
    }

    public static Func<String, Boolean> lengthLessThan(final int length, final boolean equalsCheck ){
        return StringExpression.lengthLessThan(length, equalsCheck);
    }

    public static Func<String, Boolean> startsWith(final String refString){
        Validate.notNull(refString, "Supplied Value cannot be null");
        if ( String.class != refString.getClass() ){
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        } else {
            return StringExpression.startsWith(refString);
        }

    }

    public static Func<String, Boolean> endsWith(final String refString){
        Validate.notNull(refString, "Supplied Value cannot be null");
        if ( String.class != refString.getClass() ){
            throw new IllegalArgumentException("Unsupported operation for String Object.");
        } else {
            return StringExpression.endsWith(refString);
        }
    }
}
