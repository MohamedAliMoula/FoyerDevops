package tn.esprit.spring;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Etudiant;
import tn.esprit.spring.DAO.Repositories.BlocRepository;
import tn.esprit.spring.DAO.Repositories.EtudiantRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EtudiantServiceIntegrationTest {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Test
    public void testFindAllEtudiants() {
        Etudiant etudiant = Etudiant.builder()
                .nomEt("Med")
                .prenomEt("Med")
                .cin(12345678L)
                .ecole("Esprit")
                .dateNaissance(LocalDate.of(2000, 1, 4))
                .build();
        etudiantRepository.save(etudiant);
        List<Etudiant> etudiants = etudiantRepository.findAll();

        assertEquals(1, etudiants.size());
    }
    @AfterEach
    public void cleanUp() {
        etudiantRepository.deleteAll();
    }
}
