// Start with the class declaration, for example:

abstract class AbsIterator extends AnyRef 

trait RichIterator extends AbsIterator 

class StringIterator extends AbsIterator 

class Iter extends StringIterator with RichIterator 

// Linearization sequence

// Reverse the order of the list, 
// except keep the first item (Iter) at the beginning, and drop the other keywords:

// Iter RichIterator StringIterator

// Replace each item in the list except the first (Iter) with its linearization:

// StringIterator AbsIterator
// RichIterator AbsIterator

// Iter RichIterator AbsIterator AnyRef StringIterator AbsIterator AnyRef 

// Append the standard Scala classes ScalaObject, AnyRef, Any:

// Iter RichIterator AbsIterator AnyRef StringIterator AbsIterator AnyRef ScalaObject, AnyRef, Any

// remove duplicates

// Iter RichIterator StringIterator AbsIterator ScalaObject, AnyRef, Any
