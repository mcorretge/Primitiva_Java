import java.time.LocalDateTime;
import java.util.*;

public class Aposta {
	
	private int id;
	private LocalDateTime data;
	private int combinacio;
	private int reintegrament;
	private int complementari;
	

	public Aposta(int id, int combinacio, int reintegrament, int complementari)
	{
		this.id = id;
		this.combinacio = combinacio;
		this.reintegrament = reintegrament;
		this.complementari = complementari;
		data = LocalDateTime.now();
	}

	public int getId()
	{
		return id;
	}
	public String getData()
	{
		return data.toString();
	}
	
	public int haEstatPremiat(int num, int complementari)	// 1 numero premiat
														// 2 numero + complement
														// 3 reintegrament
															// 0 Res
	{	int resultat = 0;
		int reintegrament = calcularReintegrament(num);
		
	if (num == combinacio)
		{
			resultat = 1;
			if (complementari == complementari)
				{
					resultat = 2;
				}
		}
		else
			{
			if (calcularReintegrament(num) == reintegrament)
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

}
