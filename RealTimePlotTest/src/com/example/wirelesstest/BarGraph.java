package com.example.wirelesstest;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;

public class BarGraph {

	// graphical view
	private GraphicalView view;
	// timeseries, multiseries
	private TimeSeries dataset = new TimeSeries("Oxygenation Level");
	private TimeSeries dataset2 = new TimeSeries("Heart rate");
	
	private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
	// renderer
	private XYSeriesRenderer renderer = new XYSeriesRenderer(); // uesd to customize
	private XYSeriesRenderer renderer2 = new XYSeriesRenderer();															// bar
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
	
	private int[] margins = {100,30,50,30};
	
	public BarGraph()
	{
		mDataset.addSeries(dataset);
		mDataset.addSeries(dataset2);
		//customize line 1
		renderer.setDisplayChartValues(true);
		renderer.setChartValuesSpacing((float) 10);
		renderer.setColor(Color.BLUE);
		renderer.setChartValuesTextSize((float)20);
		
		//renderer.setGradientEnabled(true);
		//renderer.setGradientStart((double) 0, Color.BLACK);
		//renderer.setGradientStop((double) 50, Color.BLUE);
		
		//customize line 2
		renderer2.setDisplayChartValues(true);
		renderer2.setChartValuesSpacing((float) 10);
		renderer2.setColor(Color.YELLOW);
		renderer2.setChartValuesTextSize((float)20);
		//renderer2.setGradientEnabled(true);
		//renderer2.setGradientStart((double) 0, Color.BLACK);
		//renderer2.setGradientStop((double) 80, Color.YELLOW);
		
		mRenderer.addSeriesRenderer(renderer);
		mRenderer.addSeriesRenderer(renderer2);
		
		mRenderer.setChartTitle("Bar Graph");
		mRenderer.setXTitle("Seconds");
		mRenderer.setYTitle("Level");
		mRenderer.setZoomEnabled(true);
		mRenderer.setZoomButtonsVisible(true);
		mRenderer.setBarSpacing((double)2);
		
		//mRenderer.setYAxisMax((double)100);
		mRenderer.setYAxisMin((double)50);
		mRenderer.setPanEnabled(true);
		mRenderer.setBackgroundColor(Color.BLACK);
		mRenderer.setApplyBackgroundColor(true);
		mRenderer.setAxesColor(Color.WHITE);
		mRenderer.setAxisTitleTextSize((float) 20) ;
		mRenderer.setChartTitle("Bar Graph");
		mRenderer.setChartTitleTextSize((float) 50);
		mRenderer.setFitLegend(true);
		mRenderer.setLabelsColor(Color.RED);
		mRenderer.setLabelsTextSize((float) 10);
		mRenderer.setLegendTextSize((float) 25);
		
		mRenderer.setYAxisMax((double)150);
		mRenderer.setYAxisMin((double)50);
		
		mRenderer.setMargins(margins);
		
	}
	
	public GraphicalView getView(Context context)
	{
		view = ChartFactory.getBarChartView(context, mDataset, mRenderer, Type.DEFAULT);
		return view;
	}
	
	public void addNewPoints1(Point p){
		dataset.add(p.getX(), p.getY());
	}
	public void addNewPoints2(Point p){
		dataset2.add(p.getX(), p.getY());
	}
	

}
