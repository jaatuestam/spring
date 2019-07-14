package hello;


import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.Set;

import com.lowagie.text.Document;
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
import com.lowagie.text.pdf.TextField;

public class MainClass {

    public static void main(String[] args) throws Exception {
//        createPdf("HelloLetter.pdf", "field", "value");
        RandomAccessFileOrArray letter = new RandomAccessFileOrArray("Asalariados.pdf");
        PdfReader  reader = new PdfReader(letter, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfStamper stamper = new PdfStamper(reader, baos);
        AcroFields form = stamper.getAcroFields();
        Set<String> fldNames = form.getFields().keySet();
        form.setField("No de Documento", "1032393128");
        form.setField("E mail", "correo@correo.com");

        for (String fldName : fldNames) {
          System.out.println( fldName + ": " + form.getField( fldName ) );
        }
        
        stamper.setFormFlattening(true);
        stamper.close();

        reader = new PdfReader(baos.toByteArray());
        Document document = new Document();
        PdfCopy writer = new PdfCopy(document, new FileOutputStream("HelloWorldStampCopy.pdf"));
        document.open();
        writer.addPage(writer.getImportedPage(reader, 1));
        writer.addPage(writer.getImportedPage(reader, 2));

        reader = new PdfReader(letter, null);
        baos = new ByteArrayOutputStream();
        stamper = new PdfStamper(reader, baos);
        form = stamper.getAcroFields();
        form.setField("No de Documento", "1032393128");
        form.setField("E mail", "correo@correo.com");
        stamper.setFormFlattening(true);
        stamper.close();

        reader = new PdfReader(baos.toByteArray());
//        writer.addPage(writer.getImportedPage(reader, 1));
        document.close();
    }

    private static void createPdf(String filename, String field, String value) throws Exception {
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);

        TextField tf = new TextField(writer, new Rectangle(64, 785, 340, 800), field);
        tf.setFontSize(12);
        tf.setFont(bf);
        tf.setText(value);
        tf.setTextColor(new GrayColor(0.5f));
        writer.addAnnotation(tf.getTextField());
        document.close();
    }
}