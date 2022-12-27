package observer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UndoableStringBuilderTest {

    @Test
    void append() {
        UndoableStringBuilder st = new UndoableStringBuilder();
        st.append(null);

        if (!(st.toString().equals("null")))
            fail("append didnt work as expected");

        st.append("abc");
        if (!(st.toString().equals("nullabc")))
            fail("append didnt work as expected");
    }

    @Test
    void delete() {
        UndoableStringBuilder st = new UndoableStringBuilder(null);
        st.delete(0, 1);
        if (!(st.toString().equals("ull")))
            fail("delete didnt work as expected");
        st.delete(2, 1);
        if (!(st.toString().equals("ull")))
            fail("delete didnt work as expected");
        st.delete(-1, 1);
        if (!(st.toString().equals("ull")))
            fail("delete didnt work as expected");
        st.delete(0, 100);
        if (!(st.toString().equals("")))
            fail("delete didnt work as expected");

    }

    @Test
    void insert() {
        UndoableStringBuilder st = new UndoableStringBuilder("abc");
        st.insert(1, "abc");
        if (!(st.toString().equals("aabcbc")))
            fail("insert didnt work as expected");
        st.insert(-2, "abc");
        if (!(st.toString().equals("aabcbc")))
            fail("insert didnt work as expected");
        st.insert(1, null);
        if (!(st.toString().equals("anullabcbc")))
            fail("insert didnt work as expected");
    }

    @Test
    void replace() {
        UndoableStringBuilder st = new UndoableStringBuilder("abcd");
        st.replace(0, 1, "cd");
        if (!(st.toString().equals("cdbcd")))
            fail("replace didnt work as expected");
        st.replace(0, 1, null);
        if (!(st.toString().equals("cdbcd")))
            fail("replace didnt work as expected");
        st.replace(2, 1, "cd");
        if (!(st.toString().equals("cdbcd")))
            fail("replace didnt work as expected");
        st.replace(100, 101, null);
        if (!(st.toString().equals("cdbcd")))
            fail("replace didnt work as expected");
    }

    @Test
    void reverse() {
        UndoableStringBuilder st = new UndoableStringBuilder("abcd");
        st.reverse();
        if(! (st.toString().equals("dcba")) )
            fail( "reverse didnt work as expected");

    }

    @Test
    void undo() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("to be or not to be");

        usb.replace(3, 5, "eat");

        usb.replace(17, 19, "eat");
        usb.reverse();

        usb.undo();

        if (!usb.toString().equals("to eat or not to eat")) {
            fail("didnt work as expected");
        }
        usb.undo();
        if (!usb.toString().equals("to eat or not to be")) {
            fail("didnt work as expected");
        }
        usb.undo();
        if (!usb.toString().equals("to be or not to be")) {
            fail("didnt work as expected");
        }
    }
}
