package tn.esprit.spring;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Registration;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.CourseServicesImpl;

import java.util.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CourseServicesImplTest {
    @Mock
    private ICourseRepository courseRepository;
    private CourseServicesImpl courseServices;
    private Course course;
    @BeforeEach
    void setUp() {
        courseServices = new CourseServicesImpl(courseRepository);
        Set<Registration> registrations = new HashSet<Registration>();
        course = new Course(1L, 1, TypeCourse.COLLECTIVE_CHILDREN, Support.SKI, 2f, 2,registrations);
    }
    @Test
    @Order(1)
    @DisplayName("Create Course")
    void testAddCourse() {
        Mockito.when(courseRepository.save(course)).thenReturn(course);

        Course result = courseServices.addCourse(course);

        Assertions.assertEquals(course, result);

        Mockito.verify(courseRepository).save(course);
    }
    @Test
    @Order(2)
    @DisplayName("Get course by id")
    void testRetrieveCourseById() {

        Mockito.when(courseRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(course));

        Course result = courseServices.retrieveCourse(1L);

        Assertions.assertNotNull(result);
    }
    @Test
    @Order(3)
    @DisplayName("Get all stock")
    void testRetrieveAllStock() {
        // Arrange
        List<Course> allCourse = new ArrayList<>();

        Mockito.when(courseRepository.findAll()).thenReturn(allCourse);

        // Act
        List<Course> retrieved = courseServices.retrieveAllCourses();

        // Assert
        Assertions.assertEquals(allCourse, retrieved);
        Assertions.assertEquals(0, retrieved.size());
        Mockito.verify(courseRepository, Mockito.times(1)).findAll();
    }

    @Test
    @Order(4)
    @DisplayName("Mettre à jour un cours")
    void testUpdateCourse() {
        // Créez un cours factice pour la mise à jour
        Course courseToUpdate = new Course(1L, 1, TypeCourse.COLLECTIVE_CHILDREN, Support.SKI, 2f, 2, new HashSet<>());

        // Configurez le comportement de votre repository mock
        Mockito.when(courseRepository.save(courseToUpdate)).thenReturn(courseToUpdate);

        // Appelez la méthode de service que vous souhaitez tester
        Course updatedCourse = courseServices.updateCourse(courseToUpdate);

        // Assurez-vous que le cours a été mis à jour correctement
        Assertions.assertEquals(1, updatedCourse.getLevel());
        Assertions.assertEquals(TypeCourse.COLLECTIVE_CHILDREN, updatedCourse.getTypeCourse());
        Assertions.assertEquals(Support.SKI, updatedCourse.getSupport());
        Assertions.assertEquals(2.0f, updatedCourse.getPrice());
        Assertions.assertEquals(2, updatedCourse.getTimeSlot());

        // Vérifiez que la méthode save a été appelée une fois avec le cours en argument
        Mockito.verify(courseRepository, Mockito.times(1)).save(courseToUpdate);
    }
    }


