package utils.factory.provider.creator;

import command.provider.GetCommandProvider;
import utils.factory.provider.CommandProvider;

/**
 * The type Get command creator.
 */
public class GetCommandCreator implements Creator {
    @Override
    public CommandProvider createCommandProvider() {
        return new GetCommandProvider();
    }
}
