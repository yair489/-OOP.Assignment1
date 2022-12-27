package observer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GroupAdmin implements Sender {

    ArrayList<Member> memberArr = new ArrayList<>();
    UndoableStringBuilder strBuild = new UndoableStringBuilder();

    /**
     * add the member to tht list
     * @param obj pointer on member
     */
    @Override
    public void register(Member obj) {
        if(obj==null){
            System.out.println("cannt enter null");
        } else if(! ( memberArr.contains(obj) ) ){
            memberArr.add(obj);
            System.out.println("mew member was added");
        }else{
            System.out.println("obj already in the list");
        }

    }

    /**
     * Unregister the member
     * @param obj pointer on member
     */
    @Override
    public void unregister(Member obj) {

        if(memberArr.contains(obj)){
            memberArr.remove(obj);
            System.out.println("member was remove");
        }
    }
    /**
     * Inserts the string into this character sequence.
     *And also announces that changes will be made
     * @param offset
     * @param obj
     * @return the previous string with the string str inserted at offset
     */
    @Override
    public void insert(int offset, String obj) {
        strBuild.insert(offset,obj);
        notifiY();

    }
    /**
     * Appends the specified string to this character sequence
     * And also announces that changes will be made
     * @param obj
     * @return the prev string with str
     */
    @Override
    public void append(String obj) {
        strBuild.append(obj);
        notifiY();
    }
    /**
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     * And also announces that changes will be made
     * @param start
     * @param end
     * @return the string without the part that beggining in index start and finish in index end
     */
    @Override
    public void delete(int start, int end) {
        strBuild.delete(start,end);
        notifiY();


    }

    /**
     *And also announces that changes will be made
     * @return the object before the last change
     */
    @Override
    public void undo() {
        strBuild.undo();
        notifiY();
    }

    /**
     * Inform all group members about the change made
     */
    public void notifiY(){
        for (int i = 0; i<memberArr.size(); i++){
            (memberArr.get(i)).update(strBuild);
        }
    }

    @Override
    public String toString() {
        return "GroupAdmin{" +
                "memberArr=\n" + memberArr +
                ", strBuild=" + strBuild +
                '}';
    }


}
