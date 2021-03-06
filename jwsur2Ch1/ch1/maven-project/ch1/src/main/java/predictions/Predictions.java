package predictions;

import java.beans.XMLEncoder; // simple and effective
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Predictions {
    private int n = 32;
    private Prediction[] predictions;

    public Predictions() { }


    // getPredictions returns an XML representation of
    // the Predictions array
    public void setPredictions(String ps) { 
	
	} // no-op
	
    public String getPredictions() {
 

		// Have the data been read already?
		if (predictions == null) 
			populate(); 

		// Convert the Predictions array into an XML document
		return toXML();
    }

    //** utilities
    private void populate() {
		String filename = "predictions.db";
		InputStream in = Predictions.class.getResourceAsStream(filename);

		// Read the data into the array of Predictions. 
		if (in != null) {
			try {
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(isr);

			predictions = new Prediction[n];
			int i = 0;
			String record = null;
			while ((record = reader.readLine()) != null) {
				String[] parts = record.split("!");
				Prediction p = new Prediction();
				p.setWho(parts[0]);
				p.setWhat(parts[1]);

				predictions[i++] = p;
			}
			}
			catch (IOException e) { }
		}
    }

    private String toXML() {
		String xml = null;
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			XMLEncoder encoder = new XMLEncoder(out);
			encoder.writeObject(predictions); // serialize to XML
			encoder.close();
			xml = out.toString(); // stringify
		}
		catch(Exception e) { }
		return xml;
    }
}




