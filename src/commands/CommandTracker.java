package commands;

import commands.interfaces.ICommand;
import commands.interfaces.ICommandTracker;
import commands.interfaces.ICommandWatcher;
import java.util.ArrayList;
import java.util.Stack;

/**
 * This class provides execution and tracking services for ICommand objects.
 * Note: No JUnit test, because there are plenty of other tests using this functionality.
 *
 * @author rtucker
 */
public class CommandTracker implements ICommandTracker {

    //Declare the 'Done' and 'Un-Done' stacks of ICommand objects
    private static Stack<ICommand> undoStack = new Stack<>();
    private static Stack<ICommand> redoStack = new Stack<>();
    private static ArrayList<ICommandWatcher> observers = new ArrayList<>();

    /**
     * Checks if there are any operations to undo.
     * 
     * @return boolean
     */
    public boolean HasUndoHistory()
    {
        return !undoStack.isEmpty();
    }

    /**
     * Checks if there are any operations to redo.
     * 
     * @return boolean
     */
    public boolean HasRedoHistory()
    {
        return !redoStack.isEmpty();
    }

    /**
     * Executes the command.
     * 
     * @throws Exception Something went wrong.
     */
    @Override
    public boolean executeCommand(ICommand _command) throws Exception {
        boolean blnExecuted = false;
        
        if (null != _command) {
            if (_command.executeCommand()) {
                undoStack.push(_command);
                blnExecuted = true;
            }   //Else not needed false is returned by default
        }
        CommandTracker.notifyCommandWatchers();
        return blnExecuted;
    }

    /**
     * Undoes the previously executed command.
     * 
     * @throws Exception Something went wrong.
     */
    @Override
    public boolean undoLastCommand() throws Exception {
        boolean blnUndone = false;

        //Get the last command
        ICommand lastCommand = undoStack.pop();
        //Undo the command
        if (lastCommand.undoCommand()) {
            //Push command to the 'redo' stack
            redoStack.push(lastCommand);
            blnUndone = true;
        }   //Else not needed false is returned by default
        CommandTracker.notifyCommandWatchers();
        return blnUndone;
    }

    /**
     * Redoes the last undone command.
     * 
     * @throws Exception Something went wrong.
     */
    @Override
    public boolean redoLastCommand() throws Exception {
        boolean blnDone = false;

        //Get last 'undone' command
        ICommand lastCommand = redoStack.pop();
        //Redo the last command
        if (lastCommand.executeCommand()) {
            //Push command to the 'undo' stack
            undoStack.push(lastCommand);
            blnDone = true;
        }   //Else not needed false is returned by default
        CommandTracker.notifyCommandWatchers();
        return blnDone;
    }
    /**
     * Register ICommandWatcher observer.
     * 
     * @param observer ICommandWatcher
     */
    public static void addCommandWatcher(ICommandWatcher observer)
    {
        CommandTracker.observers.add(observer);
    }
    /**
     * Remove observer.
     * @param observer ICommandWatcher
     */
    public static void removeCommandWatcher(ICommandWatcher observer)
    {
        CommandTracker.observers.remove(observer);
    }
    /**
     * Notify observers.
     */
    private static void notifyCommandWatchers()
    {
        for (ICommandWatcher observer : CommandTracker.observers)
        {
            observer.notifyCommandWatcher();
        }
    }
}
