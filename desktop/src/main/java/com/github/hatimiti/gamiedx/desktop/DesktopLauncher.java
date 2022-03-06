package com.github.hatimiti.gamiedx.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.github.hatimiti.gamiedx.GamieApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DesktopLauncher {

	private static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		LOGGER.info("start the game: {}", DesktopLauncher.class);
		new Lwjgl3Application(new GamieApplication(), config);
	}
}
