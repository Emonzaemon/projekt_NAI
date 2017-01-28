package pl.edu.pjatk.s11718.Project_NAI;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFile {
	int cityX[];
	int	cityY[];
	int size = 0;
	public int[][] read() throws FileNotFoundException{
		
		Frame a = null;
		//a.setVisible(true);

		FileDialog fd = new FileDialog(a,"Wczytaj",FileDialog.LOAD);
		fd.setVisible(true);
		String directory = fd.getDirectory();
		String file = fd.getFile();
		System.out.println("Wybrano plik: "+ directory + file);

		//sprawdzenie długości pliku
		File f = new File(directory+file);
		Scanner in = new Scanner(new BufferedReader(new FileReader(f)));
		while(in.hasNextInt()){
			in.nextInt();
			size++;
		}
		in.close();
		
		int cityXY[][] = new int[size/2][2];

		Scanner cin = new Scanner(new BufferedReader(new FileReader(f)));
		
		while(cin.hasNextInt()){
			for (int i=0; i<size/2;i++){
				for (int j=0; j<2; j++){
				    int date = cin.nextInt();
	                cityXY[i][j] = date;
				}
	        }
		}
		cin.close();
		return cityXY;
}

}
