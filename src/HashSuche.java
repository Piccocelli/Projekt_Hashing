public class HashSuche
{
    private static int[] schluessel;
    private static double[] werte;
    private static int mod;

    public static void HashSuche(int pMod)
    {
        schluessel = new int[pMod];
        werte = new double[pMod];
        mod = pMod;
    }

    public static int berechneHash(int pSchluessel)
    {
        return pSchluessel % mod;
    }

    public static int fuegeEin(int pSchluessel, double pWert)
    {
        int anzahl = 0;

        for (int i=berechneHash(pSchluessel); i<schluessel.length; i++)
        {
            if (schluessel[i]==0)
            {
                schluessel[i] = pSchluessel;
                werte[i] = pWert;
                return anzahl;
            }
            anzahl++;
        }
        for (int i=0; i<berechneHash(pSchluessel); i++)
        {
            if (schluessel[i] == 0)
            {
                schluessel[i] = pSchluessel;
                werte[i] = pWert;
                return anzahl;
            }
            anzahl++;
        }
        return -1;
    }

    public static int suchePositionVon(int pSchluessel)
    {
        for (int i=berechneHash(pSchluessel); i<schluessel.length; i++)
        {
            if (schluessel[i]==pSchluessel)
                return i;
        }
        for (int i=0; i<berechneHash(pSchluessel); i++)
        {
            if (schluessel[i]==pSchluessel)
                return i;
        }
        return -1;
    }

    public static int fuegeEin(int pSchluessel)
    {
        int anzahl = 0;

        for (int i=berechneHash(pSchluessel); i<schluessel.length; i++)
        {
            if (schluessel[i]==0)
            {
                schluessel[i] = pSchluessel;
                return anzahl;
            }
            anzahl++;
        }
        for (int i=0; i<berechneHash(pSchluessel); i++)
        {
            if (schluessel[i] == 0)
            {
                schluessel[i] = pSchluessel;
                return anzahl;
            }
            anzahl++;
        }
        return -1;
    }

    public static int[] gibSchluessel()
    {
        return schluessel;
    }

    public static double[] gibWerte()
    {
        return werte;
    }

    public static double gibWertVon(int pGeburtsdatum)
    {
        int position = 0;
        boolean gefunden = false;
        for (int i=berechneHash(pGeburtsdatum); i<schluessel.length; i++)
        {
            if (schluessel[i]==pGeburtsdatum)
            {
                position = i;
                gefunden = true;
            }
        }
        if (gefunden == false)
        {
            for (int i=0; i<berechneHash(pGeburtsdatum); i++)
            {
                if (schluessel[i]==pGeburtsdatum)
                {
                    position = i;
                    gefunden = true;
                }
            }
        }
        else if (gefunden == true)
        {
            return werte[position];
        }
        else
        {
            return -1;
        }
        return -2;
    }
}