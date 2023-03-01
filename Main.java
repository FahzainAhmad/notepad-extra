import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Objects;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Desktop;
import java.net.URISyntaxException;
import javax.swing.border.EmptyBorder;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        UndoManager um = new UndoManager();

        Color bgCustom = new Color(18, 18, 18);
        JFrame jf = new JFrame("Notepad Advance");

        JMenuBar jmb = new JMenuBar();
        JMenu jm1 = new JMenu("File");
        JMenu jm2 = new JMenu("Edit");
        JMenu jm3 = new JMenu("Help");
        JMenu jm4 = new JMenu("Format");
        JMenu jm5 = new JMenu("Theme");
        JMenu jm6 = new JMenu("Tools");

        JTextArea ja = new JTextArea(30, 20);
        JScrollPane jsap = new JScrollPane(ja, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        ja.setBackground(bgCustom);
        ja.setLineWrap(true);
        Font font = new Font("Consolas", Font.PLAIN, 25);
        ja.setFont(font);
        ja.setBorder(new EmptyBorder(5, 5, 5, 5));
        ja.setWrapStyleWord(true);
        ja.setForeground(Color.white);
        ja.getDocument().addUndoableEditListener(um);

        ImageIcon icon1 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/folder.png");
        JMenuItem jfi2 = new JMenuItem("Open");
        jfi2.setIcon(icon1);

        jfi2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder buff = new StringBuilder();
                JFileChooser jfc = new JFileChooser();
                int r = jfc.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    File opfile = new File(jfc.getSelectedFile().getAbsolutePath());
                    try {
                        Scanner sc = new Scanner(opfile);
                        while (sc.hasNextLine()) {
                            buff.append(sc.nextLine());
                            buff.append("\n");
                        }
                        ja.setText(buff.toString());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        ImageIcon icon3 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/disk.png");
        JMenuItem jfi3 = new JMenuItem("Save", icon3);

        jfi3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String buff = ja.getText().toString();
                JFileChooser jfc = new JFileChooser();
                int r = jfc.showSaveDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    File opfile = new File(jfc.getSelectedFile().getAbsolutePath());
                    Path fileName = Path.of(opfile.toURI());
                    try {
                        Files.writeString(fileName, buff);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });
        ImageIcon icon4 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/exit.png");
        JMenuItem jfi4 = new JMenuItem("Exit",icon4);

        jfi4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
            }
        });
        ImageIcon icon5 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/scissors.png");
        JMenuItem jei1 = new JMenuItem("Cut");

        jei1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.cut();
            }
        });

        jei1.setIcon(icon5);

        ImageIcon icon6 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/copy.png");
        JMenuItem jei2 = new JMenuItem("Copy");

        jei2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.copy();
            }
        });

        jei2.setIcon(icon6);

        ImageIcon icon7 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/paste.png");
        JMenuItem jei3 = new JMenuItem("Paste");

        jei3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.paste();
            }
        });


        jei3.setIcon(icon7);

        ImageIcon icon8 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/selall.png");
        JMenuItem jei4 = new JMenuItem("Select All");

        jei4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ja.selectAll();
            }
        });

        jei4.setIcon(icon8);

        ImageIcon icon9 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/undo.png");
        JMenuItem jei5 = new JMenuItem("Undo");

        jei5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                um.undo();
            }
        });

        jei5.setIcon(icon9);

        ImageIcon icon10 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/redo.png");
        JMenuItem jei6 = new JMenuItem("Redo");

        jei6.setIcon(icon10);

        jei6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                um.redo();
            }
        });

        ImageIcon icon11 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/info.png");
        JMenuItem jhi1 = new JMenuItem("About Me");


        jhi1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String me_content = "Hey,\n\n     So, My name is Fahzain. So, I am 19, in college and this is my first GUI related project in Java as I recently came across This Swing Framework. The sole purpose of making this project was to improve my skills. I hope you like it!\n\nThank You";
                JFrame help = new JFrame("About Me");
                help.setResizable(false);
                help.getContentPane().setBackground(bgCustom);
                help.setForeground(Color.WHITE);
                JLabel hl = new JLabel("About Me");
                hl.setForeground(Color.WHITE);
                Font font = new Font("Consolas", Font.BOLD, 50);
                hl.setFont(font);
                help.add(hl);

                JTextArea jha = new JTextArea(me_content, 20,60);
                jha.setEditable(false);
                jha.setLineWrap(true);
                jha.setWrapStyleWord(true);
                jha.setBackground(bgCustom);
                jha.setForeground(Color.WHITE);
                Font font1 = new Font("Consolas", Font.PLAIN, 22);
                jha.setFont(font1);
                help.add(jha);

                Icon blank = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/blank.png");
                JButton bl = new JButton(blank);
                bl.setBorderPainted(false);
                bl.setBackground(bgCustom);
                bl.setPreferredSize(new Dimension(40, 40));
                help.add(bl);

                Icon icon_ig = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/instagram.png");
                JButton ig = new JButton(icon_ig);
                ig.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Desktop d = Desktop.getDesktop();
                        try {
                            d.browse(new URI("https://www.instagram.com/cybersoul.exe/"));
                        } catch (IOException | URISyntaxException e2) {
                            e2.printStackTrace();
                        }
                    }
                });
                ig.setBorderPainted(false);
                ig.setBackground(bgCustom);
                ig.setPreferredSize(new Dimension(40, 40));
                help.add(ig);

                Icon icon_ld = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/linkedin.png");
                JButton ld = new JButton(icon_ld);
                ld.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Desktop d = Desktop.getDesktop();
                        try {
                            d.browse(new URI("https://www.linkedin.com/in/fahzain-ahmed-0b4a33193/"));
                        } catch (IOException | URISyntaxException e2) {
                            e2.printStackTrace();
                        }
                    }
                });
                ld.setBorderPainted(false);
                ld.setBackground(bgCustom);
                ld.setPreferredSize(new Dimension(40, 40));

                help.add(ld);

                Icon icon_gh = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/git.png");
                JButton gh = new JButton(icon_gh);
                gh.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Desktop d = Desktop.getDesktop();
                        try {
                            d.browse(new URI("https://github.com/FahzainAhmad"));
                        } catch (IOException | URISyntaxException e2) {
                            e2.printStackTrace();
                        }
                    }
                });
                gh.setBorderPainted(false);
                gh.setBackground(bgCustom);
                gh.setPreferredSize(new Dimension(40, 40));
                help.add(gh);

                help.setLayout(new FlowLayout());
                help.setSize(800,700);
                help.setVisible(true);
            }
        });

        jhi1.setIcon(icon11);


        JMenu jffi1 = new JMenu("Dark Mode");

        ImageIcon icon15 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/fonts.png");
        JMenuItem jffi2 = new JMenuItem("Font Style", icon15);

        jffi2.addActionListener(new ActionListener() {
            String curr_font;
            public void actionPerformed(ActionEvent e) {

                String[] ts = {"Regular", "Bold", "Italic"};

                JFrame font_dow = new JFrame("Fonts");
                font_dow.setResizable(false);

                JLabel fl = new JLabel("Font Size : ");

                JTextField ff = new JTextField("", 10);
                ff.setText("26");

                JLabel fs = new JLabel("Font Style : ");
                JComboBox<String> jts = new JComboBox<>(ts);
                jts.setPreferredSize(new Dimension(100, 25));

                JLabel jg = new JLabel("Font Face : ");
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                String[] allFonts = ge.getAvailableFontFamilyNames();
                JComboBox jff = new JComboBox(allFonts);

                JButton jbff = new JButton("Set Fonts");
                jbff.setPreferredSize(new Dimension(155,25));
                jbff.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Font sty =  new Font("Agency FB", Font.PLAIN, 26);;
                        Font jafont = ja.getFont();
                        ja.setFont(jafont.deriveFont(Float.parseFloat(ff.getText())));

                        if ((Objects.requireNonNull(jts.getSelectedItem()).toString()).equals("Regular")) {
                            sty = sty.deriveFont(Font.PLAIN);
                        } else if ((jts.getSelectedItem().toString()).equals("Bold")) {
                            sty = sty.deriveFont(Font.BOLD);
                        } else if ((jts.getSelectedItem().toString()).equals("Italic")) {
                            sty = sty.deriveFont(Font.ITALIC);
                        }

                        curr_font = jff.getSelectedItem().toString();

                        Font font = new Font(curr_font, sty.getStyle(), Integer.parseInt(ff.getText()));
                        ja.setFont(font);
                    }
                });

                font_dow.add(fl);
                font_dow.add(ff);
                font_dow.add(fs);
                font_dow.add(jts);
                font_dow.add(jg);
                font_dow.add(jff);
                font_dow.add(jbff);

                font_dow.getContentPane().setBackground(Color.white);
                font_dow.setVisible(true);
                font_dow.setSize(240, 200);
                font_dow.setLayout(new FlowLayout());
            }
        });
        ImageIcon icon16 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/more.png");
        JMenuItem theme = new JMenuItem("More", icon16);

        theme.addActionListener(new ActionListener() {

            final String[] theme_data = {"Material Theme - Dark", "Ayu - Dark", "Agila - Dark",
                    "Darkmatter - Dark", "Predawn - Dark", "Dracula - Dark", "Space Gray - Dark",
                    "Lucario - Dark", "Gotham - Dark", "Wild Cherry - Dark",
                    "Bluloco - Light", "Soda Light - Light", "NetBeans - Light", "N++ Remixed",
                    "Fire", "Night Ocean", "Hecker man", "Lavender"};

            public void actionPerformed(ActionEvent e) {
                JFrame cus_th = new JFrame("Themes");
                cus_th.setResizable(false);

                JLabel c1 = new JLabel("Select a Theme : ");
                JComboBox<String> cbt = new JComboBox<>(theme_data);
                JButton selt = new JButton("Select");
                selt.setPreferredSize(new Dimension(200, 30));
                JLabel cc = new JLabel("Custom Theme BG: ");
                JTextField br = new JTextField("", 4);
                JTextField bg = new JTextField("", 4);
                JTextField bb = new JTextField("", 4);
                JButton b = new JButton("Set BG Color");

                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int r = Integer.parseInt(br.getText());
                        int g = Integer.parseInt(bg.getText());
                        int b = Integer.parseInt(bb.getText());

                        ja.setBackground(new Color(r,g,b));
                    }
                });

                b.setPreferredSize(new Dimension(200, 30));
                JLabel fcc = new JLabel("Custom Theme FG: ");
                JTextField fr = new JTextField("", 4);
                JTextField fg = new JTextField("", 4);
                JTextField fb = new JTextField("", 4);

                JButton f = new JButton("Set FG Color");
                f.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int fffr = Integer.parseInt(fr.getText());
                        int fffg = Integer.parseInt(fg.getText());
                        int fffb = Integer.parseInt(fb.getText());

                        ja.setForeground(new Color(fffr,fffg,fffb));
                    }
                });


                f.setPreferredSize(new Dimension(200, 30));

                selt.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selTheme = Objects.requireNonNull(cbt.getSelectedItem()).toString();
                        switch (selTheme) {
                            case "Material Theme - Dark" -> {
                                ja.setBackground(new Color(42, 45, 62));
                                ja.setForeground(new Color(127, 146, 146));
                            }
                            case "Ayu - Dark" -> {
                                ja.setBackground(new Color(33, 39, 51));
                                ja.setForeground(new Color(141, 126, 97));
                            }
                            case "Agila - Dark" -> {
                                ja.setBackground(new Color(40, 42, 55));
                                ja.setForeground(new Color(74, 147, 177));
                            }
                            case "Darkmatter - Dark" -> {
                                ja.setBackground(new Color(20, 25, 31));
                                ja.setForeground(new Color(112, 47, 73));
                            }
                            case "Predawn - Dark" -> {
                                ja.setBackground(new Color(40, 40, 40));
                                ja.setForeground(new Color(190, 117, 76));
                            }
                            case "Dracula - Dark" -> {
                                ja.setBackground(new Color(40, 43, 54));
                                ja.setForeground(new Color(137, 128, 186));
                            }
                            case "Space Gray - Dark" -> {
                                ja.setBackground(new Color(43, 48, 60));
                                ja.setForeground(new Color(132, 145, 118));
                            }
                            case "Lucario - Dark" -> {
                                ja.setBackground(new Color(41, 62, 81));
                                ja.setForeground(new Color(82, 176, 206));
                            }
                            case "Gotham - Dark" -> {
                                ja.setBackground(new Color(9, 15, 20));
                                ja.setForeground(new Color(48, 131, 108));
                            }
                            case "Wild Cherry - Dark" -> {
                                ja.setBackground(new Color(44, 30, 52));
                                ja.setForeground(new Color(189, 104, 147));
                            }
                            case "Bluloco - Light" -> {
                                ja.setBackground(new Color(250, 250, 250));
                                ja.setForeground(new Color(71, 73, 82));
                            }
                            case "Soda Light - Light" -> {
                                ja.setBackground(new Color(255, 255, 255));
                                ja.setForeground(new Color(226, 166, 87));
                            }
                            case "NetBeans - Light" -> {
                                ja.setBackground(new Color(255, 255, 255));
                                ja.setForeground(new Color(233, 238, 157));
                            }
                            case "Notepad++ Remix - Light" -> {
                                ja.setBackground(new Color(41, 62, 81));
                                ja.setForeground(new Color(247, 249, 255));
                            }
                            case "Fire" -> {
                                ja.setBackground(new Color(78, 0, 0));
                                ja.setForeground(new Color(182, 40, 52));
                            }
                            case "Night Ocean" -> {
                                ja.setBackground(new Color(0, 11, 32));
                                ja.setForeground(new Color(0, 183, 255));
                            }
                            case "Hecker man" -> {
                                ja.setBackground(new Color(0, 14, 0));
                                ja.setForeground(new Color(0, 255, 0));
                            }
                            case "Lavender" -> {
                                ja.setBackground(new Color(41, 0, 72));
                                ja.setForeground(new Color(138, 46, 155));
                            }
                        }
                    }
                });

                cus_th.add(c1);
                cus_th.add(cbt);
                cus_th.add(selt);


                cus_th.add(cc);
                cus_th.add(br);
                cus_th.add(bg);
                cus_th.add(bb);
                cus_th.add(b);
                cus_th.add(fcc);
                cus_th.add(fr);
                cus_th.add(fg);
                cus_th.add(fb);
                cus_th.add(f);

                cus_th.getContentPane().setBackground(Color.white);
                cus_th.setVisible(true);
                cus_th.setSize(300, 230);
                cus_th.setLayout(new FlowLayout());
            }
        });
        ImageIcon icon19 = new ImageIcon("dice.png");
        JMenuItem jtool1 = new JMenuItem("Lorem Ipsum", icon19);
        jtool1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lorem_ipsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Facilisis magna etiam tempor orci eu. Dolor morbi non arcu risus quis varius. Eleifend donec pretium vulputate sapien nec sagittis aliquam. Pulvinar elementum integer enim neque volutpat ac tincidunt vitae. Mattis vulputate enim nulla aliquet porttitor lacus luctus accumsan tortor. Pharetra magna ac placerat vestibulum lectus. Orci ac auctor augue mauris augue neque. Nunc id cursus metus aliquam eleifend mi. Rhoncus est pellentesque elit ullamcorper dignissim cras tincidunt lobortis. Nam aliquam sem et tortor consequat id porta nibh. Proin libero nunc consequat interdum varius sit amet. Id cursus metus aliquam eleifend mi in. Risus quis varius quam quisque id diam vel.";
                ja.insert(lorem_ipsum, ja.getCaretPosition());
            }
        });

        JMenu jtool2 = new JMenu("Add Stamp");
        jm6.add(jtool2);

        JMenuItem jtts1 = new JMenuItem("Add Time");
        jtts1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();
                ja.insert("[" + dateformat.format(date) + "] ", ja.getCaretPosition());
            }
        });

        JMenuItem jtts2 = new JMenuItem("Add Date");
        jtts2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                ja.insert("[" + dateformat.format(date) + "] ", ja.getCaretPosition());
            }
        });

        JMenuItem jtts3 = new JMenuItem("Add Time and Date");
        jtts3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                ja.insert("[" + dateformat.format(date) + "] ", ja.getCaretPosition());
            }
        });

        jm6.add(jtool1);
        jtool2.add(jtts1);
        jtool2.add(jtts2);
        jtool2.add(jtts3);

        jm5.add(theme);
        ImageIcon icon12 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/moon.png");
        JMenuItem s2 = new JMenuItem("On",icon12);
        s2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.setBackground(bgCustom);
                ja.setBackground(bgCustom);
                ja.setForeground(Color.white);
            }
        });

        ImageIcon icon13 = new ImageIcon("C://Users//Fahzain Ahmed//IdeaProjects//NotePad Ultra/src/sun.png");
        JMenuItem s1 = new JMenuItem("Off", icon13);
        s1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.setBackground(Color.white);
                ja.setBackground(Color.white);
                ja.setForeground(bgCustom);
            }
        });
        jm1.add(jfi2);
        jm1.add(jfi3);
        jm1.add(jfi4);

        jm2.add(jei1);
        jm2.add(jei2);
        jm2.add(jei3);
        jm2.add(jei4);
        jm2.add(jei5);
        jm2.add(jei6);

        jm3.add(jhi1);

        jm4.add(jffi2);
        jm5.add(jffi1);

        jffi1.add(s1);
        jffi1.add(s2);

        jmb.add(jm1);
        jmb.add(jm2);
        jmb.add(jm4);
        jmb.add(jm5);
        jmb.add(jm6);
        jmb.add(jm3);

        jf.add(jsap);

        jf.setJMenuBar(jmb);
        jf.getContentPane().setBackground(bgCustom);
        jf.setVisible(true);
        jf.setSize(800, 600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(1, 1));
    }
}