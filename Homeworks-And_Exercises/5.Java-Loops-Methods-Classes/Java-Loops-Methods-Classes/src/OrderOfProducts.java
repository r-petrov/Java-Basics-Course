import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Locale;

public class OrderOfProducts {

	public static void main(String[] args) 
			throws FileNotFoundException, IOException, NullPointerException {
		Locale.setDefault(Locale.ROOT);
		
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<String> linesOfProducts = new ArrayList<String>();
		ArrayList<String> linesOfOrders = new ArrayList<String>();
		
		try {
			linesOfProducts = readCollectionFromFile("..\\..\\input.txt");
			
			createCollectionOfProducts(products, linesOfProducts);
			
			linesOfOrders  = readCollectionFromFile("..\\..\\orders.txt");
			
			String totalPriceOfOrdersString = calculateTatalPriceOfOrders(linesOfOrders, products);
			
			writeTotalPriceOfOrdersToFile(totalPriceOfOrdersString,
					"..\\..\\output.txt");
		} catch (FileNotFoundException fex){
			System.err.println("The specified file path does not contains the file with product information.");
		} catch (IOException ioex) {
			System.err.println(ioex.getMessage());
		} catch (NullPointerException npex) {
			System.err.println("The list of products is empty.");
		} 
		
	}

	private static String calculateTatalPriceOfOrders(ArrayList<String> linesOfOrders, 
			ArrayList<Product> products) {
		String nameOfOrder = null;
		BigDecimal totalPriceOfOrders = BigDecimal.ZERO;
		for (String line : linesOfOrders) {
			String[] orderLine = line.split(" ");
			BigDecimal currentOrderQuantity = new BigDecimal(orderLine[0]);
			nameOfOrder = orderLine[1];
			
			for (Product product : products) {
				if (product.getName().equalsIgnoreCase(nameOfOrder)) {
					BigDecimal currentOrderPrice = currentOrderQuantity.multiply(product.getPrice());
					totalPriceOfOrders = totalPriceOfOrders.add(currentOrderPrice);
				}
			}
		}
		String result = totalPriceOfOrders.setScale(1, RoundingMode.CEILING).toString();
		return result;
	}

	private static void createCollectionOfProducts(ArrayList<Product> products,
			ArrayList<String> fileContentLines) {
		for (String line : fileContentLines) {
			Product product = createProduct(line);
			products.add(product);
		}
	}
	
	private static Product createProduct (String productArguments) {
		String[] productFields = productArguments.split(" ");
		String name = productFields[0];
		double priceOfProduct = Double.parseDouble(productFields[1]);
		BigDecimal price = BigDecimal.valueOf(priceOfProduct);
				
		Product product = new Product(name, price);
		return product;
	}
	
	public static void writeTotalPriceOfOrdersToFile(String totalPriceOfOrderString, String outputFileName)
            throws java.io.IOException {

		java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.US_ASCII;
		java.nio.file.Path outputFilePath =	java.nio.file.Paths.get(outputFileName);
		
		java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset);
		
		try  {
			writer.write(totalPriceOfOrderString);
		} catch (IOException ioex) {
			System.err.println(ioex.getMessage());
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	private static ArrayList<String> readCollectionFromFile(String inputFileName)
			throws  IllegalArgumentException, IOException {
		ArrayList<String> inputLines = new ArrayList<String>();
		BufferedReader fileReader = new BufferedReader(new FileReader(inputFileName));
		
		try {
			while (true) {
				String line = fileReader.readLine();
				if (line == null) {
					break;
				}
				
				inputLines.add(line);
			}
		} catch (IllegalArgumentException iarex) {
			System.err.println("Product name should not be empty!");
		} catch (IOException ioex) {
			System.err.println("Error!");
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}
		return inputLines;
	}

}