package analogClock;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import 	java.time.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

	public class Alarm  implements ActionListener
	{
		Alarm(){
			
		}
		int x=0;
		//Declarations
		String hour1,min1;
		JFrame frame1=new JFrame("Alarm");
		JButton adder=new JButton("Click To add Alarm");
		JTextField[] Alarms=new JTextField[7];
		JButton save=new JButton("Save");
		String holder[]=new String[7];
		String hours[]=new String[7];
		String mins[]=new String[7];
		public int hour,min;

			
			//Method to create alarms interface
	public void create()
		{
		//Creates the textfields to take in Alarms
		for(int i=0;i<7;i++)
		{
			Alarms[i]=new JTextField("HH:MM");
		}
			//Frame
			frame1.setSize(218,540);
			frame1.setLocation(423,00);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setVisible(true);
			frame1.setLayout(null);
			
		
			//Add button
			adder.setLocation(0,0);
			adder.setSize(200,100);
			adder.addActionListener(this);
			frame1.add(adder);
			
			
			//TextFields
			Alarms[0].setLocation(0,100);
			Alarms[0].setSize(200,50);
			frame1.add(Alarms[0]);
			Alarms[0].setVisible(false);
			
			
			Alarms[1].setLocation(0,150);
			Alarms[1].setSize(200,50);
			frame1.add(Alarms[1]);
			Alarms[1].setVisible(false);
			
			
			Alarms[2].setLocation(0,200);
			Alarms[2].setSize(200,50);
			frame1.add(Alarms[2]);
			Alarms[2].setVisible(false);
			
			
			Alarms[3].setLocation(0,250);
			Alarms[3].setSize(200,50);
			frame1.add(Alarms[3]);
			Alarms[3].setVisible(false);
			
			
			Alarms[4].setLocation(0,300);
			Alarms[4].setSize(200,50);
			frame1.add(Alarms[4]);
			Alarms[4].setVisible(false);
			
		
			Alarms[5].setLocation(0,350);
			Alarms[5].setSize(200,50);
			frame1.add(Alarms[5]);
			Alarms[5].setVisible(false);
			
			
			Alarms[6].setLocation(0,400);
			Alarms[6].setSize(200,50);
			frame1.add(Alarms[6]);
			Alarms[6].setVisible(false);
			
			//Save Button 
			save.setLocation(0,450);
			save.setSize(200,50);
			save.addActionListener(this);
			frame1.add(save);
			save.setVisible(true);
		
		}
		
			
			
			
			
			
		
		public void actionPerformed(ActionEvent e)
		{
			
			if(e.getSource()==adder)
			{
				x++;	
				if(x==1)
				{
					Alarms[0].setVisible(true);
				}
				if(x==2)
				{
					Alarms[1].setVisible(true);
				}
				if(x==3)
				{
					Alarms[2].setVisible(true);
				}
				if(x==4)
				{
					Alarms[3].setVisible(true);
				}
				if(x==5)
				{
					Alarms[4].setVisible(true);
				}
				if(x==6) 
				{
					Alarms[5].setVisible(true);
				}
				if(x==7) 
				{
					Alarms[6].setVisible(true);
				}
			}//Save Button
			if(e.getSource()==save)
			{
				System.out.println("saved");
				for(int a=0;a<x;a++)
				{
					holder[a]=Alarms[a].getText();
					hours[a]=holder[a].substring(0,2);
					mins[a]=holder[a].substring(3,5);
					
				}
				Timer timer=new Timer(500,new ActionListener(){

					public void actionPerformed(ActionEvent s) {
						RingAlarm();
					}});
				timer.start();
				
			}}
		//Method for creating sound
		public void RingAlarm() 
		{
			//Gets an instance of Current System Time
			LocalTime n=LocalTime.now();
			this.hour=n.getHour();
			this.min=n.getMinute();
			
			for(int j=0;j<x;j++)
			{
				if(hours[j].equals(Integer.toString(this.hour))&&mins[j].equals(Integer.toString(this.min)))
				{  try {
			        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\hamda\\Downloads\\lol\\HAMDAN.wav").getAbsoluteFile());
			        Clip clip = AudioSystem.getClip();
			        clip.open(audioInputStream);
			        clip.start();
			       
			    } catch(Exception ex) {
			        System.out.println("Error with playing sound.");
			       ex.printStackTrace();
			    }}
			}
		
		}
	}		
	
		
		