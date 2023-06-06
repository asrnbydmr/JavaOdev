import java.util.*;

public class Ucak implements IUcak
{
	public String Model = "";
	public String Kod = "";
	public int YolcuKapasitesi = 0;
	public int BYolcuKapasitesi = 0;
	public int EYolcuKapasitesi = 0;
	
	public List<Ucak> YurticiUcakListesi;

	public List<Ucak> YurtdisiUcakListesi;

	private DosyaOkuma DosyaOkuma = new DosyaOkuma();

	public void YurticiUcakListesiTanimla()
	{
	    YurticiUcakListesi = DosyaOkuma.UcakBilgisi("Ucak/yurtici.txt");
	}

	public void YurtdisiUcakListesiTanimla()
	{
	    YurtdisiUcakListesi = DosyaOkuma.UcakBilgisi("Ucak/yurtdisi.txt");
	}
}