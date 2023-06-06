import java.util.Scanner;

public class mainClass
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
	    System.out.println("Ucak Rezervasyon Sistemine Hoc Geldiniz.");

	    Rezervasyon Rezervasyon = new Rezervasyon();
	    Rezervasyon.RezervasyonOlustur();

		input.nextLine();
	}
}