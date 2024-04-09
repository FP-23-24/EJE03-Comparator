package fp.cursos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Ficheros;

public class FactoriaCursosOnLine {

	public static CursoOnLine creaCurso(String id, String titulo, String organizacion, LocalDate fechaInicio,
			LocalDate fechaFin, Integer duracion, TipoCertificacion tipoCert, Double valoracion,
			NivelDificultad nivelDificultad, Integer numeroEstudiantes, Boolean gratuito) {
		return new CursoOnLine(id, titulo, organizacion, fechaInicio, fechaFin, duracion, tipoCert, valoracion,
				nivelDificultad, numeroEstudiantes, gratuito);

	}
	
	public static CursoOnLine creaCurso (String cadena) {
		return new CursoOnLine(cadena); 
	}
	
	public static List<CursoOnLine> creaCursos(String filename){
		List<CursoOnLine> res = new ArrayList<>(); 
		String errMsg = String.format(
				"Error leyendo fichero <%s>", filename);
		List<String> lineas = Ficheros.leeFichero(errMsg ,
				filename);
		lineas.remove(0);
		for (String linea:lineas) {
			res.add(creaCurso(linea));
		}
		return res;
	}

}
