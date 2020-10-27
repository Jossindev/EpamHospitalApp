package serviceTest;

import model.entity.Doctor;
import model.entity.Role;
import model.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import service.impl.DoctorService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DoctorServiceTest {

    @Mock
    DoctorService service;

    Doctor doctor;
    Doctor doc;
    List<Doctor> doctors = new ArrayList<>();

    @Before
    public void setUp() {
        User user = new User("ihor", "Ivanov", Date.valueOf("2012-01-01"),
                "gg@gmail.com", "1111", new Role(1));
        doctor = new Doctor(1, user, "Surgeon");
        User user2 = new User("ihor", "Fore", Date.valueOf("2012-01-01"),
                "gfefg@gmail.com", "11111", new Role(1));;
        doc = new Doctor(2, user2, "Surgeon");
        doctors.add(doctor);
    }

    @Test
    public void findAllDoctorsTest() {
        Mockito.when(service.findAllDoctors()).thenReturn(doctors);
    }

    @Test
    public void addDoctorTest() {
        Mockito.when(service.addDoctor(doc)).thenReturn(doc);
    }

    @Test
    public void findDoctorByIdTest() {
        Mockito.when(service.findDoctor(1)).thenReturn(doctor);
    }

    @Test
    public void findAllNursesTest() {
        Mockito.when(service.findAllNurses(1)).thenReturn(doctors);
    }
}
