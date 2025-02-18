package es.santander.ascender.ejerc003.model;

    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    
    
    @Entity
    public class Boligrafo {
    
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
    
        @Column (name = "color", nullable = false)
        private String color;
    
        @Column (name = "escribe", nullable = false)
        private boolean escribe;
    
        @Column (name = "nombre", nullable = false, unique = true)
        private String nombre;
    
    
    
        public String getColor() {
            return color;
        }
    
        public void setColor(String color) {
            this.color = color;
        }
    
        public boolean isEscribe() {
            return escribe;
        }
    
        public void setEscribe(boolean escribe) {
            this.escribe = escribe;
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
    }
