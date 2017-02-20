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

public class VolkswagonEnglish{

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		List<String> listoftitles = new ArrayList<String>();
		File file = new File(args[0]);
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

				if (title[title.length-1].contains("Engine codes")||title[title.length-1].contains("Vehicles")){
					temp1=title[title.length-2]+":-"+title[title.length-1];
				}

				///////////////////////////////////////////////////////////////////////////////////////			

				if((title.length==4)){
					temp1=title[title.length-2]+":-"+title[title.length-1];
					//System.out.println(temp1);
					//System.out.println("******************************");
				}
				///////////////////////////////////////////////////////////////////////////////////////			

				if (title.length>3){
					if (title[3].equals("23 Fuel preparation system Diesel injection")||title[3].equals("27 Starter-current supply-CC")||title[3].equals("48 Steering")||title[3].equals("30 Clutch, control")||title[3].equals("10 Engine assy,cylinder block,crankcase")||title[3].equals("01 Self diagnosis, V.A.G Inspection Service")||title[3].equals("47 Brakes, hydraulics, regulator, servo")||title[3].equals("74 Seat padding, covers")||title[3].equals("72 Seat frames")||title[3].equals("70 Trim, noise insulation")||title[3].equals("69 Passenger protection")||title[3].equals("68 Interior equipment")||title[3].equals("91 Infotainment")||title[3].equals("90 Instruments, GCI")||title[3].equals("44 Wheels, tyres. axle align")||title[3].equals("60 Sliding roof")||title[3].equals("55 Bonnet, flaps, cab, central locking")|| title[3].equals("57 Front door, central locking")|| title[3].equals("58 Rear door,sliding door,wing doors,central locking")||title[3].equals("63 Bumper")||title[3].equals("40 Front suspension, drive shafts")||title[3].equals("42 Rear suspension, drive shaft")){
						temp1="";
						for (int i=4;i<=title.length-1;i++){
							temp1=temp1.concat(title[i]+":-");

						}
						//System.out.println(temp1.length());
						temp1=temp1.substring(0,temp1.length()-2);
					}
					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[3].equals("00 Technical data")){
						if (title.length==7)
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}

					} 

					///////////////////////////////////////////////////////////////////////////////////////			
					if (title[3].equals("20 Fuel supply, gas operation")){
						if ((title.length==7)||(title.length==6))
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}

					}
					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[3].equals("26 Exhaust system")){
						//System.out.println(title.length);
						if ((title.length==7)||(title.length==6))
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}
						else
							temp1=title[title.length-1];

					}
					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[1].equals("Power transmission")){
						//	System.out.println(title.length);

						if ((title.length==7)){
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}
						if (title[3].equals("38 Automatic gearbox, gears, control")&& title[4].equals("Removing and installing valve body")&&title.length>5&&!title[5].contains("Assembly")){
							temp1=title[5]+":-"+temp1;
							String[] duplicatechecker= temp1.split(":-");
							if (duplicatechecker[0].equals(duplicatechecker[1])){
								temp1=duplicatechecker[duplicatechecker.length-2]+":-"+duplicatechecker[duplicatechecker.length-1];
							}
						}
						temp1=temp1.concat("("+title[2]+")");
					}


					///////////////////////////////////////////////////////////////////////////////////////			

					if (title[1].equals("Power unit")){
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
							//	System.out.println("#########################################");
						}

						temp1=temp1.substring(0,temp1.length()-2);

					}
					///////////////////////////////////////////////////////////////////////////////////////			
					if(title.length>4){
						if(title[3].equals("94 Lights, lamps, switches outside")||title[3].equals("96 Lights, lamps, switches inside, anti-theft system")){

							if ((title.length==7)||(title.length==6))
							{
								temp1=title[title.length-2]+":-"+title[title.length-1];

							}
							else
								temp1=title[title.length-1];



						}
					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if (title[3].equals("80 Heating")){
						if (title.length==7)
						{
							temp1=title[title.length-2]+":-"+title[title.length-1];

						}

					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if (title[3].equals("87 Air conditioner")){
						if (title[4].contains("manual controls"))
						{
							temp1=temp1+" (Manual Controls)";

						}
						else if (title[4].contains("automatic regulation")){

							temp1=temp1+" (Automatic Regulation)";

						}
						else if (title[4].equals("Bracket for air conditioner compressor")){
							if (title.length==7){
								temp1=title[title.length-2]+":-"+title[title.length-1];

							}
							if (title.length==6){
								temp1=title[title.length-1];

							}

						}


					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if(title[3].equals("45 ABS, ADR, TCS, EDL, ESP")){
						temp1=title[title.length-2]+":-"+title[title.length-1];

					}
					/////////////////////////////////////////////////////////////////////////////////////////
					if(title[1].equals("Technical product information")){
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
		PrintWriter writer = new PrintWriter(args[1]+"TitleList.txt", "UTF-8");
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