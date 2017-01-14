package commands.interfaces;

/**
 * Observer Interface for Datastore.
 * @author NotMike
 */
public interface ICommandWatcher {
    
    /**
     * Callback that is executed on Datastore update.
     */
    void notifyCommandWatcher();

}
