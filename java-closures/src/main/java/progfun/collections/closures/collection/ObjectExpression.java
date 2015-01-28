package progfun.collections.closures.collection;

import org.apache.commons.lang.StringUtils;
import progfun.collections.closures.Func;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Custom Object related Matching Expressions
 */
@SuppressWarnings("unchecked")
public class ObjectExpression {

    /** Method uses reflection and matching object to identify property and
     * attempts to match property values */
    public static <T,O> Func<O,Boolean> contains(final T matchPropValue ){
        return new Func<O,Boolean>(){
           @Override public Boolean evaluate(O refObj) {
               try {
                   String fieldName = (String) findPropertyByType(matchPropValue, refObj );
                   Object foundObj = getFieldValue( refObj, fieldName );
                   return foundObj != null && matchPropValue != null && foundObj.equals(matchPropValue);
               } catch (RuntimeException ex){
                   return false;
               }
           }
        };
    }

    /** Instead of using reflection, method accepts method-name */
    public static <T,O> Func<O,Boolean> contains(final String methodName, final T matchPropValue){
        return new Func<O,Boolean>(){
            @Override public Boolean evaluate(O refObj) {
                try{
                    Object foundObj = getFieldValueByMethod( refObj, methodName );
                    return foundObj != null && matchPropValue != null && foundObj.equals(matchPropValue);
                } catch( RuntimeException ex){
                    return false;
                }
            }
        };
    }

    /** Method identifies Object Property with type [T] */
    private static <T,O> Object findPropertyByType(final T matchPropertyValue, final O obj){
        String fieldName = "";
        for (Field field : obj.getClass().getDeclaredFields() ) {
            if( field.getType() == matchPropertyValue.getClass() ){
                fieldName = field.getName();
                break;
            }
        }
        return fieldName;
    }

    /** Method returns Property Value based on provided reference matching Property */
    private static <T> Object getFieldValue(T obj, String fieldName) {
        Object fieldValue = null;
        if ( StringUtils.isNotEmpty(fieldName) ){
            try{
                Field field = obj.getClass().getDeclaredField( fieldName );
                field.setAccessible( true );
                fieldValue = field.get( obj );
            } catch( NoSuchFieldException | IllegalAccessException | RuntimeException ex ){
                throw new RuntimeException( String.format("No such field found while attempting to extract Field value[%s] of class type - %s", fieldName, obj.getClass()) );
            }
        }
        return fieldValue;
    }

    /** Method returns Property Value based on provided reference matching Property */
    private static <T> Object getFieldValueByMethod(T destObj, String methodName) {
        Object fieldValue = null;
        if ( StringUtils.isNotEmpty(methodName) ){
            try{
                Method method = destObj.getClass().getDeclaredMethod(methodName);
                fieldValue = method.invoke( destObj );
            } catch (RuntimeException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException( String.format("No such field found while attempting to extract Field value[%s] of class type - %s",
                                                          methodName,
                                                          destObj.getClass()) );
            }
        }
        return fieldValue;
    }
}
