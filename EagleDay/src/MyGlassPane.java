//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Container;
//import java.awt.Graphics;
//import java.awt.Point;
//import java.awt.Toolkit;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//
//import javax.swing.AbstractButton;
//import javax.swing.JMenuBar;
//import javax.swing.event.MouseInputAdapter;
//
//import components.CBListener;
//import components.MyGlassPane;
//
//
//public class MyGlassPane {
//	
//    implements ItemListener {
//Point point;
//
////React to change button clicks.
//public void itemStateChanged(ItemEvent e) {
//setVisible(e.getStateChange() == ItemEvent.SELECTED);
//}
//
//protected void paintComponent(Graphics g) {
//if (point != null) {
//g.setColor(Color.red);
//g.fillOval(point.x - 10, point.y - 10, 20, 20);
//}
//}
//
//public void setPoint(Point p) {
//point = p;
//}
//
//public MyGlassPane(AbstractButton aButton,
//           JMenuBar menuBar,
//           Container contentPane) {
//CBListener listener = new CBListener(aButton, menuBar,
//                                 this, contentPane);
//addMouseListener(listener);
//addMouseMotionListener(listener);
//}
//}
//
///**
//* Listen for all events that our check box is likely to be
//* interested in.  Redispatch them to the check box.
//*/
//class CBListener extends MouseInputAdapter {
//Toolkit toolkit;
//Component liveButton;
//JMenuBar menuBar;
//MyGlassPane glassPane;
//Container contentPane;
//
//public CBListener(Component liveButton, JMenuBar menuBar,
//          MyGlassPane glassPane, Container contentPane) {
//toolkit = Toolkit.getDefaultToolkit();
//this.liveButton = liveButton;
//this.menuBar = menuBar;
//this.glassPane = glassPane;
//this.contentPane = contentPane;
//}
//
//
//}
