package observer;

public class ConcreteMember implements Member{
    UndoableStringBuilder str;
    String nameOfCon;

    /**
     * A constructor that accepts a string for a name with default UndoableStringBuilder
     * @param s name of member
     */
    public ConcreteMember(String s){
        this.str=null;
        this.nameOfCon=s;
    }
    /**
     *default constructor
     */
    public ConcreteMember(){
        this.str=null;
        this.nameOfCon=null;
    }

    /**
     * Pointing at UndoableStringBuilder received from Groupadmin on command notifiy
     * @param usb Pointing at UndoableStringBuilder
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.str=usb;
    }

    public String getNameOfCon() {
        return nameOfCon;
    }

    @Override
    public String toString() {
        return "Member:" +
                "str=" + this.str+
                ", nameOfCon='" + nameOfCon + '\''+ "\n";
    }
}
