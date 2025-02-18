package es.santander.ascender.ejerc003.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ordenador {
 @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
    
        @Column (name = "color", nullable = false)
        private Color color;
    
        @Column (name = "intel", nullable = false)
        private boolean intel;
    
        @Column (name = "teclas", nullable = false)
        private int teclas;

        @Column (name = "peso", nullable = false)
        private double peso;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Color getColor() {
                return color;
        }

        public void setColor(Color color) {
                this.color = color;
        }

        public boolean isIntel() {
                return intel;
        }

        public void setIntel(boolean intel) {
                this.intel = intel;
        }

        public int getTeclas() {
                return teclas;
        }

        public void setTeclas(int teclas) {
                if (teclas < 50 || teclas > 120) {
                        throw new IllegalArgumentException("El número de teclas debe estar entre 50 y 120");
                    }
                this.teclas = teclas;
        }

        public double getPeso() {
                return peso;
        }

        public void setPeso(double peso) {
                if (peso <= 0) {
                        throw new IllegalArgumentException("El peso debe ser mayor que 0");
                    }
                    this.peso = peso;
        }

        
}
