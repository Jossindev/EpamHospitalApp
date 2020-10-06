package utils.factory;

import model.dao.*;

public class DaoFactoryImpl implements DaoFactory {

    private static DaoFactoryImpl instance;

    public static DaoFactoryImpl getInstance() {
        if (instance == null) {
            synchronized (DaoFactoryImpl.class) {
                if (instance == null)
                    instance = new DaoFactoryImpl();
            }
        }
        return instance;
    }

    private DaoFactoryImpl() {
    }

    @Override
    public AssignmentDAOImpl createAssignmentDao() {
        return new AssignmentDAOImpl();
    }

    @Override
    public AssignmentTypeDAOImpl createAssignmentTypeDAO() { return new AssignmentTypeDAOImpl(); }

    @Override
    public DoctorDAOImpl createDoctorDAO() { return new DoctorDAOImpl(); }

    @Override
    public PatientDAOImpl createPatientDAO() { return new PatientDAOImpl(); }

    @Override
    public TreatmentDAOImpl createTreatmentDao() {
        return new TreatmentDAOImpl();
    }

    @Override
    public RoleDAOImpl createRoleDao() {
        return new RoleDAOImpl();
    }

    @Override
    public UserDAOImpl createUserDao() {
        return new UserDAOImpl();
    }
}
