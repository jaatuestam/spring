package com.example.pdfcreator;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class EncryptPdfWithoutUserPassword {

    public static final String SRC = "src/main/resources/insurances/FGA_POLICY.pdf";
    public static final String DEST = String.format("%s%s.pdf", "src/main/resources/insurances/tmp/", UUID.randomUUID());

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new EncryptPdfWithoutUserPassword().manipulatePdf(SRC, DEST);
    }

    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        RandomAccessFileOrArray letter = new RandomAccessFileOrArray(SRC);
        PdfReader reader = new PdfReader(letter, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfStamper stamper = new PdfStamper(reader, baos);
        stamper.setEncryption("1032393128".getBytes(), null,
                PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
        AcroFields form = stamper.getAcroFields();
        form.setField( "sign_phone" , "3173736412");
        form.setField( "sign_name" , "nombre de firma");
        form.setField( "month" , "09");
        form.setField( "sign_address" , "CR 36 17 333");
        form.setField( "year" , "2019");
        form.setField( "name" , "Prueba de Ñombre normál");
        form.setField( "day" , "12");
        form.setField( "sign_email" , "correodeprueba@prueba.com");
        form.setField( "sign_identification" , "1239898789");
        form.setField( "sign_time" , "Hora: 12:23:43");
        form.setField( "sign_date" , "Fecha : wafdfdsfs");
        form.setField( "sign_ip" , "ip:123.232.434.54");
        stamper.close();
        reader.close();


        FileOutputStream fileOutputStream = new FileOutputStream(dest);
        fileOutputStream.write(baos.toByteArray());
    }
}