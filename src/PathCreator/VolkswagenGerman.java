package PathCreator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class VolkswagenGerman{

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		List<String> listoftitles = new ArrayList<String>();
		File file = new File("C:/Users/asidhu/Desktop/paths.txt");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String text = null;

			while ((text = reader.readLine()) != null) {
				listoftitles.add(text);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}

		//print out the list
		//System.out.println(listoftitles);



		List<String> TitleFinal= new ArrayList<String>();

		for(String temp:listoftitles){
			if(!temp.equals("#N/A") && !temp.equals("XXXXXXXX")){
				String[] title= temp.split(":_:");
				String temp1=title[title.length-1];	
				if (!title[title.length-1].contains(" ")){
					//System.out.println(title[title.length-2]);
					temp1=title[title.length-2]+":-"+title[title.length-1];
					//System.out.println(title[title.length-2]+ " DONE");

				}
				else if (title[title.length-1].contains(" ")){
					String[] Spacesplit=title[title.length-1].split(" ");
					if (Spacesplit.length<=2){
						temp1=title[title.length-2]+":-"+title[title.length-1];		
					}
				}

				///////////////////////////////////////////////////////////////////////////////////////			

				if (title[title.length-1].contains("Motorkennbuchstabe")||title[title.length-1].contains("Fahrzeuge")){
					temp1=title[title.length-2]+":-"+title[title.length-1];
				}

				///////////////////////////////////////////////////////////////////////////////////////			

				if((title.length==4)){
					temp1=title[title.length-2]+":-"+title[title.length-1];
				}
				///////////////////////////////////////////////////////////////////////////////////////			

				if (title.length>3){
					if (title[3].equals("23 Kraftstoffaufber.-Diesel-Einspr.")||title[3].equals("27 Anlasser,Stromversorgung,GRA")||title[3].equals("48 Lenkung")||title[3].equals("30 Kupplung,Betätigung")||title[3].equals("10 Motor-ZSB.,Zylinder,Kurbelgehäuse")||title[3].equals("01 Inspektions Service,Eigendiagnose")||title[3].equals("47 Bremse- Hydraulik,Regler,Verstärker")||title[3].equals("74 Sitz-Polster, Bezüge")||title[3].equals("72 Sitz-Gestell")||title[3].equals("70 Verkleidungen,Dämpfungen")||title[3].equals("69 Insassenschutz")||title[3].equals("68 Innenausstattung")||title[3].equals("91 Infotainment")||title[3].equals("90 Armaturen,Instrumente,SVA")||title[3].equals("44 Räder,Reifen,Fahrzeugvermessung")||title[3].equals("60 Schiebedach")||title[3].equals("55 Deckel,Klappen,Fahrerhaus,Zentralv.")|| title[3].equals("57 Tür vorn,Zentralverriegelung")|| title[3].equals("58 Tür hi,Schiebetür,Flügelt.,Zentralv.")||title[3].equals("63 Stoßfänger")||title[3].equals("40 Radaufhängung vorn, Gelenkwelle")||title[3].equals("42 Radaufhängung hinten, Gelenkwelle")){
						temp1="";
						for (int i=4;i<=title.length-1;i++){
							temp1=temp1.concat(title[i]+":-");

						}
						//System.out.println(temp1.length());
						temp1=temp1.substring(0,temp1.length()-2);
					}
					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[3].equals("00 Technische Daten")){
						if (title.length==7)
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}

					} 

					///////////////////////////////////////////////////////////////////////////////////////			
					if (title[3].equals("20 Kraftstoffversorgung,Gas,Betätig.")){
						if ((title.length==7)||(title.length==6))
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}

					}
					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[3].equals("26 Abgasanlage")){
						//System.out.println(title.length);
						if ((title.length==7)||(title.length==6))
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}
						else
							temp1=title[title.length-1];

					}
					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[1].equals("Kraftübertragung")){
						//	System.out.println(title.length);

						if ((title.length==7)){
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}
						if (title[3].equals("38 Getriebe autom.- Räder,Regelung")&& title[4].equals("Schieberkasten aus- und einbauen")&&title.length>5&&!title[5].contains("Montageübersicht")){
							temp1=title[5]+":-"+temp1;
							String[] duplicatechecker= temp1.split(":-");
							if (duplicatechecker[0].equals(duplicatechecker[1])){
								temp1=duplicatechecker[duplicatechecker.length-2]+":-"+duplicatechecker[duplicatechecker.length-1];
							}
						}
						temp1=temp1.concat("("+title[2]+")");

					}


					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[1].equals("Antriebsaggregat")){
						//	System.out.println(title[2]);
						if(title[2].contains("(")){
							//System.out.println(title[2].split("\\(")[1]);
							temp1=temp1.concat(" ("+(title[2].split("\\(")[1].split("\\)")[0])+")");

						}}

					///////////////////////////////////////////////////////////////////////////////////////			
					if (title[0].equals("Body repairs")){

						temp1="";
						for (int i=2;i<=title.length-1;i++){
							temp1=temp1.concat(title[i]+":-");
							//System.out.println(temp1);
						}

						temp1=temp1.substring(0,temp1.length()-2);

					}
					///////////////////////////////////////////////////////////////////////////////////////			
					if(title.length>4){
						if(title[3].equals("94 Leuchten,Lampen,Schalter-außen")||title[3].equals("96 Leuchten,Lampen,Schalter-innen, Diebstahlschutz")){

							if ((title.length==7)||(title.length==6))
							{
								temp1=title[title.length-2]+":-"+title[title.length-1];

							}
							else
								temp1=title[title.length-1];



						}
					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if (title[3].equals("80 Heizung")){
						if (title.length==7)
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}

					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if (title[3].equals("87 Klimaanlage")){
						if (title[4].contains("manueller Regelung"))
						{
							temp1=temp1+" (manueller Regelung)";

						}
						else if (title[4].contains("automatischer Regelung")){

							temp1=temp1+" (automatischer Regelung)";

						}
						else if (title[4].equals("Halter für Klimakompressor")){
							if (title.length==7){
								temp1=title[title.length-2]+":-"+title[title.length-1];

							}
							if (title.length==6){
								temp1=title[title.length-1];

							}

						}


					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if(title[3].equals("45 ABS,ADR,ASR,EDS,ESP")){
						temp1=title[title.length-2]+":-"+title[title.length-1];

					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if(title[1].equals("Technische Produktinformationen")){
						temp1="";
						for (int i = 2;i<title.length;i++){
							temp1=temp1+title[i]+ ":-";

						}
						temp1=temp1.substring(0,temp1.length()-2);
					}


				}

				if(title.length>3){
					String t=title[3].substring(0,2);
					if(isNumeric(t)){
						if(!t.equals(temp1.substring(0,2))){
							temp1=t+" "+temp1;
						}}}

				if(title.length>2){
					String t=title[1].substring(0,2);
					if(isNumeric(t)){
						if(!t.equals(temp1.substring(0,2))){
							temp1=t+" "+temp1;
						}}}

				TitleFinal.add(temp1);
			}
			else {
				TitleFinal.add(temp);
			}


		}
		PrintWriter writer = new PrintWriter("TitleList.txt", "UTF-8");
		writer.println();
		writer.println();
		writer.println();
		writer.println();
		writer.println();

		for(String s:TitleFinal){
			writer.println(s);
		}
		writer.close();
	}
	public static boolean isNumeric(String str)
	{
		return str.matches("-?\\d+(.\\d+)?");
	}}