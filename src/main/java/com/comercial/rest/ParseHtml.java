package com.comercial.rest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream; 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.AbstractImageProvider;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
 
/**
 *
 * @author iText
 */
@WrapToTest
public class ParseHtml {
    public static final String DEST = "results/xmlworker/html_1.pdf";
 
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        
		LocalDateTime now = LocalDateTime.now();            
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSS");
        String formatDateTime = now.format(formatter);
        new ParseHtml().createPdf("results/xmlworker/" +formatDateTime + ".pdf");
        new ParseHtml().createPdf2("results/xmlworker/" +formatDateTime + ".pdf");
        
    }
 
    public void createPdf(String file) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(file));
        // step 3
        document.open();
        // step 4
        StringBuilder sb = new StringBuilder();
        sb.append("<div>\n<p align=\"center\">");
        sb.append("<font size=\"5\">");
        sb.append("<b>&nbsp;<font color=\"#32cd32\">My centered Para</font></b>");
        sb.append("</font>");
        sb.append("<font color=\"#32cd32\">&nbsp;</font>");
        sb.append("</p>\n</div>");
 
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell();
        ElementList list = XMLWorkerHelper.parseToElementList(sb.toString(), null);
        for (Element element : list) {
            cell.addElement(element);
        }
        table.addCell(cell);
        document.add(table);
 
        // step 5
        document.close();
    }
    
    
        
        class Base64ImageProvider extends AbstractImageProvider {
            
            @Override
            public Image retrieve(String src) {
                int pos = src.indexOf("base64,");
                try {
                    if (src.startsWith("data") && pos > 0) {
                        byte[] img = Base64.decode(src.substring(pos + 7));
                        return Image.getInstance(img);
                    }
                    else {
                        return Image.getInstance(src);
                    }
                } catch (BadElementException ex) {
                    return null;
                } catch (IOException ex) {
                    return null;
                }
            }

            @Override
            public String getImageRootPath() {
                return null;
            }
        }
        
        public void createPdf2(String file) throws IOException, DocumentException {
            
        	StringBuilder sb = new StringBuilder();        
            
            URL pcgull = this.getClass().getResource("CertificadoFuncionario.html");
        	
        	//URL pcgull = new URL("http://nereida.deioc.ull.es/~cleon/in.dat");
            BufferedReader in = new BufferedReader( new InputStreamReader(pcgull.openStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null){
            	
            	if (inputLine.trim().equals("<caritafeliz></caritafeliz>")){
            		sb.append("<img src=\"data:image/gif;base64,R0lGODlhEAAQALMPAAAAAIAAAACAAICAAAAAgIAAgACAgMDAwICAgP8AAAD/AP//AAAA//8A/wD//////yH5BAEAAA8ALAAAAAAQABAAQAQ78EkJqp10LaB759sDVh4ZiqVVTqC3om6smVvcAmz74Zioz7zMRmfC/WTAGXI0Ws5gtc+HhXz2fJagJAIAOw==\" />");
            	}else{
            		sb.append(inputLine);	
            	}
            	
            	
            }
            
                    // step 1
            Document document = new Document();
            // step 2
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            // step 3
            document.open();
            // step 4

            // CSS
            CSSResolver cssResolver =
                    XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
            
            // HTML
            HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
            htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
            htmlContext.setImageProvider(new Base64ImageProvider());
            
            // Pipelines
            PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
            HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
            CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);
            
            // XML Worker
            XMLWorker worker = new XMLWorker(css, true);
            XMLParser p = new XMLParser(worker);
            p.parse(new ByteArrayInputStream(sb.toString().getBytes()));
            
            // step 5
            document.close();

        }
        
        public void createPdf3(String file) throws IOException, DocumentException {
            String str = "<html><head><title>Test PDF</title></head><body>"
            		+ "<div style=\"text-align: center; border: 3px solid green;\">"  
            		+ "<img class=\"irc_mi\" src=\"http://www.bossa.mx/wp-content/uploads/2013/05/malas-2.jpg\" alt=\"Resultado de imagen para chicas malas\" onload=\"google.aft&amp;&amp;google.aft(this)\" width=\"500\" style=\"margin-top: 0px;\"/>" 
            		+ "<img src=\"data:image/gif;base64,R0lGODlhEAAQALMPAAAAAIAAAACAAICAAAAAgIAAgACAgMDAwICAgP8AAAD/AP//AAAA//8A/wD//////yH5BAEAAA8ALAAAAAAQABAAQAQ78EkJqp10LaB759sDVh4ZiqVVTqC3om6smVvcAmz74Zioz7zMRmfC/WTAGXI0Ws5gtc+HhXz2fJagJAIAOw==\" />" 
            		+ "</div><div>Hello world</div></body></html>";
            
                    // step 1
            Document document = new Document();
            // step 2
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            // step 3
            document.open();
            // step 4

            // CSS
            CSSResolver cssResolver =
                    XMLWorkerHelper.getInstance().getDefaultCssResolver(true);
            
            // HTML
            HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
            htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
            htmlContext.setImageProvider(new Base64ImageProvider());
            
            // Pipelines
            PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
            HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
            CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);
            
            // XML Worker
            XMLWorker worker = new XMLWorker(css, true);
            XMLParser p = new XMLParser(worker);
            p.parse(new ByteArrayInputStream(str.getBytes()));
            
            // step 5
            document.close();

        }
    
    
}