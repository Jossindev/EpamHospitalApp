package command.provider;

import command.HospitalCommand;
import command.provider.factory.CommandProvider;

public class GetCommandProvider implements CommandProvider {
    @Override
    public HospitalCommand provideCommand(String uri) {
        return null;
    }
}
