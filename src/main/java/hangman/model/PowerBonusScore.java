package hangman.model;

public class PowerBonusScore implements GameScore {
	
	/**
     * Calculo del puntaje: puntaje entre [0,500] inicia en 0, letras correctas suman 5^i puntos e incorrectas quitan 8 puntos
     * @param numero de letras correctas
     * @param numero de letras incorrectas
     * @return puntaje calculado en base a los parámetros
     */
	@Override
	public int calculateScore(int correctCount, int incorrectCount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
