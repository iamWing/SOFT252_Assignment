package commands.interfaces;

/**
 * An Interface that expresses the concept of a command with a do / undo behaviour
 * @author rtucker
 */
public interface ICommandBehavior {
    
    /**
     * Executes this command behaviour
     * @return boolean True if the command completed successfully, False otherwise
     * 
     * @throws Exception Something went wrong.
     */
    boolean executeCommand() throws Exception;
    
    /**
     * Reverses the command behaviour cancelling its effects
     * @return boolean True if the commend was undone, False otherwise
     * 
     * @throws Exception Something went wrong.
     */
    boolean undoCommand() throws Exception;
}
