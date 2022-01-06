/**
 * 
 */
package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.store.utility.NewExcelLibrary;

/**
 * @author Dhananjay
 *
 */
public class DataProviders {
	
	NewExcelLibrary obj = new NewExcelLibrary();
	
	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("Credentials");
		// Total Columns
		int column = obj.getColumnCount("Credentials");
		int actRows = rows - 1;
		System.out.println("row count= "+actRows);

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}

}
