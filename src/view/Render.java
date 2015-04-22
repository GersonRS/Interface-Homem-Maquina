package view;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import modelo.Balao;
import modelo.Logica;
import modelo.Mapa;
import modelo.Nuvem;
import modelo.Personagem;

public class Render extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage tela;
	public static final int LARGURA = 640, ALTURA = 448;
	private Graphics2D graphics;
	private int x, y;

	public Render(int x, int y) {
		this.x = x;
		this.y = y;
		tela = new BufferedImage(LARGURA, ALTURA, BufferedImage.TYPE_4BYTE_ABGR);
		graphics = (Graphics2D) tela.getGraphics();
		setPreferredSize(new Dimension(x, y));
		setDoubleBuffered(true);
		setFocusable(true);
	}

	public void pintarTela() {
		Mapa map = Logica.getMap();
		Personagem p1 = Logica.getP1();
		Balao balao = Logica.getBalao();
		graphics.drawImage(map.getImagem(), map.getPosX(), map.getPosY(), null);
		graphics.drawImage(map.getImagem(), map.getPosX() + LARGURA,
				map.getPosY(), null);
		for (Nuvem nuvem : Logica.getNuvens()) {
			graphics.drawImage(nuvem.getImagem(), nuvem.getPosX(),
					nuvem.getPosY(), null);
		}
		graphics.drawImage(
				balao.getImagem(),
				balao.getPosX(),
				balao.getPosY(),
				balao.getPosX() + balao.getTamanhoX() * 2,
				balao.getPosY() + balao.getTamanhoY() * 2,
				(int) (balao.getAnim() % balao.getFrame()) * balao.getTamanhoX(),
				balao.getDirecao() * balao.getTamanhoY(),
				(int) (balao.getAnim() % balao.getFrame() * balao.getTamanhoX())
						+ balao.getTamanhoX(),
				(balao.getDirecao() * balao.getTamanhoY())
						+ balao.getTamanhoY(), null);
		graphics.drawImage(
				p1.getImagem(),
				p1.getPosX(),
				p1.getPosY(),
				p1.getPosX() + p1.getTamanhoX(),
				p1.getPosY() + p1.getTamanhoY(),
				(int) (p1.getAnim() % p1.getFrame()) * p1.getTamanhoX(),
				p1.getDirecao() * p1.getTamanhoY(),
				(int) (p1.getAnim() % p1.getFrame() * p1.getTamanhoX())
				+ p1.getTamanhoX(),
				(p1.getDirecao() * p1.getTamanhoY()) + p1.getTamanhoY(), null);
		for (Balao b : Logica.getBaloes()) {
			if(b.isVisivel())
			graphics.drawImage(
					b.getImagem(),
					b.getPosX(),
					b.getPosY(),
					b.getPosX() + b.getTamanhoX(),
					b.getPosY() + b.getTamanhoY(),
					(int) (b.getAnim() % b.getFrame()) * b.getTamanhoX(),
					b.getDirecao() * b.getTamanhoY(),
					(int) (b.getAnim() % b.getFrame() * b.getTamanhoX())
							+ b.getTamanhoX(),
					(b.getDirecao() * b.getTamanhoY()) + b.getTamanhoY(), null);
		}
		getGraphics().drawImage(tela, 0, 0, x, y, null);
	}
}