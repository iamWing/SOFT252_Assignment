/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import commands.interfaces.ICommand;
import commands.interfaces.ICommandTracker;
import java.util.Stack;

/**
 * This class provides execution and tracking services for ICommand objects
 *
 * @author rtucker
 */
public class CommandTracker implements ICommandTracker {

    //Declare the 'Done' and 'Un-Done' stacks of ICommand objects
    private static Stack<ICommand> undoStack = new Stack<>();
    private static Stack<ICommand> redoStack = new Stack<>();

    @Override
    public Boolean executeCommand(ICommand _command) {
        Boolean blnExecuted = false;
        
        if (null != _command) {
            if (_command.executeCommand()) {
                undoStack.push(_command);
                blnExecuted = true;
            }   //Else not needed false is returned by default
        }
        return blnExecuted;
    }

    @Override
    public Boolean undoLastCommand() {
        Boolean blnUndone = false;

        //Get the last command
        ICommand lastCommand = undoStack.pop();
        //Undo the command
        if (lastCommand.undoCommand()) {
            //Push command to the 'redo' stack
            redoStack.push(lastCommand);
            blnUndone = true;
        }   //Else not needed false is returned by default
        return blnUndone;
    }

    @Override
    public Boolean redoLastCommand() {
        Boolean blnDone = false;

        //Get last 'undone' command
        ICommand lastCommand = this.redoStack.pop();
        //Redo the last command
        if (lastCommand.executeCommand()) {
            //Push command to the 'undo' stack
            undoStack.push(lastCommand);
            blnDone = true;
        }   //Else not needed false is returned by default

        return blnDone;
    }

}
