package com.example.wirelesstest;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.graphics.Color;

public class LineGraph {

	private GraphicalView view;
	
	private TimeSeries dataset = new TimeSeries("Oxygenation Level");
	private TimeSeries dataset2 = new TimeSeries("Heart rate");
	private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
	
	private XYSeriesRenderer renderer = new XYSeriesRenderer(); // used to customize line
	private XYSeriesRenderer renderer2 = new XYSeriesRenderer(); // used to customize line
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
	
	private double[]  initalRange = {0,10,0,100};
	private int[] margins = {100,30,50,30};
	
	public LineGraph() // constructor
	{
		//add single dataset to multiple dataset
		mDataset.addSeries(dataset);
		mDataset.addSeries(dataset2);
		
		//customization time for line 1!
		renderer.setColor(Color.BLUE);
		renderer.setPointStyle(PointStyle.SQUARE);
		renderer.setFillPoints(true);
		renderer.setDisplayChartValues(true);
		renderer.setLineWidth((float) 5);
		renderer.setFillBelowLineColor(Color.YELLOW);
		renderer.setChartValuesTextSize((float) 20);
		renderer.setGradientEnabled(true);
		// customization time for line 2!
		renderer2.setColor(Color.YELLOW);
		renderer2.setPointStyle(PointStyle.SQUARE);
		renderer2.setFillPoints(true);
		renderer2.setDisplayChartValues(true);
		renderer2.setLineWidth((float) 5);
		renderer2.setFillBelowLineColor(Color.YELLOW);
		renderer2.setChartValuesTextSize((float) 20);
		renderer2.setGradientEnabled(true);
		
		//Enable Zoom
		mRenderer.setYAxisMin((double) 50);
		mRenderer.setZoomButtonsVisible(true);
		mRenderer.setXTitle("Seconds");
		mRenderer.setYTitle("Level");
		mRenderer.setBackgroundColor(Color.BLACK);
		mRenderer.setApplyBackgroundColor(true);
		mRenderer.setAxesColor(Color.YELLOW);
		mRenderer.setAxisTitleTextSize((float) 20) ;
		mRenderer.setChartTitle("Line Graph");
		mRenderer.setChartTitleTextSize((float) 50);
		mRenderer.setFitLegend(true);
		mRenderer.setLabelsColor(Color.RED);
		mRenderer.setLabelsTextSize((float) 10);
		mRenderer.setLegendTextSize((float) 25);
		//mRenderer.setPanEnabled(true);
		
		//mRenderer.setInitialRange(initalRange);
		mRenderer.setMargins(margins);
		
		mRenderer.setYAxisMax((double)150);
		mRenderer.setYAxisMin((double)50);
				
		
		//add a single renderer to multiple renderer
		mRenderer.addSeriesRenderer(renderer);
		mRenderer.addSeriesRenderer(renderer2);
		
	}
	
	public GraphicalView getView(Context context)
	{
		view = ChartFactory.getLineChartView(context, mDataset, mRenderer);
		return view;
	}
	
	
	public void addNewPoints1(Point p1) {
		// TODO Auto-generated method stub
		dataset.add(p1.getX(), p1.getY());
	}

	public void addNewPoints2(Point p2) {
		// TODO Auto-generated method stub
		
		dataset2.add(p2.getX(), p2.getY());
	}
	
}
