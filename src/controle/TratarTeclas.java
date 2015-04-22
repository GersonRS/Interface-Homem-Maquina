package controle;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import modelo.Logica;
import modelo.Personagem;

public class TratarTeclas extends KeyAdapter {

	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);

		Personagem heroi = Logica.getP1();
		if (!heroi.isBotaoEspaco())
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				heroi.setBotaoEspaco(true);
			}
	}
}
