package command.provider.factory;

import command.HospitalCommand;

public interface CommandProvider {
    HospitalCommand provideCommand(String uri);
}
