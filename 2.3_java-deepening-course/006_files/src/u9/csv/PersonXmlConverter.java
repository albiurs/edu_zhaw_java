package u9.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class PersonXmlConverter {
	
	
	public void writeXmlToFile(List<Person> persons, String fileName) throws IOException {

		Transformer transformer;
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(createPersonXMLDocument(persons));
			
			StreamResult fileStream = new StreamResult(writer);
			transformer.transform(source, fileStream);
			
		} catch (TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}
	}

	public void writeXmlToConsole(List<Person> persons) {

		Transformer transformer;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(createPersonXMLDocument(persons));
			StreamResult console = new StreamResult(System.out);
			transformer.transform(source, console);

			System.out.println("\nXML DOM Created Successfully..");
			
		} catch (TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}
	}

	public Document createPersonXMLDocument(List<Person> persons) {

		Document doc = null;
		try {
			DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder icBuilder=null;
			icBuilder = icFactory.newDocumentBuilder();
			doc = icBuilder.newDocument();
			Element mainRootElement = doc.createElementNS("http://www.zhaw.ch", "Persons");
			doc.appendChild(mainRootElement);

			int id=1;

			for (Person person : persons) {
				mainRootElement.appendChild(createPersonNode(doc, id++, person));
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return doc;
	}

	private  Node createPersonNode(Document doc, Integer id, Person person) {
		Element personNode = doc.createElement("Person");
		personNode.setAttribute("id", id.toString());
		personNode.appendChild(createNodeElement(doc, personNode, "Name", person.getName()));
		personNode.appendChild(createNodeElement(doc, personNode, "Vorname", person.getVorname()));
		personNode.appendChild(createNodeElement(doc, personNode, "Strasse", person.getStrasse()));
		personNode.appendChild(createNodeElement(doc, personNode, "Wohnort", person.getWohnort()));
		return personNode;
	}

	// utility method to create text node
	private  Node createNodeElement(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

}
