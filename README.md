# -OOP.Assignment1

observer design pattern:

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
gg
