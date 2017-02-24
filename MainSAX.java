package XML;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class MainSAX {

	public static void main(String[] args) throws Throwable{
		
		XMLReader reader = XMLReaderFactory.createXMLReader();
		
		ParserLibroXML parserLibro=null;
		parserLibro= new ParserLibroXML();
		
		reader.setContentHandler(parserLibro);
		
		reader.parse(new InputSource(new FileInputStream("libros.xml")));
		
		ArrayList<Libro>lista = parserLibro.lista_libros;
		
		HashMap<Integer, Libro>listaLibros= parserLibro.listaLibros(lista);
		
		ParserLibroXML.mostrar(listaLibros);
		
		System.out.println("La cantidad de libros son: "+ parserLibro.getNLibros(listaLibros));
	}

}
