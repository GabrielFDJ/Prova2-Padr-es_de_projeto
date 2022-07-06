package br.edu.ifba.inf011.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifba.inf011.builder.Exercicio;

public class VideoService {
	private static List<Video> memoryVideo = new ArrayList<>();	

	public String rodarVideo(String descExercicio) {
		Video videoReproduzir = null;	
		for (Video video : memoryVideo) {
			String descExe = video.getExercicio().getDescricao();			
			if (descExercicio.equals(descExe)) {
				videoReproduzir = video;
				return reproduzirVideo(video);				
			}
		}
		
		if (videoReproduzir == null) {			
			Exercicio ex = FlyweightFactory.getIntance().getExercicio(descExercicio);
			videoReproduzir = new Video(ex);
			memoryVideo.add(videoReproduzir);			
			return reproduzirVideo(videoReproduzir);
		}
		
		return "Erro no metodo rodarVideo";		
	}

	private String reproduzirVideo(Video vd) {
		return vd.toString();
	}
}
