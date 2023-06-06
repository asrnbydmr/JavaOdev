import java.util.*;

public class Rezervasyon implements IRezervasyon
{
	Scanner input = new Scanner(System.in);
	
	public int BiletNo = 0;
	public Ucak Ucak = new Ucak();
	public Lokasyon Lokasyon = new Lokasyon();
	public Musteri Musteri = new Musteri();
	public int IndirimOrani = 0;
	public int Ucret = 0;
	
	private Random Random = new Random();
	int UcakTipi = 0;

	public void RezervasyonOlustur()
	{
	    BiletNo = Random.nextInt(1000);
	    
	    Musteri = new Musteri();
	    Musteri.MusteriOlustur();
	    
	    Lokasyon = new Lokasyon();
	    Lokasyon.LokasyonOlustur();
	    
	    Ucak = new Ucak();
	    
	    if (Lokasyon.UcusTipi == 1)
	    {
	        UcakTipi = 1;	        
	        Ucak.YurticiUcakListesiTanimla();	        
	        UcakBilgi(Ucak.YurticiUcakListesi);
	    }
	    
	    if (Lokasyon.UcusTipi == 2)
	    {
	        UcakTipi = 2;	        
	        Ucak.YurtdisiUcakListesiTanimla();	        
	        UcakBilgi(Ucak.YurtdisiUcakListesi);
	    }
	}
	
	private void UcakBilgi(List<Ucak> UcusTipi)
	{
	    int UcakIndex = Random.nextInt(UcusTipi.size());
	    
	    Ucak SecilenUcak = UcusTipi.get(UcakIndex);
	    
	    System.out.println("Sinif Secimleri: ");
	    System.out.println("1) Is Sinifi");
	    System.out.println("2) Ekonomi Sinifi");
	    
	    int SınıfSecim;
	    
	    while (true)
	    {
	        System.out.print("Secim Yapiniz: ");
	        SınıfSecim = Integer.parseInt(input.nextLine());
	        
	        if (SınıfSecim > 0 && SınıfSecim < 3)
	            break;
	    }
	    	    
	    int YolcuSayisi = 0;
	    
	    if (SınıfSecim == 1)
	    {
	        YolcuSayisi = SecilenUcak.BYolcuKapasitesi;
	    }
	    
	    if (SınıfSecim == 2)
	    {
	        YolcuSayisi = SecilenUcak.EYolcuKapasitesi;
	    }
	    
	    int Yuzde = Random.nextInt(100);
	    
	    YolcuSayisi -= (YolcuSayisi * Yuzde) / 100;
	    
	    int Sayac = Random.nextInt(1, YolcuSayisi);
	    
	    List<String> BosKoltuklar = new ArrayList<String>();
	    
	    System.out.println("Bos Koltuklar: ");
	    
	    int DonguSayac = 1;
	    
	    for (int i = 1; i <= YolcuSayisi; i = i + Sayac)
	    {
	        System.out.println(DonguSayac + ") K - " + i);
	        DonguSayac++;
	        BosKoltuklar.add("K - " + i);
	    }
	    
	    int KoltukSecim = 0;
	    
	    while (true)
	    {
	        System.out.print("Secim Yapiniz: ");
	        KoltukSecim = Integer.parseInt(input.nextLine());
	        
	        if (KoltukSecim > 0 && KoltukSecim < BosKoltuklar.size() + 1)
	            break;
	    }
	    
	    UcretBelirle();
	    
	    System.out.println(" ~ Musteri Bilgileri ~ ");
	    
	    System.out.println("Turkiye Cumhuriyeti Kimlik Numarasi: " + Musteri.TC);
	    System.out.println("Ad: " + Musteri.Ad);
	    System.out.println("Soyad: " + Musteri.Soyad);
	    System.out.println("Yas: " + Musteri.Yas);
	    System.out.println("Telefon Numarasi: 0" + Musteri.Telefon);
	    String CinsiyetMetin = Musteri.Cinsiyet ? "Erkek" : "Kadin";
	    System.out.println("Cinsiyet: " + CinsiyetMetin);
	    String EngelliMetin = Musteri.Engelli ? "Var" : "Yok";
	    System.out.println("Engelli Durumu: " + EngelliMetin);
	    
	    System.out.println();
	    
	    System.out.println(" ~ Lokasyon Bilgileri ~ ");
	    
	    Lokasyon.LokasyonYazdir();
	    
	    System.out.println();
	    
	    System.out.println(" ~ Rezervayson Bilgileri ~ ");
	    System.out.println("Bilet Numarasi: " + BiletNo);
	    System.out.println("Ucak Kodu: " + SecilenUcak.Kod);
	    System.out.println("Koltuk Numarasi: " + BosKoltuklar.get(KoltukSecim - 1));
	    System.out.println("Ucret: " + Ucret);
	    
	    System.out.println();
	    
	    System.out.print("Iyi Gunler Dileriz.");
	}

	private boolean IndirimKontrol()
	{
	    if ((Musteri.Engelli == true) || (Musteri.Yasli == true))
	        return true;
	    
	    return false;
	}

	private int IndirimBelirle()
	{
	    IndirimOrani = Random.nextInt(100) / 100;
	    
	    int Indirim = Ucret * IndirimOrani;
	    
	    Ucret = Ucret - Indirim;
	    
	    return Ucret;
	}

	private void UcretBelirle()
	{
	    Ucret = Random.nextInt(1000);
	    
	    if (IndirimKontrol())
	        Ucret = IndirimBelirle();
	}
}