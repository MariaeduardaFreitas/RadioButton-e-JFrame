package maria;

import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.*;

public class RadioButtonFrame extends JFrame{
    
    private JTextField alteraFonte;
    private Font textoSimples;
    private Font negrito;
    private Font italico;
    private Font negritoItalico;
    private JRadioButton selecTextoSimples;
    private JRadioButton selecNegrito;
    private JRadioButton selecItalico;
    private JRadioButton selecNegritoItalico;
    private ButtonGroup botoesOpcao;
    
    public RadioButtonFrame(){
        
        super("Teste com RadioButton");
        setLayout(new FlowLayout());
        
        alteraFonte = new JTextField("Estilo de fonte escolhida", 25);
        add(alteraFonte);
        
        //criando botões de opção
        selecTextoSimples = new JRadioButton("Simples", true);
        selecNegrito = new JRadioButton("Negrito", false);
        selecItalico = new JRadioButton("Italico", false);
        selecNegritoItalico = new JRadioButton("Negrito e Italico", false);
        
        add(selecTextoSimples);
        add(selecNegrito);
        add(selecItalico);
        add(selecNegritoItalico);
                
        //criando relacionamento lógico entre os botões
        botoesOpcao = new ButtonGroup();
        botoesOpcao.add(selecTextoSimples);
        botoesOpcao.add(selecNegrito);
        botoesOpcao.add(selecItalico);
        botoesOpcao.add(selecNegritoItalico);
        
        //criando fonte objetos
        textoSimples = new Font("Times New Roman", Font.PLAIN, 14);
        negrito = new Font("Times New Roman", Font.BOLD, 14);
        italico = new Font("Times New Roman", Font.ITALIC, 14);
        negritoItalico = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 14);
        alteraFonte.setFont(textoSimples);
        
        //registra eventos para JRadioButton
        selecTextoSimples.addItemListener(new RadioButtonHandler(textoSimples));
        selecNegrito.addItemListener(new RadioButtonHandler(negrito));
        selecItalico.addItemListener(new RadioButtonHandler(italico));
        selecNegritoItalico.addItemListener(new RadioButtonHandler(negritoItalico));
    }  
    
    private class RadioButtonHandler implements ItemListener{
    
        private Font fonte;
        
        public RadioButtonHandler(Font f){
        
                fonte = f; //configura a fonte do Listener
        }
        
        public void itemStateChanged(ItemEvent event){
            
            alteraFonte.setFont(fonte); //configura a fonte do altera fonte
        }
    } 
}
