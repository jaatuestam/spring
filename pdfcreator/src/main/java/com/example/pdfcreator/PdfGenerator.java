package com.example.pdfcreator;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.UUID;


public class PdfGenerator {

    private RandomAccessFileOrArray letter;
    private PdfReader reader;
    private ByteArrayOutputStream baos;
    private PdfStamper stamper;


    public static void main(String[] args) throws Exception {
        PdfGenerator pdfGenerator = new PdfGenerator();
//        createPdf("HelloLetter.pdf", "field", "value");
//        pdfGenerator.generatePdfEmployee();
        pdfGenerator.testNewPdf();
        System.out.println(".............-------·······........");
       //pdfGenerator.generatePdfIndependent();
    }

    private void testNewPdf() throws Exception {
        AcroFields form = getFields("insurances/FGA_POLICY.pdf");
        mapTestNewPdf(form);
        System.out.println(generateFile(UUID.randomUUID().toString()));
    }

    public  void createPdf(){
        try {
            String userPassword = "user123";
            String ownerPassword = "owner123";

            //Create Document instance.
            Document document = new Document();

            //Create OutputStream instance.
            OutputStream outputStream =
                    new FileOutputStream(new File("D:\\TestPasswordFile.pdf"));

            //Create PDFWriter instance.
            PdfWriter pdfWriter =
                    PdfWriter.getInstance(document, outputStream);

            //Add password protection.
            pdfWriter.setEncryption(userPassword.getBytes(),
                    ownerPassword.getBytes(),
                    PdfWriter.ALLOW_PRINTING,
                    PdfWriter.ENCRYPTION_AES_256);

            //Open the document.
            document.open();

            //Add content to the document.
            document.add(new Paragraph("Hello world, this is a " +
                    "test pdf file with password protection."));

            //Close document and outputStream.
            document.close();
            outputStream.close();

            System.out.println("Pdf created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mapTestNewPdf(AcroFields form) throws IOException, DocumentException {
        Set<String> fldNames = form.getFields().keySet();
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
        for (String fldName : fldNames) {
            System.out.println("form.setField( \"" + fldName + "\" , \"" + fldName +"\");");
        }
    }

    private void generatePdfEmployee() throws Exception {
       /* Resource resource = new ClassPathResource("insurances/653 Solicitud de seguro.pdf", getClass().getClassLoader());
        RandomAccessSourceFactory randomAccessSourceFactory = new RandomAccessSourceFactory();
        RandomAccessFileOrArray letter = new RandomAccessFileOrArray(randomAccessSourceFactory.createSource(resource.getInputStream()));
        PdfReader reader = new PdfReader(letter, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfStamper stamper = new PdfStamper(reader, baos);*/
        AcroFields form = getFields("insurances/653 Solicitud de seguro.pdf");
        mapEmployeeFields(form);
        System.out.println(generateFile(UUID.randomUUID().toString()));
       /* Set<String> fldNames = form.getFields().keySet();
        form.setField( "BIRTH_DAY2" , "5");
        form.setField( "NATIONALITY" , "Colombiano");
        form.setField( "NAMES" , "Jorge Andres Atuesta Maestre");
        form.setField( "BIRTH_DAY1" , "0");
        form.setField( "DEPARTAMENT" , "Bogota");
        form.setField( "INITIAL_CREDIT_AMOUNT" , "2500000");
        form.setField( "PHONE" , "5647783");
        form.setField( "RESIDENCE_COUNTRY" , "Colombia");
        form.setField( "SOL_YEAR" , "2019");
        form.setField( "BIRTH_MONTH2" , "8");
        form.setField( "MAIL" , "jatuest@bancodebogota.com.co");
        form.setField( "SOL_MONTH" , "07");
        form.setField( "BIRTH_MONTH1" , "0");
        form.setField( "CONSECUTIVE_NUMBER" , "0000001");
        form.setField( "OFFICE_NAME" , "OFICINA PRINCIPAL");
        form.setField( "IDENTIFICATION_NUMBER_SIGN" , "1032393128");
        form.setField( "SOL_DAY" , "23");
        form.setField( "SELLER_IDENTIFICATION" , "1098468987");
        form.setField( "CREDIT_AND_INSURANCE_AMOUNT" , "3000000");
        form.setField( "BIRTH_YEAR" , "1987");
        form.setField( "RESIDENCE_ADDRESS" , "Carrera 36 # 17-333 Torre 1 Apartamento 504");
        form.setField( "BIRTHPLACE" , "Bogota");
        form.setField( "INSURANCE_AMOUNT" , "500000");
        form.setField( "CITY" , "Bogota");
        form.setField( "SELLER_NAME" , "Npmbre del vendedor");
        form.setField( "IDENTIFICATION_NUMBER" , "1032393128");
        form.setField( "OFFICE_CODE" , "00000");

        for (String fldName : fldNames) {
            System.out.println("form.setField( \"" + fldName + "\" , \"" + fldName +"\");");
        }
       String states[] = form.getAppearanceStates("MALE");
        form.setField( "IDENTIFICATION_CE" , states[0]);
        form.setField( "IDENTIFICATION_PS" , states[0]);
        form.setField( "IDENTIFICATION_CC" , states[0]);
        form.setField( "FEMALE" , states[0]);
        form.setField( "MALE" , states[0]);
        form.setField( "GNV_SALE" , states[0]);
        form.setField( "UNIT_SALE" , states[0]);
        form.setField( "OFFICE_SALE" , states[0]);*/

      /*  stamper.setFormFlattening(true);
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
       // stamper.setFormFlattening(true);
     //   stamper.close();

        //       reader = new PdfReader(baos.toByteArray());
//        writer.addPage(writer.getImportedPage(reader, 1));
      //  document.close();
    }

    private void mapEmployeeFields(AcroFields form) throws IOException, DocumentException {
        Set<String> fldNames = form.getFields().keySet();
        form.setField( "BIRTH_DAY2" , "5");
        form.setField( "NATIONALITY" , "Colombiano");
        form.setField( "NAMES" , "Jorge Andres Atuesta Maestre");
        form.setField( "BIRTH_DAY1" , "0");
        form.setField( "DEPARTAMENT" , "Bogota");
        form.setField( "INITIAL_CREDIT_AMOUNT" , "2500000");
        form.setField( "PHONE" , "5647783");
        form.setField( "RESIDENCE_COUNTRY" , "Colombia");
        form.setField( "SOL_YEAR" , "2019");
        form.setField( "BIRTH_MONTH2" , "8");
        form.setField( "MAIL" , "micorreo@bancodebogota.com.co");
        form.setField( "SOL_MONTH" , "07");
        form.setField( "BIRTH_MONTH1" , "0");
        form.setField( "CONSECUTIVE_NUMBER" , "0000001");
        form.setField( "OFFICE_NAME" , "OFICINA PRINCIPAL");
        form.setField( "IDENTIFICATION_NUMBER_SIGN" , "1032393128");
        form.setField( "SOL_DAY" , "23");
        form.setField( "SELLER_IDENTIFICATION" , "1098468987");
        form.setField( "CREDIT_AND_INSURANCE_AMOUNT" , "3000000");
        form.setField( "BIRTH_YEAR" , "1987");
        form.setField( "RESIDENCE_ADDRESS" , "Carrera 36 # 17-333 Torre 1 Apartamento 504");
        form.setField( "BIRTHPLACE" , "Bogota");
        form.setField( "INSURANCE_AMOUNT" , "500000");
        form.setField( "CITY" , "Bogota");
        form.setField( "SELLER_NAME" , "Npmbre del vendedor");
        form.setField( "IDENTIFICATION_NUMBER" , "1032393128");
        form.setField( "OFFICE_CODE" , "00000");

        for (String fldName : fldNames) {
            System.out.println("form.setField( \"" + fldName + "\" , \"" + fldName +"\");");
        }
        String states[] = form.getAppearanceStates("MALE");
        form.setField( "IDENTIFICATION_CE" , states[0]);
        form.setField( "IDENTIFICATION_PS" , states[0]);
        form.setField( "IDENTIFICATION_CC" , states[0]);
        form.setField( "FEMALE" , states[0]);
        form.setField( "MALE" , states[0]);
        form.setField( "GNV_SALE" , states[0]);
        form.setField( "UNIT_SALE" , states[0]);
        form.setField( "OFFICE_SALE" , states[0]);
    }

    private byte[] generateFile(String uuidName) throws DocumentException, IOException {
        stamper.setFormFlattening(true);
        stamper.close();
        reader = new PdfReader(baos.toByteArray());
        String filePath = String.format("%s%s.pdf", "src/main/resources/insurances/tmp/", uuidName);
        Document document = new Document();
        /** User password. */
        byte[] USER = "Hello".getBytes();
/** Owner password. */
        byte[] OWNER = "World".getBytes();
        PdfCopy writer = new PdfCopy(document, new FileOutputStream(filePath));
//        writer.setEncryption(USER, null,
//                PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
        document.open();
        writer.addPage(writer.getImportedPage(reader, 1));
//        writer.addPage(writer.getImportedPage(reader, 2));
        reader = new PdfReader(letter, null);
        baos = new ByteArrayOutputStream();
        stamper = new PdfStamper(reader, baos);
        stamper.setEncryption(USER, OWNER,
                PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
        stamper.setFormFlattening(true);
        stamper.close();
        document.close();
        return Files.readAllBytes(Paths.get(filePath));
    }

    private AcroFields getFields(String template) throws Exception{

            Resource resource = new ClassPathResource(template, getClass().getClassLoader());
            RandomAccessSourceFactory randomAccessSourceFactory = new RandomAccessSourceFactory();
            letter = new RandomAccessFileOrArray(randomAccessSourceFactory.createSource(resource.getInputStream()));
            reader = new PdfReader(letter, null);
            baos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, baos);
            return stamper.getAcroFields();
    }

    private void generatePdfIndependent() throws IOException, DocumentException {
        Resource resource = new ClassPathResource("insurances/654 Solicitud de seguro.pdf", getClass().getClassLoader());
        RandomAccessSourceFactory randomAccessSourceFactory = new RandomAccessSourceFactory();
        RandomAccessFileOrArray letter = new RandomAccessFileOrArray(randomAccessSourceFactory.createSource(resource.getInputStream()));
        PdfReader reader = new PdfReader(letter, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfStamper stamper = new PdfStamper(reader, baos);
        AcroFields form = stamper.getAcroFields();
        Set<String> fldNames = form.getFields().keySet();
        form.setField( "BIRTH_DAY2" , "5");
        form.setField( "NATIONALITY" , "Colombiano");
        form.setField( "NAMES" , "Jorge Andres Atuesta Maestre");
        form.setField( "BIRTH_DAY1" , "0");
        form.setField( "DEPARTAMENT" , "Bogota");
        form.setField( "INITIAL_CREDIT_AMOUNT" , "2500000");
        form.setField( "PHONE" , "5647783");
        form.setField( "RESIDENCE_COUNTRY" , "Colombia");
        form.setField( "SOL_YEAR" , "2019");
        form.setField( "BIRTH_MONTH2" , "8");
        form.setField( "MAIL" , "jatuest@bancodebogota.com.co");
        form.setField( "SOL_MONTH" , "07");
        form.setField( "BIRTH_MONTH1" , "0");
        form.setField( "CONSECUTIVE_NUMBER" , "0000001");
        form.setField( "OFFICE_NAME" , "OFICINA PRINCIPAL");
        form.setField( "IDENTIFICATION_NUMBER_SIGN" , "1032393128");
        form.setField( "SOL_DAY" , "23");
        form.setField( "SELLER_IDENTIFICATION" , "1098468987");
        form.setField( "CREDIT_AND_INSURANCE_AMOUNT" , "3000000");
        form.setField( "BIRTH_YEAR" , "1987");
        form.setField( "RESIDENCE_ADDRESS" , "Carrera 36 # 17-333 Torre 1 Apartamento 504");
        form.setField( "BIRTHPLACE" , "Bogota");
        form.setField( "INSURANCE_AMOUNT" , "500000");
        form.setField( "CITY" , "Bogota");
        form.setField( "SELLER_NAME" , "Npmbre del vendedor");
        form.setField( "IDENTIFICATION_NUMBER" , "1032393128");
        form.setField( "OFFICE_CODE" , "00000");
        for (String fldName : fldNames) {
            System.out.println("public static final String " + fldName + " = \"" + fldName +"\";");
        }


        String states[] = form.getAppearanceStates("MALE");
        form.setField( "IDENTIFICATION_CE" , states[0]);
        form.setField( "IDENTIFICATION_PS" , states[0]);
        form.setField( "IDENTIFICATION_CC" , states[0]);
        form.setField( "FEMALE" , states[0]);
        form.setField( "MALE" , states[0]);
        form.setField( "GNV_SALE" , states[0]);
        form.setField( "UNIT_SALE" , states[0]);
        form.setField( "OFFICE_SALE" , states[0]);


        stamper.setFormFlattening(true);
        stamper.close();

        reader = new PdfReader(baos.toByteArray());
        Document document = new Document();
        PdfCopy writer = new PdfCopy(document, new FileOutputStream("src/main/resources/insurances/tmp/IndependentCopy.pdf"));
        document.open();
        writer.addPage(writer.getImportedPage(reader, 1));
        writer.addPage(writer.getImportedPage(reader, 2));

        reader = new PdfReader(letter, null);
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