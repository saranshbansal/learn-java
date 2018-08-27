package com.designpatterns;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * -----------------------------------------------------------------------------
 * Observer Pattern is one of the behavioral design pattern. Observer design
 * pattern is useful when you are interested in the state of an object and want
 * to get notified whenever there is any change. In observer pattern, the object
 * that watch on the state of another object are called Observer and the object
 * that is being watched is called Subject.
 * 
 * According to GoF, observer design pattern intent is;
 * 
 * Define a one-to-many dependency between objects so that when one object
 * changes state, all its dependents are notified and updated automatically.
 * 
 * Example: This pattern can be found in almost every GUI environment. When
 * buttons, text, and other fields are placed in applications the application
 * typically registers as a listener for those controls. When a user triggers an
 * event, such as clicking a button, the control iterates through its registered
 * observers and sends a notification to each.
 * 
 * For our observer pattern java program example, we would implement a simple
 * topic and observers can register to this topic. Whenever any new message will
 * be posted to the topic, all the registers observers will be notified and they
 * can consume the message. 
 * PS: For simplicity forget about synchronization.
 * -------------------------------------------------------------------------------
 */

/*
 * Based on the requirements of Subject, here is the base Subject interface that
 * defines the contract methods to be implemented by any concrete subject.
 */
interface Subject
{

    // methods to register and unregister observers
    public void register(Observer obj);


    public void unregister(Observer obj);


    // method to notify observers of change
    public void notifyObservers();


    // method to get updates from subject
    public Object getUpdates();

}


/*
 * Next we will create contract for Observer, there will be a method to attach
 * the Subject to the observer and another method to be used by Subject to
 * notify of any change.
 */
interface Observer
{

    // method to check if any update is made on the subject
    public void observeAndUpdate();


    // attach with subject to observe
    public void setSubject(Subject sub);
}


/*
 * Now our contract is ready, let�s proceed with the concrete implementation of
 * our home feed.
 * 
 * The method implementation to register and unregister an observer is very
 * simple, the extra method is postMessage() that will be used by client
 * application to post String message to the feed. Notice the boolean variable
 * to keep track of the change in the state of feed and used in notifying
 * observers. This variable is required so that if there is no update and
 * somebody calls notifyObservers() method, it doesn�t send false notifications
 * to the observers.
 * 
 * Also notice the use of synchronization in notifyObservers() method to make
 * sure the notification is sent only to the observers registered before the
 * message is published to the feed.
 */
class MyPersonalFeed implements Subject
{

    private List<Observer> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();


    public MyPersonalFeed()
    {
        this.observers = new ArrayList<>();
    }


    @Override
    public void register(Observer obj)
    {
        if (obj == null)
            throw new NullPointerException("Null Observer");
        synchronized (MUTEX)
        {
            if (!observers.contains(obj))
                observers.add(obj);
        }
    }


    /*
     * It has a synchronized block. It is because you cannot add elements to
     * arraylist and also remove elements from it at the same time. It will give a
     * java.util.ConcurrentModificationException.
     */
    @Override
    public void unregister(Observer obj)
    {
        synchronized (MUTEX)
        {
            observers.remove(obj);
        }
    }


    @Override
    public void notifyObservers()
    {
        List<Observer> observersLocal = null;
        // synchronization is used to make sure any observer registered after message is
        // received is not notified
        synchronized (MUTEX)
        {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }
        for (Observer obj : observersLocal)
        {
            obj.observeAndUpdate();
        }

    }


    @Override
    public Object getUpdates()
    {
        return this.message;
    }


    // method to post message to the home feed
    public void addNewPost(String msg)
    {
        System.out.println("New post added to feed:" + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }

}


/*
 * Here is the implementation of Observers that will watch over the subject.
 * 
 * Notice the implementation of update() method where it�s calling Subject
 * getUpdate() method to get the message to consume. We could have avoided this
 * call by passing message as argument to update() method.
 */
class MyFeedObserver implements Observer
{

    private String name;
    private Subject homeFeed;


    public MyFeedObserver(String nm)
    {
        this.name = nm;
    }


    @Override
    public void observeAndUpdate()
    {
        String msg = (String) homeFeed.getUpdates();
        if (msg == null)
        {
            System.out.println(name + ":: No new post");
        }
        else
            System.out.println(name + ":: Consuming post::" + msg);
    }


    @Override
    public void setSubject(Subject sub)
    {
        this.homeFeed = sub;
    }

}


/*
 * 
 * Here is a simple test program to consume our home feed implementation.
 */
public class ObserverPattern
{

    public static void main(String[] args)
    {
        // create your home feed
        MyPersonalFeed feed = new MyPersonalFeed();

        // create observers
        Observer obj1 = new MyFeedObserver("Observer1");
        Observer obj2 = new MyFeedObserver("Observer2");
        Observer obj3 = new MyFeedObserver("Observer3");

        // register observers to the subject
        feed.register(obj1);
        feed.register(obj2);
        feed.register(obj3);

        // attach observer to subject
        obj1.setSubject(feed);
        obj2.setSubject(feed);
        obj3.setSubject(feed);

        // check if any update is available
        obj1.observeAndUpdate();

        // now send a new post to home feed
        feed.addNewPost("New Post - " + LocalDateTime.now());
    }

}
