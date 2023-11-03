package _21010310003_Ahmet_Bektas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class _21010310003_Reader {
	int q;
	int sigma;
	String[] qArray;
	String[] sigmaArray;
	String q0;
	File dosya;
	String[] lines;
	String[][] passRuleArray;
	String[][] outputRuleArray;
	
	
	public _21010310003_Reader() {
		this.dosya = new File("FST.txt");
		this.readlines(dosya);
		this.qArray();
		this.sigmaArray();
		this.getQLength();
		this.getSigmaLength();
		this.outputRuleArray();
		this.passRuleArray();
		
		
	}
	
	public void readlines(File dosya) {
	    try {
	        this.dosya = dosya;
	        BufferedReader br = new BufferedReader(new FileReader(dosya));
	        
	        int lineCount = 0;
	        while (br.readLine() != null) {
	            lineCount++;
	        }
	        
	        br.close();
	        
	        this.lines = new String[lineCount]; 

	        br = new BufferedReader(new FileReader(dosya)); 
	        String line;
	        int i = 0;

	        while ((line = br.readLine()) != null) {
	            this.lines[i] = line;
	            i++;
	        }

	        br.close();
	    } catch (IOException e) {
	        System.out.println("Dosya okunamadı. " + e.getMessage());
	    }
	}

	
	public int getQLength(){
		String[] girdiler = lines[0].replaceAll("Q = \\{([^}]*)\\}","$1").split(", ");
		this.q = girdiler.length;
		return q;
	}
	
	public void qArray(){
		this.qArray = lines[0].replaceAll("Q = \\{([^}]*)\\}","$1").split(", ");
	}
	
	public void sigmaArray() {
		this.sigmaArray = lines[1].replaceAll(".*\\{(.*)\\}.*","$1").split(", ");
	}
	
	public int getSigmaLength() {
		String[] girdiler = lines[1].replaceAll(".*\\{(.*)\\}.*","$1").split(", ");
		this.sigma = girdiler.length;
		return sigma;
	}
	
	public String getFirstState(){
		q0 = lines[lines.length-1].replaceAll("q0 = ", "");
		return q0;
	}
	
	public void passRuleArray() {
		this.passRuleArray = new String[q][sigma];
		
		for (int i = 0; i < q; i++) {
			String regex = "\\((\\w+),";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(lines[i+4]);
	        int j=0;
	        while(matcher.find() || j<sigma ) {
	        	String qValue = matcher.group(1);
	        	passRuleArray[i][j] = qValue;
	        	j++;
	        } 
		}
	}
	
	
	public void outputRuleArray() {
		this.outputRuleArray = new String[q][sigma];
		
		for (int i = 0; i < q; i++) {
			String regex = "\\(\\w+, (\\d+)\\)";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(lines[i+4]);
	        int j=0;
	        while(matcher.find() || j<sigma ) {
	        	String num = matcher.group(1);
	        	outputRuleArray[i][j] = num;
	        	j++;
	        } 
		}
		
	}
	
	
}
