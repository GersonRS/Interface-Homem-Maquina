package modelo;

public class Mapa extends Entidade {

	public Mapa(int posX, int posY) {
		super(posX, posY, 5, "cenario.png");
	}

	@Override
	public void mover() {
		if (posX > (-imagem.getWidth())) {
			posX -= velocidade;
		} else {
			posX = 0;
		}
	}
}