/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vpssmsserver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Royal
 */
public class VPSSMSServer {

    public static JFrame mainWindow;
    public static JMenuBar menuBar;
    private static JMenu fileMenu;
    private static JMenu settingsMenu;
    public static JMenuItem portSetting;
    public static JMenuItem dataBaseSetting;
    static String title = "VPS-SMS Server [Version 1.0]";
    public static int uniformWidth;
    public static int uniformHeight;
    static int port;

    private static class MenuBarActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dim = toolkit.getScreenSize();
            int width = dim.width;
            int height = dim.height;
            String command = ev.getActionCommand();
            /*if (command.equalsIgnoreCase("Server Port Settings")) {
            PortSettings portSettings = new PortSettings(CAAIMSServer.mainWindow, true);
            portSettings .setTitle("Server Port Settings");
            portSettings .setLocation(width / 4, height / 5);
            portSettings .setVisible(true);
            } 
            else if(command.equalsIgnoreCase("DataBase Setting")){
            DBSettings dbSettings = new DBSettings(CAAIMSServer.mainWindow, true);
            dbSettings .setTitle("Data Base Settings");
            dbSettings .setLocation(width / 4, height / 5);
            dbSettings .setVisible(true);
            
            }*/
        }
    }

    public VPSSMSServer() {
        /*Reading the server port at which its listening.*/
        try {
            File file = null;
            String fileDirectory = System.getProperty("user.home") + "\\.vpssmsServerConfig";
            File makeDirectory = new File(fileDirectory);
            if (makeDirectory.mkdir()) {
                System.out.println("Folder .vpssmsConfig Created");
            } else {
                System.out.println("Folder .vpssmsConfig already Exists");
            }
            file = new File(fileDirectory + "\\port.txt");
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println(1099);
                printWriter.close();
            }
            FileReader fileReader = new FileReader(fileDirectory + "\\port.txt");
            BufferedReader read = new BufferedReader(fileReader);
            String line = read.readLine();
            port = Integer.parseInt(line);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            }
        /*
        End of port reading 
         */

        try {
            //UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (Exception ex) {
        }
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        portSetting = new JMenuItem("Server Port Settings");
        portSetting.addActionListener(new MenuBarActionListener());
        dataBaseSetting = new JMenuItem("DataBase Setting");
        dataBaseSetting.addActionListener(new MenuBarActionListener());

        settingsMenu = new JMenu("Settings");
        settingsMenu.add(portSetting);
        settingsMenu.add(dataBaseSetting);

        /*Menu bar*/
        menuBar.add(fileMenu);
        menuBar.add(settingsMenu);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        int width = dim.width;
        int height = dim.height;
        mainWindow = new JFrame(title);
        //mainWindow.setIconImage(getResourceImage("caalogo.JPG"));
        mainWindow.setJMenuBar(menuBar);
        mainWindow.setBackground(new Color(212, 201, 201));
        //mainWindow.setContentPane(new LoginWindow());
        mainWindow.setLocation(width / 9, width / 9);
        mainWindow.setSize((width / 2 + width / 6), (height / 2 + height / 5));
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new VPSSMSServer();
        try {
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("ServerStub", new Controller());
            System.out.println("system is ready");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /*public Image getResourceImage(String fileName) {
    String imageDirectory = "/images/";
    URL imgURL = getClass().getResource(imageDirectory + fileName);
    //JOptionPane.showMessageDialog(null, imgURL);
    Image image = null;
    try {
    image = ImageIO.read(imgURL);
    } catch (IOException e) {
    JOptionPane.showMessageDialog(null, e.getMessage());
    }
    return image;
    }*/
}
