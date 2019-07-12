package hello;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Locale;

public class PdfCreator {

   /* public byte[] getDocumentAsByteArray(Object dataBean, String pdfTemplateName) throws KkmsException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfStamper stamp = null;
        InputStream templateInputStream = null;

       // Locale local = new Locale(language);

        try {
            templateInputStream = // get the file input stream of the pdf
                    PdfReader reader = new PdfReader(templateInputStream);

            // Create a stamper that will copy the document to a new file
            stamp = new PdfStamper(reader, outputStream);

            AcroFields form = stamp.getAcroFields();

            // form fields are normal text in the end
            stamp.setFormFlattening(true);
            Map<String, AcroFields.Item> map = (Map<String, AcroFields.Item>)form.getFields();
            if (map != null) {
                if (map.size() == 0) {
                    logger.debug("There are no fields in this PDF layout");
                }
                for (Entry<String, AcroFields.Item> e : map.entrySet()) {
                    logger.debug("PDF fieldname = " + e.getKey());

                    // at the moment we only handle text fields
                    if (AcroFields.FIELD_TYPE_TEXT == form.getFieldType(e.getKey())) {
                        fillForm(dataBean, form, e.getKey(), local);
                    } else {
                        logger.warn("Field type is not supported: "+form.getFieldType(e.getKey()));
                    }
                }
            }

            stamp.close();
        } catch (Exception e) {
            logger.warn("Failed to create PDF document", e);
            throw new KkmsException("Failed to create PDF document: "+e.getMessage());
        } finally {
            if (templateInputStream != null) {
                try {
                    templateInputStream.close();
                } catch (IOException e) {
                    throw new KkmsException("Failed to close InputStream of PDF document", e);
                }
            }
        }
        return outputStream.toByteArray();
    }


    private void createPdf() throws Exception {
        Document doc = new Document();
        PdfSmartCopy copy = new PdfSmartCopy(doc, new FileOutputStream("result.pdf"));
        doc.open();

        PdfReader reader;
        PdfStamper stamper;
        AcroFields form;
        ByteArrayOutputStream baos;

        for(int i = 0; i < getTotalPages(); i++) {
            copyPdf(i);

            reader = new PdfReader(String.format("%d%s", i, "template.pdf"));
            baos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, baos);
            form = stamper.getAcroFields();

            //methods to fill forms

            stamper.setFormFlattening(true);
            stamper.close();

            reader = new PdfReader(baos.toByteArray());
            copy.addPage(copy.getImportedPage(reader, 1));
        }

        doc.close();
    }

    private void copyPdf(int currentPage) throws Exception {
        PdfReader reader = new PdfReader("timesheet.pdf");
        Document doc = new Document();
        File file = new File(String.format("%d%s", currentPage, "template.pdf"));
        file.deleteOnExit();
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(file));
        stamper.close();
    }*/
}
