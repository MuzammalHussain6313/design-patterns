package com.design.patterns.Adapter;
import org.json.JSONObject;
import org.json.XML;

// 1. Target interface (what client expects)
interface JsonDataProvider {
    String getJson();
}

// 2. Adapter (existing incompatible interface)
class XmlDataProvider {
    public String getXml() {
        return "<person><name>John</name><age>30</age></person>";
    }
}

// 3. Adapter class
// Inherits the target interface (JsonDataProvider) -> Inheritance via interface implementation
class XmlToJsonAdapter implements JsonDataProvider {

    // Holds a reference to the Adapter (XmlDataProvider) -> Composition
    private XmlDataProvider xmlProvider;

    // Constructor-based Dependency Injection (Composition)
    public XmlToJsonAdapter(XmlDataProvider xmlProvider) {
        this.xmlProvider = xmlProvider;
    }

    // Implements the method from JsonDataProvider interface
    // Uses composition to delegate the XML fetching to XmlDataProvider
    @Override
    public String getJson() {
        // Getting XML data from the adaptee
        String xml = xmlProvider.getXml();

        // Converting XML to JSON using org.json library
        JSONObject jsonObject = XML.toJSONObject(xml);

        // Returning the JSON string
        return jsonObject.toString(4); // Pretty print with indentation
    }
}

// 4. Client code
public class AdapterPattern {
    public static void main(String[] args) {
        // Existing XML provider
        XmlDataProvider xmlProvider = new XmlDataProvider();

        // Adapter used to convert to JSON
        JsonDataProvider jsonAdapter = new XmlToJsonAdapter(xmlProvider);

        // Client uses the JSON provider
        String json = jsonAdapter.getJson();
        System.out.println("Converted JSON:\n" + json);
    }
}
