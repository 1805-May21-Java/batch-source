package com.revature.main;

import java.io.PrintWriter;
import java.util.List;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import com.revature.model.Game;
import com.revature.service.GameCollection;

public class ClientDriver {

	public static void main(String[] args) {
		
		String serviceUrl = "http://gamecollection.us-east-2.elasticbeanstalk.com/GameCollection";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(GameCollection.class);
		factory.setAddress(serviceUrl);
		
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));
		
		GameCollection gameCollection = (GameCollection) factory.create();
		List<Game> games = gameCollection.getGames();
		for(Game g: games) {
			System.out.println(g);
		}
		Game game1 = new Game(4, "Diablo 3", "Action RPG", 2016);
		System.out.println(gameCollection.addGame(game1));
		
		try {
			Game game2 = new Game(5, "Halo 4", "FPS", 2014);
			System.out.println(gameCollection.addGame(game2));	
		} catch (Exception e) {
			System.out.println(e);
		}

		
	}
}
