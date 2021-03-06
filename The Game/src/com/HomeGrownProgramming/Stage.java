package com.HomeGrownProgramming;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Stage {

	public Shape3[] objects;
	public Unit player;
	public Rectangle view;
	private LinkedList<Shape3> objs = new LinkedList<Shape3>();
	public static final int START_STAGE = 0;
	
	public Stage() {}
	
	private void preStuff() {
		objects = new Shape3[0];
		objs.add(new Shape3(new Point3(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE), new Point3(1, 1, 1), Shape3.DIMENSIONS, Color.WHITE, 100, 0, false));
	}
	
	private void postStuff() {
		objs.add(new Shape3(new Point3(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE), new Point3(1, 1, 1), Shape3.DIMENSIONS, Color.WHITE, 100, 0, false));
		Point3 pCenter = player.getCenter();
		view = new Rectangle((int) (pCenter.x+pCenter.z-Starter.screenSize.width/2), (int)(pCenter.y-pCenter.z-Starter.screenSize.height/2), Starter.screenSize.width, Starter.screenSize.height);
		objs.getLast().gravAffect = false;
		objects = objs.toArray(objects);
	}
	
	public void loadStage(int stageNum) {
		preStuff();
		switch(stageNum){
			case 0:
				loadStage0();
				break;
			case 1:
				loadStage1();
				break;
		}
		postStuff();
	}
	
	public void loadStage0() {
		objs.add(new Shape3(new Point3(-100, 100, 0), new Point3(0, 500, Shape3.MAX_DEPTH), Shape3.OPPOSITE_POINT, Color.GRAY, 100, 0, false));
		objs.getLast().gravAffect = false;
		objs.add(new Shape3(new Point3(0, 400, 0), new Point3(2000, 100, Shape3.MAX_DEPTH), Shape3.DIMENSIONS, Color.GRAY, 100, 0, false));
		objs.getLast().gravAffect = false;
		Point3[] points = new Point3[8];
		points[0] = new Point3(1200, 390, 0);
		points[1] = new Point3(1200, 390, Shape3.MAX_DEPTH);
		points[2] = new Point3(2200, 0, 0);
		points[3] = new Point3(2200, 0, Shape3.MAX_DEPTH);
		points[4] = new Point3(2200, 400, 0);
		points[5] = new Point3(2200, 400, Shape3.MAX_DEPTH);
		points[6] = new Point3(1200, 400, 0);
		points[7] = new Point3(1200, 400, Shape3.MAX_DEPTH);
		objs.add(new Shape3(points, Color.GRAY, 100, 0, false));
		objs.add(new Unit(new Point3(1200, 200, 0), Color.GREEN));
		player = (Unit) objs.getLast();
		objs.add(new Unit(new Point3(150, 10, 10), Color.RED));
	}
	
	public void loadStage1() {
		
	}
}
