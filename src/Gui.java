import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame
{
    private JPanel panelMain;
    private JLabel selectLabel;
    private JButton bH10;
    private JButton bH11;
    private JLabel enterLabel;
    private JButton bInsertBV;
    private JButton bInsertB;
    private JButton bSearchP;
    private JButton bDisplayB;
    private JButton bDisplayV;
    private JButton bDisplayV1;
    private JLabel lBirthday;
    private JLabel lValue;
    private JTextField tfBirthday;
    private JTextField tfValue;

    public Gui()
    {

        bH10.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                HashSuche.HashSuche(10);
                JOptionPane.showMessageDialog(null, "Hash table was reset");
            }
        });

        bH11.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                HashSuche.HashSuche(11);
                JOptionPane.showMessageDialog(null, "Hash table was reset");
            }
        });

        bInsertBV.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    HashSuche.fuegeEin(Integer.parseInt(tfBirthday.getText()), Integer.parseInt(tfValue.getText()));
                    JOptionPane.showMessageDialog(null, "Input successful");
                }
                catch (Exception x)
                {
                    JOptionPane.showMessageDialog(null, "You must choose a hashing function and enter numbers only.");
                }
            }
        });

        bInsertB.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    HashSuche.fuegeEin(Integer.parseInt(tfBirthday.getText()));
                    JOptionPane.showMessageDialog(null, "Input successful");
                }
                catch (Exception x)
                {
                    JOptionPane.showMessageDialog(null, "You must choose a hashing function and enter numbers only.");
                }
            }
        });

        bSearchP.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    JOptionPane.showMessageDialog(null, "ID/Birthday found on position " + HashSuche.suchePositionVon(Integer.parseInt(tfBirthday.getText())));
                }
                catch (Exception x)
                {
                    JOptionPane.showMessageDialog(null, "You must enter numbers only");
                }
            }
        });

        bDisplayB.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    JOptionPane.showMessageDialog(null, new JList(intArrToStringArr(HashSuche.gibSchluessel())));
                }
                catch (Exception x)
                {
                    JOptionPane.showMessageDialog(null, "You must enter numbers only");
                }
            }
        });

        bDisplayV.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    JOptionPane.showMessageDialog(null, new JList(doubleArrToStringArr(HashSuche.gibWerte())));
                }
                catch (Exception x)
                {
                    JOptionPane.showMessageDialog(null, "You must enter numbers only");
                }
            }
        });

        bDisplayV1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    JOptionPane.showMessageDialog(null, HashSuche.gibWertVon(Integer.parseInt(tfBirthday.getText())));
                }
                catch (Exception x)
                {
                    JOptionPane.showMessageDialog(null, "You must enter numbers only");
                }
            }
        });
    }

    public static void main(String[] args)
    {
        Gui g = new Gui();
        g.setContentPane(g.panelMain);
        g.setTitle("GUI Hashing");
        g.setSize(600,300);
        g.setVisible(true);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public String[] intArrToStringArr(int[] arr)
    {
        String[] stringArr = new String[arr.length];
        for (int i=0; i<arr.length; i++)
        {
            stringArr[i] = "Position "+i+": "+String.valueOf(arr[i]);
        }
        return stringArr;
    }

    public String[] doubleArrToStringArr(double[] arr)
    {
        String[] stringArr = new String[arr.length];
        for (int i=0; i<arr.length; i++)
        {
            stringArr[i] = "Position "+i+": "+String.valueOf(arr[i]);
        }
        return stringArr;
    }


}


