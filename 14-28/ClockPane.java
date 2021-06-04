import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
	private int hour;
	private int minute;
	private int second;
	
	private double h = 300;
	private double w = 300;
	
	private boolean hourHandVisible=true;
	private boolean secondHandVisible=true;
	private boolean minuteHandVisible=true;
	
	//default
	public ClockPane(){
		setCurrentTime();
	}
	
	//specific
	public ClockPane(int h, int m, int s){
		this.hour=h;
		this.minute=m;
		this.second=s;
		drawClock();
	}
	
	//returns and sets and the such
	public int getHour(){
		return hour;
	}
	
	public void setHour(int h){
		this.hour=h;
		drawClock();
	}
	
	public int getMinute(){
		return minute;
	}
	
	public void setMinute(int m){
		this.minute=m;
		drawClock();
	}
		
	public int getSecond(){
		return second;
	}
	
	public void setSecond(int s){
		this.second=s;
		drawClock();
	}
	
	//double returns and the such
	public double getW(){
		return w;
	}
	
	public void setW(int wi){
		this.w=wi;
		drawClock();
	}
	
	public double getH(){
		return h;
	}	
	
	public void setH(int he){
		this.h=he;
		drawClock();
	}
	
	//boolean retursn and sets and such
	public boolean isHourHandVisible(){
		return hourHandVisible;
	}	
	
	public void setHourHandVisibility(boolean boo){
		this.hourHandVisible=boo;
		drawClock();
	}
	
	public boolean isMinuteHandVisible(){
		return minuteHandVisible;
	}	
	
	public void setMinuteHandVisibility(boolean boo){
		this.minuteHandVisible=boo;
		drawClock();
	}
	
	public boolean isSecondHandVisible(){
		return secondHandVisible;
	}	
	
	public void setSecondHandVisibility(boolean boo){
		this.secondHandVisible=boo;
		drawClock();
	}
	
	//set the time, as in like the time rn
	public void setCurrentTime(){
		Calendar calendar = new GregorianCalendar();
		
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		
		drawClock();
	}
	
	//draw the clock to the screen
	void drawClock(){
		double cR = Math.min(w, h) * 0.8 * 0.5;
		double cX=w/2;
		double cY=h/2;
		
		//ciclre time 
		Circle circle = new Circle(cX,cY,cR);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(cX-5, cY-cR+12, "12");
		Text t2 = new Text(cX-cR + 3, cY + 5, "9");
		Text t3 = new Text(cX+cR-10, cY+3, "3");
		Text t4 = new Text(cX-3, cY+cR-3, "6");
		
		//draw second hando
		double sL=cR*0.8;
		double sX=cX+sL*Math.sin(second*(2*Math.PI/60));
		double sY=cY+sL*Math.cos(second*(2*Math.PI/60));
		
		Line sLine = new Line (cX,cY,sX,sY);
		if (this.isSecondHandVisible()) {
			sLine.setStroke(Color.RED);
		}
		else{
			sLine.setStroke(Color.WHITE);
		}
		
		//draw minuteo hando
		double mL=cR*0.65;
		double mX=cX+mL*Math.sin(minute*(2*Math.PI/60));
		double mY=cY+mL*Math.cos(minute*(2*Math.PI/60));
		
		Line mLine = new Line (cX,cY,mX,mY);
		if (this.isMinuteHandVisible()) {
			mLine.setStroke(Color.BLUE);
		}
		else{
			mLine.setStroke(Color.WHITE);
		}
		
		//drawo houro hando owo
		double hL=cR*0.5;
		double hX=cX+hL*Math.sin((hour%12+minute/60.0)*(2*Math.PI/12));
		double hY=cY+hL*Math.cos((hour%12+minute/60.0)*(2*Math.PI/12));
		
		Line hLine = new Line (cX,cY,hX,hY);
		if (this.isHourHandVisible()) {
			hLine.setStroke(Color.GREEN);
		}
		else{
			hLine.setStroke(Color.WHITE);
		}
		
		getChildren().clear();
		getChildren().addAll(circle,t1,t2,t3,t4,sLine,mLine,hLine);
	}
}