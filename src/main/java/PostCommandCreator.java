import command.provider.PostCommndProvider;
import command.provider.factory.CommandProvider;
import command.provider.factory.Creator;

public class PostCommandCreator implements Creator {
    @Override
    public CommandProvider createCommandProvider() {
        return new PostCommndProvider();
    }
}
