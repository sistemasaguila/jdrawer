package com.sistemasaguila.jdrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame

{
    private JPanel panel;
    private JButton btn;

    public Main(){
        test();
        this.setContentPane(getPanel());
        this.setSize(200,200);
    }

    private JButton getBtn(){
        if(btn == null){
            btn = new JButton("Test");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(drawer.isShow()) {
                        drawer.hide();
                    }else {
                        drawer.show();
                    }
                }
            });
        }
        return btn;
    }

    private DrawerController drawer;

    private void test() {
        Drawer d = Drawer.newDrawer(this)
                .leftDrawer(false) // cuando está en false se alinea a la derecha
                .drawerWidth(500) // ajusta el tamaño del panel
                .itemAlignLeft(true) // si es true alinea a la derecha
                .headerHeight(50)
                .itemHeight(35) // tamaño de separacion de items
                .closeOnPress(true) // se cierra el panel si se da click fuera del mismo
                .enableScroll(true) // activa el scroll
                .enableScrollUI(true)
                .addChild(new PanelTest())
                .addChild(new PanelTest())
                .addChild(new PanelTest())
                .addChild(new PanelTest())
                .addChild(new PanelTest())
                .addChild(new PanelTest())
                //.addChild(new PanelTest())
                //.addChild(new DrawerItem("Item 2").build())
                //.addChild(new PanelTest())
                //.addChild(new PanelTest())
                //.addChild(new PanelTest())
                //.addChild(new PanelTest())
                //.addChild(new DrawerItem("Item 3").build())
                //.addFooter(new DrawerItem("ITEM FOOTER").build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int index, DrawerItem item) {
                        System.err.println(index + " -> " + item);
                    }
                });
            drawer = d.build();


    }
    private JPanel getPanel(){
        if(panel == null){
            panel = new JPanel();
            panel.add(getBtn());

        }
        return panel;
    }
    public static void main(String[] args) {
        new Main().setVisible(true);
    }


    public class PanelTest extends  JPanel {

        public PanelTest(){
            setPreferredSize(new Dimension(400,50));
            setBackground(Color.lightGray);
            add(btn2());
        }

        private JButton btn2;

        private JButton btn2(){
            if(btn2 == null){
                btn2 = new JButton();
                btn2.setText("close");
                btn2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       setVisible(false);
                       revalidate();
                    }
                });
            }
            return btn2;
        }


    }

}
