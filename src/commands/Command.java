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
     * @param objACommand - A Command Behaviour to wrap
     */
    public Command(ICommandBehavior objACommand)
    {
        this.delegate = objACommand;
    }

    @Override
    public Boolean isExecuted() {
        return this.blnExecuted;
    }

    @Override
    public Boolean isUndone() {
        return !this.blnExecuted;
    }

    @Override
    public Boolean doCommand() {
        Boolean done = false;
        //Call the delegates do method
        done = this.delegate.doCommand();
        //Set the done / undone flag based on the result
        this.blnExecuted = done;
        return done;
    }

    @Override
    public Boolean undoCommand() {
        Boolean undone = false;
        //Call the delegates undo method
        undone = this.delegate.undoCommand();
        //Set the done / undone flag based on the result
        this.blnExecuted = !undone;
        return undone;
    }
    
}
