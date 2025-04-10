package com.design.patterns.Facade;

// Subsystem 1 - PDF Generator
class PDFGenerator {
    public void generatePDFReport(String title, String content) {
        System.out.println("Generating PDF Report...");
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
    }
}

// Subsystem 2 - Excel Generator
class ExcelGenerator {
    public void generateExcelReport(String title, String content) {
        System.out.println("Generating Excel Report...");
        System.out.println("Sheet Title: " + title);
        System.out.println("Data: " + content);
    }
}

// Subsystem 3 - HTML Generator
class HTMLGenerator {
    public void generateHTMLReport(String title, String content) {
        System.out.println("Generating HTML Report...");
        System.out.println("<html><head><title>" + title + "</title></head>");
        System.out.println("<body><p>" + content + "</p></body></html>");
    }
}

// Facade class that simplifies report generation
class ReportFacade {
    private PDFGenerator pdfGenerator;
    private ExcelGenerator excelGenerator;
    private HTMLGenerator htmlGenerator;

    public ReportFacade() {
        pdfGenerator = new PDFGenerator();
        excelGenerator = new ExcelGenerator();
        htmlGenerator = new HTMLGenerator();
    }

    public void createPDF(String title, String content) {
        pdfGenerator.generatePDFReport(title, content);
    }

    public void createExcel(String title, String content) {
        excelGenerator.generateExcelReport(title, content);
    }

    public void createHTML(String title, String content) {
        htmlGenerator.generateHTMLReport(title, content);
    }
}

// Client code
public class FacadePatternExample2 {
    public static void main(String[] args) {
        ReportFacade facade = new ReportFacade();

        String title = "Sales Report Q1";
        String content = "Total Sales: $100,000";

        System.out.println("=== Using Facade to Generate Reports ===");
        facade.createPDF(title, content);
        System.out.println();

        facade.createExcel(title, content);
        System.out.println();

        facade.createHTML(title, content);
    }
}

