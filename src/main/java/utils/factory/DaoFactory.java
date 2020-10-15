package utils.factory;

import model.dao.*;

/**
 * The interface Dao factory.
 */
public interface DaoFactory {
    /**
     * Create assignment dao assignment dao.
     *
     * @return the assignment dao
     */
    AssignmentDAOImpl createAssignmentDao();

    /**
     * Create assignment type dao assignment type dao.
     *
     * @return the assignment type dao
     */
    AssignmentTypeDAOImpl createAssignmentTypeDAO();

    /**
     * Create doctor dao doctor dao.
     *
     * @return the doctor dao
     */
    DoctorDAOImpl createDoctorDAO();

    /**
     * Create patient dao patient dao.
     *
     * @return the patient dao
     */
    PatientDAOImpl createPatientDAO();

    /**
     * Create treatment dao treatment dao.
     *
     * @return the treatment dao
     */
    TreatmentDAOImpl createTreatmentDao();

    /**
     * Create role dao role dao.
     *
     * @return the role dao
     */
    RoleDAOImpl createRoleDao();

    /**
     * Create user dao user dao.
     *
     * @return the user dao
     */
    UserDAOImpl createUserDao();
}
