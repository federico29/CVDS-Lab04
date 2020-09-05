package hangman.model;

public class OriginalScore implements GameScore {
	
	/**
     * Calculo del puntaje: puntaje entre [0,100] inicia en 100, letras correctas no bonifican e incorrectas quitan 10 puntos
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