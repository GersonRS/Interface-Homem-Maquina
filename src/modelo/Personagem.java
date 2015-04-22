package modelo;

import java.awt.Rectangle;

public class Personagem extends Entidade {

	private boolean botaoEspaco = false;
	private int anim = 0;
	private final int tamanhoX = 95, tamanhoY = 58;
	private int direcao = 0,verifica=0;
	private int frame = 8;
	private int aceleracao = 13;
	private double gravidade = 1;
	private boolean acertou;

	public Personagem(int posX, int posY) {
		super(posX, posY, 2, "pluto.png");
	}

	@Override
	public void mover() {
		anim++;
		if (botaoEspaco) {
			pular();
		}
	}

	private void pular() {
		direcao = 1;
		frame = 3;
		if (aceleracao > 0 || posY > 0) {
			posY -= aceleracao;
			aceleracao -= gravidade;
			anim = 2;
		}
		if (posY >= 330) {
			botaoEspaco = false;
			aceleracao = 13;
			direcao = 0;
			frame = 8;
			anim = 0;
		}
	}

	public Rectangle getColisao() {
		return new Rectangle(posX + 31, posY + 19, tamanhoX - 44, tamanhoY - 36);
	}

	public boolean isBotaoEspaco() {
		return botaoEspaco;
	}

	public void setBotaoEspaco(boolean botaoEspaco) {
		this.botaoEspaco = botaoEspaco;
	}

	public int getAnim() {
		return anim;
	}

	public int getTamanhoX() {
		return tamanhoX;
	}

	public int getTamanhoY() {
		return tamanhoY;
	}

	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public boolean isAcertou() {
		return acertou;
	}

	public void setAcertou(boolean acertou) {
		if(verifica==0)
		if (acertou) {
			direcao = 2;
			frame = 8;
			anim = 0;
		} else {
			direcao = 3;
			frame = 6;
			anim = 0;
		}
		verifica++;
		this.acertou = acertou;
	}

	public int getVerifica() {
		return verifica;
	}

	public void setVerifica(int verifica) {
		this.verifica = verifica;
	}
	
}