package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import comum.Fisica;
import comum.IServicoRemoto;
import comum.Juridica;

public class AppPrincipal {

	public static void main(String[] args) {

		try {
			IServicoRemoto objPessoa = (IServicoRemoto) Naming.lookup("rmi://localhost:4545/pessoa");

			Fisica f1 = new Fisica();
			f1.setCpf("12345678910");
			f1.setId(1);
			f1.setNome("Bruna");
			f1.setEndereco("Rua dos Girassois, 1500");
			f1.setCidade("Araraquara");
			f1.setEstado("SP");
			f1.setIdade(22);
			f1.setTelefone("(16)5678-0987");
			f1.setMae("Valeria");
			f1.setPai("Walter");
			f1.setSalario(1650);

			Juridica j1 = new Juridica();
			j1.setCnpj("01234567890123");
			j1.setId(2);
			j1.setNome("Joaquim");
			j1.setEndereco("Rua das Magnolia, 2200");
			j1.setCidade("Araraquara");
			j1.setEstado("SP");
			j1.setIdade(33);
			j1.setTelefone("(16)2222-7777");
			j1.setMae("Maria");
			j1.setPai("Joao");
			j1.setSalario(1235);

			f1.setAumento(objPessoa.calcularsalario(f1));
			j1.setAumento(objPessoa.calcularsalario(j1));

			objPessoa.inserirf(f1);
			objPessoa.inserirj(j1);

			objPessoa.imprimirf(f1);
			objPessoa.imprimirj(j1);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
