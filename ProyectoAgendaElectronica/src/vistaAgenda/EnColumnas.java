package vistaAgenda;

import java.awt.*;


class EnColumnas implements LayoutManager {

    private int x;
    private int y = 20;

    @Override
    public void addLayoutComponent(String arg0, Component arg1) {
    }

    @Override
    public void layoutContainer(Container contenedor) {
        int d = contenedor.getWidth();//las dimensiones del contenedor es decir de la ventana
        x = d/2;
        int contador = 0;
        int n = contenedor.getComponentCount();
        for(int i=0;i<n;i++) {
            contador++;
            Component c = contenedor.getComponent(i);
            c.setBounds(x-90, y, 110, 20);
            x+=90;
            if(contador%2==0) {
                x=d/2;
                y+=40;
            }
        }
    }
    @Override
    public Dimension minimumLayoutSize(Container arg0) {
        return null;
    }
    @Override
    public Dimension preferredLayoutSize(Container arg0) {
        return null;
    }
    @Override
    public void removeLayoutComponent(Component arg0) {  
    }
    
}