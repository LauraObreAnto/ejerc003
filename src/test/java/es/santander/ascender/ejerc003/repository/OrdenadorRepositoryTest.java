package es.santander.ascender.ejerc003.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc003.model.Color;
import es.santander.ascender.ejerc003.model.Ordenador;

@SpringBootTest
public class OrdenadorRepositoryTest {
@Autowired
        private OrdenadorRepository repository;

        @Test
        public void testListar(){
                List<Ordenador> lista= repository.findAll();
                assertNotNull(lista);
                assertTrue(lista.size()>=2);
        }

        @Test
        public void testCreate() {
               Ordenador ordenador = new Ordenador();
                ordenador.setColor(Color.NEGRO);
                ordenador.setTeclas(50);
                ordenador.setIntel(true);
                ordenador.setPeso(200);

                repository.save(ordenador);
                assertTrue(
                                repository
                                                .findById(ordenador.getId())
                                                .isPresent());
        }

        @Test
        public void delete() {
            Ordenador ordenador = new Ordenador();
            ordenador.setColor(Color.NEGRO);
            ordenador.setTeclas(50);
            ordenador.setIntel(true);
            ordenador.setPeso(200);
             repository.save(ordenador);
                assertTrue(
                                repository
                                                .findById(ordenador.getId())
                                                .isPresent());
                repository.deleteById(ordenador.getId());
        }

        @Test
        public void update() {
            Ordenador ordenador = new Ordenador();
            ordenador.setColor(Color.BLANCO);
            ordenador.setTeclas(50);
            ordenador.setIntel(true);
            ordenador.setPeso(200);
             repository.save(ordenador);
                assertTrue(
                                repository
                                                .existsById(ordenador.getId()));
                ordenador.setColor(Color.GRIS);
                repository.save(ordenador);
                Optional<Ordenador> updatedOrdenador = repository.findById(ordenador.getId());
                assertTrue(updatedOrdenador.isPresent());
                assertTrue(updatedOrdenador.get().getColor() == Color.GRIS);
        }

}


