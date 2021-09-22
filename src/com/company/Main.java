package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Kunde k = new Kunde();
        List<Kunde> kundenListe = k.kundenbestandEinlesen("kundenbestand.txt");
        Collections.sort(kundenListe);

        for (Kunde kL: kundenListe) {
            System.out.println(kL);
        }

    }
}
