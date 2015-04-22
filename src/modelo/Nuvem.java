package modelo;

import java.util.Random;

import view.Render;


public class Nuvem extends Entidade{
	
	private Random r;
	
	public Nuvem(int posX, int posY) {
		super(posX, posY, 3, new Random().nextInt(2)==0?"nuvem.png":"nuvenzinha.png");
		r=new Random();
	}

	@Override
	public void mover() {
		if(posX<=(-imagem.getWidth()-5)){
			posX=Render.LARGURA+imagem.getWidth();
			posY=r.nextInt(200-imagem.getHeight());
		}
		posX -= velocidade;
	}
}
