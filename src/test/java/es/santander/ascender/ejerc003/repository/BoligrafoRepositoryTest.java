package es.santander.ascender.ejerc003.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc003.model.Boligrafo;

@SpringBootTest
public class BoligrafoRepositoryTest {

        @Autowired
        private BoligrafoRepository repository;

        @Test
        public void testCreate() {
               Boligrafo boligrafo = new Boligrafo();
                boligrafo.setColor("azul");
                boligrafo.setEscribe(false);
                boligrafo.setNombre("bic");

                repository.save(boligrafo);
                assertTrue(
                                repository
                                                .findById(boligrafo.getId())
                                                .isPresent());
        }

        @Test
        public void delete() {
                Boligrafo boligrafo = new Boligrafo();
                boligrafo.setColor("azul");
                boligrafo.setEscribe(false);
                boligrafo.setNombre("bic");
                repository.save(boligrafo);
                assertTrue(
                                repository
                                                .findById(boligrafo.getId())
                                                .isPresent());
                repository.deleteById(boligrafo.getId());
        }

        @Test
        public void update() {
                Boligrafo boligrafo = new Boligrafo();
                boligrafo.setColor("azul");
                boligrafo.setEscribe(false);
                boligrafo.setNombre("bic");
                repository.save(boligrafo);
                assertTrue(
                                repository
                                                .existsById(boligrafo.getId()));
                boligrafo.setColor("rojo");
                repository.save(boligrafo);
                Optional<Boligrafo> updatedBoligrafo = repository.findById(boligrafo.getId());
                assertTrue(updatedBoligrafo.isPresent());
                assertTrue(updatedBoligrafo.get().getColor() == "rojo");
        }

}

