package com.example.wirelesstest;

import org.achartengine.GraphicalView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class BarActivity extends Activity {


	private GraphicalView view;
	private BarGraph   bar = new BarGraph ();
	
	//LinearLayout llayout = (LinearLayout)findViewById(R.id.chart);
	
	private static Thread plotThread;
	private int i = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bar);
		
		plotThread = new Thread(){
			public void run()
			{
				while(true)
				{
					try {
						Thread.sleep(1000);
						i += 1;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//Point p1 = MockData.getDataFromReceiver1(i);//got new data!
					Point p1 = MockData.getDataFromReceiver1(i);
					bar.addNewPoints1(p1);
					//Point p2 = MockData.getDataFromReceiver2(i);//got new data!
					Point p2 = MockData.getDataFromReceiver2(i);
					bar.addNewPoints2(p2);
					view.repaint();
					Log.d("repaint", "repaint");
				}
			}
		};
		plotThread.start();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		view = bar.getView(this);
		setContentView(view);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		finish();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		this.finish();
	}
	
}
