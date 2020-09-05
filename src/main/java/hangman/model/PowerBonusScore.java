package hangman.model;

public class PowerBonusScore implements GameScore {
	private int initialScore=0;
	/**
     * Calculo del puntaje: puntaje entre [0,500] inicia en 0, letras correctas suman 5^i puntos e incorrectas quitan 8 puntos
     * @param numero de letras correctas
     * @param numero de letras incorrectas
     * @return puntaje calculado en base a los parámetros
     */
	@Override
	public int calculateScore(int correctCount, int incorrectCount) {
		// TODO Auto-generated method stub
		int score=initialScore;
		for(int i=1;i<=correctCount;i++) {
			score+=Math.pow(5,i);
		}
		score=score-(8*incorrectCount);
		if(score>500) {
			return 500;
		}else {
			if(score>0) {
				return score;
			}else {
				return 0;
			}
		}
	}

}
