package fp.utiles;


//De utilidad
public class Validators {
	
	public static Boolean sonDigitos(String cad) {
		//Para todo 
		Boolean res =true;
		for (int i = 0;i<cad.length();i++) {
			if (! Character.isDigit(cad.charAt(i))) {
				res =false;
				break;
			}
			
		}
		
		return res;
	}
	
	public static Boolean sonLetras(String cad) {
		//Esquema paratodo
		//Devuelve cierto si todos los caracteres de la cadena son letras
		Boolean res =true;
		for (int i = 0;i<cad.length();i++) {
			if (! Character.isLetter(cad.charAt(i))) {
				res =false;
				break;
			}
			
		}
	
		return res;
	}

}
