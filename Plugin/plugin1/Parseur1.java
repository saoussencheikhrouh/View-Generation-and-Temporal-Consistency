
public class Parseur1 {
	 
	  static String nomFichier="";
	  static String nomFichierComplet="";
	  static String src="";
	  static String dst="";
	  
	  public static String getSrc() {
		return src;
	}

	public static void setSrc(String src) {
		Parseur1.src = src;
	}

	public static String getDst() {
		return dst;
	}

	public static void setDst(String dst) {
		Parseur1.dst = dst;
	}

	public static String getNomFichierComplet() {
		return nomFichierComplet;
	}

	public static void setNomFichierComplet(String nomFichierComplet) {
		Parseur1.nomFichierComplet = nomFichierComplet;
	}

	public static String getNomFichier()
	  {
	    return nomFichier;
	  }
	  
	  public static void setNomFichier(String nomFichier1)
	  {
		  nomFichier = nomFichier1.substring(0, nomFichier1.indexOf("."));
	  }

}
