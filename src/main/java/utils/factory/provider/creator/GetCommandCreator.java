package utils.factory.provider.creator;

import command.provider.GetCommandProvider;
import utils.factory.provider.CommandProvider;

public class GetCommandCreator implements Creator {
    @Override
    public CommandProvider createCommandProvider() {
        return new GetCommandProvider();
    }
}
