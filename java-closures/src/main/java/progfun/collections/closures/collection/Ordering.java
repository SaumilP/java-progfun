package progfun.collections.closures.collection;

/**
 * Collection Ordering Enumeration
 */
public enum Ordering {
    EQ, GT, LT;

    public int ToInt(){
        return ordinal() - 1;
    }

    public static Ordering fromInt(int cmp){
        return cmp == 0 ? EQ : cmp > 0 ? GT : LT;
    }
}
