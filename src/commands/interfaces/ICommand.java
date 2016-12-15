package commands.interfaces;

/**
 * A Decorator to add functionality to an ICommandBehaviour object. Added
 * functions support tracking if the command has been executed or undo after
 * execution
 * @author rtucker
 */
public interface ICommand extends ICommandBehavior {
    
    /**
     * Accessor to test if this command has been executed
     * @return boolean True if this command has been executed and not undone,
     * False otherwise
     * 
     * @throws Exception Something went wrong.
     */
    boolean isExecuted() throws Exception;

    /**
     * Accessor to test if this command has been undone
     * @return boolean True if this command has NOT been executed or if it
     * was undone after execution, False otherwise.
     * 
     * @throws Exception Something went wrong.
     */
    boolean isUndone() throws Exception;

}
