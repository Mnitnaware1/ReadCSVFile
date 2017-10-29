package eew.rtmnu.readcsv.ReadCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import eew.rtmnu.readcsv.model.Element;

public class ReadElementCSV {
	static Logger logger = Logger.getLogger(ReadElementCSV.class.getName());

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println("Before : " + startTime);
		// long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);

		// read csv
		List<Element> objectList = readCSV();
		// filter
		Scanner scanner = new Scanner(System.in);
		String elementType = scanner.next();
		// System.out.println(objectList);
		getObjectReviewCount(objectList, elementType);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("After : " + totalTime);// 0 mins
	}

	private static void getObjectReviewCount(List<Element> objectList, String elementType) {
		System.out.println(elementType);
		// TODO Auto-generated method stub
		Map<String, Integer> count = new HashMap<String, Integer>();
		// Map<String, Integer> reviewCount = new HashMap<String, Integer>();
		String reviewType;
		for (Element element : objectList) {
			String elementName = element.getElementName().replaceAll("^\"|\"$", "");
			if (elementName.equals(elementType)) {// hard coded
				reviewType = element.getElementReview().replaceAll("^\"|\"$", "");
				if (!count.containsKey(reviewType)) {
					count.put(reviewType, 1);
				} else {
					count.put(reviewType, count.get(reviewType) + 1);
				}
			}
		}
		System.err.println(count);
	}

	private static List<Element> readCSV() {
		// TODO Auto-generated method stub
		List<Element> objectList = new ArrayList<Element>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("D:/Users/VT/Desktop/file reader/corpus.csv"));
			// read file line by line
			String line = null;
			Scanner scanner = null;
			int index = 0;

			while ((line = reader.readLine()) != null) {
				Element ele = new Element();
				scanner = new Scanner(line);
				scanner.useDelimiter(",");
				while (scanner.hasNext()) {
					String data = scanner.next();
					if (index == 0)
						ele.setElementName(data);
					else if (index == 1)
						ele.setElementReview(data);
					else if (index == 2)
						ele.setElementWeightage(data);
					else
						System.out.println("invalid data::" + data);
					index++;
				}
				index = 0;
				objectList.add(ele);
			}
			// close reader
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.info("File not found");
			// e.printStackTrace();
		} catch (IOException e) {
			logger.info("File not found");
			// e.printStackTrace();
		}
		return objectList;
	}
}
