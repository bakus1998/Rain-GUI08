import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComponentRain extends JComponent implements ActionListener {
    int drops_int;
    int y=30;
    Timer time = new Timer(10,this);
    int rainArray[][];
    int widht=1280;
    int height=720;

    public JComponentRain(){
        drops_int=100;
        int array[][] = new int [drops_int][3];
        for(int i=0;i<array.length;i++){
            array[i][0]=(int)(Math.random()*widht);  //x
            array[i][1]=(int)(Math.random()*height-50); //y
            array[i][2]=(int)(Math.random()*40)+15;
        }
        rainArray=array;
    }

    public void paintComponent(Graphics g){
        int thickness = 1; //grubosc
        int x=5;
        for(int i=0;i<rainArray.length;i++){
            g.fillRect(rainArray[i][0],rainArray[i][1],thickness,rainArray[i][2]);
            rainArray[i][1]=rainArray[i][1]+(y/4);
            if(rainArray[i][1]>height){
                rainArray[i][1]=0;
            }
        }
        time.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void setComponent(int drops,int speed){
        drops_int=drops;
        y=speed;
        int array[][] = new int [drops_int][3];

        for(int i=0;i<array.length;i++){
            array[i][0]=(int)(Math.random()*widht);  //x
            array[i][1]=(int)(Math.random()*height); //y
            array[i][2]=(int)(Math.random()*40)+15;

            System.out.println("x: "  +array[i][0] + ", y: " + array[i][1] + ", dlugosc: " + array[i][2]);
        }

        rainArray=array;
    }
}
