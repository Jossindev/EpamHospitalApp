package utils.factory.provider.creator;

import command.provider.PostCommandProvider;
import utils.factory.provider.CommandProvider;

public class PostCommandCreator implements Creator {
    @Override
    public CommandProvider createCommandProvider() {
        return new PostCommandProvider();
    }
}
