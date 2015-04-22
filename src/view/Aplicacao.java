package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import modelo.Logica;
import modelo.MainLoop;

import controle.TratarTeclas;

public class Aplicacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Dimension dimTela = Toolkit.getDefaultToolkit()
			.getScreenSize();

	public Aplicacao() {
		super("Projeto Interface Homem Maquina");
		setSize(dimTela.width, dimTela.height);
		setPreferredSize(new Dimension(dimTela.width, dimTela.height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setLayout(new BorderLayout());

		Render render = new Render(dimTela.width, dimTela.height);
		add(render, BorderLayout.CENTER);

		new Thread(new MainLoop(new Logica(render), 15)).start();

		render.addKeyListener(new TratarTeclas());

	}

	public static void main(String[] args) {
		new Aplicacao().setVisible(true);
	}
}
