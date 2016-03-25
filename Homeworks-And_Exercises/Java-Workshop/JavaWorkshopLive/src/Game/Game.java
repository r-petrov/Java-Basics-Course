package Game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Display.Display;

public class Game implements Runnable {
	private String title;
	private int width;
	private int height;
	
	private Thread thread;
	private boolean isRunning;
	
	private Display display;
	private BufferStrategy bs;
	private Graphics graphics;

	public Game(String title, int width, int height) {
		super();
		this.title = title;
		this.width = width;
		this.height = height;
		this.isRunning = false;
	}

	@Override
	public void run() {
		this.init();
	}
	
	private void init() {
		this.display = new Display(title, width, height);
		
		while (isRunning) {
			tick();
			render();
		}
		this.stop();
	}
	
	private void tick() {
		
	}
	
	private void render() {
		this.bs = this.display.getCanvas().getBufferStrategy();
		
		if (this.bs == null) {
			this.display.getCanvas().createBufferStrategy(2);
			return;
		}
		
		this.graphics = this.bs.getDrawGraphics();
		this.graphics.clearRect(0, 0, this.width, this.height);
		//START DRAW
		
		
		//CLEAR DRAW
//		this.graphics.fillRect(this.x, 100, 200, 30);
//		this.graphics.drawOval(100, 100, 200, 100);
		
		this.bs.show();
		this.graphics.dispose();
	}

	public synchronized void start() {
		if (!this.isRunning) {
			this.isRunning = true;
			this.thread = new Thread(this);
			this.thread.start();
		}
	}
	
	public synchronized void stop() {
		if (this.isRunning) {
			try {
				this.isRunning = false;
				this.thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
