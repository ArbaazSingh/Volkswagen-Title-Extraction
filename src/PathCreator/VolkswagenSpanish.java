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

public class VolkswagenSpanish{

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

				if (title[title.length-1].contains("Letras distintivas de motor")||title[title.length-1].contains("Vehículos")){
					temp1=title[title.length-2]+":-"+title[title.length-1];
				}

				///////////////////////////////////////////////////////////////////////////////////////			

				if((title.length==4)){
					temp1=title[title.length-2]+":-"+title[title.length-1];
				}
				///////////////////////////////////////////////////////////////////////////////////////			

				if (title.length>3){
					if (title[3].equals("23 Preparación combustible inyección diesel")||title[3].equals("27 Motor arranque alimentación corriente GRA")||title[3].equals("48 Dirección")||title[3].equals("30 Embrague, accionamiento")||title[3].equals("10 Motor - cilindro, cárter motor")||title[3].equals("01 Servicio de Inspección, autodiagnóstico")||title[3].equals("47 Freno - hidráulico, reg., serv.")||title[3].equals("74 Almohadillados asiento, tapizados")||title[3].equals("72 Armazón asiento")||title[3].equals("70 Revestimientos, amortiguaciones")||title[3].equals("69 Protección de ocupantes")||title[3].equals("68 Equipamiento interior")||title[3].equals("91 Sistema de infotenimiento")||title[3].equals("90 Mandos, instrumentos, SVA")||title[3].equals("44 Ruedas, neumáticos, medición vehículo")||title[3].equals("60 Techo corredizo")||title[3].equals("55 Capó, portón, cabina cierre centralizado")|| title[3].equals("57 Puerta delantera, cierre centralizado")|| title[3].equals("58 Puerta trasera/corred./hoja, cierre centralizado")||title[3].equals("63 Paragolpes")||title[3].equals("40 Suspensión ruedas anteriores, semieje articulado")||title[3].equals("42 Suspensión ruedas posteriores, semieje articulado")){
						temp1="";
						for (int i=4;i<=title.length-1;i++){
							temp1=temp1.concat(title[i]+":-");

						}
						//System.out.println(temp1.length());
						temp1=temp1.substring(0,temp1.length()-2);
					}
					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[3].equals("00 Datos técnicos")){
						if (title.length==7)
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}

					} 

					///////////////////////////////////////////////////////////////////////////////////////			
					if (title[3].equals("20 Alimentación combustible, gas, accionamiento")){
						if ((title.length==7)||(title.length==6))
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}

					}
					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[3].equals("26 Sistema escape")){
						//System.out.println(title.length);
						if ((title.length==7)||(title.length==6))
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}
						else
							temp1=title[title.length-1];

					}
					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[1].equals("Transmisión")){
						//	System.out.println(title.length);

						if ((title.length==7)){
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}
						if (title[3].equals("38 Cambio automático, piñónes, regulación")&& title[4].equals("Caja de correderas: desmontar y montar")&&title.length>5&&!title[5].contains("de montaje")){
							temp1=title[5]+":-"+temp1;
							String[] duplicatechecker= temp1.split(":-");
							if (duplicatechecker[0].equals(duplicatechecker[1])){
								temp1=duplicatechecker[duplicatechecker.length-2]+":-"+duplicatechecker[duplicatechecker.length-1];
							}
						}
						temp1=temp1.concat("("+title[2]+")");

					}

					///////////////////////////////////////////////////////////////////////////////////////			


					if (title[1].equals("Motopropulsor")){
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
						if(title[3].equals("94 Luces, lámparas, conmutadores exterior")||title[3].equals("96 Luces,lámparas,conmutadores int.,alarma antirobo")){

							if ((title.length==7)||(title.length==6))
							{
								temp1=title[title.length-2]+":-"+title[title.length-1];

							}
							else
								temp1=title[title.length-1];



						}
					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if (title[3].equals("80 Calefacción")){
						if (title.length==7)
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}

					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if (title[3].equals("87 Equipo aire acondicionado")){
						if (title[4].contains("regulación manual"))
						{
							temp1=temp1+" (regulación manual)";

						}
						else if (title[4].contains("regulación automática")){

							temp1=temp1+" (regulación automática)";

						}
						else if (title[4].equals("Soporte del compresor de aire acondicionado")){
							if (title.length==7){
								temp1=title[title.length-2]+":-"+title[title.length-1];

							}
							if (title.length==6){
								temp1=title[title.length-1];

							}

						}


					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if(title[3].equals("45 ABS, ADR, ASR, EDS, ASR")){
						temp1=title[title.length-2]+":-"+title[title.length-1];

					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if(title[1].equals("Información técnica de producto")){
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
