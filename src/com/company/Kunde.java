package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class Kunde {

    private String name;
    private String vorname;
    private String straße;
    private int hausNr;
    private int plz;
    private String stadt;
    private String telefonNr;
    private String mobilNr;
    private String eMail;

    public Kunde(){

    }

    public Kunde(String name, String vorname, String straße, int hausNr, int plz, String stadt, String telefonNr, String mobilNr, String eMail){

        this.name = name;
        this.vorname = vorname;
        this.straße = straße;
        this.hausNr = hausNr;
        this.plz = plz;
        this.stadt = stadt;
        this.telefonNr = telefonNr;
        this.mobilNr = mobilNr;
        this.eMail = eMail;

    }

    public static List<Kunde> kundenbestandEinlesen (String datei) throws IOException {

        BufferedReader in = null;
        in = new BufferedReader(new FileReader(datei));
        List<Kunde> kunden = new ArrayList<>();
        String read;

        while ((read = in.readLine()) != null){

            String[] attributes = read.split(";");
            Kunde k = createKunde(attributes);
            kunden.add(k);

        }

        in.close();
        return kunden;
    }

    private static Kunde createKunde(String[] metadata) {
        String name = metadata[0];
        String vorname = metadata[1];
        String straße = metadata[2];
        int hausNr = Integer.parseInt(metadata[3]);
        int plz = Integer.parseInt(metadata[4]);
        String stadt = metadata[5];
        String telefonNr = metadata[6];
        String mobilNr = metadata[7];
        String eMail = metadata[8];

        // create and return book of this metadata
        return new Kunde(name, vorname, straße, hausNr, plz, stadt, telefonNr, mobilNr, eMail);
    }

    public String toString() {
        return "Kunde [Name= " + name + ", Vorname= " + vorname + ", Straße= " + straße + "]";
    }

}
