package observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAdminTest {

    @Test
    void register() {
        GroupAdmin group = new GroupAdmin();
        ConcreteMember co1=new ConcreteMember("yair");
        ConcreteMember co2=new ConcreteMember("david");
        ConcreteMember co3=new ConcreteMember("elad");

        group.register(co1);
        group.register(co2);
        group.register(co3);
        assertEquals("GroupAdmin{memberArr=\n[Member:str=null, nameOfCon='yair'\n, Member:str=null, nameOfCon='david'\n, Member:str=null, nameOfCon='elad'\n], strBuild=}",group.toString());

    }

    @Test
    void unregister() {
        GroupAdmin group = new GroupAdmin();
        ConcreteMember co1=new ConcreteMember("yair");
        ConcreteMember co2=new ConcreteMember("david");
        ConcreteMember co3=new ConcreteMember("elad");

        group.register(co1);
        group.register(co2);
        group.register(co3);
        group.append("abc");
        group.unregister(co1);
        group.unregister(co2);

        assertEquals("GroupAdmin{memberArr=\n[Member:str=abc, nameOfCon='elad'\n], strBuild=abc}",group.toString());
    }

    @Test
    void insert() {
        GroupAdmin group = new GroupAdmin();
        ConcreteMember co1=new ConcreteMember("yair");
        group.register(co1);
        group.insert(0,"hello");
        assertEquals("GroupAdmin{memberArr=\n[Member:str=hello, nameOfCon='yair'\n], strBuild=hello}",
                group.toString());
        group.insert(6,"world");
        assertEquals("GroupAdmin{memberArr=\n[Member:str=hello, nameOfCon='yair'\n], strBuild=hello}",
                group.toString());
        System.out.println(group);
        group.insert(5," world");
        assertEquals("GroupAdmin{memberArr=\n[Member:str=hello world, nameOfCon='yair'\n], strBuild=hello world}",
                group.toString());
    }

    @Test
    void append() {
        GroupAdmin group = new GroupAdmin();
        ConcreteMember co1=new ConcreteMember("yair");
        group.register(co1);
        group.append("hello");
        assertEquals("GroupAdmin{memberArr=\n[Member:str=hello, nameOfCon='yair'\n], strBuild=hello}",
                group.toString());
        group.append(" beautiful");
        assertEquals("GroupAdmin{memberArr=\n[Member:str=hello beautiful, nameOfCon='yair'\n], strBuild=hello beautiful}",
                group.toString());
        group.append(" world");
        assertEquals("GroupAdmin{memberArr=\n[Member:str=hello beautiful world, nameOfCon='yair'\n], strBuild=hello beautiful world}",
                group.toString());

    }

    @Test
    void delete() {
        GroupAdmin group = new GroupAdmin();
        ConcreteMember co1=new ConcreteMember("yair");
        group.register(co1);
        group.append("hello world");
        group.delete(0,2);
        assertEquals("GroupAdmin{memberArr=\n[Member:str=llo world, nameOfCon='yair'\n], strBuild=llo world}",
                group.toString());
        group.delete(0,2);

        assertEquals("GroupAdmin{memberArr=\n[Member:str=o world, nameOfCon='yair'\n], strBuild=o world}",
                group.toString());
        group.delete(0,-1);
        assertEquals("GroupAdmin{memberArr=\n[Member:str=o world, nameOfCon='yair'\n], strBuild=o world}",
                group.toString());

    }

    @Test
    void undo() {
        GroupAdmin group = new GroupAdmin();
        ConcreteMember co1=new ConcreteMember("yair");
        group.register(co1);
        group.append("hello");
        group.append(" beautiful");
        group.append(" world");
        group.insert(2,"bb");

        group.undo();
        assertEquals("GroupAdmin{memberArr=\n[Member:str=hello beautiful world, nameOfCon='yair'\n], strBuild=hello beautiful world}",
                group.toString());
        group.undo();
        assertEquals("GroupAdmin{memberArr=\n[Member:str=hello beautiful, nameOfCon='yair'\n], strBuild=hello beautiful}",
                group.toString());
        group.undo();
        assertEquals("GroupAdmin{memberArr=\n[Member:str=hello, nameOfCon='yair'\n], strBuild=hello}",
                group.toString());

    }
}