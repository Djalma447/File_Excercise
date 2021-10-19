package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file path:");
		String strPath = sc.nextLine();
		File path = new File(strPath);
		boolean out = new File(path.getParent() + "\\out").mkdir();
		System.out.println("Directory created " + out);
		String targetPath = path.getParentFile() + "\\out\\summary.csv";
		List<Product> list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path)); BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath))){
			String line = br.readLine();
			while (line != null) {
				String[] data = line.split(",");
				String name = data[0];
				Double price = Double.parseDouble(data[1]);
				Integer unity = Integer.parseInt(data[2]);
				Product p = new Product(name, price, unity);
				list.add(p);
				line = br.readLine();
			}
			
			for (Product p : list) {
				bw.write(p.getName() + "," + String.format("%.2f", p.total()));
				bw.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
	}
}
