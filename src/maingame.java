import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.*;
public class maingame {
    
    JFrame frame;
    Container con;
    JPanel mainTextPanel;
    JLabel  bg;
    JTextArea maintextArea;
    Font normaltext=new Font("Angsana New",Font.PLAIN,28);
    JButton btn1,btn2,btn3,Continue,re,heart,square;
    choice ch=new choice();
    setting set=new setting();
    public static void main(String[] args)throws FileNotFoundException {
        new maingame();
        while(true){
            File Music = new File ("Music//realBGM.wav");
            PlayMusic(Music);}
    }

    public static void PlayMusic(File Music){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Music));
            clip.start();

            Thread.sleep(clip.getMicrosecondLength()/1000);
        }
        catch(Exception e){}
    }

    public maingame(){ //menu
        frame=new JFrame();
        frame.setSize(1024,784); //ขนาดหน้าจอเกม
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //การปิดโปรแกรม
		frame.setLocationRelativeTo(null); //set ตรงกลางจอ
        frame.setTitle("Real Happy Ending"); //ชื่อแถบโปรแกรม
        frame.setResizable(false); //set ให้ขยายหน้าจอไม่ได้เพราะกลัวรูปมันไม่ขยายตาม
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("pic//icon.jpg"));
        frame.setIconImage(icon);
        con=frame.getContentPane();
        
        ImageIcon start = new ImageIcon(getClass().getResource("pic//START.png"));
        btn1 = new JButton(start);
        btn1.setBounds(400, 530, 200, 60);
        btn1.addActionListener(set);//ตอบสนองการคลิกปุ่ม
        btn1.setActionCommand("start"); 
        btn1.setFocusPainted(false);
        con.add(btn1);
        
        ImageIcon Exit = new ImageIcon(getClass().getResource("pic//EXIT.png"));
        btn3 = new JButton(Exit);
        btn3.setBounds(400, 620, 200, 60);
        btn3.addActionListener(set);
        btn3.setActionCommand("exit");
        btn3.setFocusPainted(false);
        con.add(btn3);

        ImageIcon image=new ImageIcon(getClass().getResource()"pic//bg.png");//ตรงนี้ให้ใส่เป็นที่อยู่ไฟล์ที่จะใช้เป็นพื้นหลัง
        bg=new JLabel("",image,JLabel.CENTER); //บอกให้รูปมันไปอยู่ในจอ
        bg.setBounds(0, 0, 1024, 784);//สเกลของรูปจะไปอยู่ตรงไหนของจอ (x,y,w,h)
        frame.add(bg);
        frame.setVisible(true);
        
    }
    public void pregame(){
        frame.remove(bg);
        btn1.setVisible(false);
        btn3.setVisible(false);

        ImageIcon Continue = new ImageIcon("pic//กุหลาบ.gif");
        btn2 = new JButton(Continue);
        btn2.setFont(normaltext);
        btn2.setBounds(0, 0, 1024, 784);
        btn2.setFocusPainted(false);
        btn2.addActionListener(ch);
        btn2.setActionCommand("ingame");
        con.add(btn2);
        
    }
    public void ingame(){ //frame1
        btn2.setVisible(false);

        mainTextPanel=new JPanel();
        mainTextPanel.setFont(normaltext);
        mainTextPanel.setBounds(100,530, 800, 180);
        mainTextPanel.setBackground(Color.white);
        //con.add(mainTextPanel);

        ImageIcon charac=new ImageIcon("pic//สีชมพู.png");
        Continue = new JButton(charac);
        Continue.setBounds(720, 530, 180, 180);
        Continue.setBackground(Color.white);
        Continue.setFocusPainted(false);
        Continue.addActionListener(ch);
        Continue.setActionCommand("screen"); 
        con.add(Continue);

        ImageIcon reset=new ImageIcon("pic//reset.png");
        re = new JButton(reset);
        re.setBounds(900, 0, 100, 50);
        re.setFocusPainted(false);
        re.addActionListener(set);
        re.setActionCommand("reset"); 
        con.add(re);
        
        maintextArea=new JTextArea("[โรงเรียนคุณหนูผู้เปี่ยมไปด้วยสีสันอันหอมหวานของดอกไม้นานาพันธุ์\nจากทั่วทุกมุมโลก โรงเรียนอันโด่งดังที่ลือกันว่าหากเป็นผู้ที่ถูกเลือก\nจากนักเรียนทั่วทั้งโรงเรียน บุคคลผู้นั้นจะสามารถสร้างสวนดอกไม้\nที่เต็มไปด้วยดอกไม้ที่ตนต้องการได้]");
        maintextArea.setBounds(150, 550, 700, 150);
        maintextArea.setBackground(Color.white);
        maintextArea.setForeground(Color.black);
        maintextArea.setFont(normaltext);
        maintextArea.setLineWrap(true);
        maintextArea.setEditable(false);
        maintextArea.setWrapStyleWord(true);
        mainTextPanel.add(maintextArea);
        con.add(mainTextPanel);

        ImageIcon image=new ImageIcon("pic//f1.png");//ตรงนี้ให้ใส่เป็นที่อยู่ไฟล์ที่จะใช้เป็นพื้นหลัง
        bg=new JLabel("",image,JLabel.CENTER); //บอกให้รูปมันไปอยู่ในจอ
        bg.setBounds(0, 0, 1024, 784);
        frame.add(bg);
        
    }
    public void screen(ImageIcon screen,String x){
        btn2 = new JButton(screen);
        btn2.setBounds(0, 0, 1024, 784);
        btn2.setFocusPainted(false);
        btn2.addActionListener(ch);
        btn2.setActionCommand(x);
        con.add(btn2);
    }
    public void screenend(ImageIcon screen){
        btn2 = new JButton(screen);
        btn2.setBounds(0, 0, 1024, 784);
        btn2.setFocusPainted(false);
        btn2.addActionListener(set);
        btn2.setActionCommand("reset");
        con.add(btn2);
    }
    public void house(String x,ImageIcon charac){ //" โรส ไว้มาสร้างสวนดอกไม้ที่เป็นของเรากันเองเถอะนะ สวนดอกไม้ที่สวยงามที่สุดในโลกใบนี้ "
        
        mainTextPanel=new JPanel();
        mainTextPanel.setFont(normaltext);
        mainTextPanel.setBounds(100,500, 800, 180);
        mainTextPanel.setBackground(Color.white);

        Continue = new JButton(charac);
        Continue.setBounds(720, 500, 180, 180);
        Continue.setBackground(Color.white);
        Continue.setFocusPainted(false);
        Continue.addActionListener(ch);
        Continue.setActionCommand("house"); 
        con.add(Continue);
        re.setVisible(true);
        
        maintextArea=new JTextArea(x);
        maintextArea.setBounds(150, 520, 700, 150);
        maintextArea.setBackground(Color.white);
        maintextArea.setForeground(Color.black);
        maintextArea.setFont(normaltext);
        maintextArea.setLineWrap(true);
        maintextArea.setEditable(false);
        maintextArea.setWrapStyleWord(true);
        mainTextPanel.add(maintextArea);
        con.add(mainTextPanel);

        ImageIcon image=new ImageIcon("pic//บ้านโรส.png");//ตรงนี้ให้ใส่เป็นที่อยู่ไฟล์ที่จะใช้เป็นพื้นหลัง
        bg=new JLabel("",image,JLabel.CENTER); //บอกให้รูปมันไปอยู่ในจอ
        bg.setBounds(0, 0, 1024, 784);
        frame.add(bg);
    }
    public void garden(ImageIcon Rose){
        frame.remove(bg);
        maintextArea.setVisible(false);
        Continue.setVisible(false);

        Continue = new JButton(Rose);
        Continue.setBounds(720, 500, 180, 180);
        Continue.setBackground(Color.white);
        Continue.setFocusPainted(false);
        Continue.addActionListener(ch);
        Continue.setActionCommand("S");
        con.add(Continue);
        re.setVisible(true);
        
        maintextArea=new JTextArea("[นี่เป็นเช้าวันแรกที่โรสก้าวเข้ามาในโรงเรียนแห่งนี้ ทุกสิ่งทุกอย่าง\nดูใหญ่โตไปเสียหมด แต่สิ่งที่โด่งดังที่สุดก็คงจะเป็นสวนดอกกุหลาบ\nที่ตั้งอยู่ใจกลางของโรงเรียน เป็นสวนกุหลาบที่ทุกๆปีจะสามารถ\nเปลี่ยนดอกไม้ในสวนตามใจของผู้ที่ได้รับเลือก นั้นเป็นประเพณี\nที่มีชื่อเรียกตามชื่อโรงเรียน ประเพณี 'ลา เฟลอค์']");
        maintextArea.setBounds(150, 520, 700, 150);
        maintextArea.setBackground(Color.white);
        maintextArea.setForeground(Color.black);
        maintextArea.setFont(normaltext);
        maintextArea.setLineWrap(true);
        maintextArea.setEditable(false);
        maintextArea.setWrapStyleWord(true);
        mainTextPanel.add(maintextArea);
        con.add(mainTextPanel);

        ImageIcon image=new ImageIcon("pic//สวนรร..png");//ตรงนี้ให้ใส่เป็นที่อยู่ไฟล์ที่จะใช้เป็นพื้นหลัง
        bg=new JLabel("",image,JLabel.CENTER); //บอกให้รูปมันไปอยู่ในจอ
        bg.setBounds(0, 0, 1024, 784);
        frame.add(bg);
    }
    public void school(ImageIcon charac,String text){

        Continue = new JButton(charac);
        Continue.setBounds(720, 500, 180, 180);
        Continue.setBackground(Color.white);
        Continue.setFocusPainted(false);
        Continue.addActionListener(ch);
        Continue.setActionCommand("S");
        con.add(Continue);
        re.setVisible(true);
        
        maintextArea=new JTextArea(text);
        maintextArea.setBounds(150, 520, 700, 150);
        maintextArea.setBackground(Color.white);
        maintextArea.setForeground(Color.black);
        maintextArea.setFont(normaltext);
        maintextArea.setLineWrap(true);
        maintextArea.setEditable(false);
        maintextArea.setWrapStyleWord(true);
        mainTextPanel.add(maintextArea);
        con.add(mainTextPanel);

        ImageIcon image=new ImageIcon("pic//real school.png");//ตรงนี้ให้ใส่เป็นที่อยู่ไฟล์ที่จะใช้เป็นพื้นหลัง
        bg=new JLabel("",image,JLabel.CENTER); //บอกให้รูปมันไปอยู่ในจอ
        bg.setBounds(0, 0, 1024, 784);
        frame.add(bg);
    }
    public void field(ImageIcon charac,String command,String text){
        frame.remove(bg);
        Continue.setVisible(false);
        maintextArea.setVisible(false);
        
        Continue = new JButton(charac);
        Continue.setBounds(720, 500, 180, 180);
        Continue.setBackground(Color.white);
        Continue.setFocusPainted(false);
        Continue.addActionListener(ch);
        Continue.setActionCommand(command);
        con.add(Continue);
        re.setVisible(true);
        
        maintextArea=new JTextArea(text);
        maintextArea.setBounds(150, 520, 700, 150);
        maintextArea.setBackground(Color.white);
        maintextArea.setForeground(Color.black);
        maintextArea.setFont(normaltext);
        maintextArea.setLineWrap(true);
        maintextArea.setEditable(false);
        maintextArea.setWrapStyleWord(true);
        mainTextPanel.add(maintextArea);
        con.add(mainTextPanel);

        ImageIcon image=new ImageIcon("pic//สนามหญ้า.png");//ตรงนี้ให้ใส่เป็นที่อยู่ไฟล์ที่จะใช้เป็นพื้นหลัง
        bg=new JLabel("",image,JLabel.CENTER); //บอกให้รูปมันไปอยู่ในจอ
        bg.setBounds(0, 0, 1024, 784);
        frame.add(bg);
    }
    public void root(String good,String bad,String commandgood,String commandbad,ImageIcon image){
        heart=new JButton(good);
        heart.setBounds(150, 300, 700, 80);
        heart.setBackground(Color.white);
        heart.setForeground(Color.black);
        heart.setFont(normaltext);
        heart.setFocusPainted(false);
        heart.addActionListener(ch);
        heart.setActionCommand(commandgood);
        con.add(heart);

        square=new JButton(bad);
        square.setBounds(150, 400, 700, 80);
        square.setBackground(Color.white);
        square.setForeground(Color.black);
        square.setFont(normaltext);
        square.setFocusPainted(false);
        square.addActionListener(ch);
        square.setActionCommand(commandbad);
        con.add(square);

        bg=new JLabel("",image,JLabel.CENTER); //บอกให้รูปมันไปอยู่ในจอ
        bg.setBounds(0, 0, 1024, 784);
        frame.add(bg);
    }
    public void hospital(String text,ImageIcon charac,String command){
        heart.setVisible(false);
        square.setVisible(false);
        frame.remove(bg);
        maintextArea.setVisible(false);
        Continue.setVisible(false);

        Continue = new JButton(charac);
        Continue.setBounds(720, 500, 180, 180);
        Continue.setBackground(Color.white);
        Continue.setFocusPainted(false);
        Continue.addActionListener(ch);
        Continue.setActionCommand(command); 
        con.add(Continue);
        re.setVisible(true);
        
        maintextArea=new JTextArea(text);
        maintextArea.setBounds(150, 520, 700, 150);
        maintextArea.setBackground(Color.white);
        maintextArea.setForeground(Color.black);
        maintextArea.setFont(normaltext);
        maintextArea.setLineWrap(true);
        maintextArea.setEditable(false);
        maintextArea.setWrapStyleWord(true);
        mainTextPanel.add(maintextArea);
        con.add(mainTextPanel);

        ImageIcon image=new ImageIcon("pic//ห้องพยาบาล.png");//ตรงนี้ให้ใส่เป็นที่อยู่ไฟล์ที่จะใช้เป็นพื้นหลัง
        bg=new JLabel("",image,JLabel.CENTER); //บอกให้รูปมันไปอยู่ในจอ
        bg.setBounds(0, 0, 1024, 784);
        frame.add(bg);
    }
    public void hallway(String text,ImageIcon charac,String command){
        heart.setVisible(false);
        square.setVisible(false);
        frame.remove(bg);
        maintextArea.setVisible(false);
        Continue.setVisible(false);

        Continue = new JButton(charac);
        Continue.setBounds(720, 500, 180, 180);
        Continue.setBackground(Color.white);
        Continue.setFocusPainted(false);
        Continue.addActionListener(ch);
        Continue.setActionCommand(command); 
        con.add(Continue);
        re.setVisible(true);
        
        maintextArea=new JTextArea(text);
        maintextArea.setBounds(150, 520, 700, 150);
        maintextArea.setBackground(Color.white);
        maintextArea.setForeground(Color.black);
        maintextArea.setFont(normaltext);
        maintextArea.setLineWrap(true);
        maintextArea.setEditable(false);
        maintextArea.setWrapStyleWord(true);
        mainTextPanel.add(maintextArea);
        con.add(mainTextPanel);

        ImageIcon image=new ImageIcon("pic//ทางเดิน.png");//ตรงนี้ให้ใส่เป็นที่อยู่ไฟล์ที่จะใช้เป็นพื้นหลัง
        bg=new JLabel("",image,JLabel.CENTER); //บอกให้รูปมันไปอยู่ในจอ
        bg.setBounds(0, 0, 1024, 784);
        frame.add(bg);
    }
    public void schoolroom(String text,ImageIcon charac,String command){
        heart.setVisible(false);
        square.setVisible(false);
        frame.remove(bg);
        maintextArea.setVisible(false);
        Continue.setVisible(false);

        Continue = new JButton(charac);
        Continue.setBounds(720, 500, 180, 180);
        Continue.setBackground(Color.white);
        Continue.setFocusPainted(false);
        Continue.addActionListener(ch);
        Continue.setActionCommand(command); 
        con.add(Continue);
        re.setVisible(true);
        
        maintextArea=new JTextArea(text);
        maintextArea.setBounds(150, 520, 700, 150);
        maintextArea.setBackground(Color.white);
        maintextArea.setForeground(Color.black);
        maintextArea.setFont(normaltext);
        maintextArea.setLineWrap(true);
        maintextArea.setEditable(false);
        maintextArea.setWrapStyleWord(true);
        mainTextPanel.add(maintextArea);
        con.add(mainTextPanel);

        ImageIcon image=new ImageIcon("pic//ห้องเรียน.png");//ตรงนี้ให้ใส่เป็นที่อยู่ไฟล์ที่จะใช้เป็นพื้นหลัง
        bg=new JLabel("",image,JLabel.CENTER); //บอกให้รูปมันไปอยู่ในจอ
        bg.setBounds(0, 0, 1024, 784);
        frame.add(bg);
    }
    public void lastGarden(String text,ImageIcon charac,String command){
        heart.setVisible(false);
        square.setVisible(false);
        frame.remove(bg);
        maintextArea.setVisible(false);
        Continue.setVisible(false);

        Continue = new JButton(charac);
        Continue.setBounds(720, 500, 180, 180);
        Continue.setBackground(Color.white);
        Continue.setFocusPainted(false);
        Continue.addActionListener(ch);
        Continue.setActionCommand(command); 
        con.add(Continue);
        re.setVisible(true);
        
        maintextArea=new JTextArea(text);
        maintextArea.setBounds(150, 520, 700, 150);
        maintextArea.setBackground(Color.white);
        maintextArea.setForeground(Color.black);
        maintextArea.setFont(normaltext);
        maintextArea.setLineWrap(true);
        maintextArea.setEditable(false);
        maintextArea.setWrapStyleWord(true);
        mainTextPanel.add(maintextArea);
        con.add(mainTextPanel);

        ImageIcon image=new ImageIcon("pic//ฉากสวนตอนจบ.png");//ตรงนี้ให้ใส่เป็นที่อยู่ไฟล์ที่จะใช้เป็นพื้นหลัง
        bg=new JLabel("",image,JLabel.CENTER); //บอกให้รูปมันไปอยู่ในจอ
        bg.setBounds(0, 0, 1024, 784);
        frame.add(bg);
    }
    public void libary(String text,ImageIcon charac,String command){
        heart.setVisible(false);
        square.setVisible(false);
        frame.remove(bg);
        maintextArea.setVisible(false);
        Continue.setVisible(false);

        Continue = new JButton(charac);
        Continue.setBounds(720, 500, 180, 180);
        Continue.setBackground(Color.white);
        Continue.setFocusPainted(false);
        Continue.addActionListener(ch);
        Continue.setActionCommand(command); 
        con.add(Continue);
        re.setVisible(true);
        
        maintextArea=new JTextArea(text);
        maintextArea.setBounds(150, 520, 700, 150);
        maintextArea.setBackground(Color.white);
        maintextArea.setForeground(Color.black);
        maintextArea.setFont(normaltext);
        maintextArea.setLineWrap(true);
        maintextArea.setEditable(false);
        maintextArea.setWrapStyleWord(true);
        mainTextPanel.add(maintextArea);
        con.add(mainTextPanel);

        ImageIcon image=new ImageIcon("pic//ห้องสมุด.png");//ตรงนี้ให้ใส่เป็นที่อยู่ไฟล์ที่จะใช้เป็นพื้นหลัง
        bg=new JLabel("",image,JLabel.CENTER); //บอกให้รูปมันไปอยู่ในจอ
        bg.setBounds(0, 0, 1024, 784);
        frame.add(bg);
    }
    public void specialscreen(String text,ImageIcon charac,String command,ImageIcon image){
        heart.setVisible(false);
        square.setVisible(false);
        frame.remove(bg);
        mainTextPanel.setVisible(true);
        maintextArea.setVisible(false);
        Continue.setVisible(false);

        Continue = new JButton(charac);
        Continue.setBounds(720, 500, 180, 180);
        Continue.setBackground(Color.white);
        Continue.setFocusPainted(false);
        Continue.addActionListener(ch);
        Continue.setActionCommand(command); 
        con.add(Continue);
        re.setVisible(true);
        
        maintextArea=new JTextArea(text);
        maintextArea.setBounds(150, 520, 700, 150);
        maintextArea.setBackground(Color.white);
        maintextArea.setForeground(Color.black);
        maintextArea.setFont(normaltext);
        maintextArea.setLineWrap(true);
        maintextArea.setEditable(false);
        maintextArea.setWrapStyleWord(true);
        mainTextPanel.add(maintextArea);
        con.add(mainTextPanel);

        bg=new JLabel("",image,JLabel.CENTER); //บอกให้รูปมันไปอยู่ในจอ
        bg.setBounds(0, 0, 1024, 784);
        frame.add(bg);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public class setting implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String button = event.getActionCommand();
            if(button=="start"){
                pregame();}
            else if(button =="exit"){System.exit(0);}
            else if(button=="reset"){
                frame.dispose();
                new maingame();}
        }
    }
    public class choice implements ActionListener{
        int i=-1,j=-1,a=0,b=-1,rootcase=-1;
        ImageIcon mom=new ImageIcon("pic//แม่โรส.png");
        ImageIcon friend=new ImageIcon("pic//เพื่อน.png");
        ImageIcon action1=new ImageIcon("pic//ตปก1.png");
        ImageIcon action2=new ImageIcon("pic//ตปก2.png");
        ImageIcon action3=new ImageIcon("pic//ตปก3.png");
        ImageIcon idol=new ImageIcon("pic//พิธีกร.png");
        ImageIcon elm=new ImageIcon("pic//เอล์มไม่รู้.png");
        ImageIcon rosa=new ImageIcon("pic//โรซาเลียไม่รู้.png");
        ImageIcon Rose=new ImageIcon("pic//โรส.png");
        ImageIcon Elm=new ImageIcon("pic//เอล์มหน้าปกติ.png");
        ImageIcon Elmangry=new ImageIcon("pic//เอล์มโกรธ.png");
        ImageIcon Elmhappy=new ImageIcon("pic//เอล์มดีใจ.png");
        ImageIcon ElmStunt=new ImageIcon("pic//เอล์มอึ้ง.png");
        ImageIcon RoseWorry=new ImageIcon("pic//โรสกังวล.png");
        ImageIcon RoseSerious=new ImageIcon("pic//โรสจริงจัง.png");
        ImageIcon RoseStunt=new ImageIcon("pic//โรสอึ้ง.png");
        ImageIcon RoseDo=new ImageIcon("pic//โรสดูถูก.png");
        ImageIcon RosaSerious=new ImageIcon("pic//โรซาเลียลำบากใจ.png");
        ImageIcon RosaStunt=new ImageIcon("pic//โรซาเลียตกใจ.png");
        ImageIcon Rosa=new ImageIcon("pic//โรซาเลียปกติ.png");
        ImageIcon roseIcon=new ImageIcon("pic//สีชมพู.png");
        ImageIcon badend1=new ImageIcon("pic//BAD1.png");
        ImageIcon badend2=new ImageIcon("pic//BAD2.png");
        ImageIcon badend3=new ImageIcon("pic//BAD3.png");
        ImageIcon badend4=new ImageIcon("pic//BAD4.png");
        ImageIcon badend5=new ImageIcon("pic//BAD5.png");
        ImageIcon normal=new ImageIcon("pic//NORMAL ENDING.png");
        ImageIcon realhappy=new ImageIcon("pic//REAL HAPPY ENDING.png");
        ImageIcon normalending=new ImageIcon("pic//NORMAL END.png");
        ImageIcon realhappyending=new ImageIcon("pic//REAL END.png");
 
        ImageIcon ingame1=new ImageIcon("pic//school.gif");
        ImageIcon ingame2=new ImageIcon("pic//โรสไว้มาสร้าง.gif");
        ImageIcon filed=new ImageIcon("pic//สนามหญ้า.png");
        ImageIcon hospital=new ImageIcon("pic//ห้องพยาบาล.png");
        ImageIcon hallway =new ImageIcon("pic//ทางเดิน.png");
        ImageIcon libary =new ImageIcon("pic//ห้องสมุด.png");
        ImageIcon schoolroom =new ImageIcon("pic//ห้องเรียน.png");
        ImageIcon lastgarden =new ImageIcon("pic//ฉากสวนตอนจบ.png");
        ImageIcon lunch =new ImageIcon("pic//พักเที่ยง.png");

        ImageIcon Rosaria =new ImageIcon("pic//โรซาเลียร้องไห้.png");
        ImageIcon secret =new ImageIcon("pic//ตัวละครลับ.png");
        ImageIcon Rosariamis=new ImageIcon("pic//ฉากเปิดหน้า.png");
        public void actionPerformed(ActionEvent event){
            String button = event.getActionCommand();
            if(button=="ingame"){ingame();}
            else if(button=="screen"){
                frame.remove(bg);
                mainTextPanel.setVisible(false);
                maintextArea.setVisible(false);
                Continue.setVisible(false);
                re.setVisible(false);
                btn2.setVisible(false);
                a++;
                if(a==0){//ingame
                    screen(ingame1,"screen");}
                else if(a==1){ //ingame
                    screen(ingame2,"house");}
            }   
            else if(button=="house"){
                String x[]={new String(" แม่ : โรส วันนี้ไปโรงเรียนวันแรกต้องทำตัวดีๆนะลูก "),new String(" โรส : รับทราบค่ะ ท่านแม่"),new String("( นี่เป็นเวลาที่ฉันรอคอยมาเนิ่นนาน เวลาที่ฉันจะได้ก้าวสู่\nรั้วโรงเรียนคุณหนูชื่อดัง ! และครั้งนี้ฉันจะต้องตามหาเธอให้ได้ \nบุคคลในความทรงจำของฉัน ในที่สุดฉันก็จะสร้างสวนดอกไม้\nที่เต็มไปด้วยดอก... )")};
                i++;
                if(i==0){
                    btn2.setVisible(false);
                    house(x[i],mom);}
                else if(i==1){
                    frame.remove(bg);
                    Continue.setVisible(false);
                    mainTextPanel.setVisible(false);
                    maintextArea.setVisible(false);
                    house(x[i],Rose);}
                else if(i==2){
                    frame.remove(bg);
                    Continue.setVisible(false);
                    mainTextPanel.setVisible(false);
                    maintextArea.setVisible(false);
                    house(x[i],Rose);}
                else{garden(Rose);}
            }
            else if(button=="S"){
                j++;
                String x[]={new String(" โรส : ที่นี่ใหญ่เป็นบ้าเลยนะ ไม่รู้ว่าจะตามหาเธอคนนั้นเจอที่นี่มั้ย"),new String(" โรส : ว่าแต่หอประชุมมันอยู่ตรงไหนของโรงเรียนกันละเนี่ย \nเดินผ่านตรงทางเข้าแล้วเลี้ยวขวา ? เอ๋ ? เดินผ่านสนามหญ้าเหรอ... ")};
                if(j==0){
                    frame.remove(bg);
                    Continue.setVisible(false);
                    maintextArea.setVisible(false);
                    school(Rose,x[j]);}
                else if(j==1){
                    frame.remove(bg);
                    Continue.setVisible(false);
                    maintextArea.setVisible(false);
                    school(Rose,x[j]);}
                else{field(elm, "root", " ??? : ระวัง!!! อย่าเดินผ่านมาตรงทางเดินเวลานี้!!!!! ");}
            }
            else if(button=="root"){
                String root1[]={new String("1) หลบ "),new String("2) ไม่หลบ")};
                String root2[]={new String("1) บอกลาแล้วขอตัวไปหอประชุมเพราะสายมากแล้ว"),new String("2) ทำแผลให้แอล์ม")};
                String root3[]={new String("1) ไม่ไปดู"),new String("2) ไปดู")};
                String root4[]={new String("1) เข้าไปช่วย"),new String("2) นี่มันไม่ใช่เรื่องของฉันหนิ")};
                String root5[]={new String("1) ไม่ไปดูการแข่งขัน"),new String("2) ไปดูการแข่งขัน")};
                String root6[]={new String("1) วิ่งหันกลับไปดึงโรซาเลียไว้"),new String("2) เลือกเอล์มแล้วลืมเรื่องสัญญาซะ")};
                rootcase++;
                frame.remove(bg);
                Continue.setVisible(false);
                mainTextPanel.setVisible(false);
                maintextArea.setVisible(false);
                if(rootcase==0){root(root1[0], root1[1], "goodend1", "badend1", filed);}
                else if(rootcase==1){root(root2[0],root2[1],"badend2","goodend2",hospital);}
                else if(rootcase==2){root(root3[0],root3[1],"badend3","goodend3",hallway);}
                else if(rootcase==3){root(root4[0], root4[1], "goodend4", "badend4", hallway);}
                else if(rootcase==4){root(root5[0], root5[1], "badend5", "goodend5", schoolroom);}
                else if(rootcase==5){root(root6[0], root6[1], "realhappy", "normalend", lastgarden);}
                }
            else if(button == "badend1"){
                b++;
                String x[]={new String(" [ฉันได้ยินเสียงของผู้หญิงดังขึ้นแต่ว่าขาของฉันดันไม่ขยับเนี่ยสิ \nทำยังไงดี เจ้าขา!!] ")
                ,new String("โครม !!!")
                ,new String("??? : โอ้ย นี่เธอทำไมถึงไม่หลบเนี่ย?!?!")
                ,new String("[ทำยังไงดีล่ะ ดูเหมือนเธอจะโกรธมากด้วยสิ]")
                ,new String("โรส : ขอโทษนะคะ ขอโทษจริงๆค่ะ เป็นอะไรมากมั้ยคะ ?")
                ,new String("[ฉันพยายามที่จะพยุงผู้หญิงคนนั้นขึ้นมา แต่ว่าเธอกลับปัดมือของฉันทิ้ง]")
                ,new String("???: ขอบใจที่พยายามจะช่วยแต่ไม่ต้อง ฉันไม่ต้องการ")
                ,new String("[ เป็นสีหน้าที่น่ากลัวสุดๆเลย ทำเอาซะจนไม่กล้ามองหน้า\nหรือขยับไปไหนเลย ฉันจึงเลือกที่จะอยู่เงียบๆไว้ ] ")
                ,new String("???: เฮ้ ถ้าหากว่าเธอไม่คิดจะพูดอะไรอีกก็เชิญออกไปจากลู่วิ่งที \nไม่รู้เหรอว่าเขาไม่ให้มาเดินผ่านตอนนักกีฬาซ้อม ออกไปซักที\nมันเสียเวลาคนอื่นซ้อม ")
                ,new String("โรส : อะ...")};
                if(b==0){
                    heart.setVisible(false);
                    square.setVisible(false);
                    mainTextPanel.setVisible(true);
                    field(RoseWorry, "badend1", x[b]);}
                else if(b==1){field(roseIcon, "badend1", x[b]);}
                else if(b==2){field(elm, "badend1", x[b]);}
                else if(b==3){field(RoseWorry, "badend1", x[b]);}
                else if(b==4){field(RoseWorry, "badend1", x[b]);}
                else if(b==5){field(RoseWorry, "badend1", x[b]);}
                else if(b==6){field(elm, "badend1", x[b]);}
                else if(b==7){field(RoseWorry, "badend1", x[b]);}
                else if(b==8){field(elm, "badend1", x[b]);}
                else if(b==9){field(RoseWorry, "badend1", x[b]);}
                else{
                    re.setVisible(false);
                    frame.remove(bg);
                    Continue.setVisible(false);
                    mainTextPanel.setVisible(false);
                    maintextArea.setVisible(false);
                    screenend(badend1);b=-1;}
            }
            else if(button == "goodend1"){ 
                b++;
                String x[]={new String(" [ฉันได้ยินเสียงร้องตะโกนของผู้หญิงคนหนึ่งดังขึ้นมา ด้วยความตกใจ\nฉันจึงเอี้ยวตัวหลบแต่ดูเหมือนว่าฉันจะดวงซวยแท้ๆเลยวันนี้] ")
                ,new String("โครม !!!")
                ,new String("โรส : โอ้ย ขอโทษทีนะ ฉันพยายามหลบแล้วแต่ว่าฉันทรงตัวไม่อยู่ ")
                ,new String("[ ดูเหมือนเขาจะไม่ค่อยโกรธฉันเท่าไหร่เลยนะ \nดีจริงๆที่ไม่ได้ไปทำใครโกรธไว้ตั้งแต่วันแรก ]")
                ,new String("??? : ไม่เป็นไร แค่ต่อไประวังอย่าวิ่งลงมาที่ลู่วิ่งเวลานักกีฬาซ้อมกันอยู่ล่ะ ")
                ,new String("โรส : เดี๋ยว?!! นั้นเธอเลือดออกเหรอ ไปห้องพยาบาลมั้ย??? ")
                ,new String("???: อ่า ไม่เป็นไรหรอกนะ เธอ? เด็กใหม่? ไม่รีบไปเหรอ \nหอประชุมน่ะ พิธีปฐมนิเทศกำลังจะเริ่มแล้วนะ")
                ,new String("โรส : ไม่เป็นไรหรอกนะ เธอบาดเจ็บอยู่ไม่ใช่หรือไง \nต้องพาเธอไปห้องพยาบาลก่อนสิ นี่ไม่ใช่เวลามาหาทาง\nไปหอประชุมหรอกนะ ")
                ,new String("[ เธอดูเหมือนจะตกใจกับคำตอบของฉันนิดหน่อยนะ แต่ว่าถ้าเจอคนเจ็บ\nก็ต้องพาคนเจ็บไปรักษาก่อนสิถูกแล้ว ]")
                ,new String("??? : งั้นเหรอ งั้นก็รบกวนด้วยนะ คุณน้องใหม่ " )
                ,new String("[ ว้าว ผู้หญิงคนนี้ ปกติทำหน้านิ่งๆแล้วดูน่ากลัวมากเลย \nไม่คิดว่ายิ้มแล้วจะดูสวยขนาดนี้] ")
                ,new String("โรส :อาจจะช้าไปหน่อย แต่ดิฉัน โรส ดีค่ะ \nขออภัยที่เดินลงมาไม่ดูตาม้าตาเรือด้วยนะคะ " )
                ,new String("แอล์ม : ไม่เป็นไรหรอกโรส ฉันแอล์มนะ หากอยากเข้าชมรมกรีฑา\nก็มาหาฉันได้ ฉันอยู่ที่ตึกปี2น่ะ มาสิช่วยพยุงฉันที" )
                ,new String("โรส : จะว่าไปแล้ว ห้องพยาบาลมันอยู่ทางไหนเหรอคะ ?" )
                ,new String("แอล์ม : .....ทางนี้ " )
                ,new String("แอล์ม : ถึงแล้วล่ะโรส ขอบคุณมากนะ " )
                ,new String("โรส : ไม่เป็นไรหรอกค่ะ ฉันเป็นคนชนแอล์มล้มเอง \nว่าแต่คุณครูหายไปไหนกันละคะเนี่ย ?")};
                if(b==0){
                    heart.setVisible(false);
                    square.setVisible(false);
                    mainTextPanel.setVisible(true);
                    field(RoseWorry, "goodend1", x[b]);}
                else if(b==1){field(roseIcon, "goodend1", x[b]);}
                else if(b==2){field(RoseWorry, "goodend1", x[b]);}
                else if(b==3){field(Rose, "goodend1", x[b]);}
                else if(b==4){field(Elmhappy, "goodend1", x[b]);}
                else if(b==5){field(RoseWorry, "goodend1", x[b]);}
                else if(b==6){field(Elm, "goodend1", x[b]);}
                else if(b==7){field(RoseSerious, "goodend1", x[b]);}
                else if(b==8){field(RoseStunt, "goodend1", x[b]);}
                else if(b==9){field(Elmhappy, "goodend1", x[b]);}
                else if(b==10){field(RoseStunt, "goodend1", x[b]);}
                else if(b==11){field(Rose, "goodend1", x[b]);}
                else if(b==12){field(Elm, "goodend1", x[b]);}
                else if(b==13){field(Rose, "goodend1", x[b]);}
                else if(b==14){field(Elmhappy, "goodend1", x[b]);}
                else if(b==15){hospital(x[b], Elm, "goodend1");} 
                else if(b==16){hospital( x[b], Rose, "root");b=-1;}
            }
            else if(button=="goodend2"){
                String x[]={new String("โรส : ถ้างั้นนั่งรอตรงนี้สักครู่นะคะ เดี๋ยวฉันจะทำแผลให้"),new String("เอล์ม : เหย ไม่เป็นไรหรอกแผลแค่นี้ฉันทำเองได้ มันจะรบกวนเธอเปล่าๆ")
                ,new String("โรส : ไม่เป็นไรหรอกค่ะ ฉันไม่อยากทิ้งคนที่ตัวเองทำให้บาดเจ็บ\nไว้เฉยๆหรอกนะคะ"),new String("เอล์ม : ขอบคุณมากนะ ฉันเกือบจะมองเธอในแง่ร้ายแล้วสิ"),new String("โรส : เสร็จแล้วค่ะ ถ้างั้นขอตัวก่อนนะคะ \nแล้วอยากจะถามว่าหอประชุมไปทางไหนเหรอคะ?")
                ,new String("เอล์ม : เดินผ่านห้องสมุดแล้วเลี้ยวขวานะ เดินตรงไปสักพัก\nก็จะเจอหอประชุมแล้ว"),new String("โรส : ขอบคุณนะคะเอล์ม ขอโทษสำหรับวันนี้อีกครั้งค่ะ ")
                ,new String("เอล์ม : ไม่เป็นไรหรอก ฉันไม่ว่าอะไร \nไว้เจอกันใหม่นะโรส "),new String("โรส : [จะว่าไปฉันเดินมาถูกทางแล้วจริงใช่มั้ยเนี่ย \nเอล์มคงไม่ได้โกรธจนแกล้งฉันใช่มั้ยนะ]"),new String("จังหวะนั้นโรสก็เผลอหันไปมองห้องที่เธอเดินผ่านมา"),new String("โรส : [เจอห้องสมุดแล้วแหะ เอล์มบอกว่าเดินผ่านห้องสมุดไปแล้ว\nจะเจอหอประชุมใช่มั้ยนะ?]")
                ,new String("โรส : [ว่าแต่ห้องสมุดที่นี่ดูใหญ่จังนะแต่ว่า\nไม่ค่อยมีคนมาใช้บริการเท่าไหร่เลย มันเป็นเพราะอะไรกันนะ?]") ,new String("โรส : [แต่ว่าตอนนี้ไม่ใช่เวลามาสงสัยนะ จะสายแล้วว]"),new String("ไม่ใช้"),new String("โรส : [นี่เป็นช่วงเวลาพักแล้วนี้หน่า ลองเดินไปดูห้องสมุด\nที่เดินผ่านไปตอนเช้าดีมั้ยนะ?]")};
                b++;
                if(b==0){mainTextPanel.setVisible(true);
                    hospital(x[b], Rose, "goodend2");}
                else if(b==1){hospital(x[b], ElmStunt, "goodend2");}
                else if(b==2){hospital(x[b], RoseSerious, "goodend2");}
                else if(b==3){hospital(x[b], Elm, "goodend2");}
                else if(b==4){hospital(x[b], Rose, "goodend2");}
                else if(b==5){hospital(x[b], Elm, "goodend2");}
                else if(b==6){hospital(x[b], Rose, "goodend2");}
                else if(b==7){hospital(x[b], Elm, "goodend2");}
                else if(b==8){hallway(x[b], Rose, "goodend2");}
                else if(b==9){hallway(x[b], roseIcon, "goodend2");}
                else if(b==10){hallway(x[b], Rose, "goodend2");}
                else if(b==11){hallway(x[b], Rose, "goodend2");}
                else if(b==12){hallway(x[b], Rose, "goodend2");}
                else if(b==13){mainTextPanel.setVisible(false);maintextArea.setVisible(false);re.setVisible(false);Continue.setVisible(false);frame.remove(bg);screen(lunch, "goodend2");}
                else if(b==14){mainTextPanel.setVisible(true); btn2.setVisible(false); hallway(x[b], Rose, "root");b=-1;}
            }
            else if(button=="badend2"){b++;
                if(b==0){mainTextPanel.setVisible(true);
                    hospital("โรส : โทษทีนะ แต่ว่าฉันคงต้องขอตัวก่อนแล้วละ \nเดี๋ยวจะไปไม่ทันปฐมนิเทศน่ะ แค่นี้เธอคงทำต่อเองได้ใช่มั้ย \nขอโทษทีนะ ไว้โอกาสหน้าแล้วกัน!!!", Rose, "badend2");}
                else{
                    re.setVisible(false);
                    frame.remove(bg);
                    Continue.setVisible(false);
                    mainTextPanel.setVisible(false);
                    maintextArea.setVisible(false);
                    screenend(badend2);b=-1;}
            }
            else if(button=="goodend3"){
                String x[]={new String ("โรส: ลองเดินไปดูหน่อยดีกว่า \nไหนๆถือว่าเป็นโอกาสสำรวจโรงเรียนเลยละกัน"),new String("โรส : ไม่มีคนเลยจริงๆด้วย \nแต่หนังสือทุกเล่มถูกรักษาอย่างดีเลยนะ "),
                new String(" [หลังจากที่เดินดูรอบๆแล้วสายตาของโรสก็ไปสะดุดกับหนังสือเล่มหนึ่ง]"),new String("โรส : หนังสือเล่มนี้ดูเก่ามากเลยนะ แต่คุ้นๆเหมือนเคยเห็นที่ไหนเลย\n อ่า นึกไม่ออกแหะ"),
                new String("ตัวประกอบ1 : หล่อนอย่าคิดนะว่าได้เป็นนักกีฬาของโรงเรียนแล้ว \nหล่อนจะสามารถเชิดหน้าชูตาได้นะ!!!"),new String("[มีเสียงทะเลาะกันดังออกมาจากข้างนอกห้องสมุด]"),
                new String("โรส: เกิดอะไรขึ้นกันนะ ต้องรีบไปดูแล้วล่ะ"),new String("ตัวประกอบ2 : หวังว่าจะได้เป็นผู้ถูกเลือกของปีนี้เหรอ มันจะไม่มากเกินไป\nสำหรับตระกูลที่มีดอกไม้สีสันเช่นเธอหรอกเหรอ"),
                new String("ตัวประกอบ3 : อย่ามากเลยนะ อย่างเธอเป็นได้แค่ดอกไม้\nประดับรั้วเล็กๆเท่านั้นแหละ"),new String("[เมื่อลองมองดูชัดๆก็พบว่าเป็นเอล์มที่กำลังโดนรุมแกล้งอยู่ \nฉันควรจะทำยังไงดีนะ]")};
                b++;
                if(b==0){mainTextPanel.setVisible(true); hallway(x[b], Rose, "goodend3");}
                else if(b==1){libary(x[b], Rose, "goodend3");}
                else if(b==2){libary(x[b], Rose, "goodend3");}
                else if(b==3){libary(x[b], Rose, "goodend3");}
                else if(b==4){libary(x[b], action1, "goodend3");}
                else if(b==5){libary(x[b], roseIcon, "goodend3");}
                else if(b==6){libary(x[b], Rose, "goodend3");}
                else if(b==7){hallway(x[b],action2, "goodend3");}
                else if(b==8){hallway(x[b], action3, "goodend3");}
                else if(b==9){hallway(x[b], RoseWorry, "root");b=-1;}
            }
            else if(button=="badend3"){b++;
                if(b==0){mainTextPanel.setVisible(true);hallway("โรส : ไม่ไปดูดีกว่าแหะ ฉันน่าจะเอาเวลาไปทำอย่างอื่นดีกว่า ", Rose, "badend3");}
                else if(b==1){mainTextPanel.setVisible(false);maintextArea.setVisible(false);re.setVisible(false);Continue.setVisible(false);frame.remove(bg); screenend(badend3);b=-1;}
            }
            else if(button=="goodend4"){
                String x[]={new String("[ยังไงก็ต้องไปเข้าไปช่วยแล้วล่ะ ปล่อยไว้แบบนั้นไม่ได้]"),new String("หลังจากตัดสินใจแล้วโรสก็เดินเข้าไปขวาง\nระหว่างเอล์มกับคนกลุ่มนั้นทันที"),new String(" โรส : นี่พวกคุณกำลังทำอะไรกันอยู่คะ?"),
                new String("ตัวประกอบ1 : เธอเป็นใครกันแน่เนี่ย ? อ่า \nผมสีแดงแบบนี้ ตระกูลกุหลาบ “ดี” เหรอ"),new String("ตัวประกอบ2 : นี่ไม่ใช่เรื่องที่คุณหนูแบบเธอสมควรมายุ่งหรอกนะ \nกลับไปจิบน้ำชากับท่านพ่อของเธอเถอะ"),
                new String("ตัวประกอบ3 : จริงด้วย คิก"),new String("เสียงหัวเราะแสนน่ารังเกียจดังไปทั่วหลังจากที่คนพวกนั้นพูดเสร็จ"),new String("โรส : ต้องขออภัยที่เสียมารยาทนะคะ ในเมื่อพวกคุณทราบอยู่แล้ว\nว่าดิฉันเป็นใคร แต่ไม่ทราบว่าพวกคุณคือใครเหรอคะ"),
                new String("โรส :  สีผมที่ไม่โดดเด่น หน้าตาก็ดูไม่ออกว่ามาจาก\nตระกูลดอกไม้อะไร คุณหนูอย่างพวกเธอกล้ามากเลยนะคะที่มายืนดูถูกฉัน\nที่มาจากตระกูลดอกไม้ที่โดดเด่นที่สุดน่ะ"),new String("{เฮือก!}"),
                new String("โรส : จะวางมือแล้วไปหรือต้องให้ดิฉันใช้อำนาจของตระกูลเหรอคะ"),new String("เหล่าตัวประกอบ : ค่ะๆ ไปแล้วค่ะ ขอภัยด้วยนะคะคุณโรส!!"),new String("หลังจากพูดเสร็จกลุ่มคนพวกนั้นก็พากันวิ่งหนีออกไป\nโดยไม่หันมามองข้างหลังอีกเลย"),
                new String("โรส : เป็นอะไรมั้ยคะเอล์ม? บาดเจ็บตรงไหนรึป่าว"),new String("เอล์ม : ขอบคุณมากนะโรส ขอโทษที่ต้องมาทำให้\nเห็นในสภาพแบบนี้นะ ไม่น่าดูเลยใช่มั้ยละ"),new String("โรส : ไม่หรอกค่ะ ฉันไม่เห็นอะไรเลยนะคะ \nเมื่อกี้แค่ปัดแมลงที่ตอมดอกไม้ออกก็เท่านั้นเอง"),
                new String("เอล์ม : คิก เธอเนี้ยนะโรส ปากร้ายไม่เบาเลยนะ \nฮ่าๆ ขอบใจมาก ฉันโอเคขึ้นมากแล้วละ "),new String("โรส : ได้ยินแบบนั้นฉันก็ดีใจนะคะเอล์ม \nเอาเป็นว่าเรารีบออกไปจากที่นี้กันก่อนเถอะค่ะ"),new String("เอล์ม : เอาสิ ว่าแต่เธอมาทำอะไรที่ห้องสมุดเหรอ?"),
                new String("โรส : พอดีว่าตอนเช้าฉันเดินผ่านแล้วเห็นมันน่าสนใจดี\nเลยกะจะมาดูน่ะค่ะ แต่ว่าห้องสมุดที่สวยขนาดนี้แต่กลับ\nไม่มีคนมาใช้เลยนะคะ"),new String("เอล์ม :  เป็นปกติแหละ เพราะว่าพวกคุณหนูน่ะมักจะ\nมีห้องสมุดอยู่ที่ตระกูลแหละ เลยไม่เข้าห้องสมุดที่นี่น่ะ"),
                new String("โรส : งั้นเองเหรอคะ ทั้งๆที่สวยขนาดนี้แท้ๆ น่าเสียดายจริงๆ"),new String("เอล์ม : ว่าแต่โรสหยิบอะไรมาด้วยเหรอ?"),new String("โรส : อะ เป็นหนังสือที่ฉันเผลอหยิบมาดูเพราะสนใจน่ะค่ะ"),
                new String("เอล์ม : “Real Happy Ending” งั้นเหรอ เป็นหนังสือที่เล่าเกี่ยวกับ\nตำนานของโรงเรียนสินะ"),new String("โรส : ตำนาน?"),new String("เอล์ม : ใช่แล้วล่ะ ที่นักเรียนผู้ถูกเลือกคนแรกได้สร้างสวนดอกไม้\nเพื่อสารภาพกับคนที่ตัวเองชอบน่ะ"),
                new String("โรส : สร้างสวนดอกไม้?"),new String("เอล์ม : ใช่แล้ว แต่คุ้นๆเหมือนว่าตอนเด็กๆ\nจะเคยสัญญากับเด็กคนหนึ่งอยู่เหมือนกันนะ "),
                new String("โรส : เอ๊ะ สัญญาเหรอคะ?"),new String("เอล์ม : จำไม่ค่อยได้แล้วล่ะ แต่เป็นประโยคจากหนังสือเล่มนี้แหละ \nประโยคก็คงประมาณว่า “มาสร้างสวนดอกไม้ที่เป็นของเรากันเองเถอะนะ”"),
                new String("หลังจากที่ได้ยินประโยคนั้นโรสก็พึมพำออกมาเบาๆว่า"),new String("โรส : …..สวนดอกไม้ที่สวยงามที่สุดในโลกใบนี้"),new String("เอล์ม : อะไรนะโรส เธอพูดเบามากเลย ฉันไม่ได้ยินเลย"),
                new String("โรส : ปล่าวหรอกเอล์ม ไม่มีอะไรหรอก"),new String("โรส : (หรือว่าเอล์มจะเป็นเด็กคนนั้นนะ… แต่ว่าไม่ใช่หรอก)"),new String("เอล์ม : งั้นเหรอ แต่ว่าตอนนี้จะหมดเวลาพักแล้วนะ ฉันคงต้องขอตัวก่อน \nครั้งนี้ขอบคุณเธอมากจริงๆนะ ถ้าไม่มีเธอ ฉันคงแย่ไปแล้วล่ะ"),
                new String("โรส :  ด้วยความยินดีค่ะเอล์ม"),new String("หลังจากเหตุการณ์ครั้งนั้นโรสก็สนิทกับเอล์มมากขึ้น"),new String("ผ่านไปไม่กี่วันต่อมา"),new String("เพื่อน : โรส จะไปดูการแข่งขันกีฬาประเภทไหนเหรอ"),
                new String("โรส : การแข่งขันกีฬาเหรอ?"),new String("เพื่อน : ใช่แล้ว การแข่งขันกีฬาประจำปีน่ะ เธอไม่เคยได้ยินเหรอ"),new String("โรส : ไม่เคยนะ แล้วมีกีฬาประเภทอะไรบ้างเหรอ"),
                new String("เพื่อน : ก็เยอะนะ แต่ที่เด่นๆก็มีวิ่งแข่งละมั้ง \nเห็นว่าครั้งนี้มีตระกูลที่ไม่เคยเห็นมาแข่งขันด้วยหนิ"),new String("โรส : ตระกูลที่ไม่เคยเห็นมาก่อนเหรอ?"),new String("เพื่อน : ใช่ เหมือนจะชื่อตระกูลแปร์น่ะ เมื่อก่อนคฤหาสน์\nของพวกเขาเคยอยู่แถวๆตระกูลเธอด้วยหนิ "),
                new String("โรส : เอ๊ะ ? หมายความว่ายังไงเหรอ"),new String("เพื่อน : ก็ตระกูลแปร์น่ะ เมื่อก่อนรุ่งเรืองมากๆยังไงละ \nเธอน่าจะเคยเห็นลูกสาวตระกูลนั้นน่ะ เหมือนจะชื่อ เอล์ม ละมั้ง"),
                new String("โรส : เอล์มงั้นเหรอ….")};
                b++;
                if(b==0){mainTextPanel.setVisible(true); hallway(x[b], Rose, "goodend4");}
                else if(b==1){hallway(x[b], roseIcon, "goodend4");}
                else if(b==2){hallway(x[b], RoseSerious, "goodend4");}
                else if(b==3){hallway(x[b], action1, "goodend4");}
                else if(b==4){hallway(x[b], action2,"goodend4");}
                else if(b==5){hallway(x[b], action3,"goodend4");}
                else if(b==6){hallway(x[b], roseIcon,"goodend4");}
                else if(b==7){hallway(x[b], RoseDo,"goodend4");}
                else if(b==8){hallway(x[b], RoseDo, "goodend4");}
                else if(b==9){hallway(x[b], action1, "goodend4");}
                else if(b==10){hallway(x[b], RoseDo, "goodend4");}
                else if(b==11){hallway(x[b], action2, "goodend4");}
                else if(b==12){hallway(x[b], roseIcon, "goodend4");}
                else if(b==13){hallway(x[b], Rose, "goodend4");}
                else if(b==14){hallway(x[b], Elm, "goodend4");}
                else if(b==15){hallway(x[b], Rose, "goodend4");}
                else if(b==16){hallway(x[b], Elmhappy, "goodend4");}
                else if(b==17){hallway(x[b], Rose, "goodend4");}
                else if(b==18){libary(x[b], Elm, "goodend4");}
                else if(b==19){libary(x[b], Rose, "goodend4");}
                else if(b==20){libary(x[b], Elm, "goodend4");}
                else if(b==21){libary(x[b], Rose, "goodend4");}
                else if(b==22){libary(x[b], Elm, "goodend4");}
                else if(b==23){libary(x[b], Rose, "goodend4");}
                else if(b==24){libary(x[b], Elm, "goodend4");}
                else if(b==25){libary(x[b], Rose, "goodend4");}
                else if(b==26){libary(x[b], Elm, "goodend4");}
                else if(b==27){libary(x[b], Rose, "goodend4");}
                else if(b==28){libary(x[b], Elm, "goodend4");}
                else if(b==29){libary(x[b], Rose, "goodend4");}
                else if(b==30){libary(x[b], Elm, "goodend4");}
                else if(b==31){libary(x[b], roseIcon, "goodend4");}
                else if(b==32){libary(x[b], Rose, "goodend4");}
                else if(b==33){libary(x[b], Elm, "goodend4");}
                else if(b==34){libary(x[b], Rose, "goodend4");}
                else if(b==35){libary(x[b], Rose, "goodend4");}
                else if(b==36){libary(x[b], Elm, "goodend4");}
                else if(b==37){libary(x[b], Rose, "goodend4");}
                else if(b==38){libary(x[b], roseIcon, "goodend4");}
                else if(b==39){schoolroom(x[b], roseIcon, "goodend4");}
                else if(b==40){schoolroom(x[b], friend, "goodend4");}
                else if(b==41){schoolroom(x[b], Rose, "goodend4");}
                else if(b==42){schoolroom(x[b], friend, "goodend4");}
                else if(b==43){schoolroom(x[b], Rose, "goodend4");}
                else if(b==44){schoolroom(x[b], friend, "goodend4");}
                else if(b==45){schoolroom(x[b], Rose, "goodend4");}
                else if(b==46){schoolroom(x[b], friend, "goodend4");}
                else if(b==47){schoolroom(x[b], Rose, "goodend4");}
                else if(b==48){schoolroom(x[b], friend, "goodend4");}
                else if(b==49){schoolroom(x[b], Rose, "root");b=-1;a++;}
            }
            else if(button=="badend4"){
                String x[]={new String("[ฉันว่าฉันอย่าเข้าไปยุ่งเลยดีกว่า เดี๋ยวจะเป็นปัญหาเปล่าๆ]"),new String("[รีบเดินหนีออกมาจากตรงนี้ก่อนแล้วกัน]")};
                b++;
                if(b==0){mainTextPanel.setVisible(true);hallway(x[b], Rose, "badend4");}
                else if(b==1){hallway(x[b], Rose, "badend4");}
                else if(b==2){mainTextPanel.setVisible(false);maintextArea.setVisible(false);re.setVisible(false);Continue.setVisible(false);frame.remove(bg);screenend(badend4);b=-1;}
            }
            else if(button=="goodend5"){
                String x[]={new String("โรส : ฉันตัดสินใจแล้วละว่าจะไปดูการแข่งขันประเภทไหน"),new String("เพื่อน : ทำไมจู่ๆก็ตัดสินใจล่ะโรส ฉันตกใจหมดเลย \nว่าแต่จะไปดูประเภทไหนเหรอ"),
                new String("โรส : วิ่งแข่งน่ะ ฉันจะต้องไปดูวิ่งแข่งให้ได้"),new String("เพื่อน : หรือจะเพราะเรื่องเมื่อกี้งั้นเหรอ?"),new String("โรส : ใช่แล้ว บางทีเอล์มอาจจะเป็นคนที่ฉันตามหาอยู่น่ะ"),new String("เพื่อน : คนที่เธอตามหาอยู่มีลักษณะอะไรพิเศษมั้ย"),
                new String("โรส : ผมสีดำ ใช่แล้วผมสีดำ แล้วก็ผมสั้น..."),new String("ไม่ใช้"),new String("เพื่อน : ผมสีดำงั้นเหรอ มีแค่2คนในโรงเรียนเองหนิ คนหนึ่งก็คือเอล์ม \nส่วนอีกคนเหมือนจะเป็นรุ่นพี่ที่เป็นบรรณารักษ์อยู่ละมั้ง  น่าจะชื่อ โรซาเลีย?  \nแต่รุ่นพี่คนนั้นผมยาวนี้หน่า…"),
                new String("โรส : ถ้าอย่างงั้นต้องเป็นเอล์มแน่นอน"),new String("หลังจากนั้นโรสก็รีบเดินทางไปยังลู่วิ่งที่เธอเคยชนกับเอล์มทันที"),new String("โรส : เอล์ม!! "),new String("โรสตะโกนเรียกเอล์มที่กำลังเตรียมตัวอยู่ในสนาม"),
                new String("เอล์ม : อ้าวโรส มาดูการแข่งขันวิ่งด้วยเหรอ"),new String("โรส : ใช่แล้วละ ฉันมีเรื่องที่อยากจะถามเธอน่ะ คือว่า-----"),new String("พิธีกร : ขอเชิญนักกีฬาทุกท่านที่สนามตอนนี้เลยค่า"),new String("เอล์ม : ขอโทษนะโรส ฉันคงต้องไปก่อนแล้วล่ะ \nไว้แข่งขันเสร็จแล้วจะรีบมาหานะ"),new String("โรส : ได้สิ ฉันจะรออยู่ที่สวนดอกไม้กลางโรงเรียนนะ"),
                new String("[จะต้องเป็นเอล์มแน่นอน ตั้งแต่ครั้งแรกแล้วที่รู้สึกว่าเธอคุ้นๆ]"),new String("??? : ขอโทษนะคะ นั่นใช่โรสมั้ยคะ?"),new String("โรส : ใช่ค่ะ ไม่ทราบว่าคุณคือ??"),new String("โรซาเลีย : ขออภัยที่แนะนำตัวช้านะคะ ดิฉันโรซาเลีย การ์เด้นค่ะ"),new String("โรส : ตระกูลการ์เด้นเองเหรอคะเนี้ย ท่านดยุกเป็นอย่างไรบ้างเหรอคะ \nพอดีว่าไม่ได้เจอกันมาตั้งนานแล้ว"),
                new String("โรซาเลีย : จากไปหลายปีแล้วค่ะ ขอบคุณที่นึกถึงท่านนะคะ \nแต่ไม่ทราบว่าคุณโรสมาทำอะไรที่สวนแห่งนี้เหรอคะ"),new String("โรส : มาเพื่อรอคุยเรื่องสำคัญกับบุคคลที่ตามาหามาอย่างยาวนานน่ะค่ะ"),new String("โรซาเลีย : เรื่องสำคัญ?"),new String("โรส : เคยสัญญาว่าจะสร้างสวนดอกไม้ด้วยกันน่ะค่ะ"),new String("โรซาเลีย : แสดงว่าเธอก็----"),
                new String("เอล์ม : โรส!! อะ รุ่นพี่โรซาเลียก็อยู่ด้วยเหรอคะ"),new String("โรซาเลีย : สวัสดีค่ะคุณเอล์ม ถ้างั้นท่านที่คุณโรสนัดพบก็คือท่านเอล์ม?"),new String("โรส : ใช่แล้วล่ะค่ะ ดิฉันมีเรื่องสำคัญที่อยากจะบอก"),new String("โรซาเลีย : ถ้างั้นดิฉันขอตัวก่อนนะคะ"),new String("ก่อนที่รุ่นพี่โรซาเลียจะเดินออกไปเหมือนเธอจะพึมพำอะไรบางอย่างด้วย"),
                new String("เหมือนว่าเอล์มจะทำสีหน้าอึ้งไปพักหนึ่งหลังจากรุ่นพี่โรซาเลียเดินออกไป"),new String("โรส : สวนดอกกุหลาบที่นี่สวยมากเลยเนอะเอล์ม"),new String("เอล์ม : สวยสิ ก็เป็นสวนที่รุ่นพี่โรซาเลียชนะทุกปีนี่หน่า"),new String("โรส : รุ่นพี่คนนั้นเก่งน่าดูเลยนะ ได้รับเลือกเป็นผู้ถูกเลือกทุกปีเลย"),
                new String("เอล์ม : ซักวันจะต้องตามให้ทันให้ได้เลย"),new String("โรส : เธอเก่งเสมออยู่แล้วละเอล์ม"),new String("เอล์ม : ขอบคุณนะ ว่าแต่มีเรื่องอะไรจะพูดรึเปล่าถึงได้เรียกมาเจอที่นี่น่ะ"),new String("โรส : เอล์ม มันอาจจะเร็วเกินไปหน่อยนะ ฉันไม่รู้ว่าเธอจะจำ\nเรื่องคำสัญญาตอนเด็กไหม แต่ช่วยคบกับฉันทีเถอะนะ"),
                new String("เอล์ม : หมายความว่ายังไงเหรอโรส"),new String("โรส : ฉันชอบเธอเอล์ม"),new String("เอล์ม : โรสนี่ไม่ใช่เรื่องล้อเล่นนะ"),new String("โรส : ฉันไม่ได้ล้อเล่นนะเอล์ม ฉันจริงจัง เธอช่วยคบกับฉันแล้ว\nเรามาสร้างสวนดอกไม้ที่สวยกว่าสวนแห่งนี้กันเถอะ"),
                new String("เอล์ม : ฉันไม่เคยคิดเลยว่าคนที่ฉันชอบจะมาชอบฉันกลับด้วย \nฉันดีใจมากจริงๆ"),new String("เอล์ม : ฉันตกลงนะโรส"),new String("โรส : ขอบคุณที่ยอมรับฉันนะเอล์ม"),new String("โรส : ว่าแต่เธอจำเรื่องสมัยเด็กได้มั้ย ที่เธอเคยมาอยู่แถวบ้านฉันน่ะ"),new String("เอล์ม : อ๋อ จำได้สิ ตอนนั้นฉันไปพักอาศัยอยู่ที่บ้านรุ่นพี่โรซาเลียเนี่ยแหละ"),
                new String("โรส : หมายความว่ายังไงเหรอ"),new String("เอล์ม : ตอนเด็กๆฉันไปเล่นกับรุ่นพี่โรซาเลียบ่อยน่ะ \nพร้อมกับเด็กผมแดงคนหนึ่งน่ะ"),new String("เอล์ม : เดี๋ยวก่อนนะ งั้นแสดงว่าเด็กคนนั้นคือเธอจริงๆด้วยสินะ!"),new String("โรส : ใช่แล้วละ"),new String("เอล์ม : ว่าแต่เมื่อกี้เธอพูดอะไรกับรุ่นพี่โรซาเลียเหรอ"),
                new String("โรส : เรื่องเธอน่ะ ว่าเธอเป็นคนที่ฉันตามหามานาน"),new String("เอล์ม : ...งั้นเหรอ"),new String("โรส : ทำไมเหรอ"),new String("เอล์ม : โรส ฉันไม่รู้หรอกนะว่าทำไมแค่พูดเรื่องฉัน\nแล้วรุ่นพี่ถึงพูดประโยคนั้นออกมา"),new String("โรส : พูดว่าอะไรเหรอ ?"),new String("เอล์ม : ‘ทั้งๆที่ฉันรอคอยเธอมาตลอดแท้ๆ…’ น่ะ"),new String("ไม่ใช้"),
                new String("[ แถมยังทำหน้าแบบนั้นอีก... ]"),new String("เอล์ม : ถ้าเธอเป็นเด็กคนนั้นจริง ฉันนึกว่าเธอเข้าโรงเรียนนี้\nมาตามหารุ่นพี่โรซาเลียซะอีกนะ"),new String("โรส : หมายความว่ายังไงเหรอ"),new String("เอล์ม : เธอจำได้มั้ยที่บอกว่าตอนเด็กเคยสัญญากับเด็กคนหนึ่งไว้น่ะ \nนั่นคือฉันเคยได้ยินมันจากรุ่นพี่โรซาเลียอีกที เรื่องของเธอน่ะ\nที่สัญญากันไว้ว่า..."),
                new String("โรซาเลีย :“มาสร้างสวนดอกไม้ที่เป็นของเรากันเองเถอะนะ”"),new String("ไม่ใช้"),new String("โรส:..... นั่นหมายความว่า?"),new String("เอล์ม : เด็กผู้หญิงในคำสัญญาก็คือรุ่นพี่โรซาเลียยังไงละโรส \nฉันตกใจหมดเลยที่เธอหันมาเลือกฉันแทนน่ะ"),new String("โรส : ถ้าอย่างงั้น…")};
                b++;
                if(b==0){mainTextPanel.setVisible(true);schoolroom(x[b], Rose, "goodend5");}
                else if(b==1){schoolroom(x[b], friend, "goodend5");}
                else if(b==2){schoolroom(x[b], Rose, "goodend5");}
                else if(b==3){schoolroom(x[b], friend, "goodend5");}
                else if(b==4){schoolroom(x[b], Rose, "goodend5");}
                else if(b==5){schoolroom(x[b], friend, "goodend5");}
                else if(b==6){specialscreen(x[b], Rose, "goodend5", schoolroom);}
                else if(b==7){mainTextPanel.setVisible(false);maintextArea.setVisible(false);Continue.setVisible(false);frame.remove(bg);re.setVisible(false); screen(secret, "goodend5");}
                else if(b==8){mainTextPanel.setVisible(true);btn2.setVisible(false);schoolroom(x[b], friend, "goodend5");}
                else if(b==9){schoolroom(x[b], Rose, "goodend5");}
                else if(b==10){schoolroom(x[b], roseIcon, "goodend5");}
                else if(b==11){field(Rose, "goodend5", x[b]);}
                else if(b==12){field(roseIcon, "goodend5", x[b]);}
                else if(b==13){field(Elmhappy, "goodend5", x[b]);}
                else if(b==14){field(RoseSerious, "goodend5", x[b]);}
                else if(b==15){field(idol, "goodend5", x[b]);}
                else if(b==16){field(Elmhappy, "goodend5", x[b]);}
                else if(b==17){field(Rose, "goodend5", x[b]);}
                else if(b==18){lastGarden(x[b], Rose, "goodend5");} //ใส่สวนดอกไม้
                else if(b==19){lastGarden(x[b], rosa, "goodend5");}
                else if(b==20){lastGarden(x[b], Rose, "goodend5");}
                else if(b==21){lastGarden(x[b], Rosa, "goodend5");}//โรซา
                else if(b==22){lastGarden(x[b], Rose, "goodend5");} 
                else if(b==23){lastGarden(x[b], Rosa, "goodend5");}//โรซา
                else if(b==24){lastGarden(x[b], Rose, "goodend5");} 
                else if(b==25){lastGarden(x[b], Rosa, "goodend5");}//โรซา
                else if(b==26){lastGarden(x[b], Rose, "goodend5");}
                else if(b==27){lastGarden(x[b], Rosa, "goodend5");}//โรซา
                else if(b==28){lastGarden(x[b], ElmStunt, "goodend5");}
                else if(b==29){lastGarden(x[b], RosaStunt, "goodend5");}//โรซา
                else if(b==30){lastGarden(x[b], Rose, "goodend5");}
                else if(b==31){lastGarden(x[b], RosaSerious, "goodend5");}//โรซา
                else if(b==32){lastGarden(x[b], roseIcon, "goodend5");}
                else if(b==33){lastGarden(x[b], roseIcon, "goodend5");}
                else if(b==34){lastGarden(x[b], Rose, "goodend5");}
                else if(b==35){lastGarden(x[b], Elm, "goodend5");}
                else if(b==36){lastGarden(x[b], Rose, "goodend5");}
                else if(b==37){lastGarden(x[b], Elm, "goodend5");}
                else if(b==38){lastGarden(x[b], Rose, "goodend5");}
                else if(b==39){lastGarden(x[b], Elm, "goodend5");}
                else if(b==40){lastGarden(x[b], Rose, "goodend5");}
                else if(b==41){lastGarden(x[b], ElmStunt, "goodend5");}
                else if(b==42){lastGarden(x[b], RoseSerious, "goodend5");}
                else if(b==43){lastGarden(x[b], ElmStunt, "goodend5");}
                else if(b==44){lastGarden(x[b], RoseSerious, "goodend5");}
                else if(b==45){lastGarden(x[b], Elmhappy, "goodend5");}
                else if(b==46){lastGarden(x[b], Elm, "goodend5");}
                else if(b==47){lastGarden(x[b], Rose, "goodend5");}
                else if(b==48){lastGarden(x[b], Rose, "goodend5");}
                else if(b==49){lastGarden(x[b], Elm, "goodend5");}
                else if(b==50){lastGarden(x[b], RoseStunt, "goodend5");}
                else if(b==51){lastGarden(x[b], Elm, "goodend5");}
                else if(b==52){lastGarden(x[b], ElmStunt, "goodend5");}
                else if(b==53){lastGarden(x[b], Rose, "goodend5");}
                else if(b==54){lastGarden(x[b], Elm, "goodend5");}
                else if(b==55){lastGarden(x[b], RoseSerious, "goodend5");}
                else if(b==56){lastGarden(x[b], ElmStunt, "goodend5");}
                else if(b==57){lastGarden(x[b], Rose, "goodend5");}
                else if(b==58){lastGarden(x[b], Elm, "goodend5");}
                else if(b==59){lastGarden(x[b], Rose, "goodend5");}
                else if(b==60){specialscreen(x[b], RosaSerious, "goodend5", Rosaria);}
                else if(b==61){mainTextPanel.setVisible(false);maintextArea.setVisible(false);Continue.setVisible(false);frame.remove(bg);re.setVisible(false); screen(Rosaria, "goodend5");}
                else if(b==62){mainTextPanel.setVisible(true);btn2.setVisible(false); lastGarden(x[b], ElmStunt, "goodend5");}
                else if(b==63){lastGarden(x[b], Elm, "goodend5");}
                else if(b==64){lastGarden(x[b], Rose, "goodend5");}
                else if(b==65){lastGarden(x[b], Elm, "goodend5");}
                else if(b==66){specialscreen(x[b],Rosa , "goodend5", Rosariamis); } //โรซา
                else if(b==67){mainTextPanel.setVisible(false);maintextArea.setVisible(false);Continue.setVisible(false);frame.remove(bg);re.setVisible(false); screen(Rosariamis, "goodend5");}
                else if(b==68){mainTextPanel.setVisible(true);btn2.setVisible(false);lastGarden(x[b], RoseWorry, "goodend5");}
                else if(b==69){lastGarden(x[b], ElmStunt, "goodend5");}
                else if(b==70){lastGarden(x[b], RoseStunt, "root");b=-1;}
            }
            else if(button=="badend5"){b++;
                String x[]={new String("โรส : ไม่ดีกว่า มีการแข่งขันที่น่าสนใจกว่านี้มั้ย"),new String("เพื่อน : ถ้างั้นไปดูการแข่งขันยิงธนูกันเถอะ"),new String("โรส : น่าสนใจดีหนิ เราไปกันเถอะ")};
                if(b==0){mainTextPanel.setVisible(true);schoolroom(x[b], Rose, "badend5");}
                else if(b==1){schoolroom(x[b], friend, "badend5");}
                else if(b==2){schoolroom(x[b], Rose, "badend5");}
                else if(b==3){mainTextPanel.setVisible(false);maintextArea.setVisible(false);re.setVisible(false);Continue.setVisible(false);frame.remove(bg);screenend(badend5);b=-1;}
            }
            else if(button=="normalend"){b++;
                String x[]={new String("โรส : แต่ตอนนี้ฉันเลือกเธอแทนแล้วล่ะ ลืมเรื่องนั้นไปเถอะ"),new String("เอล์ม : ขอบคุณนะ")};
                if(b==0){mainTextPanel.setVisible(true);lastGarden(x[b], Rose, "normalend");}
                else if(b==1){specialscreen(x[b], Elm, "normalend", normal);}
                else if(b==2){mainTextPanel.setVisible(false);maintextArea.setVisible(false);re.setVisible(false);Continue.setVisible(false);frame.remove(bg);screen(normal,"normalend");}
                else if(b==3){btn2.setVisible(false);screenend(normalending);b=-1;}
            }
            else if(button=="realhappy"){b++;
                String x[]={new String("โรส : ถ้างั้นขอโทษด้วยนะเอล์ม"),new String("หลังจากนั้นโรสก็วิ่งตามโรซาเลียไป ทิ้งให้เอล์มยืนมองแผ่นหลังเล็ก\nที่กำลังค่อยๆห่างออกไปทีละเล็ก ละน้อย"),new String("เอล์ม : ... ถึงนี่จะเป็นโลกของเกม แต่เธอกำลังจะทำอะไรงั้นเหรอ"),
                new String("เอล์ม : ใช่ว่าทุกๆอย่างมันสามารถกลับไปเหมือนเดิมได้นะ \nไม่แปลกใจเหรอที่เกมนี้ไม่มีปุ่ม SAVE ให้เธอน่ะ \nไม่ว่าจะชีวิตจริงหรือโลกของเกมก็ตาม เธอตัดสินใจพลาดก็คือพลาดนะ \nชีวิตจริงมันไม่มีปุ่ม SAVE ไม่ใช่เหรอผู้เล่น\nเธอจะสารภาพรักกับผู้หญิงอีกคนแต่สุดท้ายก็ทิ้งเธอไปงั้นเหรอ"),
                new String("เอล์ม : งั้นก็ไว้เจอกันใหม่ตั้งแต่ตอนที่ลู่วิ่งนะผู้เล่น")};
                if(b==0){mainTextPanel.setVisible(true);lastGarden(x[b], RoseWorry, "realhappy");}
                else if(b==1){lastGarden(x[b], roseIcon, "realhappy");}
                else if(b==2){lastGarden(x[b], Elmangry, "realhappy");}
                else if(b==3){lastGarden(x[b], Elmangry, "realhappy");}
                else if(b==4){specialscreen(x[b], Elm, "realhappy", realhappy);}
                else if(b==5){mainTextPanel.setVisible(false);maintextArea.setVisible(false);re.setVisible(false);Continue.setVisible(false);frame.remove(bg);screen(realhappy,"realhappy");}
                else if(b==6){btn2.setVisible(false);screenend(realhappyending);b=-1;}
            }
        }
    }
}