import java.util.*;
import java.time.LocalDate;

public class Musteri implements IMusteri
{
	Scanner input = new Scanner(System.in);
	
	public long TC = 0;
	public String Ad = "";
	public String Soyad = "";
	public short Yas = 0;
	public long Telefon = 0;
	public boolean Cinsiyet = false;
	public boolean Engelli = false;
	public boolean Yasli = false;
		
	public void MusteriOlustur()
	{
		INT64Kontrol("Turkiye Cumhuriyeti Kimlik Numaranizi Giriniz: ", "Turkiye Cumhuriyeti Kimlik Numarasi", 0);
	    System.out.print("Adinizi Giriniz: ");
	    Ad = input.next();
	    System.out.print("Soydinizi Giriniz: ");
	    Soyad = input.next().toUpperCase();
	    INT16Kontrol("Dogum Yilinizi Giriniz: ", "Yas");
	    INT64Kontrol("Telefon Numaranizi Giriniz: ", "Telefon Numarasi", 1);
	    CEKontrol("Cinsiyetinizi Giriniz (e, k): ", 'e', 'k', 0);
	    CEKontrol("Engelli Durumunuzu Giriniz (e, h): ", 'e', 'h', 1);
	    YasliKontrol();
	    MusteriYazdir();
	    MusteriBilgiGuncelle();
	}

	private void INT64Kontrol(String SoruMetin, String HataMetin, int Degisken)
	{
	    String Temp = "";
	    
	    while (true)
	    {
	        System.out.print(SoruMetin);
	        
	        Temp = input.next();
	        
	        try
	        {	            
	            if (Temp.length() != 11)
	            {
	                System.out.println(HataMetin + " 11 Haneden Olusmaktadir.");
	            }
	            else
	            {
	                if (Degisken == 0)
	                {
	                    if (KimlikNoKontrol.KimlikKontrol(Temp))
	                    {
	                        TC = Long.parseLong(Temp);
	                        break;
	                    }
	                    else
	                    {
	                        System.out.println("Gercek T.C. Kimlik Numarasi Giriniz.");
	                    }
	                }
	                
	                if (Degisken == 1)
	                {
	                    Telefon = Long.parseLong(Temp);
	                    break;
	                }
	            }
	        }
	        catch (NumberFormatException e)
	        {
	            System.out.println(HataMetin + " Rakamlardan Olusmaktadir.");
	        }
	    }
	}

	private void INT16Kontrol(String SoruMetin, String HataMetin)
	{
	    String Temp = "";
	    
	    while (true)
	    {
	        System.out.print(SoruMetin);
	        
	        Temp = input.next();
	        
	        try
	        {	            
	            if (!(Short.parseShort(Temp) >= Short.parseShort(String.valueOf(LocalDate.now().getYear() - 100)) && Short.parseShort(Temp) <= Short.parseShort(String.valueOf(LocalDate.now().getYear()))))
	            {
	                System.out.println(HataMetin + " 0 ile 100 Arasinda Olmalidir. Dogum Yilinizi Giriniz.");
	            }
	            else
	            {
	                Yas = Short.parseShort(String.valueOf(Short.parseShort(String.valueOf(LocalDate.now().getYear())) - Short.parseShort(Temp)));
	                break;
	            }
	        }
	        catch (NumberFormatException e)
	        {
	            System.out.println(HataMetin + " Rakamlardan Olusmaktadir.");
	        }
	    }
	}

	private void CEKontrol(String SoruMetin, char Karakter1, char Karakter2, int Degisken)
	{
	    String Temp = "";
	    
	    while (true)
	    {
	        System.out.print(SoruMetin);
	        
	        Temp = input.next().toLowerCase();
	        
	        if (Temp.equals(String.valueOf(Karakter1)))
	        {
	            if (Degisken == 0)
	                Cinsiyet = true;
	            
	            if (Degisken == 1)
	                Engelli = true;
	            
	            break;
	        }
	        else if (Temp.equals(String.valueOf(Karakter2)))
	        {
	            if (Degisken == 0)
	                Cinsiyet = false;
	            
	            if (Degisken == 1)
	                Engelli = false;
	            
	            break;	            
	        }
	        else
	        {
	            System.out.println(Karakter1 + " veya " + Karakter2 + " Seceneklerinden Bir Tanesini Seciniz.");
	        }
	    }
	}

	private void YasliKontrol()
	{
	    if (Yas >= 60 && Yas <= 100)
	        Yasli = true;
	    
	    else
	        Yasli = false;
	}

	public void MusteriYazdir()
	{
	    System.out.println();
	    System.out.println("Turkiye Cumhuriyeti Kimlik Numaraniz: " + TC);
	    System.out.println("Adiniz: " + Ad);
	    System.out.println("Soyadiniz: " + Soyad);
	    System.out.println("Yasiniz: " + Yas);
	    System.out.println("Telefon Numaraniz: 0" + Telefon);
	    String CinsiyetMetin = Cinsiyet ? "Erkek" : "Kadin";
	    System.out.println("Cinsiyetiniz: " + CinsiyetMetin);
	    String EngelliMetin = Engelli ? "Var" : "Yok";
	    System.out.println("Engelli Durumunuz: " + EngelliMetin);
	    System.out.println();
	}

	private void MusteriBilgiGuncelle()
	{		
		String temp = "";
		
	    while (true)
		{
	    	System.out.print("Bilgileri Degistirmek Ister Misiniz? (e, h): ");	    
		    temp = input.next().toLowerCase();
		    
		    if (temp.equals("e"))
		    {
		        MusteriOlustur();
		        break;
		    }
		    else if (temp.equals("h"))
		    {
		    	break;
		    }
		    else
		    {
		        System.out.println("Lutfen 'e' veya 'h' seceneklerinden birini giriniz.");
		    }
		}
	}
}