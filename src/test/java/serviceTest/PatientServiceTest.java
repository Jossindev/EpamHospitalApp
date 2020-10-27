package serviceTest;

import model.entity.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import service.impl.PatientService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PatientServiceTest {
    @Mock
    private PatientService patientService;

    Patient patient;
    List<Patient> patients = new ArrayList<>();

    @Before
    public void setUp() {
        User user = new User("ihor", "Ivanov", Date.valueOf("2012-01-01"),
                "gg@gmail.com", "1111", new Role(1));
        Doctor doctor = new Doctor(1, user, "Surgeon");
        Treatment treatment = new Treatment(1, new Assignment(1), "diagnosis");
        patient = new Patient(1, doctor, doctor, treatment);
        patients.add(patient);
    }

    @Test
    public void findAllPatientsTest() {
        Mockito.when(patientService.findAll()).thenReturn(patients);
    }

    @Test
    public void findPatientByIdTest() {
        Mockito.when(patientService.findPatientById(1)).thenReturn(patient);
    }

    @Test
    public void findAllDoctorPatientsTest() {
        Mockito.when(patientService.findAllDoctorPatients(1)).thenReturn(patients);
    }

    @Test
    public void registerPatientTest() {
        Mockito.when(patientService.registerPatient(1,1)).thenReturn(true);
    }

}
