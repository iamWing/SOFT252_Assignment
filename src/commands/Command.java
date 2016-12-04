/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import commands.interfaces.ICommand;
import commands.interfaces.ICommandBehavior;


/**
 * Concrete implementation of the ICommand interface, wraps an ICommandBehaviour
 * and ads functionality to track its status as executed or undone.
 * @author rtucker
 */
public class Command implements ICommand {

    private ICommandBehavior delegate;
    private Boolean blnExecuted = false;

    /**
     * Constructor to 'Decorate' i.e. wrap an ICommandBehaviour object
     * @param _decoratedCommand - A Command Behaviour to wrap
     */
    public Command(ICommandBehavior _decoratedCommand)
    {
        delegate = _decoratedCommand;
    }

    @Override
    public Boolean isExecuted() {
        return blnExecuted;
    }

    @Override
    public Boolean isUndone() {
        return !blnExecuted;
    }

    @Override
    public Boolean executeCommand() {
        Boolean done = false;
        //Call the delegates do method
        done = delegate.executeCommand();
        //Set the done / undone flag based on the result
        blnExecuted = done;
        return done;
    }

    @Override
    public Boolean undoCommand() {
        Boolean undone = false;
        //Call the delegates undo method
        undone = delegate.undoCommand();
        //Set the done / undone flag based on the result
        blnExecuted = !undone;
        return undone;
    }

}
