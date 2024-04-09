package fp.cursos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import fp.utiles.Checkers;
import fp.utiles.Validators;
public class CursoOnLine implements Comparable<CursoOnLine>{

	private String id;
	private String titulo;
	private String organizacion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Integer duracion;
	private TipoCertificacion tipoCertificacion;
	private Double valoracion;
	private NivelDificultad nivelDificultad;
	private Integer numeroEstudiantes;
	private Boolean gratuito;
	
	//Constantes
	private static final Integer DURACION_MINIMA=1;
	private static final Double VALORACION_MINIMA = 0.0;
	private static final Double VALORACION_MAXIMA = 5.0;
	
	
	//Constructores
	public CursoOnLine(String id,String titulo,
			String organizacion, LocalDate fechaInicio,
			LocalDate fechaFin, Integer duracion,
			TipoCertificacion tipoCert, 
			Double valoracion,
			NivelDificultad nivelDificultad, 
			Integer numeroEstudiantes,
			Boolean gratuito) {
		setId(id);
		this.titulo=titulo;
		this.organizacion= organizacion;
		checkFechas(fechaInicio, fechaFin);
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		//R3
//		checkDuracion(duracion);
//		this.duracion=duracion;
		setDuracion(duracion);
		
		this.tipoCertificacion= tipoCert;
		setValoracion(valoracion);
		this.nivelDificultad = nivelDificultad;
		setNumeroEstudiantes(numeroEstudiantes);
		this.gratuito = gratuito;
	}
	private void setValoracion(Double valoracion) {
		checkValoracion(valoracion);
		this.valoracion=valoracion;
	}
	private void checkId(String id) {
		if (!(id.length()==8 && Validators.sonLetras(id.substring(0,3))
				&& Validators.sonDigitos(id.substring(3)))) {
			throw new IllegalArgumentException("CursoOnLine::Id no tiene un formato válido");
		}
	}

	

	

	
	private void setId(String id) {
		checkId(id);
		this.id = id;
		
	}

	private void checkFechas(LocalDate fechaInicio, LocalDate fechaFin) {
		if (! (fechaFin.isAfter(fechaInicio))) {
			throw new IllegalArgumentException("CursoOnLine:La fecha de fin no es posterior a la de inicio");
		}
		
	}
	private void checkValoracion(Double valoracion) {
		if (! (valoracion>=VALORACION_MINIMA && valoracion<=VALORACION_MAXIMA)) {
			throw new IllegalArgumentException("CursonOnLine::La valoración debe estar entre 0 y 5");
		}
	}
	
	private void checkNumeroEstudiantes(Integer numeroEstudiantes) {
		if (!(numeroEstudiantes>=0)) {
			throw new IllegalArgumentException("CursoOnLine::Numero estudiantes incorrecto");
		}
		
	}
	//Consultores y modificadores
	//R3
	private void checkDuracion(Integer duracion) {
		if (!(duracion >=DURACION_MINIMA)) {
			throw new IllegalArgumentException("CursoOnLine::La duración debe ser superior a "+ DURACION_MINIMA);
		}
	}

	public CursoOnLine (String cad) {
		Checkers.checkNoNull (cad);
		String [] trozos= cad.split(",");
		Checkers.check("Formato no válido", trozos.length == 11);
		String id = trozos[0].trim();
		setId(id);
		this.titulo = trozos[1].trim();
		this.organizacion = trozos[2].trim();
		LocalDate fechaInicio = parseaFecha(trozos[3].trim());
		LocalDate fechaFin = parseaFecha(trozos[4].trim());
		checkFechas(fechaInicio, fechaFin);
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		Integer duracion = Integer.parseInt(trozos[5].trim());
		setDuracion(duracion);
		TipoCertificacion tipoCert = parseaTipoCertificacion(trozos[6].trim());
		this.tipoCertificacion= tipoCert;
		Double valoracion = Double.parseDouble(trozos[7].trim());
		setValoracion(valoracion);
		NivelDificultad dificultad = parseaNivelDificutad(trozos[8].trim());
		this.nivelDificultad = dificultad;
		Integer numEstudiantes = Integer.parseInt(trozos[9].trim());
		setNumeroEstudiantes(numEstudiantes);
		Boolean gratuito = Boolean.parseBoolean(trozos[10].trim());
		setGratuito(gratuito);
	}
	
	private void setNumeroEstudiantes(Integer numEstudiantes) {
		checkNumeroEstudiantes(numEstudiantes);
		this.numeroEstudiantes= numEstudiantes;		
	}
	private NivelDificultad parseaNivelDificutad(String strDificultad) {
		return NivelDificultad.valueOf(strDificultad.toUpperCase());
	}
	private TipoCertificacion parseaTipoCertificacion(String strTipoCertificacion) {
		String cad = strTipoCertificacion.toUpperCase()
										 .replace(" ", "_");
		return TipoCertificacion.valueOf(cad);
	}
	private LocalDate parseaFecha(String strFecha) {
		return LocalDate.parse(strFecha,
						 DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		checkFechas(fechaInicio, getFechaFin());
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		checkFechas(getFechaInicio(), fechaFin);
		this.fechaFin = fechaFin;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		checkDuracion(duracion);
		this.duracion = duracion;
	}

	public Boolean getGratuito() {
		return gratuito;
	}

	public void setGratuito(Boolean gratuito) {
		this.gratuito = gratuito;
	}

	public String getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getOrganizacion() {
		return organizacion;
	}

	public TipoCertificacion getTipoCertificacion() {
		return tipoCertificacion;
	}

	public Double getValoracion() {
		return valoracion;
	}

	public NivelDificultad getNivelDificultad() {
		return nivelDificultad;
	}

	public Integer getNumeroEstudiantes() {
		return numeroEstudiantes;
	}
	
	//Propiedades derivadas
	public Double getMediaHorasSemanales() {
		Long numSemanas = ChronoUnit.WEEKS.between(
				           getFechaInicio(), getFechaFin());
		return getDuracion()*1.0/numSemanas;
	}
	
	public EstadoCurso getEstadoCurso() {
		EstadoCurso res = null;
		LocalDate hoy = LocalDate.now();
		if (getFechaFin().isBefore(hoy)) { //El curso ha acabado
			res = EstadoCurso.FINALIZADO;
		}else if(getFechaInicio().isAfter(hoy)) {//El curso no ha empezado
			res= EstadoCurso.PROXIMO;
		}else {
			res = EstadoCurso.EN_CURSO;
		}
		return res;
	}

	@Override
	public String toString() {
		return "CursoOnLine [getFechaInicio()=" + getFechaInicio() + ", getFechaFin()=" + getFechaFin()
				+ ", getDuracion()=" + getDuracion() + ", getGratuito()=" + getGratuito() + ", getId()=" + getId()
				+ ", getTitulo()=" + getTitulo() + ", getOrganizacion()=" + getOrganizacion()
				+ ", getTipoCertificacion()=" + getTipoCertificacion() + ", getValoracion()=" + getValoracion()
				+ ", getNivelDificultad()=" + getNivelDificultad() + ", getNumeroEstudiantes()="
				+ getNumeroEstudiantes() + ", getMediaHorasSemanales()=" + getMediaHorasSemanales()
				+ ", getEstadoCurso()=" + getEstadoCurso() + "]";
	}
	
	//Criterio de igualdad
	public boolean equals(Object obj) {
		boolean res = false;
			if (obj instanceof CursoOnLine) {
				CursoOnLine c = (CursoOnLine) obj;
				res = this.getId().equals(c.getId());
			}
		
		return res;
	}
	
	public int hashCode() {
		return this.getId().hashCode();
	}
	@Override
	public int compareTo(CursoOnLine c) {
		int res = getTitulo().compareTo(c.getTitulo());
		if (res == 0) {
			res = getId().compareTo(getId());
		}
		return res;
	}

	
	
}
