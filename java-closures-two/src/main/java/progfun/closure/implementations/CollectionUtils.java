package progfun.closure.implementations;

import progfun.closure.interfaces.OneArg;

import java.util.Collection;
import java.util.Iterator;

/**
 * ForEach implementation using Closures in Java7
 */
public final class CollectionUtils {

    public static <T> void forEach( Collection<T> elementList, OneArg<T> block){
        for( Iterator<T> it = elementList.iterator(); it.hasNext(); ){
            block.invoke( it.next() );
        }
    }
}
