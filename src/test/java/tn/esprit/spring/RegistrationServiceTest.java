package tn.esprit.spring;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Registration;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.repositories.IRegistrationRepository;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.services.RegistrationServicesImpl;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RegistrationServiceTest {
    @Mock
    private IRegistrationRepository registrationRepository;

    @Mock
    private ISkierRepository skierRepository;

    @Mock
    private ICourseRepository courseRepository;

    @InjectMocks
    private RegistrationServicesImpl registrationServices;

    @BeforeEach
    void setUp() {
        
    }

    @Test
    @DisplayName("Test addRegistrationAndAssignToSkier")
    void testAddRegistrationAndAssignToSkier() {
        Registration registration = new Registration();
        Long numSkier = 1L;
        Skier skier = new Skier();

        when(skierRepository.findById(numSkier)).thenReturn(Optional.of(skier));
        when(registrationRepository.save(registration)).thenReturn(registration);

        Registration result = registrationServices.addRegistrationAndAssignToSkier(registration, numSkier);

        assertEquals(registration, result);
        verify(registrationRepository).save(registration);
    }




    @Test
    @DisplayName("Test addRegistrationAndAssignToSkierAndCourse with existing registration")
    void testAddRegistrationAndAssignToSkierAndCourseWithExistingRegistration() {
        Registration registration = new Registration();
        Long numSkier = 1L;
        Long numCourse = 2L;
        Skier skier = new Skier();
        Course course = new Course();

        when(skierRepository.findById(numSkier)).thenReturn(Optional.of(skier));
        when(courseRepository.findById(numCourse)).thenReturn(Optional.of(course));
        when(registrationRepository.countDistinctByNumWeekAndSkier_NumSkierAndCourse_NumCourse(registration.getNumWeek(), skier.getNumSkier(), course.getNumCourse())).thenReturn(1L);

        Registration result = registrationServices.addRegistrationAndAssignToSkierAndCourse(registration, numSkier, numCourse);

        assertNull(result);
    }

  

}
