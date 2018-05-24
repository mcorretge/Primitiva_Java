import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Primitiva {

	private Vector<Aposta> futArray = new Vector <Aposta>();
	private static HashMap<String, Aposta> apostaHashMap = new HashMap<String, Aposta>();
	
	public static String ExtraDades[][] = new String[100][100]; /*//Data*/
	public static int dades[][] = new int[100][100];	/*//[id, combinacio, complementari, reintegro, pagat?]*/
	int contCol=0;
	
	static int contadorApostesFetes = 0;
	private static LocalDate localDate;
	
	public static void main(String[] args) {
		while(true)
		{
			printMenu1();
		}
	//Combinacio combinacio = new Combinacio();	
	
	//System.out.println(combinacio.getNumPremiat()); 	
	
	}
	public static String getData()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "-1";
		}
	}
	public static void printAllData()
	{
		String val = "";
				for(int i=0; i< contadorApostesFetes; i++)
				{
					val += "id: " + dades[i][0] + "\nNum. Premiat: " + dades[i][1] + "\nNum. Complementari: " + dades[i][2] + "\nNum. Reintegrament: " + dades[i][3] + "\nHa estat cobrat?: ";
							if (dades[i][4] == 0)
							{				val += "No";			}
							else {	val += "Si";			}
					val += "\nData: " + ExtraDades[i][0] + "\n\n";
					/*val += ExtraDades[i][0];*/
				}
		System.out.println(val);;
	}
	
	
	public static void printMenu1()
	{
		Combinacio combinacio = new Combinacio();
		System.out.print("/-------------------------------------------------------\\\n"); 
		System.out.println("| 1.- Crear Nova aposta                                 |"); 	
		System.out.println("| 2.- Participar a l'aposta                             |"); 	
		System.out.println("| 3.- Consultar totes les apostes creades               |"); 
		System.out.print("|.......................................................|\n"); 
		System.out.println("| 4.- Convertir el numero premiat en un String ordenat  |"); 
		System.out.print("|.......................................................|\n"); 
		System.out.println("| 5.- Consultar l'identificador de l'ultima aposta      |");
		System.out.println("| 6.- Consultar Numero Premiat                          |"); 
		System.out.println("| 7.- Consultar Numero Complementari                    |"); 
		System.out.println("| 8.- Consultar Numero Reintegrament                    |"); 
		System.out.println("| 9.- Consultar Data de l'ultima aposta                 |"); 
		System.out.println("| 10.- S'ha cobrat l'aposta?                            |"); 
		System.out.println("|   11.- Marcar com a cobrada                           |"); 
		System.out.println("|   12.- Marcar com NO cobrada                          |");  
		System.out.print("|.......................................................|\n"); 
		System.out.println("| 13.- Buscar aposta a traves de ID                     |");
		System.out.print("\\-------------------------------------------------------/\n"); 
		
		String entrada = getData();
		//String menuOption = JOptionPane.showInputDialog("MEnu").toString();
		int valMenuOpt = Integer.parseInt(entrada);
		switch (valMenuOpt) {
		case 1:
			combinacio.generarNovesCombinacions();
			//apostaHashMap.put(String.valueOf(contadorApostesFetes), new Aposta(contadorApostesFetes, combinacio.getNumPremiat(), combinacio.getReintegrament(), combinacio.getComplementari()));
			dades[contadorApostesFetes][0] = contadorApostesFetes;	
			//Combinacio combinacio = new Combinacio();	
			dades[contadorApostesFetes][1] = combinacio.getNumPremiat();
			dades[contadorApostesFetes][2] = combinacio.getComplementari();
			dades[contadorApostesFetes][3] = combinacio.getReintegrament();
			dades[contadorApostesFetes][4] = 0;
			/*
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			
			*/
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			ExtraDades[contadorApostesFetes][0] = dateFormat.format(date); //2016/11/16 12:08:43
			
			contadorApostesFetes++;
			
			
			break;
		

		case 3:
			printAllData();
			break;
			
		case 2:
			
			System.out.print("\tAmb quin numero jugues? -> "); 				
			String numHaComprovar = getData();
			System.out.print("\tQuin complement tens? -> "); 				
			String comlementHaComprovar = getData();

			System.out.print("\n"); 
			switch(combinacio.haEstatPremiat(Integer.parseInt(numHaComprovar), Integer.parseInt(comlementHaComprovar), dades[contadorApostesFetes-1][1], dades[contadorApostesFetes-1][2]))
			{
			case 0:
				System.out.println("No has obtingut cap premi\n"); 	
				break;
			case 1:
				System.out.println("PREMI !!!\nEl numero escollit es el teu, llastima del complement");
				break;
			case 2:
				System.out.println("PREMI !!!\nEl numero escollit i el complement es el teu. FELICITATS :)");
				break;
			case 3:
				System.out.println("Reintegrament encertat, et tornem els diners");
				break;
			
			}
			System.out.print("El numero premiat es:\n\n"); 
			System.out.println("id: " + dades[contadorApostesFetes-1][0] + "\nNum. Premiat: " + dades[contadorApostesFetes-1][1] + "\nNum. Complementari: " + dades[contadorApostesFetes-1][2] + "\nNum. Reintegrament: " + dades[contadorApostesFetes-1][3] + "\nHa estat cobrat?: " + dades[contadorApostesFetes-1][4]);
			break;
		
		case 4:
			System.out.println(combinacio.convert2String(dades[contadorApostesFetes-1][1]));
			break;

		case 5:
			System.out.println("id: " + dades[contadorApostesFetes-1][0]);
			break;
		case 6:
			System.out.println("id: " + dades[contadorApostesFetes-1][0] + "\nNum. Premiat: " + dades[contadorApostesFetes-1][1] );
			break;
		case 7:
			System.out.println("id: " + dades[contadorApostesFetes-1][0] + "\nNum. Complementari: " + dades[contadorApostesFetes-1][2]);
			break;
		case 8:
			System.out.println("id: " + dades[contadorApostesFetes-1][0] + "\nNum. Reintegrament: " + dades[contadorApostesFetes-1][3]);
			break;
		case 9:
			System.out.println("id: " + dades[contadorApostesFetes-1][0] + "\nNum. Data: " + ExtraDades[contadorApostesFetes-1][0]);
			break;
		case 10:
			System.out.print("id: " + dades[contadorApostesFetes-1][0] + "\nNum. Ha estat cobrat?: ");
			if (dades[contadorApostesFetes-1][4] == 0)
			{				System.out.println("No.");			}
			else {	System.out.println("Si.");			}
			break;
		case 11:
			dades[contadorApostesFetes-1][4] = 1;
			System.out.println("Cobrada");
			break;
		case 12:
			dades[contadorApostesFetes-1][4] = 0;
			System.out.println("Pendent de cobrar");
			break;
		case 13:
			System.out.print("\tQuin ID tenia l'aposta que estas buscant? -> "); 				
			int idABuscar = Integer.parseInt(getData());			
			for(int i=0; i< contadorApostesFetes; i++)
			{	String val = Integer.toString(dades[i][0]);
				int val1 = Integer.parseInt(val);
			
				if (val1 == idABuscar)
				{
					System.out.print("id: " + dades[i][0] + "\nNum. Premiat: " + dades[i][1] + "\nNum. Complementari: " + dades[i][2] + "\nNum. Reintegrament: " + dades[i][3] + "\nHa estat cobrat?: ");
					if (dades[contadorApostesFetes-1][4] == 0)
					{				System.out.println("No.");			}
					else {	System.out.println("Si.");			}
					System.out.println(ExtraDades[i][0]);
				}
				
			}
			
			break;
			
					
		default:
			System.out.flush();
			//pintarMenu();
			break;
		}	
	}

}
