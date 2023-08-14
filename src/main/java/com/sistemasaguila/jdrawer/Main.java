package com.sistemasaguila.jdrawer;

import javax.swing.*;
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
    private void test(){
        drawer = Drawer.newDrawer(this)
                //.header(new encabezado())
                //.separator(2, new Color(90,90,90))
                .space(50) // espacio entre el encabezado y el cuerpo
                // 	.background(new Color(255,51,51)) cambia el color del fondo
                // 	.backgroundTransparent(0.3f) cambia el color del efecto en la transparencia
                .leftDrawer(false) // cuando está en false se alinea a la derecha
                .drawerWidth(500) // ajusta el tamaño del panel
                .itemAlignLeft(true) // si es true alinea a la derecha
                .itemHeight(40) // tamaño de separacion de items
                .closeOnPress(true) // se cierra el panel si se da click fuera del mismo
                //	.drawerBackground(new Color(238,238,143)) color del panel
                //	.duration(300)  duracion de apertura del panel
                .enableScroll(true) // activa el scroll
                //	.enableScrollUI(false)
                .addChild(new DrawerItem("ITEM NAME").build())
                .addChild(new DrawerItem("ITEM NAME").build())
                .addChild(new DrawerItem("ITEM NAME").build())
                .addChild(new DrawerItem("ITEM NAME").build())
                .addFooter(new DrawerItem("ITEM FOOTER").build())
                .event(new EventDrawer() {
                    @Override
                    public void selected(int index, DrawerItem item) {
                        System.err.println("okoite la prueba che karai");

                    }
                })
                .build();
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

}
