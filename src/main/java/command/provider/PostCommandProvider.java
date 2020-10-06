package command.provider;

import command.HospitalCommand;
import command.impl.HomeCommand;
import command.impl.LoginCommand;
import command.impl.RegisterCommand;
import constant.HospitalPaths;
import utils.factory.provider.CommandProvider;

import java.util.HashMap;
import java.util.Map;

public class PostCommandProvider implements CommandProvider {
    private final Map<String, HospitalCommand> command = new HashMap<>();

    public PostCommandProvider() {
        command.put(HospitalPaths.HOME_HOSPITAL, new HomeCommand());

        command.put(HospitalPaths.LOGIN, new LoginCommand());
        command.put(HospitalPaths.REGISTER, new RegisterCommand());
    }

    @Override
    public HospitalCommand provideCommand(String uri) {
        HospitalCommand hospitalCommand = command.get(uri);
        if (hospitalCommand == null) {
            return command.get(HospitalPaths.HOME_HOSPITAL);
        }
        return hospitalCommand;
    }
}
