# Java Uçak Rezervasyon Sistemi Konsol Uygulamlası

Bu örnek basit bir uçak rezervayon sistemi örneğidir. Uygulamanın çalışması için 2 dosya ve 3 belge gereklidir. Bu dosyalar ve belgeler otomatik olarak oluşturulmaktadır.

### Uygulama Klasör Yapısı
* Havalimani ve Ucak adlı klasör programın içerisinde oluşturulmaktadır.

##### Havalimani
* Havalimani adlı klasörün içerisinde havalimani.txt adlı belge bulunmaktadır. Bu belgenin içeriği havalimanı bilgilerini (ülke, şehir, havalimanı adı) tutmaktır.

##### Ucak
* Ucak adlı klasörün içerisinde yurtici.txt ve yurtdisi.txt adlı belge bulunmaktadır. Bu belgelerin içeriği yurtiçi ve yurtdışı uçuşu yapan uçakların bilgilerini tutmaktır.

### Uygulamada Bulunan Interfaceler
* ILokasyon => Lokasyon sınıfının kullanacağı metodu içerir.
* IMusteri => Musteri sınıfının kullanacağı alanları içerir.
* IRezervasyon => Rezervasyon sınıfının kullanacağı alanları içerir.
* IUcak => Ucak sınıfının kullanacağı alanları içerir.

#### ILokasyon
* void LokasyonOlustur()

#### IMusteri
* long TC
* String Ad
* String Soyad
* short Yas
* long Telefon
* Boolean Cinsiyet
* Boolean Yasli
* Boolean Engelli

#### IRezervasyon
* int BiletNo
* Ucak Ucak
* Lokasyon Lokasyon
* Musteri Musteri
* int IndirimOrani
* int Ucret

#### IUcak
* String Model
* String Kod
* int YolcuKapasitesi
* int BYolcuKapasitesi
* int EYolcuKapasitesi

### Uygulamada Bulunan Sınıflar
* DosyaOkuma => Belge içeriğini okumak için gerekli metodları içerir.
* KimlikNoKontrol => Türkiye Cumhuriyeti Kimlik Numarasının gerçek olup olmadığını kontrol etmek için gerekli metodu içerir.
* Lokasyon => Program yükünün en çok üstüne olduğu sınıftır. Lokasyon bilgileri ile ilgili alanları ve bu alanlara girilen verilerin kontrol edilmesini sağlayan metodları içerir.
* mainClass => Programın asıl sınıfıdır. Main metodu dışında bir metod ve alan içermez.
* Musteri => Müşteri bilgileri ile ilgili alanları ve bu alanlara girilen verilerin kontrol edilmesini sağlayan metodları içerir.
* Rezervasyon => Rezervasyon bilgileri ile ilgili alanları ve bu alanlara girilen verilerin kontrol edilmesini, ücret bilgisinin oluşturulmasını sağlayan metodları içerir.
* Ucak => Uçak bilgileri ile ilgili alanları ve bu alanlar içerisinde bulunan listelere veri doldurulması için gerekli metodları içerir.
* VeriOlustur => Programın çalışması için gerekli olan dosyaları ve dosyaların içerisinde bulunan belgeleri oluşturmaya ve bu belgelere veri eklenmesi için gerekli metodları içerir.

#### DosyaOkuma
* public List<Ucak> UcakBilgisi(String DosyaYolu)
* public List<Lokasyon.YHavalimani> HavalimaniBilgisi(String DosyaYolu)

#### KimlikNoKontrol
* public static boolean KimlikKontrol(String KimlikNumarası)

#### Lokasyon
* public static class YHavalimani { public String UlkeAdi; public String BolgeAdi; public String HavalimaniAdi; }
* public static class YLokasyon { public String KalkisYeri; public String VarisYeri; public LocalDate UcusTarihi; public LocalTime UcusSaati; }
* private List<YHavalimani> Havalimanlari = new ArrayList<YHavalimani>();
* private List<YHavalimani> YurticiUcus = new ArrayList<YHavalimani>();
* private List<YHavalimani> YurtdisiUcus = new ArrayList<YHavalimani>();
* private ArrayList<String> UlkeListesi = new ArrayList<String>();
* private List<YHavalimani> HavalimaniListesi = new ArrayList<YHavalimani>();
* private YLokasyon MusteriLokasyon = new YLokasyon();
* private DosyaOkuma DosyaOkuma = new DosyaOkuma();
* private int Sayac = 1, YSecim = 0, Secim = 0, UlkeSayac = 1;
* public int UcusTipi;
* private void HavalimaniListesiOlustur()
* public void LokasyonOlustur()
* private boolean UcusTipiKontrol(int UcusTipi)
* private int UcusTipiBelirle()
* private void Yurtici(int Kod, String KalkisYeri)
* private void Yurtdisi(int Kod, String KalkisYeri)
* private String KalkisYeriSec(int UcusTipi)
* private String VarisYeriSec(int UcusTipi, String KalkisYeri)
* private LocalDate[] TarihOlustur()
* private void TarihSecim()
* private LocalTime[] SaatOlustur()
* private void SaatSecim()
* public void LokasyonYazdir()

#### mainClass
* System.out.println("Ucak Rezervasyon Sistemine Hoc Geldiniz.");
* Rezervasyon Rezervasyon = new Rezervasyon();
* Rezervasyon.RezervasyonOlustur();

#### Musteri
* public long TC
* public String Ad
* public String Soyad
* public short Yas
* public long Telefon
* public boolean Cinsiyet
* public boolean Engelli
* public boolean Yasli
* public void MusteriOlustur()
* private void INT64Kontrol(String SoruMetin, String HataMetin, int Degisken)
* private void INT16Kontrol(String SoruMetin, String HataMetin)
* private void CEKontrol(String SoruMetin, char Karakter1, char Karakter2, int Degisken)
* private void YasliKontrol()
* public void MusteriYazdir()
* private void MusteriBilgiGuncelle()

#### Rezervasyon
* public int BiletNo
* public Ucak Ucak
* public Lokasyon Lokasyon
* public Musteri Musteri
* public int IndirimOrani
* public int Ucret
* private Random Random = new Random();
* int UcakTipi;
* public void RezervasyonOlustur()
* private void UcakBilgi(List<Ucak> UcusTipi)
* private boolean IndirimKontrol()
* private int IndirimBelirle()
* private void UcretBelirle()

#### Ucak
* public String Model
* public String Kod
* public int YolcuKapasitesi
* public int BYolcuKapasitesi
* public int EYolcuKapasitesi
* public List<Ucak> YurticiUcakListesi;
* public List<Ucak> YurtdisiUcakListesi;
* private DosyaOkuma DosyaOkuma = new DosyaOkuma();
* public void YurticiUcakListesiTanimla()
* public void YurtdisiUcakListesiTanimla()

#### VeriOlustur
* private String[] Yurtici = new String[4];
* private String[] Yurtdisi = new String[5];
* private String[] Havalimani = new String[1279];
* private void DosyaOlustur(String DosyaAdi)
* private void BelgeOlustur(String DosyaAdi, String BelgeAdi, String[] Satirlar)
* private void YurticiEkle()
* private void YurtdisiEkle()
* private void HavalimaniEkle()
* public void UcakBelgeOlustur()
* public void HavalimaniBelgeOlustur()