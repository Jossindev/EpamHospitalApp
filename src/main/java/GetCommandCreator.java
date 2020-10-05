import command.provider.GetCommandProvider;
import command.provider.factory.CommandProvider;
import command.provider.factory.Creator;

public class GetCommandCreator implements Creator {
    @Override
    public CommandProvider createCommandProvider() {
        return new GetCommandProvider();
    }
}
