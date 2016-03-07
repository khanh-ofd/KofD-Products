import java.awt.*;
import javax.swing.JFrame;
public class demo extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		demo f=new demo();
		f.setTitle("Chao ban");
		f.setBounds(200,500,700,400); //tao khung
		f.setLayout(new FlowLayout());
		f.add(new Button("OK"));
		f.add(new Button("Cancel"));
		f.add(new Label("Day la Label"));
		f.add(new TextField(7));
		f.add(new TextArea(5,30));
		f.add(new Checkbox("Sport"));
		f.add(new Checkbox("Music"));
		f.add(new Checkbox("Travel"));
		CheckboxGroup cg = new CheckboxGroup();
		f.add(new Checkbox("Female",cg,true));
		f.add(new Checkbox("Male",cg,true));
		Choice ch = new Choice();
		ch.addItem("Support");
		ch.addItem("Music");
		ch.addItem("Travel");
		f.add(ch);
		List list = new List(3,false);
		list.add("Sport");
		list.add("Music");
		list.add("Travel");
		list.add("Game");
		f.add(list);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
