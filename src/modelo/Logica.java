package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import view.Render;

public class Logica implements LoopSteps {

	private static Personagem p1;
	private static Balao balao;
	private static Mapa map;
	private Render render;
	private static List<Balao> baloes;
	private static List<Nuvem> nuvens;
	private int acertou = 0, tempo = 0;

	public Logica(Render render) {
		this.render = render;
		setup();
	}

	@Override
	public void setup() {
		Random r = new Random();
		baloes = new ArrayList<Balao>();
		nuvens = new ArrayList<Nuvem>();
		p1 = new Personagem(100, 330);
		balao = new Balao((Render.LARGURA / 2) - 64, 0, r.nextInt(6));
		for (int i = 0; i < 4; i++) {
			baloes.add(new Balao(Render.LARGURA + 170 * i, 250, r.nextInt(6)));
		}
		for (int i = 0; i < 5; i++) {
			nuvens.add(new Nuvem(800 + (i * 123), new Random().nextInt(200)));
		}
		map = new Mapa(0, 0);
	}

	@Override
	public void processLogics() {
		balao.b();
		switch (acertou) {
		case 0: {
			map.mover();
			for (int i = 0; i < baloes.size(); i++) {
				baloes.get(i).mover();
			}
			break;
		}
		case 1: {
			tempo++;
			if (!p1.isBotaoEspaco()) {
				p1.setAcertou(true);
			}
			if (tempo >= 64) {
				acertou = 0;
				tempo = 0;
				p1.setDirecao(0);
				p1.setFrame(8);
			}
			break;
		}
		case 2: {
			tempo++;
			if (!p1.isBotaoEspaco()) {
				p1.setAcertou(false);
			}
			map.mover();
			for (int i = 0; i < baloes.size(); i++) {
				baloes.get(i).mover();
			}
			if (tempo >= 64) {
				acertou = 0;
				tempo = 0;
				p1.setDirecao(0);
				p1.setFrame(8);
			}
			break;
		}
		default:
			break;
		}
		p1.mover();
		for (int i = 0; i < nuvens.size(); i++) {
			nuvens.get(i).mover();
		}
		for (int i = 0; i < baloes.size(); i++) {
			baloes.get(i).b();
		}
		verificaColisao();
	}

	@Override
	public void renderGraphics() {
	}

	@Override
	public void paintScreen() {
		render.pintarTela();
	}

	@Override
	public void tearDown() {

	}

	public void verificaColisao() {
		for (int i = 0; i < baloes.size(); i++) {
			if (p1.isBotaoEspaco()) {
				if (baloes.get(i).getColisao().intersects(p1.getColisao())) {
					if (baloes.get(i).getDirecao() == balao.getDirecao()) {
						baloes.get(i).animar();
						balao.animar();
						acertou = 1;
						p1.setVerifica(0);
					} else {
						if(p1.isBotaoEspaco()){
							acertou = 2;
							p1.setVerifica(0);
						}
					}
				}
			}
		}
		if (!balao.isVisivel()) {
			balao = new Balao(balao.getPosX(), balao.getPosY(),
					new Random().nextInt(6));
		}
	}

	public static Personagem getP1() {
		return p1;
	}

	public static List<Balao> getBaloes() {
		return baloes;
	}

	public static List<Nuvem> getNuvens() {
		return nuvens;
	}

	public static Mapa getMap() {
		return map;
	}

	public static Balao getBalao() {
		return balao;
	}

}
