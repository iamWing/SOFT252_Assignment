/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

/**
 * A Decorator to add functionality to an ICommandBehaviour object. Added
 * functions support tracking if the command has been executed or undo after
 * execution
 * @author rtucker
 */
public interface ICommand extends ICommandBehavior {
    
    /**
     * Accessor to test if this command has been executed
     * @return Boolean True if this command has been executed and not undone,
     * False otherwise
     */
    Boolean isExecuted();

    /**
     * Accessor to test if this command has been undone
     * @return Boolean True if this command has NOT been executed or if it
     * was undone after execution, False otherwise.
     */
    Boolean isUndone();
    
}
