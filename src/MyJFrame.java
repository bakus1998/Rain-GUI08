import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame extends JFrame {
    int drops_int;
    int refreshing_int;

    public MyJFrame(){
        setTitle("Symulacja deszczu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1280,720);
        setResizable(false);

        BorderLayout bl = new BorderLayout();
        setLayout(bl);

        JComponentRain rainComp = new JComponentRain();


        JPanel JPset = new JPanel();

        JPset.setBackground(Color.GRAY);
        JTextField jtf_drops = new JTextField();
        JTextField jtf_refreshing = new JTextField();

        JLabel jl_drops = new JLabel("Ilość Kropli: ");
        JLabel jl_refreshing = new JLabel("Szybkość odtwarzania: ");


        JButton set = new JButton("Ustaw");

        FlowLayout fl = new FlowLayout(30);
        JPset.setLayout(fl);

        jtf_drops.setPreferredSize(new Dimension(80,20));
        jtf_refreshing.setPreferredSize(new Dimension(80,20));
        JPset.add(jl_drops);
        JPset.add(jtf_drops);
        JPset.add(jl_refreshing);
        JPset.add(jtf_refreshing);
        JPset.add(set);

        jtf_drops.setText("100");
        jtf_refreshing.setText("30");
        String get_drops = jtf_drops.getText();
        String get_refreshing = jtf_refreshing.getText();

        drops_int=Integer.parseInt(get_drops);
        refreshing_int=Integer.parseInt(get_refreshing);


        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String get_drops = jtf_drops.getText();
                String get_refreshing = jtf_refreshing.getText();

                drops_int=Integer.parseInt(get_drops);
                refreshing_int=Integer.parseInt(get_refreshing);

                rainComp.setComponent(drops_int,refreshing_int);
                System.out.println(drops_int + " " + refreshing_int);
            }
        });


        add(JPset,BorderLayout.NORTH);
        add(rainComp,BorderLayout.CENTER);


    }
}
