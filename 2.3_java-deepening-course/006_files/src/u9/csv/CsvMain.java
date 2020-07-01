package u9.csv;

import java.io.IOException;
import java.util.List;

public class CsvMain {

	public static void main (String[] args){
		PersonCsvConverter pcc = new PersonCsvConverter();
		try {
			List<Person> persons = pcc.readPersonFile("src/u9/csv/personen.csv", ";");
			printPerson (persons);
			pcc.writePersonFile(persons, "src/u9/csv/personen2.csv", ";");
			
			// write XML to Console and to file
			PersonXmlConverter pxc = new PersonXmlConverter();
			pxc.writeXmlToConsole(persons);
			pxc.writeXmlToFile(persons, "src/u9/csv/personen2.xml");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printPerson(List<Person> persons) {
		for (Person person : persons)
			System.out.println(person.print());
	}

}
