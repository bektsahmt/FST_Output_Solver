package _21010310003_Ahmet_Bektas;

import java.util.Scanner;
import java.util.Arrays;

public class _21010310003_Rules {
	String temp;
	String output;
	String[] states;
	String[] outputs;
	String[] read;
	String[] firstInput;
	String[] secondInput;
	String[] input;
	
	public _21010310003_Rules() {
		
	}
	
	public void getInputFromUserandPrint() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen birinci input'u giriniz.");
		String input1 = sc.nextLine();
		this.firstInput = input1.split("");
		insertStatesandOutputs(firstInput);
		
		System.out.println("Lütfen ikinci input'u giriniz.");
		String input2 = sc.nextLine();
		this.secondInput = input2.split("");
		insertStatesandOutputs(secondInput);	
	}
	
	public void insertStatesandOutputs(String[] input) {
		_21010310003_Reader reader = new _21010310003_Reader();
		this.temp = reader.getFirstState();
		this.states = new String[input.length+1];
		this.outputs = new String[input.length];
		states[0] = temp;
		for (int i = 0; i < input.length; i++) {
			int qIndex = Arrays.asList(reader.qArray).indexOf(temp);
			int sigmaIndex = Arrays.asList(reader.sigmaArray).indexOf(input[i]);
			String newState = reader.passRuleArray[qIndex][sigmaIndex];
			String newOutput = reader.outputRuleArray[qIndex][sigmaIndex];
			states[i+1] = newState;
			temp = newState;
			outputs[i] = newOutput;
		}
		System.out.println("Durumlarin sirasi: " + Arrays.toString(states));
		System.out.println("Cikti: " + Arrays.toString(outputs));
		
	}
	
}
