

import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;





import part1.abstraction.ElementOperation;
import part1.abstraction.FileOperation;
import part5.abstraction.FinalAbstraction;


public class AbstractionOperation {
	
	public static void abstraction(String file, String src, String dst)  throws JDOMException, IOException
	{
		Document document = FileOperation.parseFileXML(file);
		Element racine = document.getRootElement();
		Element process = racine.getChild("process", racine.getNamespace());
		Namespace ns = racine.getNamespace();
		
		int pos = file.indexOf(".bpmn");
		String interm = file.substring(0, pos);
		String fileResult = interm+"_view"+".bpmn";
		
	boolean b = FinalAbstraction.abstractionAndTD(ElementOperation.getElement(src, process),
				ElementOperation.getElement(dst, process), process,racine, ns,
				file, fileResult);
				
	
	
	}
	
	public static boolean verif(String file, String src) throws JDOMException, IOException
	{
		Document document = FileOperation.parseFileXML(file);
		Element racine = document.getRootElement();
		Element process = racine.getChild("process", racine.getNamespace());
		Namespace ns = racine.getNamespace();
		
		boolean b = ElementOperation.getElement(src, process) !=null;
		
		return b;
	}

}
