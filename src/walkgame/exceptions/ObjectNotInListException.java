package walkgame.exceptions;

import java.util.Collection;

public class ObjectNotInListException extends Exception
{
    public ObjectNotInListException(String message)
    {
        super(message);
    }

    public ObjectNotInListException(Object object, Collection collection) {
        super(String.format("Object '%s' not in collection '%s'", object, collection));
    }
}
