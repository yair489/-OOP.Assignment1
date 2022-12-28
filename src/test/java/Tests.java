import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(()->JvmUtilities.objectFootprint(s1));
        logger.info(()->JvmUtilities.objectFootprint(s1,s2));
        logger.info(()->JvmUtilities.objectTotalSize(s1));
        logger.info(() -> JvmUtilities.jvmInfo());

        /**
         * we check memory code after some action
         */
        GroupAdmin group = new GroupAdmin();
        ConcreteMember co1=new ConcreteMember("yair");
        ConcreteMember co2=new ConcreteMember("david");
        ConcreteMember co3=new ConcreteMember("elad");

        System.out.println("object memory");
        logger.info(()->JvmUtilities.objectFootprint(group,co1,co2,co3));
        logger.info(()->JvmUtilities.objectTotalSize(group,co1,co2,co3));

        group.register(co1);
        group.register(co2);
        group.register(co3);

        System.out.println("Memory size after adding members to the group");
        logger.info(()->JvmUtilities.objectFootprint(group));
        logger.info(()->JvmUtilities.objectTotalSize(group));

        group.append("abc");

        System.out.println("The memory after action append");
        logger.info(()->JvmUtilities.objectFootprint(group));
        logger.info(()->JvmUtilities.objectTotalSize(group));
        logger.info(()->JvmUtilities.memoryStats(group));

        System.out.println("The memory after action unregister one member");
        group.unregister(co3);
        logger.info(()->JvmUtilities.objectFootprint(group));
        logger.info(()->JvmUtilities.objectTotalSize(group));

        System.out.println("The memory after action unregister all member");
        group.unregister(co2);
        group.unregister(co1);
        logger.info(()->JvmUtilities.objectFootprint(group));
        logger.info(()->JvmUtilities.objectTotalSize(group));


    }
}
