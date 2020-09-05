package hangman.model;

public class BonusScore implements GameScore {
	
	private int initialScore=0;
	
	/**
     * Calculo del puntaje: puntaje entre [0,..) inicia en 0, letras correctas suman 10 puntos e incorrectas quitan 5 puntos
     * @param numero de letras correctas
     * @param numero de letras incorrectas
     * @return puntaje calculado en base a los parámetros
     */
	@Override
	public int calculateScore(int correctCount, int incorrectCount) {
		// TODO Auto-generated method stub
		int score=initialScore+(10*correctCount)-(5*incorrectCount);
		if(score<0) {
			return initialScore;
		}else {
			return score;
		}
	}
}