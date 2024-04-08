package br.com.Meadow.apresentacao;

import java.util.Scanner;

import br.com.Meadow.modelos.Usuario;
import br.com.Meadow.persistencia.UsuarioDAO;

public class Cadastro {
	public static void cadastroUsuario() {
		Usuario usuario = new Usuario();
		UsuarioDAO u = new UsuarioDAO();
		Scanner sc = new Scanner(System.in);
		String apelido = sc.next();
		usuario.setApelido(apelido);
		String email = sc.next();
		usuario.setEmail(email);
		u.salvar(usuario);
	}
}
