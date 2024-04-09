package fp.cursos.test;

import java.util.Collection;
import java.util.List;

import java.util.SortedSet;

import fp.cursos.CursoOnLine;
import fp.cursos.FactoriaCursosOnLine;



public class EjercicioComparator {
	
	public static void main(String [] args) {
		
		  List<CursoOnLine> cursos = crearPoolDatos();
		  mostrarCursos(cursos);
		  
	    	
		  //Ordenar la lista de cursos por el criterio de orden natural de los cursos
		  
		  
		  System.out.println("Lista ordenada por orden natural" +"=".repeat(40));
		  mostrarCursos(cursos);
		  //Ordenar la listra de cursos por el criterio de orden natural invertido de los cursos.
		 
		  System.out.println("Lista ordenada por orden natural inverso" +"=".repeat(40));
		  mostrarCursos(cursos);
		 
		  //Ordenar la lista de cursos por número de estudiantes y a igualdad de número de estudiantes por id del curso
		  
		  System.out.println("Lista ordenada por numero de estutiantes y por id" +"=".repeat(40));
		  mostrarCursos(cursos);
		 
		  //Ordenar la lista de cursos por fecha de inicio (de más reciente a más antigua) y a igualdad de fecha por organización
		  
		  System.out.println("Lista ordenada por fecha inicio (de reciente a antigua) y por organización" +"=".repeat(40));
		  mostrarCursos(cursos);
		 
		  //Ordenar la lista de cursos por organización, y a igualdad de organización, por fecha de inicio (de más reciente a más antigua)
		  System.out.println("Lista ordenada por organización, y a igualdad de organización por fecha inicio (de más reciente a más antigua" +"=".repeat(40));
		  mostrarCursos(cursos);
		 
		  //Ordenar la lista de cursos por el número de caracteres del titulo del curso (de mayor a menor)
		  System.out.println("Lista ordenada el número de caracteres del título del curso " +"=".repeat(40));
		  mostrarCursos(cursos);
		  
		  //Cree un SortedSet que use la duración como criterio de ordenación ¿Qué ocurre si añadimos dos cursos que 
		  //tienen la misma duración?
		  SortedSet<CursoOnLine> cursosOrdenados=null;
		  
		  System.out.println("El conjunto de cursos ordenado por duración es");
		  mostrarCursos(cursos);
		  //Sin usar bucle for, devuelve el Curso mejor valorado.
		  CursoOnLine mejorValorado =null;
		  System.out.println("El curso mejor valorado es " + mejorValorado);
	}
	
	private static void mostrarCursos(Collection<CursoOnLine> cursos) {
		int indx=1;
		for (CursoOnLine c: cursos) {
			System.out.println(String.format("\t%d-%s", indx, c));
			indx++;
		}
		
	}

	private static List<CursoOnLine> crearPoolDatos(){
		List<CursoOnLine> cursos = FactoriaCursosOnLine.creaCursos("data/cursos_online.csv");
		System.out.println(String.format("Leídos %d cursos",cursos.size()));
		return cursos;
	}
	
	

}
