package tn.esprit.spring;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Color;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.repositories.IPisteRepository;
import tn.esprit.spring.services.PisteServicesImpl;

import java.util.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PisteServicesTest {
/* 
    @Mock
    private IPisteRepository pisteRepository;

    private PisteServicesImpl pisteServices;

    private Piste piste;

    @BeforeEach
    void setUp() {
        pisteServices = new PisteServicesImpl(pisteRepository);
        Set<Skier> skiers = new HashSet<>();
        piste = new Piste(1L, "Piste 1", Color.RED, 100, 10, skiers);
    }

    @Test
    @Order(1)
    @DisplayName("Add Piste")
    void testAddPiste() {
        Mockito.when(pisteRepository.save(piste)).thenReturn(piste);

        Piste result = pisteServices.addPiste(piste);

        Assertions.assertEquals(piste, result);

        Mockito.verify(pisteRepository).save(piste);
    }

    @Test
    @Order(2)
    @DisplayName("Retrieve Piste by ID")
    void testRetrievePisteById() {
        Mockito.when(pisteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(piste));

        Piste result = pisteServices.retrievePiste(1L);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(piste, result);
    }

    @Test
    @Order(3)
    @DisplayName("Retrieve All Pistes")
    void testRetrieveAllPistes() {
        // Arrange
        List<Piste> allPistes = new ArrayList();

        Mockito.when(pisteRepository.findAll()).thenReturn(allPistes);

        // Act
        List<Piste> retrieved = pisteServices.retrieveAllPistes();

        // Assert
        Assertions.assertEquals(allPistes, retrieved);
        Assertions.assertEquals(0, retrieved.size());
        Mockito.verify(pisteRepository, Mockito.times(1)).findAll();
    }

    @Test
    @Order(4)
    @DisplayName("Remove Piste")
    void testRemovePiste() {
        Long numPiste = 1L;

        pisteServices.removePiste(numPiste);

        Mockito.verify(pisteRepository, Mockito.times(1)).deleteById(numPiste);
    }
    */
}