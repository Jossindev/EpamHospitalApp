package command.provider;

import command.HospitalCommand;
import command.impl.HomeCommand;
import command.impl.LoginCommand;
import command.impl.RegisterCommand;
import utils.factory.provider.CommandProvider;

import java.util.HashMap;
import java.util.Map;

public class PostCommandProvider implements CommandProvider {
    private final Map<String, HospitalCommand> command = new HashMap<>();

    public PostCommandProvider() {
        command.put("HOME", new HomeCommand());

        command.put("LOGIN", new LoginCommand());
        command.put("REGISTER", new RegisterCommand());
    }

    @Override
    public HospitalCommand provideCommand(String uri) {
        HospitalCommand hospitalCommand = command.get(uri);
        if (hospitalCommand == null) {
            return command.get(1);
        }
        return hospitalCommand;
    }
}
