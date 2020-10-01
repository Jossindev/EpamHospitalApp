package utils.factory;

import model.dao.*;

public interface DaoFactory {
    AssignmentDAOImpl createAssignmentDao();

    AssignmentTypeDAOImpl createAssignmentTypeDAO();

    DoctorDAOImpl createDoctorDAO();

    PatientDAOImpl createPatientDAO();

    TreatmentDAOImpl createTreatmentDao();

    RoleDAOImpl createRoleDao();

    UserDAOImpl createUserDao();
}
