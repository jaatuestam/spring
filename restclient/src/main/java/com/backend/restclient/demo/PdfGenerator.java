package com.backend.restclient.demo;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

/*import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.RandomAccessFileOrArray;
import com.lowagie.text.pdf.TextField;*/

public class PdfGenerator {



    public static void main(String[] args) throws Exception {
        PdfGenerator pdfGenerator = new PdfGenerator();
//        createPdf("HelloLetter.pdf", "field", "value");
       //pdfGenerator.generatePdfEmployee();
        pdfGenerator.generatePdfIndependent();
    }

    private void generatePdfEmployee() throws IOException, DocumentException {
        Resource resource = new ClassPathResource("insurances/AsalariadosMod.pdf", getClass().getClassLoader());
        RandomAccessSourceFactory randomAccessSourceFactory = new RandomAccessSourceFactory();
        RandomAccessFileOrArray letter = new RandomAccessFileOrArray(randomAccessSourceFactory.createSource(resource.getInputStream()));
        PdfReader reader = new PdfReader(letter, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfStamper stamper = new PdfStamper(reader, baos);
        AcroFields form = stamper.getAcroFields();
        Set<String> fldNames = form.getFields().keySet();
        form.setField("No de Documento", "1032393128");
        form.setField("E mail", "correo@correo.com");
        form.setField("Dirección de Residencia", "Dirección de Residencia");
        form.setField("No de Identificación", "No de Identificación");
        form.setField("Text9", "9");
        form.setField("Text8", "8");
        form.setField("Text7", "7");
        form.setField("Text3", "3");
        form.setField("Text2", "2");
        form.setField("Text1", "1");
        form.setField("Text5", "5");
        form.setField("Text4", "4");
        form.setField("Text6", "6");
        form.setField("Consecutivo", "0000001");
        form.setField("Nombres y Apellidos DATOS DEL ASEGURADO", "Nombres y Apellidos DATOS DEL ASEGURADO");
        form.setField("Valor del Crédito inicialmente Solicitado", "Valor del Crédito inicialmente Solicitado");
        form.setField("Lugar de Nacimiento", "Lugar de Nacimiento");
        form.setField("Código de la Oficina", "Código de la Oficina");
        form.setField("Teléfono", "Teléfono");
        form.setField("enfermedad que ha padecido Tipo de enfermedad", "enfermedad que ha padecido Tipo de enfermedad");
        form.setField("Valor prima Única", "Valor prima Única");
        form.setField("Ciudad", "Ciudad");
        form.setField("País de Residencia", "País de Residencia");
        form.setField("Departamento", "Departamento");
        form.setField("Nombre del Comercial", "Nombre del Comercial");
        form.setField("Cédula del Comercial", "Cédula del Comercial");
        form.setField("Valor Crédito con Seguro", "Valor Crédito con Seguro");
        form.setField("Nacionalidad", "Nacionalidad");
        form.setField("Nombre de la oficina", "Nombre de la oficina");

        for (String fldName : fldNames) {
          System.out.println( fldName + ": " + form.getField( fldName ) );
        }
        String states[] = form.getAppearanceStates("Check Box11");
        form.setField("Check Box11",states[0]);  //SEXO FEMENINO
        form.setField("Check Box10", states[0]);  //SEXO MASCULINO
        form.setField("Check Box13", states[0]);  //CANAL DE VENTAS UNIDADES
        form.setField("Check Box12", states[0]); //CANAL DE VENTAS GNV
        form.setField("Check Box14", states[0]);  //CANAL DE VENTAS OFICINA
        states = form.getAppearanceStates("IdentificacionPS");
        form.setField("IdentificacionCC", states[0]);  //CANAL DE VENTAS OFICINA
        form.setField("IdentificacionCE", states[0]);  //CANAL DE VENTAS OFICINA
        form.setField("IdentificacionPS", states[0]);  //CANAL DE VENTAS OFICINA

        stamper.setFormFlattening(true);
        stamper.close();

        reader = new PdfReader(baos.toByteArray());
        Document document = new Document();
        PdfCopy writer = new PdfCopy(document, new FileOutputStream("src/main/resources/insurances/tmp/HelloWorldStampCopy.pdf"));
        document.open();
        writer.addPage(writer.getImportedPage(reader, 1));
        writer.addPage(writer.getImportedPage(reader, 2));

        reader = new PdfReader(letter, null);
        baos = new ByteArrayOutputStream();
        stamper = new PdfStamper(reader, baos);
        form = stamper.getAcroFields();
       /* form.setField("No de Documento", "1032393128");
        form.setField("E mail", "correo@correo.com");
        form.setField("Dirección de Residencia", "Dirección de Residencia");
        form.setField("No de Identificación", "No de Identificación");
        form.setField("Text9", "9");
        form.setField("Text8", "8");
        form.setField("Text7", "7");
        form.setField("Text3", "3");
        form.setField("Text2", "2");
        form.setField("Text1", "1");
        form.setField("Text5", "5");
        form.setField("Text4", "4");
        form.setField("Text6", "6");
        form.setField("Check Box11",states[0]);
        form.setField("Check Box10", states[0]);
        form.setField("Check Box13", states[0]);
        form.setField("Check Box12", states[0]);
        form.setField("Check Box14", states[0]);
        form.setField("Nombres y Apellidos DATOS DEL ASEGURADO", "Nombres y Apellidos DATOS DEL ASEGURADO");
        form.setField("Valor del Crédito inicialmente Solicitado", "Valor del Crédito inicialmente Solicitado");
        form.setField("Lugar de Nacimiento", "Lugar de Nacimiento");
        form.setField("Código de la Oficina", "Código de la Oficina");
        form.setField("Teléfono", "Teléfono");
        form.setField("enfermedad que ha padecido Tipo de enfermedad", "enfermedad que ha padecido Tipo de enfermedad");
        form.setField("Valor prima Única", "Valor prima Única");
        form.setField("Ciudad", "Ciudad");
        form.setField("País de Residencia", "País de Residencia");
        form.setField("Departamento", "Departamento");
        form.setField("Nombre del Comercial", "Nombre del Comercial");
        form.setField("Cédula del Comercial", "Cédula del Comercial");
        form.setField("Valor Crédito con Seguro", "Valor Crédito con Seguro");
        form.setField("Nacionalidad", "Nacionalidad");
        form.setField("Nombre de la oficina", "Nombre de la oficina");*/
        /*for (String fldName : fldNames) {
            System.out.println( fldName + ": " + form.getField( fldName ) );
        }*/
        stamper.setFormFlattening(true);
        stamper.close();

        //       reader = new PdfReader(baos.toByteArray());
//        writer.addPage(writer.getImportedPage(reader, 1));
        document.close();
    }

    private  void generatePdfIndependent() throws IOException, DocumentException {
        Resource resource = new ClassPathResource("insurances/IndependientesMod.pdf", getClass().getClassLoader());
        RandomAccessSourceFactory randomAccessSourceFactory = new RandomAccessSourceFactory();
        RandomAccessFileOrArray letter = new RandomAccessFileOrArray(randomAccessSourceFactory.createSource(resource.getInputStream()));
        PdfReader reader = new PdfReader(letter, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfStamper stamper = new PdfStamper(reader, baos);
        AcroFields form = stamper.getAcroFields();
        Set<String> fldNames = form.getFields().keySet();
        form.setField("E mail", "E mail");
        form.setField("No DOCUMENTO DE IDENTIDADRow1", "No DOCUMENTO DE IDENTIDADRow1");
        form.setField("No DOCUMENTO DE IDENTIDADRow2", "No DOCUMENTO DE IDENTIDADRow2");
        form.setField("No DOCUMENTO DE IDENTIDADRow3", "No DOCUMENTO DE IDENTIDADRow3");
        form.setField("No DOCUMENTO DE IDENTIDADRow4", "No DOCUMENTO DE IDENTIDADRow4");
        form.setField("Valor prima Única", "Valor prima Única");
        form.setField("Valor del Crédito inicialmente Solicitado", "Valor del Crédito inicialmente Solicitado");
        form.setField("Lugar de Nacimiento", "Lugar de Nacimiento");
        form.setField("APELLIDOSRow1", "APELLIDOSRow1");
        form.setField("APELLIDOSRow2", "APELLIDOSRow2");
        form.setField("APELLIDOSRow3", "APELLIDOSRow3");
        form.setField("Teléfono", "Teléfono");
        form.setField("APELLIDOSRow4", "APELLIDOSRow4");

        form.setField("Ciudad", "Ciudad");

        form.setField("Text10", "10");
        form.setField("Nacionalidad", "Nacionalidad");
        form.setField("Consecutivo", "0000001");
        form.setField("Nombre de la oficina", "Nombre de la oficina");
        form.setField(" DE PARTICIPACIÓN Row1", " DE PARTICIPACIÓN Row1");
        form.setField(" DE PARTICIPACIÓN Row2", " DE PARTICIPACIÓN Row2");
        form.setField(" DE PARTICIPACIÓN Row3", " DE PARTICIPACIÓN Row3");
        form.setField(" DE PARTICIPACIÓN Row4", " DE PARTICIPACIÓN Row4");
        form.setField("Text9", "9");
        form.setField("Text8", "8");
        form.setField("Text7", "7");
        form.setField("enfermedad que ha padecido Tipo de enfermedad", "enfermedad que ha padecido Tipo de enfermedad");
        form.setField("Text6", "6");
        form.setField("No de Identificación", "No de Identificación");
        form.setField("Text5", "5");
        form.setField("Text4", "4");
        form.setField("Text3", "3");
        form.setField("Nombres y Apellidos DATOS DEL ASEGURADO", "Nombres y Apellidos DATOS DEL ASEGURADO");
        form.setField("Text1", "1");
        form.setField("NOMBRESRow1", "NOMBRESRow1");
        form.setField("NOMBRESRow3", "NOMBRESRow3");
        form.setField("NOMBRESRow2", "NOMBRESRow2");
        form.setField("NOMBRESRow4", "NOMBRESRow4");
        form.setField("Código de la Oficina", "Código de la Oficina");
        form.setField("Dirección de Residencia", "Dirección de Residencia");
        form.setField("País de Residencia", "País de Residencia");
        form.setField("Departamento", "Departamento");
        form.setField("Nombre del Comercial", "Nombre del Comercial");
        form.setField("Cédula del Comercial", "Cédula del Comercial");
        form.setField("Valor Crédito con Seguro", "Valor Crédito con Seguro");
        form.setField("No de Documento", "No de Documento");

        for (String fldName : fldNames) {
            System.out.println( "form.setField(\"" + fldName + "\", \"" + form.getField( fldName )  + "\");");
        }


        String states[] = form.getAppearanceStates("Check Box16");
        form.setField("Check Box11", states[0]);
        form.setField("Check Box13", states[0]);
        form.setField("Check Box12", states[0]);
        form.setField("Check Box15", states[0]);
        form.setField("Check Box14", states[0]);
        form.setField("Check Box17", states[0]);
        form.setField("Check Box16", states[0]);
        form.setField("Check Box18", states[0]);


        stamper.setFormFlattening(true);
        stamper.close();

        reader = new PdfReader(baos.toByteArray());
        Document document = new Document();
        PdfCopy writer = new PdfCopy(document, new FileOutputStream("src/main/resources/insurances/tmp/IndependentCopy.pdf"));
        document.open();
        writer.addPage(writer.getImportedPage(reader, 1));
        writer.addPage(writer.getImportedPage(reader, 2));

        reader = new PdfReader(letter, null) ;
        baos = new ByteArrayOutputStream();
        stamper = new PdfStamper(reader, baos);
        stamper.setFormFlattening(true);
        stamper.close();
        document.close();
    }

    private static void createPdf(String filename, String field, String value) throws Exception {
   /*     Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);

        TextField tf = new TextField(writer, new Rectangle(64, 785, 340, 800), field);
        tf.setFontSize(12);
        tf.setFont(bf);
        tf.setText(value);
        tf.setTextColor(new GrayColor(0.5f));
        writer.addAnnotation(tf.getTextField());
        document.close();*/
    }
}