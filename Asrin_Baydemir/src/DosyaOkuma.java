import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DosyaOkuma
{
	public List<Ucak> UcakBilgisi(String DosyaYolu)
	{
		List<Ucak> UcakListe = new ArrayList<Ucak>();
		
		try
		{
		    while (true)
		    {
		        if (new File(DosyaYolu).exists())
		        {
		            String[] Satirlar = Files.readAllLines(Paths.get(DosyaYolu)).toArray(new String[0]);

		            for (int i = 0; i < Satirlar.length; i++)
		            {
		                String[] Veriler = Satirlar[i].split(",");

		                if (Veriler[0] != null && Veriler[1] != null && Veriler[2] != null && Veriler[3] != null && Veriler[4] != null)
		                {
		                    Ucak Ucak = new Ucak();
		                    Ucak.Model = Veriler[0];
		                    Ucak.Kod = Veriler[1];
		                    Ucak.YolcuKapasitesi = Integer.parseInt(Veriler[2]);
		                    Ucak.BYolcuKapasitesi = Integer.parseInt(Veriler[3]);
		                    Ucak.EYolcuKapasitesi = Integer.parseInt(Veriler[4]);
		                    UcakListe.add(Ucak);
		                }
		            }

		            break;
		        }
		        else
		        {
		            VeriOlustur VeriOlustur = new VeriOlustur();
		            VeriOlustur.UcakBelgeOlustur();
		        }
		    }
		}
		catch(Exception e){}
		
		return UcakListe;
	}

	public List<Lokasyon.YHavalimani> HavalimaniBilgisi(String DosyaYolu)
	{
	    List<Lokasyon.YHavalimani> HavalimaniListe = new ArrayList<Lokasyon.YHavalimani>();

	    try
		{
	    	while (true)
		    {
		        if (new File(DosyaYolu).exists())
		        {
		            String[] Satirlar = Files.readAllLines(Paths.get(DosyaYolu)).toArray(new String[0]);

		            for (int i = 0; i < Satirlar.length; i++)
		            {
		                String[] Veriler = Satirlar[i].split(",");

		                if (Veriler[0] != null && Veriler[1] != null && Veriler[2] != null)
		                {
		                    Lokasyon.YHavalimani Havalimani = new Lokasyon.YHavalimani();
		                    Havalimani.UlkeAdi = Veriler[0];
		                    Havalimani.BolgeAdi = Veriler[1];
		                    Havalimani.HavalimaniAdi = Veriler[2];
		                    HavalimaniListe.add(Havalimani);
		                }
		            }

		            break;
		        }
		        else
		        {
		            VeriOlustur VeriOlustur = new VeriOlustur();
		            VeriOlustur.HavalimaniBelgeOlustur();
		        }
		    }
		}
		catch(Exception e){}

	    return HavalimaniListe;
	}
}