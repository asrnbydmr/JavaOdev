public class KimlikNoKontrol
{
	public static boolean KimlikKontrol(String KimlikNumarası)
	{
	    int[] Hane = new int[11];
	    for (int i = 0; i < 11; i++)
	    {
	        Hane[i] = Integer.parseInt(KimlikNumarası.substring(i, i + 1));
	    }
	    
	    if (Hane[0] == 0)
	    {
	        return false;
	    }

	    int Toplam1 = Hane[0] + Hane[2] + Hane[4] + Hane[6] + Hane[8];

	    int Toplam2 = Hane[1] + Hane[3] + Hane[5] + Hane[7];
	    
	    int Hesap = ((Toplam1 * 7) - Toplam2) % 10;

	    if (Hesap != Hane[9])
	    {
	        return false;
	    }
	    
	    Hesap = (Toplam1 + Toplam2 + Hane[9]) % 10;

	    if (Hesap != Hane[10])
	    {
	        return false;
	    }

	    return true;
	}
}