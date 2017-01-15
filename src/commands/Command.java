package commands;

import commands.interfaces.ICommand;
import commands.interfaces.ICommandBehavior;


/**
 * Concrete implementation of the ICommand interface, wraps an ICommandBehaviour
 * and ads functionality to track its status as executed or undone.
 * Note: No JUnit test, because there are plenty of other tests using this functionality.
 * @author rtucker
 */
public class Command implements ICommand {

    private ICommandBehavior delegate;
    private boolean blnExecuted = false;

    /**
     * Constructor to 'Decorate' i.e. wrap an ICommandBehaviour object
     * @param _decoratedCommand - A Command Behaviour to wrap
     */
    public Command(ICommandBehavior _decoratedCommand)
    {
        delegate = _decoratedCommand;
    }

    /**
     * Accessor to test if this command has been executed
     * @return boolean True if this command has been executed and not undone,
     * False otherwise
     * 
     */
    @Override
    public boolean isExecuted() {
        return blnExecuted;
    }

    /**
     * Accessor to test if this command has been undone
     * @return boolean True if this command has NOT been executed or if it
     * was undone after execution, False otherwise.
     * 
     */
    @Override
    public boolean isUndone() {
        return !blnExecuted;
    }

    /**
     * Executes the command.
     * 
     * @throws Exception Something went wrong.
     */
    @Override
    public boolean executeCommand() throws Exception {
        boolean done = false;
        //Call the delegates do method
        done = delegate.executeCommand();
        //Set the done / undone flag based on the result
        blnExecuted = done;
        return done;
    }

    /**
     * Undoes a previously executed command.
     * 
     * @throws Exception Something went wrong.
     */
    @Override
    public boolean undoCommand() throws Exception {
        boolean undone = false;
        //Call the delegates undo method
        undone = delegate.undoCommand();
        //Set the done / undone flag based on the result
        blnExecuted = !undone;
        return undone;
    }

}
