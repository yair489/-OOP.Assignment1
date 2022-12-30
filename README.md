# -OOP.Assignment1

### observer design pattern:

In this assignment we learned about the observer design pattern.
The observer pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents,
called observers, and notifies them automatically of any state changes, usually by calling one of their methods.
The observer design pattern involves three main components:
1. Subject: This is the object that is being observed. It maintains a list of its observers and provides an
interface for attaching and detaching observers.
2. Observer: This is an object that wants to be notified of changes in the subject. It defines a update() method
that will be called by the subject when a change occurs.
3. Client: This is the object that creates the subject and observer objects and establishes the relationship between them.
The observer design pattern is useful for creating a system where objects can be notified of changes in other objects
without having to know the details of those objects. This allows for a more flexible and modular design,
as the subject and observer objects can be developed and used independently of each other.

### ConcreteMember:
The ConcreteMember class implements the Member interface, It is an interface that is implemented by classes that can be
members of groups. It represents a member that belongs to a group. 
In addition,The Member interface has the following methods:
1. getName(): This method returns the name of the member.
2. getGroup(): This method returns the group to which the member belongs.
3. isActive(): This method returns a boolean value indicating whether the member is active or not.
The ConcertMember object is the observe, it is contains an UndoableStringBuilder object reference, in case whice the ConcertMember object
related to a GroupAdmin object, it will be update (by updating his UndoableStringBuilder pointer reference to the GroupAdmin's 
UndoableStringBuilder object) everytime that the GroupAdmin object send him an update.
The meaning of this process is that we do not use a deep copy  but shallow copying.

### GroupAdmin:
The GroupAdmin class implements the Sender interface, this interface is a part of the JavaMail API, which is a set of Java classes that
provide support for sending and receiving electronic mail (email) messages.
The Sender interface has the following methods:
1. getName(): This method returns the name of the sender.
2. getAddress(): This method returns the email address of the sender.
The GroupAdmin object is the subject, it is contains an ArrayList object (of all related members, every time when a member related to the
GroupAdmin it is added to the array) and an UndoableStringBuilder object.
In case a change is made in the UndoableStringBuilder objec, the GroupAdmin object will send an update about the change to all the related members, 
in addition, it will pass a referrnce to his UndoableStringBuilder object.

### Tests



