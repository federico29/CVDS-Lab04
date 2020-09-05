package hangman;

import org.junit.Test;
import junit.framework.*;

import hangman.model.BonusScore;
import hangman.model.OriginalScore;
import hangman.model.PowerBonusScore;

public class GameScoreTest{
	/**
	* Clases de equivalencia OriginalScore:
	* 	valores correctos:  0<=score && 0<=100
	*	valores incorrectos: score%10 != 0 && score<0 && 100<score
	*	casos frontera inferior: score==-10  score==0  score==10
	*	casos frontera superior: score==90 score==100 score>100
	**/

	@SuppressWarnings("deprecation")
	@Test
	public void originalScoreTestCorrecto(){
		OriginalScore score=new OriginalScore();
		int valor = score.calculateScore(3,4);		
		Assert.assertEquals(valor,60);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void originalScoreTestIncorrecto() {
		OriginalScore score=new OriginalScore();
		int valor = score.calculateScore(2,5);
		boolean esMultiplo=(valor%10)==0;
		Assert.assertEquals(esMultiplo,true);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void originalScoreTestFronteraInferior1() {
		OriginalScore score=new OriginalScore();
		int valor = score.calculateScore(1,11);
		Assert.assertEquals(valor,0);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void originalScoreTestFronteraInferior2() {
		OriginalScore score=new OriginalScore();
		int valor = score.calculateScore(0,10);
		Assert.assertEquals(valor,0);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void originalScoreTestFronteraInferior3() {
		OriginalScore score=new OriginalScore();
		int valor = score.calculateScore(3,9);
		Assert.assertEquals(valor,10);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void originalScoreTestFronteraSuperior1() {
		OriginalScore score=new OriginalScore();
		int valor = score.calculateScore(5,1);
		Assert.assertEquals(valor,90);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void originalScoreTestFronteraSuperior2() {
		OriginalScore score=new OriginalScore();
		int valor = score.calculateScore(0,0);
		Assert.assertEquals(valor,100);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void originalScoreTestFronteraSuperior3() {
		OriginalScore score=new OriginalScore();
		int valor = score.calculateScore(10,0);
		Assert.assertEquals(valor,100);
	}
	/**
	* Clases de equivalencia Bonus Score:
	* 	valores correcto:  0<=score
	*	valores incorrectos: score%5 != 0 && score<0
	*	casos frontera inferior: score==-5  score==0 score==5
	**/
	
	@SuppressWarnings("deprecation")
	@Test
	public void bonusScoreTestCorrecto(){
		BonusScore score=new BonusScore();
		int valor = score.calculateScore(10,3);
		Assert.assertEquals(valor,85);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void bonusScoreTestIncorrecto(){
		BonusScore score=new BonusScore();
		int valor = score.calculateScore(3,3);
		boolean esMultiplo=(valor%5)==0;
		Assert.assertEquals(esMultiplo,true);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void bonusScoreTestFronteraInferior1(){
		BonusScore score=new BonusScore();
		int valor = score.calculateScore(0,1);
		Assert.assertEquals(valor,0);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void bonusScoreTestFronteraInferior2(){
		BonusScore score=new BonusScore();
		int valor = score.calculateScore(0,1);
		Assert.assertEquals(valor,0);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void bonusScoreTestFronteraInferior3(){
		BonusScore score=new BonusScore();
		int valor = score.calculateScore(1,1);
		Assert.assertEquals(valor,5);
	}
	/**
	* Clases de equivalencia Bonus Score:
	* 	valores correcto:  0<=score<=500
	*	casos frontera inferior: score==-8  score==0 score==5
	*	casos frontera superior: score==155  score==500 score==780
	**/
	
	@SuppressWarnings("deprecation")
	@Test
	public void powerBonusScoreTestCorrecto(){
		PowerBonusScore score=new PowerBonusScore();
		int valor = score.calculateScore(2,1);
		Assert.assertEquals(valor,17);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void powerBonusScoreTestFronteraInferior1(){
		PowerBonusScore score=new PowerBonusScore();
		int valor = score.calculateScore(0,1);
		Assert.assertEquals(valor,0);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void powerBonusScoreTestFronteraInferior2(){
		PowerBonusScore score=new PowerBonusScore();
		int valor = score.calculateScore(0,0);
		Assert.assertEquals(valor,0);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void powerBonusScoreTestFronteraInferior3(){
		PowerBonusScore score=new PowerBonusScore();
		int valor = score.calculateScore(1,0);
		Assert.assertEquals(valor,5);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void powerBonusScoreTestFronteraSuperior1(){
		PowerBonusScore score=new PowerBonusScore();
		int valor = score.calculateScore(3,0);
		Assert.assertEquals(valor,155);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void powerBonusScoreTestFronteraSuperior2(){
		PowerBonusScore score=new PowerBonusScore();
		int valor = score.calculateScore(4,0);
		Assert.assertEquals(valor,500);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void powerBonusScoreTestFronteraSuperior3(){
		PowerBonusScore score=new PowerBonusScore();
		int valor = score.calculateScore(4,10);
		Assert.assertEquals(valor,500);
	}
}