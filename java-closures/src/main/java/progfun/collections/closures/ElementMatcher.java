package progfun.collections.closures;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for basic Object Type comparisons
 */
public class ElementMatcher {

    /** Generic Method returning FirstMatched Value of type T */
    public static <T> T matchFirst(final List<T> objectList, final Func<T, Boolean> funct, T objValue){
        if( CollectionUtils.isNotEmpty(objectList ) ){
            for (T t : objectList) {
                if( funct.evaluate(t) ){
                    return t;
                }
            }
        }
        return objValue;
    }

    /** Generic Method returning FirstMatched Value of type T */
    public static <T> List<T> matchAll(final List<T> objectList, final Func<T, Boolean> funct, T objValue){
        List<T> collectedElements = new ArrayList<>();

        if( CollectionUtils.isNotEmpty(objectList ) ){
            for (T t : objectList) {
                if( funct.evaluate(t) ){
                    collectedElements.add(t);
                }
            }
        } else {
            collectedElements.add(objValue);
        }
        return collectedElements;
    }
}
