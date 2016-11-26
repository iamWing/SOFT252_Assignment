/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClasses;

import command.ICommand;
import command.ICommandTracker;
import java.util.Stack;

/**
 * This class provides execution and tracking services for ICommand objects
 * @author rtucker
 */
public class CommandTracker implements ICommandTracker {

    //Declare the 'Done' and 'Un-Done' stacks of ICommand objects
    private Stack<ICommand> stkDone = new Stack<>();
    private Stack<ICommand> stkUndone = new Stack<>();

    @Override
    public Boolean executeCommand(ICommand objACommand) {
        Boolean blnExecuted = false;
        if (null != objACommand) {
            if (objACommand.doCommand()) {
                this.stkDone.push(objACommand);
                blnExecuted = true;
            }   //Else not needed false is returned by default
        }
        return blnExecuted;
    }

    @Override
    public Boolean undoLastCommand() {
        Boolean blnUndone = false;
        
            //Get the last command
            ICommand lastCommand = this.stkDone.pop();
            //Undo the command
            if(lastCommand.undoCommand()){
                //Push command to the undone stack
                this.stkUndone.push(lastCommand);
                blnUndone = true;
            }   //Else not needed false is returned by default
        return blnUndone;
    }

    @Override
    public Boolean redoLastCommand() {
        Boolean blnDone = false;

            //Get last 'undone' command
            ICommand lastCommand = this.stkUndone.pop();
            //Redo the last command
            if(lastCommand.doCommand()){
                //Push command to the 'done' stack
                this.stkDone.push(lastCommand);
                blnDone = true;
            }   //Else not needed false is returned by default
        
        return blnDone;
    }

}