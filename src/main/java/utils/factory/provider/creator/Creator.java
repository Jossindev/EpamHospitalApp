package utils.factory.provider.creator;

import utils.factory.provider.CommandProvider;

/**
 * The interface Creator.
 */
public interface Creator {
    /**
     * Create command provider command provider.
     *
     * @return the command provider
     */
    CommandProvider createCommandProvider();
}
