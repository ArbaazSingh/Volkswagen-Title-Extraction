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

public class VolkswagenFrench{

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

				if (title[title.length-1].contains("Lettres-repères moteur")||title[title.length-1].contains("Véhicules")){
					temp1=title[title.length-2]+":-"+title[title.length-1];
				}

				///////////////////////////////////////////////////////////////////////////////////////			

				if((title.length==4)){
					temp1=title[title.length-2]+":-"+title[title.length-1];
				}
				///////////////////////////////////////////////////////////////////////////////////////			

				if (title.length>3){
					if (title[3].equals("23 Préparation du mélange-injection diesel")||title[3].equals("27 Alimentation courant démarreur -GRA")||title[3].equals("48 Direction")||title[3].equals("30 Embrayage, commande")||title[3].equals("10 Moteur assemblé,cylindres,carter")||title[3].equals("01 Service Entretien, Autodiagnostic")||title[3].equals("47 Freins-commande hydraul.,compensateur,servofrein")||title[3].equals("74 Rembourrages sièges, garnitures")||title[3].equals("72 Châssis siège")||title[3].equals("70 Revêtements, insonorisants")||title[3].equals("69 Protection des passagers")||title[3].equals("68 Equipement int.")||title[3].equals("91 Systèm d'infodivertissement")||title[3].equals("90 Cadrans, instruments, SVA")||title[3].equals("44 Roues,pneus,contrôle de géométrie")||title[3].equals("60 Toit coulissant")||title[3].equals("55 Capots, hayons, battants, cabine, verrouil.centr.")|| title[3].equals("57 Porte AV,verrouillage central")|| title[3].equals("58 Porte AR, couliss., à vantaux, verrouil.centr.")||title[3].equals("63 Pare-chocs")||title[3].equals("40 Suspension AV, arbre de pont")||title[3].equals("42 Suspension AR, arbre de pont")){
						temp1="";
						for (int i=4;i<=title.length-1;i++){
							temp1=temp1.concat(title[i]+":-");

						}
						//System.out.println(temp1.length());
						temp1=temp1.substring(0,temp1.length()-2);
					}
					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[3].equals("00 Caractéristiques techniques")){
						if (title.length==7)
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}

					} 

					///////////////////////////////////////////////////////////////////////////////////////			
					if (title[3].equals("20 Alimentation, accélér., commande")){
						if ((title.length==7)||(title.length==6))
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}

					}
					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[3].equals("26 Echappement")){
						//System.out.println(title.length);
						if ((title.length==7)||(title.length==6))
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}
						else
							temp1=title[title.length-1];

					}
					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[1].equals("Transmission")){
						//	System.out.println(title.length);

						if ((title.length==7)){
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}
						if (title[3].equals("38 BV autom. - Pignons, régulation")&& title[4].equals("Distributeur hydraulique : dépose et repose")&&title.length>5&&!title[5].contains("Distributeur")){
							temp1=title[5]+":-"+temp1;
							String[] duplicatechecker= temp1.split(":-");
							if (duplicatechecker[0].equals(duplicatechecker[1])){
								temp1=duplicatechecker[duplicatechecker.length-2]+":-"+duplicatechecker[duplicatechecker.length-1];
							}
						}
						temp1=temp1.concat("("+title[2]+")");
					}
					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[1].equals("Groupe motopropulseur")){
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
						if(title[3].equals("94 Feux, lampes, commutateurs ext.")||title[3].equals("96 Feux, lampes, commutateurs int.,protection antivol")){

							if ((title.length==7)||(title.length==6))
							{
								temp1=title[title.length-2]+":-"+title[title.length-1];

							}
							else
								temp1=title[title.length-1];



						}
					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if (title[3].equals("80 Chauffage")){
						if (title.length==7)
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}

					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if (title[3].equals("87 Climatiseur")){
						if (title[4].contains("régulation manuelle"))
						{
							temp1=temp1+" (régulation manuelle)";

						}
						else if (title[4].contains("régulation automatique")){

							temp1=temp1+" (régulation automatique)";

						}
						else if (title[4].equals("Support de compresseur de climatiseur")){
							if (title.length==7){
								temp1=title[title.length-2]+":-"+title[title.length-1];

							}
							if (title.length==6){
								temp1=title[title.length-1];

							}

						}


					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if(title[3].equals("45 ABS, ADR, ASR, EDS, ESP")){
						temp1=title[title.length-2]+":-"+title[title.length-1];

					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if(title[1].equals("Information Technique Produit")){
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
				if(title.length>2){
					String t=title[2].substring(0,2);
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
