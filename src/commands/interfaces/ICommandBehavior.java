/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.interfaces;

/**
 * An Interface that expresses the concept of a command with a do / undo behaviour
 * @author rtucker
 */
public interface ICommandBehavior {
    
    /**
     * Executes this command behaviour
     * @return Boolean True if the command completed successfully, False otherwise
     */
    Boolean doCommand();
    
    /**
     * Reverses the command behaviour cancelling its effects
     * @return Boolean True if the commend was undone, False otherwise
     */
    Boolean undoCommand();
}
