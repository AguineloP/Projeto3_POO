package Teste;

import java.awt.Color;
import java.time.*;
import javax.swing.*;

public class Janela extends JFrame
{
   private Desenho desenho1;
   private Desenho desenho2;
   private Desenho desenho3;

   Janela()
   {
      Color zumbi1 = new Color(154, 205, 50);
      Color zumbi2 = new Color(0, 255, 0);
      Color zumbi3 = new Color(85, 107, 47);
      
      desenho1 = new Desenho(1, zumbi1);
      desenho2 = new Desenho(2, zumbi2);
      desenho3 = new Desenho(3, zumbi3);
      this.add(desenho1);
      this.add(desenho2);
      this.add(desenho3);

      this.setVisible(true);
      this.setTitle("Desenhos...");
      this.setLocationRelativeTo(null);
      this.setSize(300,300);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
   }
}
