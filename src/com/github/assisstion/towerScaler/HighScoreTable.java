package com.github.assisstion.towerScaler;

import java.util.LinkedList;

public class HighScoreTable{
	
	protected int maxScores = 10;
	protected LinkedList<Score> scores = new LinkedList<Score>();

	public void addScore(Score score){
		if(score.getName() == null || score.getName().equals("")){
			return;
		}
		boolean add = false;
		int index = 0;
		for(Score oldScore : scores){
			if(score.getScore() > oldScore.getScore()){
				add = true;
				break;
			}
			index++;
			if(index >= maxScores){
				break;
			}
		}
		if(index < maxScores){
			add = true;
		}
		if(add){
			scores.add(index, score);
		}
	}
	
	public LinkedList<Score> getScores(){
		return scores;
	}
}
