package org.core.designpatterns;

/**
 * 
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
 */
public class ObserverPattern {

}
