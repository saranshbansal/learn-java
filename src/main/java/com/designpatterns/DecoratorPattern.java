package com.designpatterns;

interface Troll {
    void attack();


    int getAttackPower();


    void fleeBattle();
}

/**
 * Decorator design pattern (S)
 * <p>
 * Decorator design pattern is used to enhance the functionality of a particular
 * object at run-time or dynamically. � At the same time other instance of same
 * class will not be affected by this so individual object gets the new
 * behavior. � Basically we wrap the original object through decorator object. �
 * Decorator design pattern is based on abstract classes and we derive concrete
 * implementation from those classes, � It�s a structural design pattern and
 * most widely used.
 * <p>
 * Use When Object responsibilities and behaviors should be dynamically
 * modifiable. Concrete implementations should be decoupled from
 * responsibilities and behaviors. Subclassing to achieve modification is
 * impractical or impossible. Specific functionality should not reside high in
 * the object hierarchy. A lot of little objects surrounding a concrete
 * implementation is acceptable.
 * <p>
 * Example Many businesses set up their mail systems to take advantage of
 * decorators. When messages are sent from someone in the company to an external
 * address the mail server decorates the original message with copyright and
 * confidentiality information. As long as the message remains internal the
 * information is not attached. This decoration allows the message itself to
 * remain unchanged until a runtime decision is made to wrap the message with
 * additional information.
 */
public class DecoratorPattern {
    public static void main(String[] args) {

        // simple troll
        Troll troll = new SimpleTroll();
        troll.attack(); // The troll tries to grab you!
        troll.fleeBattle(); // The troll shrieks in horror and runs away!

        // change the behavior of the simple troll by adding a decorator
        troll = new ClubbedTroll(troll);
        troll.attack(); // The troll tries to grab you! The troll swings at you with a club!
        troll.fleeBattle(); // The troll shrieks in horror and runs away!
    }
}

class SimpleTroll implements Troll {

    @Override
    public void attack() {
        System.out.println("The troll tries to grab you!");
    }


    @Override
    public int getAttackPower() {
        return 10;
    }


    @Override
    public void fleeBattle() {
        System.out.println("The troll shrieks in horror and runs away!");
    }
}


class ClubbedTroll implements Troll {

    private final Troll decorated;


    public ClubbedTroll(Troll decorated) {
        this.decorated = decorated;
    }


    @Override
    public void attack() {
        decorated.attack();
        System.out.println("The troll swings at you with a club!");
    }


    @Override
    public int getAttackPower() {
        return decorated.getAttackPower() + 10;
    }


    @Override
    public void fleeBattle() {
        decorated.fleeBattle();
    }
}
