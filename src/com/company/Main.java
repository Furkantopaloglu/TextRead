package com.company;
import java.io.*;
import java.util.ArrayList;
public class Main {

    public static int ascii (int value,int indis){ // Create new value
        if (indis==0) indis=1;
        while (indis>value){
            value=value*value;
        }
        value=(value/indis)*2;
        while ( value<32|| value>=126){
            if (value<32) value=value*3;
            if (value>126) value=value/3;
        }
        return value ;
    }

    public static char ascii_to_char(int asci_value){ // New char
        char new_char= (char) asci_value;

        return new_char;
    }

    public static void main(String[] args) throws IOException {
        ArrayList liste=new ArrayList();
        FileReader fr=new FileReader("C:\\Users\\Windows10\\Desktop\\text1.txt");// File read
        BufferedReader oku= new BufferedReader(fr);
        while (true) {
            String yazi = oku.readLine();
            if (yazi == null) {
                break;
            }//
            liste.add(yazi); // yazi add arrayList liste
        }
        File new_txt=new File("C:\\Users\\Windows10\\Desktop\\Newtext1.txt"); //Create new text
        FileWriter dosya_yaz = new FileWriter(new_txt);
        BufferedWriter writer = new BufferedWriter(dosya_yaz); //Writer new to new text
        for (int i=0;i<liste.size();i++){ //Control at works
            String klm= (String) liste.get(i);
            String[] sp=klm.split(" ");//spacing
            for (String j : sp) {// take words
                for (int k=0;k<j.length();k++) {// j strings look at letters
                    char harf=j.charAt(k);
                    int asciii=harf;// letter to ascii
                    int c=ascii(asciii,k);
                    System.out.println(harf+"="+asciii+"=>"+ascii(asciii,k)+"="+ascii_to_char(c));
                    writer.write(ascii_to_char(c));
                }
            }
        }

        writer.close();
     }
}





