package model.dao.interfaces;

import model.entity.Assignment;

/**
 * The interface Assignment dao.
 */
public interface AssignmentDAO {
    /**
     * Find by id assignment.
     *
     * @param id the id
     * @return the assignment
     */
    Assignment findById(int id);

    /**
     * Update assignment executor.
     *
     * @param executorId the executor id
     * @param id         the id
     */
    void updateAssignmentExecutor(int executorId, int id);

    /**
     * Update assignment reporter.
     *
     * @param reporterId  the reporter id
     * @param id          the id
     * @param description the description
     */
    void updateAssignmentReporter(int reporterId, int id, String description);
}
