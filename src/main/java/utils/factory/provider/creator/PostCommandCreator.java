package utils.factory.provider.creator;

import command.provider.PostCommandProvider;
import utils.factory.provider.CommandProvider;

/**
 * The type Post command creator.
 */
public class PostCommandCreator implements Creator {
    @Override
    public CommandProvider createCommandProvider() {
        return new PostCommandProvider();
    }
}
