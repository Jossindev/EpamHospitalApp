package utils.factory.provider;

import command.HospitalCommand;

public interface CommandProvider {
    HospitalCommand provideCommand(String uri);
}
