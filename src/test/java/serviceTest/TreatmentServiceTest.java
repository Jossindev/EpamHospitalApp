package serviceTest;

import model.entity.Assignment;
import model.entity.Treatment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import service.impl.TreatmentService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TreatmentServiceTest {

    @Mock
    TreatmentService service;

    Treatment treatment;

    @Before
    public void setUp() {
        treatment = new Treatment(1, new Assignment(1), "diagnosis");
    }

    @Test
    public void findTreatmentByIdTest() {
        Mockito.when(service.findTreatmentById(1)).thenReturn(treatment);
    }
}
