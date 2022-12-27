package observer;
import java.util.Stack;

/*
Use the class you've implemented in previous assignment
 */
public class UndoableStringBuilder {
    StringBuilder st;
    Stack<String> Builde;

    /**
     * constructor
     */
    public UndoableStringBuilder() {
        st = new StringBuilder();
        Builde = new Stack<String>();
    }

    /**
     * copy constructor
     * @param str
     */
    public UndoableStringBuilder(String str) {
        if(str == null) str = "null";

        st = new StringBuilder(str);
        Builde = new Stack<String>();
    }

    /**
     * Appends the specified string to this character sequence
     *
     * @param str
     * @return the prev string with str
     */
    public UndoableStringBuilder append(String str) {
        try {
            String temp = st.toString();
            st.append(str);
            Builde.push(temp);
        }
        catch(Exception e) {
            System.out.println("Error : problem appending string");
        }
        return this;
    }

    /**
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     *
     * @param start
     * @param end
     * @return the string without the part that beggining in index start and finish in index end
     */
    public UndoableStringBuilder delete(int start, int end) {
        try {
            String temp = st.toString();
            st.delete(start, end);
            Builde.push(st.toString());
        }
        catch(StringIndexOutOfBoundsException e) {
            System.out.println("Error : the index out of the string");
        }
        catch(Exception e) {
            System.out.println("Error : problem deleting string");
        }
        return this;
    }

    /**
     * Inserts the string into this character sequence.
     *
     * @param offset
     * @param str
     * @return the previous string with the string str inserted at offset
     */
    public UndoableStringBuilder insert(int offset, String str) {
        try {
            String temp = st.toString();
            st.insert(offset, str);
            Builde.push(temp);
        }
        catch(StringIndexOutOfBoundsException e) {
            System.out.println("Error : the index out of the string");
        }
        catch(Exception e) {
            System.out.println("Error : problem inserting string");
        }

        return this;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in
     * the specified String. The substring begins at the specified start and
     * extends to the character at index end - 1 or to the end of the sequence if
     * no such character exists. First the characters in the substring are removed
     * and then the specified String is inserted at start. (This sequence will be
     * lengthened to accommodate the specified String if necessary).
     *
     * @param start
     * @param end
     * @param str
     * @return the new string with str from index start to index end
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        try {
            String temp = st.toString();
            st.replace(start, end, str);
            Builde.push(temp);
        }
        catch(StringIndexOutOfBoundsException e) {
            System.out.println("Error : the index out of the string");
        }
        catch(Exception e) {
            System.out.println("Error : problem replace string");
        }
        return this;
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the
     * sequence.
     *
     * @return the previous string reversed
     */
    public UndoableStringBuilder reverse() {
        try {
            String temp = st.toString();
            st.reverse();
            Builde.push(temp);
        }
        catch(Exception e) {
            System.out.println("Error : problem reversing string");
        }
        return this;
    }

    /**
     * @return the object before the last change
     */
    public void undo() {
        if (!Builde.isEmpty())
            st = new StringBuilder(Builde.pop());


    }

    @Override
    public String toString() {
        return st.toString();
    }
}


