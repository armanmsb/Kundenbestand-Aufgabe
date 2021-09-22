package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Comparable;

public class Kunde implements Comparable<Kunde>{

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

    //Diese Methode list den Kundenbestand aus einer csv Datei (Inhalte getrennt durch Semikolon) ein gibt eine Liste mit Kunden-Objekten zurück.
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

    @Override
    public int compareTo(Kunde o) {
        int firstCmp = this.getName().compareTo(o.getName());
        return firstCmp != 0 ? firstCmp :  this.getVorname().compareTo(o.getVorname());
    }

    //Diese Methode erzeugt Kunden-Objekte
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVorname() {
            return vorname;
        }

        public void setVorname(String vorname) {
            this.vorname = vorname;
        }

        public String getStraße() {
            return straße;
        }

        public void setStraße(String straße) {
            this.straße = straße;
        }

        public int getHausNr() {
            return hausNr;
        }

        public void setHausNr(int hausNr) {
            this.hausNr = hausNr;
        }

        public int getPlz() {
            return plz;
        }

        public void setPlz(int plz) {
            this.plz = plz;
        }

        public String getStadt() {
            return stadt;
        }

        public void setStadt(String stadt) {
            this.stadt = stadt;
        }

        public String getTelefonNr() {
            return telefonNr;
        }

        public void setTelefonNr(String telefonNr) {
            this.telefonNr = telefonNr;
        }

        public String getMobilNr() {
            return mobilNr;
        }

        public void setMobilNr(String mobilNr) {
            this.mobilNr = mobilNr;
        }

        public String geteMail() {
            return eMail;
        }

        public void seteMail(String eMail) {
            this.eMail = eMail;
        }

        public String toString() {
        return "Kunde [Name= " + name + ", Vorname= " + vorname + ", Straße= " + straße + ", Haus Nr= " + hausNr + ", PLZ= " + plz + ", Stadt= " + stadt + ", TelefonNr= " + telefonNr + ", MobilNr= " + mobilNr + ", E-Mail= " + eMail + "]";
        }

}
