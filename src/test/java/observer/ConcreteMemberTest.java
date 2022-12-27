package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {

    @Test
    void update() {
        GroupAdmin group = new GroupAdmin();
        ConcreteMember c1 = new ConcreteMember("yair");

        group.register(c1);
        assertEquals("Member:str=null, nameOfCon='yair'\n",c1.toString());
        group.append("abc");
        assertEquals("Member:str=abc, nameOfCon='yair'\n",c1.toString());
        group.insert(1,"yair");
        assertEquals("Member:str=ayairbc, nameOfCon='yair'\n",c1.toString());
        group.delete(0,1);
        assertEquals("Member:str=yairbc, nameOfCon='yair'\n",c1.toString());
        group.undo();
        assertEquals("Member:str=yairbc, nameOfCon='yair'\n",c1.toString());

    }
}