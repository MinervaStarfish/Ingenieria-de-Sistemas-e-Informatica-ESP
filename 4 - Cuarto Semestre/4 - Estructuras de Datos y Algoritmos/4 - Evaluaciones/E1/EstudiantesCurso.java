import java.util.ArrayList;

public class EstudiantesCurso {

    public static void main(String[] args) {
        // Prueba unitaria
        Curso curso = new Curso("Curso de Java", "CS101");
        Estudiante estudiante1 = new Estudiante(1, "Juan");
        estudiante1.agregarNota(3.5);
        estudiante1.agregarNota(4.0);
        estudiante1.agregarNota(3.7);
        curso.matricularEstudiante(estudiante1);

        Estudiante estudiante2 = new Estudiante(2, "María");
        estudiante2.agregarNota(4.5);
        estudiante2.agregarNota(3.8);
        estudiante2.agregarNota(4.2);
        curso.matricularEstudiante(estudiante2);

        System.out.println("Nota promedio del curso: " + curso.getNotaPromedioCurso());
    }

    public static class Curso {
        private String nombreCurso;
        private String codigoCurso;
        private ArrayList<Estudiante> estudiantes;
    
        public Curso(String nombreCurso, String codigoCurso) {
            this.nombreCurso = nombreCurso;
            this.codigoCurso = codigoCurso;
            this.estudiantes = new ArrayList<>();
        }
    
        public void matricularEstudiante(Estudiante estudiante) {
            estudiantes.add(estudiante);
        }
    
        public double getNotaPromedioCurso() {
            double sumaNotas = 0;
            for (Estudiante estudiante : estudiantes) {
                sumaNotas += estudiante.getNotaPromedio();
            }
            return sumaNotas / estudiantes.size();
        }
    
        // Otros métodos de acceso y operaciones sobre estudiantes
    
        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Curso curso = (Curso) obj;
            return codigoCurso.equals(curso.codigoCurso);
        }
    
        @Override
        public String toString() {
            return "Curso{" +
                    "nombreCurso='" + nombreCurso + '\'' +
                    ", codigoCurso='" + codigoCurso + '\'' +
                    '}';
        }
    }

    public static class Estudiante {
        private int ID;
        private String nombreEstudiante;
        private ArrayList<Double> notasCurso;
    
        public Estudiante(int ID, String nombreEstudiante) {
            this.ID = ID;
            this.nombreEstudiante = nombreEstudiante;
            this.notasCurso = new ArrayList<>();
        }
    
        public void agregarNota(double nota) {
            notasCurso.add(nota);
        }
    
        public double getNotaPromedio() {
            double sumaNotas = 0;
            for (double nota : notasCurso) {
                sumaNotas += nota;
            }
            return sumaNotas / notasCurso.size();
        }
    
        // Otros métodos de acceso y operaciones sobre las notas
    
        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Estudiante estudiante = (Estudiante) obj;
            return ID == estudiante.ID;
        }
    
        @Override
        public String toString() {
            return "Estudiante{" +
                    "ID=" + ID +
                    ", nombreEstudiante='" + nombreEstudiante + '\'' +
                    '}';
        }
    }
}
