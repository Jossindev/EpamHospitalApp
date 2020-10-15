package utils.factory.provider;

import command.HospitalCommand;

/**
 * The interface Command provider.
 */
public interface CommandProvider {
    /**
     * Provide command hospital command.
     *
     * @param uri the uri
     * @return the hospital command
     */
    HospitalCommand provideCommand(String uri);
}
