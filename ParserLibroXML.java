package XML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ParserLibroXML extends DefaultHandler
{
	private static  Libro libro;
	private String valor_actual;
	String valor_isbn;
	ArrayList<Libro>lista_libros = new ArrayList<Libro>();
	
	public static HashMap<Integer, Libro> listaLibros (ArrayList<Libro> libros) {
		
		Integer i=0;
		HashMap<Integer, Libro> mapa=new HashMap<Integer,Libro>();
		
		for (Libro libro1 : libros) {
			
		++i;
		mapa.put(i, libro1)	;
		
		}
		
		return mapa;
	}
	
	public static void mostrar(HashMap<Integer, Libro> lista){
	    Integer clave;
	    Iterator<Integer> productos = lista.keySet().iterator();
	    System.out.println("Hay los siguientes libros:");
	    while(productos.hasNext()){
	        clave = productos.next();
	        System.out.println(clave + " - " + lista.get(clave));
	    }        
	}
		
	public static int getNLibros(HashMap<Integer, Libro> lista){
		
		int cantidad = lista.size();
		
		return cantidad;
	}
	
//	
	@Override
	public void startDocument() throws SAXException {
	}
	
	@Override
	public void endDocument() throws SAXException {
		
		listaLibros(lista_libros);
	
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if (localName.equals("libro"))
		{
			valor_isbn = attributes.getValue("isbn");
			libro=new Libro();
			libro.setIsbn(valor_isbn);
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if (localName.equalsIgnoreCase("titulo"))
		{
			libro.setTitulo(valor_actual);
		} else if(localName.equalsIgnoreCase("autor"))
		{
			libro.setAutor(valor_actual);
		} else if (localName.equalsIgnoreCase("anyo"))
		{
			libro.setAnyo(valor_actual);
		} else if (localName.equalsIgnoreCase("editorial"))
		{
			libro.setEditorial(valor_actual);
		}
		
		if(localName.equalsIgnoreCase("libro"))
		lista_libros.add(libro);
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		String str = new String(ch, start, length);
		valor_actual = str;
		
	}
	
}
