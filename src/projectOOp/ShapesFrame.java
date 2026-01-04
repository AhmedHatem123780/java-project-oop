package projectOOp;

import javax.swing.JFrame;

public class ShapesFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public ShapesFrame(Drawable[] arr) {
        
        setTitle("Shapes Drawer");
        setSize(1300, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ShapesPanel panel = new ShapesPanel(arr);  
        add(panel);

        setVisible(true);   
    }
}
