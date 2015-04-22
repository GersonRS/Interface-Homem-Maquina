package modelo;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Entidade {

	protected int posX;
	protected int posY;
	protected int velocidade;
	protected BufferedImage imagem;

	public Entidade(int posX, int posY, int velocidade, String img) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.velocidade = velocidade;
		try {
			imagem = ImageIO.read(this.getClass().getClassLoader()
					.getResource(img));
		} catch (IOException e) {
			System.out.println("Erro ao buscar imagem do " + img
					+ ".\nEncerrando aplicação");
			System.exit(0);
		}
	}

	public abstract void mover();

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public BufferedImage getImagem() {
		return imagem;
	}
}
