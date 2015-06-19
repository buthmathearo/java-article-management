package kshrd.miniproject;

import java.util.Collections;
import java.util.List;

public class ArticleView {
	
	private String header;
	private int length = 50;  // Specify the width of display text
	private String[] tableHeader = {"NO", "TITLE", "AUTHOR", "DATE"};
	//private String stringFormat = "|%10s%10s%20s%20s%20s%20s%20s%20s\n";
	private String stringFormat = " | %-14d | %-23s | %-23s | %-22s |%n";
	private int maxRow = 5;

	public ArticleView(String header, int length) {
		this.header = header;
		this.length = length;
	}
	
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String[] getTableHeader() {
		return tableHeader;
	}

	public void setTableHeader(String[] tableHeader) {
		this.tableHeader = tableHeader;
	}

	public String getStringFormat() {
		return stringFormat;
	}

	public void setStringFormat(String stringFormat) {
		this.stringFormat = stringFormat;
	}

	public int getMaxRow() {
		return maxRow;
	}

	public void setMaxRow(int maxRow) {
		this.maxRow = maxRow;
	}

	public void initGui(List<ArticleModel> objList, int maxRow) {
		
		this.maxRow = maxRow;
		
		generateHeader();
		generateTableView(objList, maxRow);
		generatePageNavView();
		generateMenuView();
		
	}
	
	public void generateHeader() {
		
		System.out.println("[-]===========================================================================================[-]");
		System.out.println(" |                                                                                             |");
		System.out.println(" |----------------------------------Korea Software HRD Center----------------------------------|");
		System.out.println(" |                                                                                             |");
		System.out.println("[-]========================================================================================== [-]");
		System.out.println();
		System.out.println("                          * Welcome to Article Management Application *");
		System.out.println("                                   [ Group 2 Phnom Penh Class ]");
		System.out.println();
		
	}
	
	public void generateTableView(List<ArticleModel> objList, int maxRow) {
		
		System.out.println();
		System.out.println();
		System.out.format(" +================+=========================+=========================+========================+%n");
		System.out.printf(" |       ID       |          TITLE          |          AUTHOR         |          DATE          | %n");
		System.out.format(" +================+=========================+=========================+========================+%n");
		
		if ( !objList.isEmpty() ) {
			Collections.sort(objList, Collections.reverseOrder());
			
			int tempMaxRow = maxRow;
			
			if (objList.size() < tempMaxRow) {
				tempMaxRow = objList.size();
			} 
			
			ArticleModel tempObj;
			
			for (int i = 0; i < tempMaxRow; i++) {
				tempObj = objList.get(i);
				//System.out.println(" | " + tempObj.getId());
				System.out.format(stringFormat, tempObj.getId(), tempObj.getTitle(), tempObj.getAuthor(), tempObj.getDate());
				System.out.format(" +----------------+-------------------------+-------------------------+------------------------+%n");
			}
			
			System.out.println();
			
		}
	}
	
	public void generatePageNavView() {
	
		
	}
	
	public void generateMenuView() {
		System.out.println();
		System.out.format(" >>===========================================<MENU>==========================================<<%n");
		System.out.format(" |            1.First              2.Prev             3.Next              4.Last               |%n");
		System.out.format(" |         5.Read     6.Write     7.Search    8.Update      9.Delete      10.SetRow     0.Exit |%n");
		System.out.format(" >>===========================================================================================<<%n");
	}
}

