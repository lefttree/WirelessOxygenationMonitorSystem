package com.example.wirelesstest;

import org.achartengine.GraphicalView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class LineActivity extends Activity {
	private GraphicalView view;
	private LineGraph line = new LineGraph();
	private static Thread plotThread;
	private int i = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_line);
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
					Point p1 = MockData.getDataFromReceiver1(i);
					line.addNewPoints1(p1);
					Point p2 = MockData.getDataFromReceiver2(i);
					line.addNewPoints2(p2);
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
		view = line.getView(this);
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
		finish();
	}  
	
}
