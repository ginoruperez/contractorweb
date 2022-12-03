package com.gino.contractor.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gino.contractor.entities.Contractor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFGenerator {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(PDFGenerator.class);
	
	
	public void generateContractor(Contractor contractor, String filePath) {
		LOGGER.info("Inside generateContractor");
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			document.add(generateTable(contractor));
			document.close();

		} catch (FileNotFoundException | DocumentException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			LOGGER.error("Exception in generateContractor ", e1);
			

		}

	}

	private PdfPTable generateTable(Contractor contractor) {
		PdfPTable table = new PdfPTable(2);

		PdfPCell cell;

		cell = new PdfPCell(new Phrase("Contractor Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("Name");
		table.addCell(contractor.getName());

		table.addCell("Location");
		table.addCell(contractor.getLocation());

		table.addCell("Specialties");
		table.addCell(contractor.getSpecialties());

		return table;
	}
}
