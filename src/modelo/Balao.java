package modelo;

import java.awt.Rectangle;
import java.util.Random;

import view.Render;

public class Balao extends Entidade {

	private int anim = 0;
	private final int tamanhoX = 64, tamanhoY = 70;
	private int direcao = 0;
	private int frame = 4;
	private boolean visivel;

	public Balao(int posX, int posY, int cor) {
		super(posX, posY, 3, "baloes.png");	
		this.direcao=cor;
		this.visivel = true;
	}

	@Override
	public void mover() {
		if (posX <= -tamanhoX) {
			posX = Render.LARGURA;
			direcao = new Random().nextInt(6);
			visivel = true;
		}
		posX -= velocidade;
	}

	public Rectangle getColisao() {
		return new Rectangle(posX + 16, posY + 5, tamanhoX - 32, tamanhoY - 25);
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

	public void animar() {
		frame=14;
	}
	
	public void b(){
		anim++;
		if(anim>=frame){
			if(anim>=14){
				visivel=false;
				frame=4;
			}
			anim=0;
		}
	}

	public boolean isVisivel() {
		return visivel;
	}
	
	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

}
