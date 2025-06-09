package Jogo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Desenho extends JComponent implements Runnable
{
   private int forma;
   private Color cor;
   private int zx = 300, zy = 300;
   private int px = 0, py = 0;
   private int height = 20, width = 20;
   private int dirPX = 1, dirPY = 1, dirZX = 1, dirZY = 1;
   
   Desenho(int forma, Color cor)
   {
      this.forma = forma;
      this.cor = cor;
      new Thread(this).start();
   }

   public int getDirPX()
   {
      return dirPX;
   }

   public void setDirPX(int dirPX)
   {
      this.dirPX = dirPX;
   }

   public int getDirPY()
   {
      return dirPY;
   }

   public void setDirPY(int dirPY)
   {
      this.dirPY = dirPY;
   }

   public int getDirZX()
   {
      return dirZX;
   }

   public void setDirZX(int dirZX)
   {
      this.dirZX = dirZX;
   }

   public int getDirZY()
   {
      return dirZY;
   }

   public void setDirZY(int dirZY)
   {
      this.dirZY = dirZY;
   }
   
   public int getForma() {
      return forma;
   }

   public void setForma(int forma) {
      this.forma = forma;
   }

   public Color getCor() {
      return cor;
   }

   public void setCor(Color cor) {
      this.cor = cor;
   }

   public int getZx() {
      return zx;
   }

   public void setZx(int zx) {
      this.zx = zx;
   }
   
   public int getZy() {
      return zy;
   }

   public void setZy(int zy) {
      this.zy = zy;
   }

   public int getPx() {
      return px;
   }

   public void setPx(int px) {
      this.px = px;
   }
   
   public int getPy() {
      return py;
   }

   public void setPy(int py) {
      this.py = py;
   }

   @Override
   public void paint(Graphics g)
   {
      g.setColor(new Color(154, 205, 50));
      g.fillOval(zx, zy, height, width);

      g.setColor(Color.black);
      g.fillRect(px, py, 15, 15);
   }

   @Override
   public void run()
   {
      while(true)
      {
         try
         {
            Thread.sleep(50);
            move();
            repaint();
            moveP();
            repaint();
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }
      }
   }
   
   private void moveP()
   {
      if(py < 15)
         dirPY = 1;
      else if (py > this.getHeight() - 15)     //25 para descontar o tamanho do obj e da borda
         dirPY = 2;

      if(px < 15)
         dirPX = 1;
      else if (px > this.getWidth() - 15)     //25 para descontar o tamanho do obj e da borda
         dirPX = 2;

      //if(dirPX == 1)
         //px += 1;
      //else if(dirPX == 2)
         //px -= 1;

      if(dirPY == 1)
         py += 1;

      else if(dirPY == 2)
         py -= 1;
   }
   
   private void move()
   {
         if(zx < px)
         {
            dirZX = 1;
         }
         else if(zx > px)
         {
            dirZX = 2;               //
         }

         if(zy < py)
         {
            dirZY = 1;
         }
         else if(zy > py)
         {
            dirZY = 2;               //
         }

         if(dirZX == 1)
         {
            zx += 1;
         }
         else if(dirZX == 2)
         {
            zx -= 1;
         }

         if(dirZY == 1)
         {
            zy += 1;
         }
         else if(dirZY == 2)
         {
            zy -= 1;
         }
   }
}
