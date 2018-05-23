
public class Combinacio {

	private int numPremiat;
	private int reintegrament;
	private int complementari;
	

	public Combinacio()
	{
	}
	
	public void generarNovesCombinacions()
	{
		numPremiat = (int) (Math.random() * 99999);
		reintegrament = numPremiat%10;
		complementari = (int) (Math.random() * 9);
		System.out.println("Noves combinacions Creades !!!");
	}
	
	public int haEstatPremiat(int num, int complement, int numRand, int complementRand)	// 1 numero premiat
																			// 2 numero + complement
																			// 3 reintegrament
																			// 0 Res
	{	int resultat = 0;
		int reintegrament = calcularReintegrament(num);
	
		if (num == numRand)
		{
			resultat = 1;
			if (complement == complementRand)
			{
				resultat = 2;
			}
		}
		else
		{
			if (calcularReintegrament(num) == (numRand%10))
			{
				resultat = 3;
			}
		}
		return resultat;
	}

	public int calcularReintegrament(int num)
	{
		return num%10;
	}
	public int getNumPremiat()
	{
		return (numPremiat);
	}
	public int getReintegrament()
	{
		return (reintegrament);
	}
	public int getComplementari()
	{
		return (complementari);
	}
	
	public String printAllData()
	{
		return ( "Numero premiat: " + numPremiat + "\nReintegrament: " + reintegrament + "\n" + "Complementari: " + complementari);
	}
	
	public String convert2String(int num)
	{
		String numero = Integer.toString(num);
		String resultat = "";
		String resultat_final = "";		
		int cadena[] = new int[5];
		

		resultat_final = numero + " -> ";
		
		// Separar numeros
	    resultat = "";
		for (int i = 0; i < numero.length(); i++){
		    cadena[i] = numero.charAt(i) - 48;
		    resultat += numero.charAt(i) - 48;
		}				
		
		resultat = "";
		for (int i=0; i<5; i++)
	    {	    	resultat += cadena[i];	    }
		// Ordena de menor a major
		int aux;
	    for (int i = 0; i < cadena.length - 1; i++) {
	        for (int x = i + 1; x < cadena.length; x++) {
	            if (cadena[x] < cadena[i]) {
	                aux = cadena[i];
	                cadena[i] = cadena[x];
	                cadena[x] = aux;
	            }
	        }
	    }

	    // passar a String
		resultat = "";
	    for (int i=0; i<5; i++)
	    {
	    	resultat += cadena[i];
	    }
	    
	    resultat_final += resultat + " -> ";
	  
	 // Separar numeros
		for (int i = 0; i < resultat.length(); i++){
		    resultat_final += (resultat.charAt(i) - 48) + " ";
		}		

		return resultat_final;
	}
	
	
}
