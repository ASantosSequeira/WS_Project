package main;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.text.Document;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.util.FileManager;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) {
		/*Model model = ModelFactory.createDefaultModel(); 
		InputStream in = FileManager.get().open("OntologiaProjeto.rdf");
		if (in == null) 
			throw new IllegalArgumentException("File: OntologiaProjeto.rdf not found"); 
		model.read(in, null);
		String query = "PREFIX CarOnt:<http://www.w3.org/2002/07/owl#Thing>\nSELECT ?brand {\n?car CarOnt:hasBrand ?brand.\n}";
		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) { 
			ResultSet results = qexec.execSelect();
			System.out.println("ENTREI!");
			for ( ; results.hasNext() ; ){
				System.out.println("ENTREI!");
				QuerySolution soln = results.nextSolution() ;
				System.out.println(soln);
				//RDFNode x = soln.get("x") ; // Get a result variable by name.
				//Resource r = soln.getResource("x") ; // Get a result variable - must be a resource //Literal l = soln.getLiteral("x") ; // Get a result variable - must be a literal System.out.println(x);
			} 
		}
		System.out.print("Teste");
		 */
		try {
			Scanner scanner = new Scanner( new File("OntologiaProjeto.rdf") );
			String text = scanner.useDelimiter("\\A").next();
			scanner.close(); // Put this call in a finally block
			//System.out.println(text);

			String[] lines = text.split("\\r?\\n");
			String StringFinal = "";
			int contador = 0;
			for(String line : lines) {
				System.out.println("--"+contador);
				contador++;
				if(line.contains("</rdf:RDF>")) {

					StringFinal+="\n---------------------------------------\n";
				}
				
				StringFinal+=line+"\n";
				//System.out.println(line);
			}

			FileWriter f2 = new FileWriter("OntologiaProjeto.rdf", false);
			f2.write(StringFinal);
			f2.close();

		}catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}

	}
	
	public void crawler() {
		Document docu = Jsoup.connect("https://www.standvirtual.com/destaques/").get();
		
	}


}
