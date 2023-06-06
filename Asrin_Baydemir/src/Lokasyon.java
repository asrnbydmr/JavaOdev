import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Lokasyon implements ILokasyon
{
	public static class YHavalimani
	{
	    public String UlkeAdi;
	    public String BolgeAdi;
	    public String HavalimaniAdi;
	}

	public static class YLokasyon
	{
	    public String KalkisYeri;
	    public String VarisYeri;
	    public LocalDate UcusTarihi;
	    public LocalTime UcusSaati;
	}

	private List<YHavalimani> Havalimanlari = new ArrayList<YHavalimani>();
	
	private List<YHavalimani> YurticiUcus = new ArrayList<YHavalimani>();
	
	private List<YHavalimani> YurtdisiUcus = new ArrayList<YHavalimani>();
	
	private ArrayList<String> UlkeListesi = new ArrayList<String>();
	
	private List<YHavalimani> HavalimaniListesi = new ArrayList<YHavalimani>();
	
	private YLokasyon MusteriLokasyon = new YLokasyon();
	
	private DosyaOkuma DosyaOkuma = new DosyaOkuma();
	
	private int Sayac = 1, YSecim = 0, Secim = 0, UlkeSayac = 1;
	
	public int UcusTipi;
	
	Scanner input = new Scanner(System.in);

	private void HavalimaniListesiOlustur()
	{
	    Havalimanlari = DosyaOkuma.HavalimaniBilgisi("Havalimani\\havalimani.txt");
	    
	    for (YHavalimani Havalimani : Havalimanlari)
	    {
	        if (Havalimani.UlkeAdi.equals("Turkiye"))
	            YurticiUcus.add(Havalimani);
	        
	        else
	            YurtdisiUcus.add(Havalimani);
	    }
	}

	public void LokasyonOlustur()
	{
	    HavalimaniListesiOlustur();
	    
	    UcusTipi = UcusTipiBelirle();
	    
	    if (UcusTipi == 1)
	    {
	        MusteriLokasyon.KalkisYeri = KalkisYeriSec(1);
	        MusteriLokasyon.VarisYeri = VarisYeriSec(1, MusteriLokasyon.KalkisYeri);
	    }
	    
	    if (UcusTipi == 2)
	    {
	        MusteriLokasyon.KalkisYeri = KalkisYeriSec(2);
	        MusteriLokasyon.VarisYeri = VarisYeriSec(2, MusteriLokasyon.KalkisYeri);
	    }
	    
	    TarihSecim();
	    
	    SaatSecim();
	}

	private boolean UcusTipiKontrol(int UcusTipi)
	{
	    if (UcusTipi != 1 && UcusTipi != 2)
	        return false;
	    
	    return true;
	}

	private int UcusTipiBelirle()
	{
	    int UcusTipi;
	    
	    while (true)
	    {
	        System.out.println("Ucus Yapmak Icin Ucus Tipi Seciniz: ");
	        System.out.println("1) Yurtici");
	        System.out.println("2) Yurtdisi");
	        System.out.print("Secim: ");
	        
	        UcusTipi = Integer.parseInt(input.nextLine());
	        
	        if (UcusTipiKontrol(UcusTipi))
	            break;
	    }
	    
	    return UcusTipi;
	}

	private void Yurtici(int Kod, String KalkisYeri)
	{	    
	    System.out.print("Yurtici Ucuslar Getiriliyor:");
	    
	    try
	    {
	        Thread.sleep(1000);
	    }
	    catch (InterruptedException e)
	    {
	        e.printStackTrace();
	    }
	    
	    System.out.println();
	    
	    if (Kod == 1)
	    {
	        for (YHavalimani Havalimani : YurticiUcus)
	        {
	            System.out.println(Sayac + ") " + Havalimani.BolgeAdi + " - " + Havalimani.HavalimaniAdi);
	            Sayac++;
	        }
	    }
	    
	    if (Kod == 2)
	    {
	        for (YHavalimani Havalimani : YurticiUcus)
	        {
	            if (Havalimani.HavalimaniAdi.equals(KalkisYeri))
	                YSecim = Sayac;
	            
	            System.out.println(Sayac + ") " + Havalimani.BolgeAdi + " - " + Havalimani.HavalimaniAdi);
	            Sayac++;
	        }
	    }
	}

	private void Yurtdisi(int Kod, String KalkisYeri)
	{
	    String UlkeAdi = "";
	    
	    System.out.print("Yurtdisi Ucuslar Getiriliyor:");
	    
	    try
	    {
	        Thread.sleep(1000);
	    }
	    catch (InterruptedException e)
	    {
	        e.printStackTrace();
	    }
	    
	    System.out.println();
	    
	    UlkeSayac = 1;
	    
	    UlkeListesi.clear();
	    
	    HavalimaniListesi.clear();
	    
	    for (YHavalimani Havalimani : YurtdisiUcus)
	    {
	        if (!UlkeListesi.contains(Havalimani.UlkeAdi))
	        {
	            System.out.println(UlkeSayac + ") " + Havalimani.UlkeAdi);
	            UlkeListesi.add(Havalimani.UlkeAdi);
	            UlkeSayac++;
	        }
	    }
	    
	    while (true)
	    {
	        System.out.print("Ulke Seciniz: ");
	        
	        int UlkeSecim = Integer.parseInt(input.nextLine());
	        
	        if (UlkeSecim > 0 && UlkeSecim < UlkeSayac)
	        {
	            UlkeAdi = UlkeListesi.get(UlkeSecim - 1).toString();
	            System.out.println();
	            
	            break;
	        }
	    }
	    
	    for (YHavalimani Havalimani : Havalimanlari)
	    {
	        if (Havalimani.UlkeAdi.equals(UlkeAdi))
	            HavalimaniListesi.add(Havalimani);
	    }
	    
	    if (Kod == 1)
	    {
	        for (YHavalimani Havalimani : HavalimaniListesi)
	        {
	            System.out.println(Sayac + ") " + Havalimani.BolgeAdi + " - " + Havalimani.HavalimaniAdi);
	            Sayac++;
	        }
	    }
	    
	    if (Kod == 2)
	    {
	        for (YHavalimani Havalimani : HavalimaniListesi)
	        {
	            if (Havalimani.HavalimaniAdi.equals(KalkisYeri))
	                YSecim = Sayac;
	            
	            System.out.println(Sayac + ") " + Havalimani.BolgeAdi + " - " + Havalimani.HavalimaniAdi);
	            Sayac++;
	        }
	    }
	}

	private String KalkisYeriSec(int UcusTipi)
	{
	    String Deger = "";
	    
	    Sayac = 1;
	    
	    if (UcusTipi == 1)
	        Yurtici(1, "");
	    
	    if (UcusTipi == 2)
	        Yurtdisi(1, "");
	    
	    Secim = 0;
	    
	    while (true)
	    {
	        System.out.print("Kalkis Yeri Seciniz: ");
	        
	        Secim = Integer.parseInt(input.nextLine());
	        
	        boolean Kontrol = false;
	        
	        if (UcusTipi == 1)
	        {
	            if (Secim > 0 && Secim < Sayac)
	                Kontrol = true;
	        }
	        
	        if (UcusTipi == 2)
	        {
	            if (Secim > 0 && Secim < Sayac)
	                Kontrol = true;
	        }
	        
	        if (Kontrol)
	        {
	            if (UcusTipi == 1)
	            {
	                Deger = YurticiUcus.get(Secim - 1).HavalimaniAdi;
	                break;
	            }
	            
	            if (UcusTipi == 2)
	            {
	                Deger = HavalimaniListesi.get(Secim - 1).HavalimaniAdi;
	                break;
	            }
	        }
	    }
	    
	    return Deger;
	}

	private String VarisYeriSec(int UcusTipi, String KalkisYeri)
	{
		String Deger = "";
		
	    Sayac = 1;
	    
	    YSecim = 0;
	    
	    if (UcusTipi == 1)
	    {
	        Yurtici(2, KalkisYeri);
	    }
	    
	    if (UcusTipi == 2)
	    {
	        Yurtdisi(2, KalkisYeri);
	    }
	    
	    Secim = 0;
	    
	    while (true)
	    {
	        System.out.print("Varis Yeri Seciniz: ");
	        
	        Secim = Integer.parseInt(input.nextLine());
	        
	        boolean Kontrol = false;
	        
	        if (UcusTipi == 1)
	        {
	            if (Secim > 0 && Secim < Sayac)
	                Kontrol = true;
	        }
	        
	        if (UcusTipi == 2)
	        {
	            if (Secim > 0 && Secim < Sayac)
	                Kontrol = true;
	        }
	        
	        if (Secim != YSecim)
	        {
	            if (Kontrol)
	            {
	                if (UcusTipi == 1)
	                {
	                    Deger = YurticiUcus.get(Secim - 1).HavalimaniAdi;
	                    break;
	                }
	                
	                if (UcusTipi == 2)
	                {
	                    Deger = HavalimaniListesi.get(Secim - 1).HavalimaniAdi;
	                    break;
	                }
	            }
	        }
	        
	        else
	        {
	            System.out.println("Varis Yeri Kalkis Yeri ile Ayni Olamaz.");
	        }
	    }
	    
	    return Deger;
	}
	
	private LocalDate[] TarihOlustur()
	{
	    LocalDate[] Tarihler = new LocalDate[14];
	    
	    int SimdiTarih = LocalDate.now().getYear();
	    
	    Random Random = new Random();
	    
	    for (int i = 0; i < Tarihler.length;)
	    {
	        LocalDate RandomDate = LocalDate.of(Random.nextInt(SimdiTarih + 1 - SimdiTarih) + SimdiTarih, Random.nextInt(12) + 1, Random.nextInt(28) + 1);
	        
	        if (!Arrays.asList(Tarihler).contains(RandomDate) && (RandomDate.getYear() == LocalDate.now().getYear()) && (RandomDate.getMonthValue() > LocalDate.now().getMonthValue()))
	        {
	            Tarihler[i] = RandomDate;
	            i++;
	        }
	    }
	    
	    Arrays.sort(Tarihler);
	    
	    return Tarihler;
	}

	private void TarihSecim()
	{	    
	    System.out.print("Aktif Tarihler Getiriliyor:");
	    
	    try
	    {
	        Thread.sleep(1000);
	    }
	    catch (InterruptedException e)
	    {
	        e.printStackTrace();
	    }
	    
	    System.out.println();
	    
	    LocalDate[] Tarihler = TarihOlustur();
	    
	    int Sayac = 1;
	    
	    for (LocalDate Tarih : Tarihler)
	    {
	        System.out.println(Sayac + ") " + Tarih.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	        Sayac++;
	    }
	    
	    while (true)
	    {
	        System.out.print("Tarih Seciniz: ");
	        
	        int Secim = Integer.parseInt(input.nextLine());
	        
	        if (Secim > 0 && Secim < Sayac)
	        {
	            MusteriLokasyon.UcusTarihi = Tarihler[Secim - 1];
	            break;
	        }
	    }
	}

	private LocalTime[] SaatOlustur()
	{
	    LocalTime[] Saatler = new LocalTime[20];
	    
	    Random Random = new Random();
	    
	    for (int i = 0; i < Saatler.length;)
	    {
	        int[] SecilenDakika = { 0, 30 };
	        int DakikaSayi = Random.nextInt(2);
	        int Saat = Random.nextInt(24);
	        int Dakika = SecilenDakika[DakikaSayi];
	        int Saniye = Random.nextInt(1);
	        
	        LocalTime Zaman = LocalTime.of(Saat, Dakika, Saniye);
	        
	        boolean Kontrol = true;
	        
	        for (LocalTime Nesne : Saatler)
	        {
	            if (Nesne != null && Nesne.getHour() == Saat && Nesne.getMinute() == Dakika)
	                Kontrol = false;
	        }
	        
	        if (Kontrol)
	        {
	            Saatler[i] = Zaman;
	            i++;
	        }
	    }
	    
	    Arrays.sort(Saatler);
	    
	    return Saatler;
	}

	private void SaatSecim()
	{
	    System.out.print("Aktif Saatler Getiriliyor:");
	    
	    try
	    {
	        Thread.sleep(1000);
	    }
	    catch (InterruptedException e)
	    {
	        e.printStackTrace();
	    }
	    
	    System.out.println();
	    
	    LocalTime[] Saatler = SaatOlustur();
	    
	    int Sayac = 1;
	    
	    for (LocalTime Saat : Saatler)
	    {
	        System.out.println(Sayac + ") " + Saat.format(DateTimeFormatter.ofPattern("HH:mm")));
	        Sayac++;
	    }
	    
	    while (true)
	    {
	        System.out.print("Saat Seciniz: ");
	        
	        int Secim = Integer.parseInt(input.nextLine());
	        
	        if (Secim > 0 && Secim < Sayac)
	        {
	            MusteriLokasyon.UcusSaati = Saatler[Secim - 1];
	            break;
	        }
	    }
	}

	public void LokasyonYazdir()
	{
	    System.out.println("Kalkis Yeri: " + MusteriLokasyon.KalkisYeri);
	    System.out.println("Varis Yeri: " + MusteriLokasyon.VarisYeri);
	    System.out.println("Ucus Tarihi: " + MusteriLokasyon.UcusTarihi.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	    System.out.println("Ucus Saati: " + MusteriLokasyon.UcusSaati.format(DateTimeFormatter.ofPattern("HH:mm")));
	}
}